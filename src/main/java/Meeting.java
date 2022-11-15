import java.time.*;
import java.util.ArrayList;
import java.util.Objects;

public class Meeting
{
    public String description = "";
    public String employeePassword = "";
    public Room room;
    public LocalDate appointDate = LocalDate.now();
    public LocalTime timeFrom = LocalTime.now();
    public LocalTime timeTo;
    public ArrayList<Person> attendants = new ArrayList<>();

    public Meeting() {
        description = "New meeting";
        room = new Room("CS1-044", 32);
        appointDate = LocalDate.now();
        timeFrom = LocalTime.now();
        timeTo = LocalTime.of(19, 30);
    }

    public Meeting(String description, Room room, LocalDate appointDate, LocalTime timeFrom, LocalTime timeTo, ArrayList<Person> people) {
        this.description = description;
        this.room = room;
        this.appointDate = appointDate;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        attendants = people;
    }

    public Meeting(String description, Room room, LocalDate appointDate, LocalTime timeFrom, LocalTime timeTo) {
            this.description = description;
            this.room = room;
            this.appointDate = appointDate;
            this.timeFrom = timeFrom;
            this.timeTo = timeTo;
    }

    public String getDescription() {
        return description;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public ArrayList<Person> getAttendants() {
        return attendants;
    }

    public void addAttendant(String forename, String surname, String phoneNumber) {
        int match = 0;
        for (int i = 0; i < attendants.size(); i++) {
            if (attendants.get(i).getPhoneNumber().contentEquals(phoneNumber)) {
                match++;
            }
        }
        Person person;
        if (match == 0) {
            person = new Person(surname, forename, phoneNumber);
            attendants.add(person);
        }
    }

    public void addAttendant(Person attendee) {
        int match = 0;
        for (Person attendant : attendants) {
            if (attendant.getPhoneNumber().contentEquals(attendee.getPhoneNumber()) ) {
                match++;
            }
        }
        if (match == 0) {
            attendants.add(attendee);
        }
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

        public Room getRoom () {
            return this.room;
        }

        public void setTimeFrom (LocalTime timeFrom){
            this.timeFrom = timeFrom;
        }

        public void setTimeTo (LocalTime timeTo){
            this.timeTo = timeTo;
        }

        public void setRoom (Room room){
            this.room = room;
        }

        @Override
        public String toString () {
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

