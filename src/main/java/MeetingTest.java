import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
                    containsDupe++;
                } else
                {
                    temp.add(m.meetings.get(i).getAttendants().get(j).getPhoneNumber());
                }
            }
        }
        assertEquals(0, containsDupe);
    }
    Meeting nm;
    @BeforeEach
    void setUp()
    {
        nm = new Meeting();
    }
    @ParameterizedTest
    @ValueSource(ints = {33,50,69})
    void getAttendantsOverLimit(int number)
    {
        assertEquals(0,nm.getAttendantsNumber(number),"The room is not big enough");
    }
    @ParameterizedTest
    @ValueSource(ints = {1,14,32})
    void getAttendantsUnderLimit(int number)
    {
        assertEquals(1,nm.getAttendantsNumber(number),"The room is big enough");
    }
    @Test
    void checkTimeBounds() {
        for (int i = 0; i < m.meetings.size(); i++){
            assertTrue(((m.meetings.get(i).timeTo.getHour() <= 23) && (m.meetings.get(i).timeTo.getHour() >= 0)), "Test bounds for Time to");
            assertTrue(((m.meetings.get(i).timeFrom.getHour() <= 23) && (m.meetings.get(i).timeFrom.getHour() >= 0)), "Test bounds for Time from");
            assertTrue((m.meetings.get(i).timeFrom.isBefore(m.meetings.get(i).timeTo)), "Test that the from time is before the to time");
        }
    }
        @Test
        void checkPassword()
        {
         assertTrue(m.addMeeting(new Meeting("Sample", m.rooms.get(1), LocalDate.now(),  LocalTime.now().minusHours(1), LocalTime.now()), "ULCSIS02"), "Using correct password");
         assertFalse(m.addMeeting(new Meeting("Sample", m.rooms.get(2), LocalDate.now(),  LocalTime.now().minusHours(1), LocalTime.now()), "ULCSIS01"), "Using incorrect password");
         assertFalse(m.addMeeting(new Meeting("Sample", m.rooms.get(2), LocalDate.now(),  LocalTime.now().minusHours(1), LocalTime.now()), ""), "Using null password.");
         assertFalse(m.addMeeting(new Meeting("Sample", m.rooms.get(2), LocalDate.now(),  LocalTime.now().minusHours(1), LocalTime.now()), "NULCSIS02"), "Using password that contains right characters but isn't exact");
        }
    @ParameterizedTest
    @ValueSource(LocalTime = LocalTime.of(20,00,00))
    void checkRepeatTime(LocalTime st1)
    {
        assertTrue(nm.checkAvailability(st1));
    }
}