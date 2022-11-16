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

        Room compApple = new Room("Apple Computer Room", 24,true,1);
        rooms.add(compApple);
        Room compWindows = new Room("Windows Computer Lab", 24,true,2);
        rooms.add(compWindows);
        Room conference_room = new Room("Conference Room", 48,true,3);
        rooms.add(conference_room);
        Room office0 = new Room("Manager's Office", 4,true,4);
        rooms.add(office0);
        Room online = new Room("Online [Microsoft Teams]", 128,true,5);
        rooms.add(online);


        Meeting first = new Meeting("Orientation", rooms.get(0), LocalDate.now(), LocalTime.now(), LocalTime.now().plusHours(1));
        Meeting second = new Meeting("Orientation Group 2", rooms.get(1), LocalDate.now(), LocalTime.now().minusHours(1), LocalTime.now().plusMinutes(30));
        Meeting onlineMeet = new Meeting("Interview", rooms.get(4), LocalDate.of(2022,12,6), LocalTime.of(12,0), LocalTime.of(12,30));


        Person john = new Person("Doe", "John", "894984195");
        Person johnny = new Person("Doe", "John", "864674228");
        attendants.add(john); attendants.add(johnny);

        first.addAttendant(john);
        first.addAttendant(johnny);
        second.addAttendant(johnny);
        addMeeting(first, "ULCSIS02"); addMeeting(second, "ULCSIS02"); addMeeting(onlineMeet, "ULCSIS02");
        for (int i =0; i < 32; i++){
            Person dude = new Person("Test", "Case", "1234567890");
            meetings.get(2).addAttendant(dude);
        }
    }
    public boolean addMeeting(Meeting meeting,String password){
        if (password.contentEquals("ULCSIS02")){
            meetings.add(meeting);
            return true;
        } else System.out.println("Only staff can add meetings"); return false;
    }
}
