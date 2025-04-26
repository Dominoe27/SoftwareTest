package appointment;

import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


  //Unit tests for AppointmentService.

public class AppointmentServiceTest {

    @Test
    void testAddAppointment_withUniqueId_shouldSucceed() {
        AppointmentService service = new AppointmentService();
        Appointment appt = new Appointment("A123", new Date(System.currentTimeMillis() + 10000), "Dentist visit");

        service.addAppointment(appt);

        assertEquals(appt, service.getAppointment("A123"));
    }

    @Test
    void testAddAppointment_withDuplicateId_shouldThrowException() {
        AppointmentService service = new AppointmentService();
        Appointment appt1 = new Appointment("A123", new Date(System.currentTimeMillis() + 10000), "Visit");
        Appointment appt2 = new Appointment("A123", new Date(System.currentTimeMillis() + 20000), "Check-up");

        service.addAppointment(appt1);

        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appt2));
    }

    @Test
    void testDeleteAppointment_withExistingId_shouldRemoveAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appt = new Appointment("A123", new Date(System.currentTimeMillis() + 10000), "Visit");

        service.addAppointment(appt);
        service.deleteAppointment("A123");

        assertNull(service.getAppointment("A123"));
    }

    @Test
    void testDeleteAppointment_withNonExistentId_shouldThrowNoSuchElementException() {
        AppointmentService service = new AppointmentService();

        assertThrows(NoSuchElementException.class, () -> service.deleteAppointment("NonExistentID"));
    }
}
