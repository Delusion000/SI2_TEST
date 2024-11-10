package domain;

import javax.swing.table.AbstractTableModel;

import java.util.Date;
import java.util.List;

public class DriverAdapter extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private final List<Ride> rides;
    
    // Definimos los nombres de las columnas
    private final String[] columnNames = { "Ride Number", "From", "To", "Date", "Available Seats", "Price", "Active" };

    public DriverAdapter(Driver driver) {
        this.rides = driver.getCreatedRides();
    }

    @Override
    public int getRowCount() {
        return rides.size();
    }

    @Override
    public int getColumnCount() {	
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ride ride = rides.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ride.getRideNumber().shortValue(); 
            case 1:
                return ride.getFrom(); 
            case 2:
                return ride.getTo(); 
            case 3:
                return ride.getDate(); 
            case 4:
                return ride.getnPlaces(); 
            case 5:
                return ride.getPrice(); 
            case 6:
                return ride.isActive(); 
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class; // Tipo de datos del número de ride
            case 1:
            case 2:
                return String.class; // Tipo de datos de origen y destino
            case 3:
                return Date.class; // Tipo de datos de la fecha
            case 4:
                return Integer.class; // Tipo de datos para el número de plazas disponibles
            case 5:
                return Double.class; // Tipo de datos para el precio
            case 6:
                return Boolean.class; // Tipo de datos para el estado activo
            default:
                return Object.class;
        }
    }
}

