import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MeetingTest {
    MeetingSetup m = new MeetingSetup();
    @Test
    void CheckIfEmptyAttendants() {
        assertFalse(m.attendants.isEmpty(), "The meeting isn't empty");
    }
    @Test
    void CheckThatAttendantsLessThanCapacity(){
        for (int i = 0; i < m.meetings.size(); i++){
            assertTrue(m.meetings.get(i).getAttendants().size() <= m.meetings.get(i).getRoom().getCapacity());
        }
    }
    @Test
    void CheckThatPhoneNumberIsntRepeated(){
        int containsDupe = 0;
        ArrayList<String> temp = new ArrayList<>();
        for (int i =0; i < m.meetings.size(); i++){
            temp.clear();
            for (int j=0; j < m.meetings.get(i).getAttendants().size(); j++){
                if (temp.contains(m.meetings.get(i).getAttendants().get(j).getPhoneNumber())){
                    containsDupe = 1;
                } else
                {
                    temp.add(m.meetings.get(i).getAttendants().get(j).getPhoneNumber());
                }
            }
        }
        assertEquals(0, containsDupe);
    }

    @Test
    void checkTimeBounds() {
        for (int i = 0; i < m.meetings.size(); i++){
            assertTrue(((m.meetings.get(i).timeTo.getHour() <= 23) && (m.meetings.get(i).timeTo.getHour() >= 0)));
            assertTrue(((m.meetings.get(i).timeFrom.getHour() <= 23) && (m.meetings.get(i).timeFrom.getHour() >= 0)));
            assertTrue((m.meetings.get(i).timeFrom.isBefore(m.meetings.get(i).timeTo)));
        }
    }
    @Test
    void checkPassword(){
        for (int i = 0; i < m.meetings.size(); i++){
            assertTrue(m.meetings.get(i).getEmployeePassword().contentEquals("ULCSIS02"));
        }
    }
}