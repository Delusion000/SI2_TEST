import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

import businessLogic.BLFacade;
import configuration.UtilDate;
import dataAccess.DataAccess;
import domain.Driver;
import domain.Ride;

public class GetRidesByDriverBDBlackTestMock {
	
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
		public void test1() {
			Calendar cal = Calendar.getInstance();
			cal.set(2024, Calendar.MAY, 20);
			Date date1 = UtilDate.trim(cal.getTime());
			
			Driver driver1 = new Driver("Driver1", "123");
			driver1.addRide("Bilbao", "Donosti", date1, 2, 7);
			driver1.addRide("Donosti", "Bilbao", date1, 2, 7);
			driver1.addRide("Cali", "Bogota", date1, 2, 7);
			
			//List<Ride> actRides = new ArrayList<>();
			//Mockito.when(db.createQuery(Mockito.anyString(), Mockito.any(Class.class))).thenReturn(typedQuery);		
			//Mockito.when(typedQuery.getSingleResult()).thenReturn(actRides);
			
			//verify the results
			Mockito.when(db.createQuery(Mockito.anyString(), Mockito.eq(Driver.class))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.setParameter(Mockito.eq("username"), Mockito.anyString())).thenReturn(typedQuery);
		    Mockito.when(typedQuery.getSingleResult()).thenReturn(driver1);

		    // Llamar al método que estás probando
		    List<Ride> result = sut.getRidesByDriver("Driver1");

		    // Comprobar el resultado
		    assertNotNull(result);
		    assertEquals(3, result.size());
		    assertTrue(result.contains(driver1.getCreatedRides().get(0)));
		    assertTrue(result.contains(driver1.getCreatedRides().get(1)));
		    assertTrue(result.contains(driver1.getCreatedRides().get(2)));    
		}
		@Test
		public void test2() {
			Calendar cal = Calendar.getInstance();
			cal.set(2024, Calendar.MAY, 20);
			Date date1 = UtilDate.trim(cal.getTime());
			
			Driver driver1 = new Driver("Driver1", "123");
			driver1.addRide("Bilbao", "Donosti", date1, 2, 7);
			driver1.getCreatedRides().get(0).setActive(false);
			
			driver1.addRide("Donosti", "Bilbao", date1, 2, 7);
			driver1.getCreatedRides().get(1).setActive(false);
			
			driver1.addRide("Cali", "Bogota", date1, 2, 7);
			driver1.getCreatedRides().get(2).setActive(false);
			
			//List<Ride> actRides = new ArrayList<>();
			//Mockito.when(db.createQuery(Mockito.anyString(), Mockito.any(Class.class))).thenReturn(typedQuery);		
			//Mockito.when(typedQuery.getSingleResult()).thenReturn(actRides);
			
			//verify the results
			Mockito.when(db.createQuery(Mockito.anyString(), Mockito.eq(Driver.class))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.setParameter(Mockito.eq("username"), Mockito.anyString())).thenReturn(typedQuery);
		    Mockito.when(typedQuery.getSingleResult()).thenReturn(driver1);

		    // Llamar al método que estás probando
		    List<Ride> result = sut.getRidesByDriver("Driver1");

		    // Comprobar el resultado
		    assertNotNull(result);
		    assertEquals(0, result.size());
		    assertFalse(result.contains(driver1.getCreatedRides().get(0)));
		    assertFalse(result.contains(driver1.getCreatedRides().get(1)));
		    assertFalse(result.contains(driver1.getCreatedRides().get(2)));    
		}
		@Test
		public void test3() {
			
			Driver driver1 = new Driver("Driver1", "123");
			
			
			//List<Ride> actRides = new ArrayList<>();
			//Mockito.when(db.createQuery(Mockito.anyString(), Mockito.any(Class.class))).thenReturn(typedQuery);		
			//Mockito.when(typedQuery.getSingleResult()).thenReturn(actRides);
			
			//verify the results
			Mockito.when(db.createQuery(Mockito.anyString(), Mockito.eq(Driver.class))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.setParameter(Mockito.eq("username"), Mockito.anyString())).thenReturn(typedQuery);
		    Mockito.when(typedQuery.getSingleResult()).thenReturn(driver1);

		    // Llamar al método que estás probando
		    List<Ride> result = sut.getRidesByDriver("Driver1");

		    // Comprobar el resultado
		    assertNotNull(result);
		    assertEquals(0, result.size());
		}
		
		@Test
		public void test4() {
			Calendar cal = Calendar.getInstance();
			cal.set(2024, Calendar.MAY, 20);
			Date date1 = UtilDate.trim(cal.getTime());
			
			Driver driver1 = new Driver("Driver1", "123");
			driver1.addRide("Bilbao", "Donosti", date1, 2, 7);
			
			driver1.addRide("Donosti", "Bilbao", date1, 2, 7);
			
			//driver1.addRide(null, null, date1, 0, 0);//opcion null no valida
			
			driver1.addRide("Cali", "Bogota", date1, 2, 7);
			driver1.getCreatedRides().get(2).setActive(false);
			
			//List<Ride> actRides = new ArrayList<>();
			//Mockito.when(db.createQuery(Mockito.anyString(), Mockito.any(Class.class))).thenReturn(typedQuery);		
			//Mockito.when(typedQuery.getSingleResult()).thenReturn(actRides);
			
			//verify the results
			Mockito.when(db.createQuery(Mockito.anyString(), Mockito.eq(Driver.class))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.setParameter(Mockito.eq("username"), Mockito.anyString())).thenReturn(typedQuery);
		    Mockito.when(typedQuery.getSingleResult()).thenReturn(driver1);

		    // Llamar al método que estás probando
		    List<Ride> result = sut.getRidesByDriver("Driver1");

		    // Comprobar el resultado
		    assertNotNull(result);
		    assertEquals(2, result.size());
		    assertTrue(result.contains(driver1.getCreatedRides().get(0)));
		    assertTrue(result.contains(driver1.getCreatedRides().get(1)));
		    assertFalse(result.contains(driver1.getCreatedRides().get(2)));    
		}
		
		@Test
		public void test5() {
			Calendar cal = Calendar.getInstance();
			cal.set(2024, Calendar.MAY, 20);
			Date date1 = UtilDate.trim(cal.getTime());
			
			Driver driver1 = new Driver("Driver1", "123");
			driver1.addRide("Bilbao", "Donosti", date1, 2, 7);
			
			driver1.addRide("Donosti", "Bilbao", date1, 2, 7);
			
		    // Mockear la interacción con la base de datos
		    Mockito.when(db.createQuery(Mockito.anyString(), Mockito.eq(Driver.class))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.setParameter(Mockito.eq("username"), Mockito.isNull())).thenReturn(typedQuery);
		    Mockito.when(typedQuery.getSingleResult()).thenThrow(new IllegalArgumentException("Username cannot be null"));
		    
		    // Llamar al método con un username null
		    List<Ride> result = sut.getRidesByDriver(null);
		    
		    // Verificar que el resultado es null debido a la excepción capturada en el catch
		    assertNull(result);
		}

		@Test
		public void test6() {
			
			Calendar cal = Calendar.getInstance();
			cal.set(2024, Calendar.MAY, 20);
			Date date1 = UtilDate.trim(cal.getTime());
			
			Driver driver1 = new Driver("Driver1", "123");
			driver1.addRide("Bilbao", "Donosti", date1, 2, 7);
			
			driver1.addRide("Donosti", "Bilbao", date1, 2, 7);
			
			
		    // Mockear la interacción con la base de datos
		    Mockito.when(db.createQuery(Mockito.anyString(), Mockito.eq(Driver.class))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.setParameter(Mockito.eq("username"), Mockito.eq(""))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.getSingleResult()).thenThrow(new IllegalArgumentException("Username cannot be empty"));
		    
		    // Llamar al método con un username vacío
		    List<Ride> result = sut.getRidesByDriver("");
		    
		    // Verificar que el resultado es null debido a la excepción capturada en el catch
		    assertNull(result);
		}
		
		@Test
		public void test7() {
			Calendar cal = Calendar.getInstance();
			cal.set(2024, Calendar.MAY, 20);
			Date date1 = UtilDate.trim(cal.getTime());
			
			Driver driver1 = new Driver("Driver1", "123");
			driver1.addRide("Bilbao", "Donosti", date1, 2, 7);
			driver1.addRide("Donosti", "Bilbao", date1, 2, 7);
			
		    String nonExistentDriver = "user1";
		    
		    // Mockear la interacción con la base de datos
		    Mockito.when(db.createQuery(Mockito.anyString(), Mockito.eq(Driver.class))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.setParameter(Mockito.eq("username"), Mockito.eq(nonExistentDriver))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.getSingleResult()).thenThrow(new NoResultException("No driver found for username: " + nonExistentDriver));
		    
		    // Llamar al método con un username que no existe
		    List<Ride> result = sut.getRidesByDriver(nonExistentDriver);
		    
		    // Verificar que el resultado es null debido a la excepción capturada en el catch
		    assertNull(result);
		}
		
		@Test
		public void test8() {
			Calendar cal = Calendar.getInstance();
			cal.set(2024, Calendar.MAY, 20);
			Date date1 = UtilDate.trim(cal.getTime());
			
			Driver driver1 = new Driver("Driver1", "123");
			driver1.addRide("Bilbao", "Donosti", date1, 2, 7);
			driver1.addRide("Donosti", "Bilbao", date1, 2, 7);
			
		    String nonExistentDriver = "driver00";
		    
		    // Mockear la interacción con la base de datos
		    Mockito.when(db.createQuery(Mockito.anyString(), Mockito.eq(Driver.class))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.setParameter(Mockito.eq("username"), Mockito.eq(nonExistentDriver))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.getSingleResult()).thenThrow(new NoResultException("No driver found for username: " + nonExistentDriver));
		    
		    // Llamar al método con un username que no existe
		    List<Ride> result = sut.getRidesByDriver(nonExistentDriver);
		    
		    // Verificar que el resultado es null debido a la excepción capturada en el catch
		    assertNull(result);
		}
		
		@Test
		public void test9() {
			Calendar cal = Calendar.getInstance();
			cal.set(2024, Calendar.MAY, 20);
			Date date1 = UtilDate.trim(cal.getTime());
			
			Driver driver1 = new Driver("Driver1", "123");
			driver1.addRide("Bilbao", "Donosti", date1, 2, 7);
			
			driver1.addRide("Donosti", "Bilbao", date1, 2, 7);
			
			driver1.addRide(null, null, date1, 0, 0);//opcion null no valida
			
			driver1.addRide("Cali", "Bogota", date1, 2, 7);
			driver1.getCreatedRides().get(2).setActive(false);
			
			//List<Ride> actRides = new ArrayList<>();
			//Mockito.when(db.createQuery(Mockito.anyString(), Mockito.any(Class.class))).thenReturn(typedQuery);		
			//Mockito.when(typedQuery.getSingleResult()).thenReturn(actRides);
			
			//verify the results
			Mockito.when(db.createQuery(Mockito.anyString(), Mockito.eq(Driver.class))).thenReturn(typedQuery);
		    Mockito.when(typedQuery.setParameter(Mockito.eq("username"), Mockito.anyString())).thenReturn(typedQuery);
		    Mockito.when(typedQuery.getSingleResult()).thenReturn(driver1);

		    // Llamar al método que estás probando
		    List<Ride> result = sut.getRidesByDriver("Driver1");

		    // Comprobar el resultado
		    assertNotNull(result);
		    assertEquals(2, result.size());
		    assertTrue(result.contains(driver1.getCreatedRides().get(0)));
		    assertTrue(result.contains(driver1.getCreatedRides().get(1)));
		    assertFalse(result.contains(driver1.getCreatedRides().get(2)));    
		}
}




















