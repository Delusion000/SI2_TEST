//test2

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Test;

import dataAccess.DataAccess;
import domain.Driver;
import domain.Ride;
import testOperations.TestDataAccess;

public class GetRidesByDriverBDBlackTest {
	 //sut:system under test
	 static DataAccess sut=new DataAccess();
	 
	 //additional operations needed to execute the test 
	 static TestDataAccess testDA=new TestDataAccess();

	@SuppressWarnings("unused")
	private Driver driver; 
    
	//hola
	@Test
	public void test1() {
	    String driverUsername = "Driver1";

	    
	    Calendar cal = Calendar.getInstance();
	    cal.set(2024, Calendar.MAY, 20);
	    Date rideDate = cal.getTime();

	    try {
	        // 
	        testDA.open();
	        testDA.createDriver(driverUsername, null);  
	        testDA.addDriverWithRide(driverUsername, "Cali", "Bogota", rideDate, 2, 10); 
	        testDA.addDriverWithRide(driverUsername, "Donosti", "Bilbao", rideDate, 2, 10);
	        testDA.addDriverWithRide(driverUsername, "Bilbao", "Donosti", rideDate, 2, 10);
	        testDA.close();
	        
	        // Llamar al método 
	        sut.open();
	        List<Ride> result = sut.getRidesByDriver(driverUsername);
	        sut.close();
	        
	        // Verificar que no es null
	        assertNotNull(result);
	        
	        // Verificar que el resultado 
	        assertEquals(3, result.size());
	        assertTrue(result.contains(result.get(0)));
	        assertTrue(result.contains(result.get(1)));
	        assertTrue(result.contains(result.get(2)));
	    } finally {
	        testDA.open();
	        testDA.removeDriver(driverUsername); 
	        testDA.close();
	    }
	}
	
	@Test
	public void test2() {
	    String driverUsername = "Driver1";

	    
	    Calendar cal = Calendar.getInstance();
	    cal.set(2024, Calendar.MAY, 20);
	    Date rideDate = cal.getTime();
	    
	    try {
	        // 
	        testDA.open();
	        testDA.createDriver(driverUsername, null);  
	        testDA.addDriverWithRide(driverUsername, "Cali", "Bogota", rideDate, 2, 10);
	        
	        testDA.addDriverWithRide(driverUsername, "Donosti", "Bilbao", rideDate, 2, 10);
	        testDA.addDriverWithRide(driverUsername, "Bilbao", "Donosti", rideDate, 2, 10);

	        testDA.deactivateRide(driverUsername, "Cali", "Bogota", rideDate);
	        testDA.deactivateRide(driverUsername, "Donosti", "Bilbao", rideDate);
	        testDA.deactivateRide(driverUsername, "Bilbao", "Donosti", rideDate);
	        testDA.close();
	        
	        // Llamar al método 
	        
	        sut.open();
	        List<Ride> result = sut.getRidesByDriver(driverUsername);
	        sut.close();
	        
	        // Verificar que no es null
	        assertNotNull(result);
	        
	        // Verificar que el resultado 
	        assertEquals(0, result.size());
	       
	    } finally {
	        testDA.open();
	        testDA.removeDriver(driverUsername); 
	        testDA.close();
	    }
	}
	
	public void test3() {
	    String driverUsername = "Driver1";

	    try {
	        // 
	        testDA.open();
	        testDA.createDriver(driverUsername, null);  
	        testDA.close();
	        // Llamar al método 
	        
	        sut.open();
	        List<Ride> result = sut.getRidesByDriver(driverUsername);
	        sut.close();
	        
	        // Verificar que no es null
	        assertNotNull(result);
	        
	        // Verificar que el resultado 
	        assertEquals(0, result.size());
	       
	    } finally {
	        testDA.open();
	        testDA.removeDriver(driverUsername); 
	        testDA.close();
	    }
	}
	
	@Test
	public void test4() {
	    String driverUsername = "Driver1";

	    
	    Calendar cal = Calendar.getInstance();
	    cal.set(2024, Calendar.MAY, 20);
	    Date rideDate = cal.getTime();
	    
	    try {
	        // 
	        testDA.open();
	        testDA.createDriver(driverUsername, null);  
	        testDA.addDriverWithRide(driverUsername, "Cali", "Bogota", rideDate, 2, 10);
	        
	        testDA.addDriverWithRide(driverUsername, "Donosti", "Bilbao", rideDate, 2, 10);
	        testDA.addDriverWithRide(driverUsername, "Bilbao", "Donosti", rideDate, 2, 10);

	        testDA.deactivateRide(driverUsername, "Cali", "Bogota", rideDate);//desactiva el viaje
	        testDA.close();
	        // Llamar al método 
	        
	        sut.open();
	        List<Ride> result = sut.getRidesByDriver(driverUsername);
	        sut.close();
	        
	        // Verificar que no es null
	        assertNotNull(result);
	        
	        // Verificar que el resultado 
	        assertEquals(2, result.size());
	       
	    } finally {
	        testDA.open();
	        testDA.removeDriver(driverUsername); 
	        testDA.close();
	    }
	}
	
	@Test
	public void test5() {
	    String driverUsername = "Driver1";

	    
	    Calendar cal = Calendar.getInstance();
	    cal.set(2024, Calendar.MAY, 20);
	    Date rideDate = cal.getTime();
	    
	    try {
	        // 
	        testDA.open();
	        testDA.createDriver(driverUsername, null);  
	        testDA.addDriverWithRide(driverUsername, "Cali", "Bogota", rideDate, 2, 10);
	        testDA.addDriverWithRide(driverUsername, "Donosti", "Bilbao", rideDate, 2, 10);
	        testDA.addDriverWithRide(driverUsername, "Bilbao", "Donosti", rideDate, 2, 10);
	        testDA.close();

	        // Llamar al método 
	        sut.open();
	        List<Ride> result = sut.getRidesByDriver(null);
	        sut.close();
	        
	        // Verificar es null por exepcion 
	        assertNull(result);
	       
	       
	    } finally {
	        testDA.open();
	        testDA.removeDriver(driverUsername); 
	        testDA.close();
	    }
	}
	
	
	@Test
	public void test6() {
	    String driverUsername = "Driver1";

	    
	    Calendar cal = Calendar.getInstance();
	    cal.set(2024, Calendar.MAY, 20);
	    Date rideDate = cal.getTime();
	    
	    try {
	        // 
	        testDA.open();
	        testDA.createDriver(driverUsername, null);  
	        testDA.addDriverWithRide(driverUsername, "Cali", "Bogota", rideDate, 2, 10);
	        testDA.addDriverWithRide(driverUsername, "Donosti", "Bilbao", rideDate, 2, 10);
	        testDA.addDriverWithRide(driverUsername, "Bilbao", "Donosti", rideDate, 2, 10);
	        testDA.close();
	        
	        // Llamar al método 
	        sut.open();
	        List<Ride> result = sut.getRidesByDriver("");
	        sut.close();
	        
	        // Verificar es null por exepcion 
	        assertNull(result);
	       
	       
	    } finally {
	        testDA.open();
	        testDA.removeDriver(driverUsername); 
	        testDA.close();
	    }
	}
	
	@Test
	public void test7() {
	    String driverUsername = "Driver1";
	    String UsernameUser = "user1";
	    
	    Calendar cal = Calendar.getInstance();
	    cal.set(2024, Calendar.MAY, 20);
	    Date rideDate = cal.getTime();
	    
	    try {
	        // 
	        testDA.open();
	        testDA.createDriver(driverUsername, null);  
	        testDA.addDriverWithRide(driverUsername, "Cali", "Bogota", rideDate, 2, 10);
	        testDA.addDriverWithRide(driverUsername, "Donosti", "Bilbao", rideDate, 2, 10);
	        testDA.addDriverWithRide(driverUsername, "Bilbao", "Donosti", rideDate, 2, 10);
	        testDA.close();
	        
	        // Llamar al método 
	        sut.open();
	        List<Ride> result = sut.getRidesByDriver(UsernameUser);
	        sut.close();
	        
	        // Verificar es null por exepcion 
	        assertNull(result);
	       
	       
	    } finally {
	        testDA.open();
	        testDA.removeDriver(driverUsername); 
	        testDA.close();
	    }
	}
	
	@Test
	public void test8() {
	    String driverUsername = "Driver1";
	    String drivernonExist = "driver00";
	    
	    Calendar cal = Calendar.getInstance();
	    cal.set(2024, Calendar.MAY, 20);
	    Date rideDate = cal.getTime();
	    
	    try {
	        // 
	        testDA.open();
	        testDA.createDriver(driverUsername, null);  
	        testDA.addDriverWithRide(driverUsername, "Cali", "Bogota", rideDate, 2, 10);
	        testDA.addDriverWithRide(driverUsername, "Donosti", "Bilbao", rideDate, 2, 10);
	        testDA.addDriverWithRide(driverUsername, "Bilbao", "Donosti", rideDate, 2, 10);
	        testDA.close();
	        
	        // Llamar al método 
	        sut.open();
	        List<Ride> result = sut.getRidesByDriver(drivernonExist);
	        sut.close();
	        
	        // Verificar es null por exepcion 
	        assertNull(result);
	       
	       
	    } finally {
	        testDA.open();
	        testDA.removeDriver(driverUsername); 
	        testDA.close();
	    }
	}
	
	@Test
	public void test9() {
	    String driverUsername = "Driver1";
	    
	    Calendar cal = Calendar.getInstance();
	    cal.set(2024, Calendar.MAY, 20);
	    Date rideDate = cal.getTime();
	    
	    try {
	        // 
	        testDA.open();
	        testDA.createDriver(driverUsername, null);  
	        testDA.addDriverWithRide(driverUsername, "Cali", "Bogota", rideDate, 2, 10);
	        testDA.addDriverWithRide(driverUsername, "Donosti", "Bilbao", rideDate, 2, 10);
	        testDA.addDriverWithRide(driverUsername, "Bilbao", "Donosti", rideDate, 2, 10);
	        
	        //viaje null
	        testDA.addDriverWithRide(driverUsername, null, null, rideDate, 0, 0);
	        testDA.close();
	        
	        // Llamar al método 
	        sut.open();
	        List<Ride> result = sut.getRidesByDriver(driverUsername);
	        sut.close();
	        
	         
	     // Verificar que no es null
	        assertNotNull(result);
	        
	        // Verificar que el resultado 
	        assertEquals(3, result.size());
	       
	       
	    } finally {
	        testDA.open();
	        testDA.removeDriver(driverUsername); 
	        testDA.close();
	    }
	}
	
}
