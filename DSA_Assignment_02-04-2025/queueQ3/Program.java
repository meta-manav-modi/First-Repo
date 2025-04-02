package queueQ3;

/** class Program, used to store the name and capacity of a program */
public class Program {
    private String name;
    private int capacity;

    public Program(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Getters and Setters
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
