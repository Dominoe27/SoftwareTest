package appointment;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


 //AppointmentService manages appointments in memory.
 //Provides functionality to add and delete appointments using unique IDs.
 
public class AppointmentService {

    //Storage for appointment objects keyed by their IDs
    private final Map<String, Appointment> appointments = new HashMap<>();

    
     //Adds an appointment if its ID is unique.
     //appointment Appointment to add
     //IllegalArgumentException if ID already exists
     
    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment with this ID already exists.");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    
     //Deletes an appointment by ID.
     //appointmentId The ID of the appointment to delete
     //NoSuchElementException if appointment does not exist
     
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new NoSuchElementException("Appointment not found.");
        }
        appointments.remove(appointmentId);
    }

    
     //Pulls an appointment by ID.
     //appointmentId The ID of the appointment
     //The Appointment object or null if not found
     
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
