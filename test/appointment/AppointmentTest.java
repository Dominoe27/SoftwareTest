package appointment;

import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


 //Unit tests for the Appointment model.
 
public class AppointmentTest {

    @Test
    void testConstructor_withValidInputs_shouldCreateAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        Appointment appt = new Appointment("A123", futureDate, "Dental check-up");
        assertEquals("A123", appt.getAppointmentId());
    }

    @Test
    void testConstructor_withDatePlusOneSecond_shouldSucceed() {
        // Use a short buffer to avoid millisecond-level timing failure
        Date todayPlus1Sec = new Date(System.currentTimeMillis() + 1000);
        Appointment appt = new Appointment("A777", todayPlus1Sec, "Same-day test");
        assertEquals("A777", appt.getAppointmentId());
    }

    @Test
    void testConstructor_withNullId_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment(null, new Date(System.currentTimeMillis() + 10000), "Check-up")
        );
    }

    @Test
    void testConstructor_withPastDate_shouldThrowException() {
        Date pastDate = new Date(System.currentTimeMillis() - 10000);
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("A124", pastDate, "Too late")
        );
    }

    @Test
    void testConstructor_withLongDescription_shouldThrowException() {
        String longDesc = "x".repeat(51);
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("A125", new Date(System.currentTimeMillis() + 10000), longDesc)
        );
    }

    @Test
    void testGetAppointmentDate_returnsCopy_shouldNotAffectOriginal() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        Appointment appt = new Appointment("A999", futureDate, "Immutability test");

        Date returned = appt.getAppointmentDate();
        returned.setTime(0);

        assertNotEquals(0, appt.getAppointmentDate().getTime());
    }
}
