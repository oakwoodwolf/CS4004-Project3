public class Person {
    public String forename = "John";
    public String surname = "Doe";
    public String phoneNumber = "0893459213" ;
    public Person()
    {

    }
    public Person(String surname, String forename, String phoneNumber)
    {
        this.surname = surname;
        this.forename = forename;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return surname + ","+ forename;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
