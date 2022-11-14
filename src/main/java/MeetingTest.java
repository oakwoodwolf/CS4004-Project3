import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MeetingTest {
    ArrayList<Room> rooms = new ArrayList<>();
    Room compApple = new Room("Apple Computer Room", 24);

    ArrayList<Meeting> meetings = new ArrayList<Meeting>();
    Meeting first = new Meeting("Orientation", rooms.get(1), LocalDate.now(), LocalTime.now(), LocalTime.now().plusHours(1), "ULCSIS02");
    Meeting second = new Meeting("Orientation Group 2", rooms.get(2), LocalDate.now(), LocalTime.now(), LocalTime.now().plusHours(1), "ULCSIS02");

    ArrayList<Person> attendants = new ArrayList<Person>();
    Person john = new Person("Doe", "John", "894984195");
    Person johnny = new Person("Doe", "John", "864674228");

    @Test
    void CheckIfEmptyAttendants() {
        assertTrue(attendants.isEmpty());
    }

    @Test
    void getAppointDate() {
    }
}