import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Test;

import dataAccess.DataAccess;
import domain.Driver;
import domain.Ride;
import testOperations.TestDataAccess;

public class GetRidesByDriverBDWhiteTest {
	/*
	 //sut:system under test
	 static DataAccess sut=new DataAccess();
	 
	 //additional operations needed to execute the test 
	 static TestDataAccess testDA=new TestDataAccess();

	@SuppressWarnings("unused")
	
	private Driver driver;
	
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
	        testDA.close();
	        
	        // Llamar al método 
	        sut.open();
	        List<Ride> result = sut.getRidesByDriver(driverUsername);
	        sut.close();
	        
	        // Verificar que no es null
	        assertNotNull(result);
	        
	        // Verificar que el resultado 
	        assertEquals(2, result.size());
	        assertTrue(result.contains(result.get(0)));
	        assertTrue(result.contains(result.get(1)));
	    } finally {
	        testDA.open();
	        testDA.removeDriver(driverUsername); 
	        testDA.close();
	    }
	}
	
	@Test
	public void test2() {
	    String driverUsername = "DRIVER1";
	    String userUsername = "USER1";

	    Calendar cal = Calendar.getInstance();	
	    cal.set(2024, Calendar.MAY, 20);
	    Date rideDate = cal.getTime();

	    try {
	        // 
	        testDA.open();
	        testDA.createDriver(driverUsername, null);  
	        testDA.addDriverWithRide(driverUsername, "Cali", "Bogota", rideDate, 2, 10); 
	        testDA.addDriverWithRide(driverUsername, "Donosti", "Bilbao", rideDate, 2, 10);
	        testDA.close();
	        
	        // Llamar al método 
	        sut.open();
	        List<Ride> result = sut.getRidesByDriver(userUsername);
	        sut.close();
	        
	        // Verificar que no es null
	        assertNull(result);
	        
	        // Verificar que el resultado 
	        
	    } finally {
	        testDA.open();
	        testDA.removeDriver(driverUsername); 
	        testDA.close();
	    }
	}
	
	@Test
	public void test3() {
	    String driverUsername = "DRIVER1";
	    String driverNonExist = "DRIVER00";

	    Calendar cal = Calendar.getInstance();	
	    cal.set(2024, Calendar.MAY, 20);
	    Date rideDate = cal.getTime();

	    try {
	        // 
	        testDA.open();
	        testDA.createDriver(driverUsername, null);  
	        testDA.addDriverWithRide(driverUsername, "Cali", "Bogota", rideDate, 2, 10); 
	        testDA.addDriverWithRide(driverUsername, "Donosti", "Bilbao", rideDate, 2, 10);
	        testDA.close();
	        
	        // Llamar al método 
	        sut.open();
	        List<Ride> result = sut.getRidesByDriver(driverNonExist);
	        sut.close();
	        
	        // Verificar que no es null
	        assertNull(result);
	        
	        // Verificar que el resultado 
	        
	    } finally {
	        testDA.open();
	        testDA.removeDriver(driverUsername); 
	        testDA.close();
	    }
	}
	
	@Test
	public void test4() {
	    String driverUsername = "DRIVER2";

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
	*/
}
