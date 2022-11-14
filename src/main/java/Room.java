public class Room {
    private int capacity = 32;
    public String name = "";
    public Room(){

    }
    public Room(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
