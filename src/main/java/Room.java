public class Room {
    private int number;
    private int capacity = 32;
    public String name = " ";
    public Room(){

    }
    private boolean status;
    public boolean getStatus() {
        return status;
    }
    public boolean setStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public Room(String name, int capacity,boolean status,int number){
        this.name = name;
        this.capacity = capacity;
        this.status = status;
        this.number = number;
    }


    @Override
    public String toString() {
        return name;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
