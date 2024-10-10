import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import businesslogic.BLFacade;
import configuration.UtilDate;
import dataAccess.DataAccess;
import domain.Driver;
import domain.Ride;

public class GetRidesByDriverBDWhiteTestMock {
	
	static BLFacade appFacadeInterface = Mockito.mock(BLFacade.class);

	static DataAccess sut;
	protected MockedStatic<Persistence> persistenceMock;
	@Mock
	protected EntityManagerFactory entityManagerFactory;
	@Mock
	protected EntityManager db;
	@Mock
	protected EntityTransaction et;
	
	@Mock
	TypedQuery<Driver> typedQuery;	
	
	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
		persistenceMock = Mockito.mockStatic(Persistence.class);
		persistenceMock.when(() -> Persistence.createEntityManagerFactory(Mockito.any())).thenReturn(entityManagerFactory);
		Mockito.doReturn(db).when(entityManagerFactory).createEntityManager();
			Mockito.doReturn(et).when(db).getTransaction();
		 sut=new DataAccess(db);
		 
		}
		@After
		public void tearDown() {
			persistenceMock.close();
		}
		
		Driver driver;
		
		@Test
		//todo correcto
		public void test1() {
			Calendar cal = Calendar.getInstance();
			cal.set(2024, Calendar.MAY, 20);
			Date date1 = UtilDate.trim(cal.getTime());
			
		    Driver driver1 = new Driver("DRIVER1", "password");
		    driver1.addRide("Bilbao", "Donosti", date1, 2, 7);

		    // Mockear la base de datos
		    Mockito.when(db.createQuery(Mockito.anyString(), Mockito.eq(Driver.class))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.setParameter("username", "DRIVER1")).thenReturn(typedQuery);
		    Mockito.when(typedQuery.getSingleResult()).thenReturn(driver1);

		    // Llamar al método
		    List<Ride> result = sut.getRidesByDriver("DRIVER1");

		    // Verificar el resultado
		    assertNotNull(result);
		    assertEquals(1, result.size());
		    assertTrue(result.contains(driver1.getCreatedRides().get(0)));
		}

		@Test
		//Prueba de que el usuario no es un driver
		public void test2() {
		    // Simular que el usuario no es un driver
		    Mockito.when(db.createQuery(Mockito.anyString(), Mockito.eq(Driver.class))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.setParameter("username", "USER1")).thenReturn(typedQuery);
		    Mockito.when(typedQuery.getSingleResult()).thenThrow(new NoResultException("No driver found"));

		    // Llamar al método
		    List<Ride> result = sut.getRidesByDriver("USER1");

		    // Verificar el resultado
		    assertNull(result); 
		}
		
		@Test
		//el Driver no existe en la base de datos
		public void test3() {
		    // Mockear la consulta que lanza una excepción porque el driver no existe
		    Mockito.when(db.createQuery(Mockito.anyString(), Mockito.eq(Driver.class))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.setParameter("username", "DRIVER00")).thenReturn(typedQuery);
		    Mockito.when(typedQuery.getSingleResult()).thenThrow(new NoResultException("No driver found"));

		    // Llamar al método
		    List<Ride> result = sut.getRidesByDriver("DRIVER00");

		    // Verificar el resultado
		    assertNull(result); 
		}

		@Test
		//Driver sin viajes activos
		public void test4() {
		    // Preparar un driver sin rides activos
		    Driver driver2 = new Driver("DRIVER2", "password");

		    // Mockear la base de datos
		    Mockito.when(db.createQuery(Mockito.anyString(), Mockito.eq(Driver.class))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.setParameter("username", "DRIVER2")).thenReturn(typedQuery);
		    Mockito.when(typedQuery.getSingleResult()).thenReturn(driver2);

		    // Llamar al método
		    List<Ride> result = sut.getRidesByDriver("DRIVER2");

		    // Verificar el resultado
		    assertNotNull(result);
		    assertTrue(result.isEmpty()); 
		}
		
		/*
		@Test
		public void test5() {
		    // Caso: username es null
		    Mockito.when(db.createQuery(Mockito.anyString(), Mockito.eq(Driver.class))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.setParameter(Mockito.eq("username"), Mockito.isNull())).thenReturn(typedQuery);
		    Mockito.when(typedQuery.getSingleResult()).thenThrow(new IllegalArgumentException("Username cannot be null"));

		    // Llamar al método con username null
		    List<Ride> resultNull = sut.getRidesByDriver(null);

		    // Verificar que el resultado es null debido a la excepción capturada en el catch
		    assertNull(resultNull);
		}
		
		public void test6() {

		    // Caso: username es vacío
		    Mockito.when(db.createQuery(Mockito.anyString(), Mockito.eq(Driver.class))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.setParameter(Mockito.eq("username"), Mockito.eq(""))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.getSingleResult()).thenThrow(new IllegalArgumentException("Username cannot be empty"));

		    // Llamar al método con username vacío
		    List<Ride> resultEmpty = sut.getRidesByDriver("");

		    // Verificar que el resultado es null debido a la excepción capturada en el catch
		    assertNull(resultEmpty);
		}
*/




		
		
		
}