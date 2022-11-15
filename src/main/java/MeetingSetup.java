import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class MeetingSetup {
    ArrayList<Meeting> meetings = new ArrayList<Meeting>();
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Person> attendants = new ArrayList<Person>();
    public MeetingSetup(){
        setUp();
    }
    public void setUp(){

        Room compApple = new Room("Apple Computer Room", 24);         rooms.add(compApple);
        Room compWindows = new Room("Windows Computer Lab", 24);         rooms.add(compWindows);
        Room conference_room = new Room("Conference Room", 48);         rooms.add(conference_room);
        Room office0 = new Room("Manager's Office", 4);         rooms.add(office0);



        Meeting first = new Meeting("Orientation", rooms.get(0), LocalDate.now(), LocalTime.now(), LocalTime.now().plusHours(1), "ULCSIS02");
        Meeting second = new Meeting("Orientation Group 2", rooms.get(1), LocalDate.now(), LocalTime.now().minusHours(1), LocalTime.now().plusMinutes(30), "ULCSIS02");
        meetings.add(first); meetings.add(second);

        Person john = new Person("Doe", "John", "894984195");
        Person johnny = new Person("Doe", "John", "864674228");
        attendants.add(john); attendants.add(johnny);

        first.addAttendant(john);
        first.addAttendant(johnny);
        second.addAttendant(johnny);

    }

}
