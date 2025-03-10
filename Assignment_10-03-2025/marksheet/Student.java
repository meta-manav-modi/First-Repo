package marksheet;

/** class Student used to initialize the value to object grade */

public class Student{
    private double gradeStudent;
    
    // Constructor to initialize value
    Student(double gradeStudent){
        this.gradeStudent = gradeStudent;
    }

    // getter to get grade of instance
    public double getGradeStudent(){
        return gradeStudent;
    }
}