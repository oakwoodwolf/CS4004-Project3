import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import static java.time.LocalTime.*;;
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
    @Test
    void checkTimeBounds() {
        for (int i = 0; i < m.meetings.size(); i++){
            assertTrue(((m.meetings.get(i).timeTo.getHour() <= 23) && (m.meetings.get(i).timeTo.getHour() >= 0)), "Test bounds for Time to");
            assertTrue(((m.meetings.get(i).timeFrom.getHour() <= 23) && (m.meetings.get(i).timeFrom.getHour() >= 0)), "Test bounds for Time from");
            assertTrue((m.meetings.get(i).timeFrom.isBefore(m.meetings.get(i).timeTo)), "Test that the from time is before the to time");
        }
    }
    @Test
    void checkDateBounds(){
        for (Meeting meeting: m.meetings){
            assertFalse(meeting.getAppointDate().lengthOfMonth() > 31);
            assertFalse(meeting.getAppointDate().lengthOfYear() > 366);
            assertThrows(DateTimeException.class, () -> {meeting.setAppointDate(LocalDate.of(2019,2,29));}, "Check if it throws this exception when using 29th of february on a leap year");
            assertThrows(DateTimeException.class, () -> {meeting.setAppointDate(LocalDate.of(2019,2,0));}, "0th Day of a month");
            assertThrows(DateTimeException.class, () -> {meeting.setAppointDate(LocalDate.of(2019,1,32));}, "32th Day of a month");
            assertThrows(DateTimeException.class, () -> {meeting.setAppointDate(LocalDate.of(2019,6,31));}, "31st of a month with only 30 days");
            assertThrows(DateTimeException.class, () -> {meeting.setAppointDate(LocalDate.of(2019,13,30));}, "13th Month");
            assertThrows(DateTimeException.class, () -> {meeting.setAppointDate(LocalDate.of(2019,0,30));}, "0th Month");
        }
    }
        @Test
        void checkPassword()
        {
         assertTrue(m.addMeeting(new Meeting("Sample", m.rooms.get(1), LocalDate.now(),  now().minusHours(1), now()), "ULCSIS02"), "Using correct password");
         assertFalse(m.addMeeting(new Meeting("Sample", m.rooms.get(2), LocalDate.now(),  now().minusHours(1), now()), "ULCSIS01"), "Using incorrect password");
         assertFalse(m.addMeeting(new Meeting("Sample", m.rooms.get(2), LocalDate.now(),  now().minusHours(1), now()), ""), "Using null password.");
         assertFalse(m.addMeeting(new Meeting("Sample", m.rooms.get(2), LocalDate.now(),  now().minusHours(1), now()), "NULCSIS02"), "Using password that contains right characters but isn't exact");
        }
        @ParameterizedTest
        @ValueSource(ints = {1,3,5})
        void checkRoomStatus(int n)
        {
            assertTrue(m.getRoomNumber(n),"Room is available");

        }
        @ParameterizedTest
        @ValueSource(ints = {2,4})
        void checkUnavailableRoomStatus(int n)
        {
            assertFalse(m.getRoomNumber(n),"Room is not available");
        }
        @ParameterizedTest
        @ValueSource(ints = {1,15,24})
        void checkDeposit(int p)
        {
            assertEquals(5,m.getDepositNumber(p),"Please hand in your deposit");
        }
        @ParameterizedTest
        @ValueSource(ints = {25,35,48})
        void checkMoreDeposit(int p)
        {
            assertEquals(10,m.getDepositNumber(p),"Please hand in your deposit");
        }
        @ParameterizedTest
        @ValueSource(ints = {1,5,10})
        void changeMeetingDate(int t)
        {
            assertEquals(LocalDate.of(2022,11,19+t),m.changeDate(t));
        }
}