package queueQ3;

/** class Student, used to store name and list of preferences of student */
import java.util.List;

public class Student {
    private String name;
    private int rank;
    private List<String> programPreference;

    public Student(String name, int rank, List<String> programPreference) {
        this.name = name;
        this.rank = rank;
        this.programPreference = programPreference;
    }

    // Getters of Student class
    public List<String> getProgramPreference() {
        return programPreference;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

}
