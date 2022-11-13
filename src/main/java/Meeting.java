import java.time.*;
import java.util.ArrayList;

public class Meeting {
    public String description = "";
    public Room room;
    public LocalDate appointDate = LocalDate.now();
    public LocalTime timeFrom = LocalTime.now();
    public LocalTime timeTo;
    public ArrayList<Person> attendants = new ArrayList<>();
    public Meeting(){
        description = "New meeting";
        room = new Room("CS1-044", 32);
        appointDate = LocalDate.now();
        timeFrom = LocalTime.now();
        timeTo = LocalTime.of(19,30);
        attendants.add(new Person());
    }
    public Meeting(String description, Room room, LocalDate appointDate, LocalTime timeFrom, LocalTime timeTo, ArrayList<Person> people){
        description = this.description;
        room = this.room;
        appointDate = this.appointDate;
        timeFrom = this.timeFrom;
        timeTo = this.timeTo;
        attendants = people;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Person> getAttendants() {
        return attendants;
    }

    public LocalDate getAppointDate() {
        return appointDate;
    }

    public LocalTime getTimeFrom() {
        return timeFrom;
    }

    public LocalTime getTimeTo() {
        return timeTo;
    }

    public Room getRoom() {
        return room;
    }

    public void setTimeFrom(LocalTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public void setTimeTo(LocalTime timeTo) {
        this.timeTo = timeTo;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "description='" + description + '\'' +
                ", room='" + room + '\'' +
                ", appointDate=" + appointDate +
                ", timeFrom=" + timeFrom +
                ", timeTo=" + timeTo +
                ", attendants=" + attendants +
                '}';
    }
}
