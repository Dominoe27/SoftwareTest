package appointment;

import java.util.Date;
import java.util.Objects;


  //Immutable appointment entry with a unique ID,
  //a scheduled future date, and a brief description.
 
public class Appointment {
    private final String appointmentId;
    private final Date appointmentDate;
    private final String description;

    
     //Creates an Appointment with validation for each field.
     
     //appointmentId Unique identifier 
     //appointmentDate Must be today or in the future 
     //description Description 
     
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID must be non-null and up to 10 characters.");
        }

        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date must not be null or in the past.");
        }

        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must be non-null and up to 50 characters.");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        // Return copy to prevent mutation
        return new Date(appointmentDate.getTime());
    }

    public String getDescription() {
        return description;
    }

    // For comparison when testing
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return appointmentId.equals(that.appointmentId) &&
               appointmentDate.equals(that.appointmentDate) &&
               description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, appointmentDate, description);
    }
}
