package marksheet;
import java.util.HashMap;

/** class Opeartions have all methods requires like average, maximum, minimum and passed %,
 * Each method return a double type value, grades are stored in hashmap acc to their key
 */

public class Operations{
    
    // Hashmap to store the grades of students
    private HashMap<String, Student> grade = new HashMap<>();
    
    public void addGrade(String key,Student student) {
        try{
            grade.put(key,student);
        }catch(ArithmeticException e){
            System.out.println("Marks cannot be negative");
        }
        }
    
    /**Method Average, return the average of all grades in double type 
     * @ param HashMap with grades of student
    */
    public double average()  throws ArithmeticException {
        if(grade == null || grade.size() == 0){
            throw new ArithmeticException("Cannot comput, no data available");
        }
        int sum = 0;
        for(String key : grade.keySet()){
            sum += grade.get(key).getGradeStudent();
        }
        return (double)sum / grade.size();
    }

    /**Method maximumGrade, return the maximum grades from all in double type value 
     *  @ param HashMap with grades of student
    */
    public double maximumGrade() throws ArithmeticException {
         if(grade == null || grade.size() == 0){
            throw new ArithmeticException("Cannot comput, no data available");
        }
        double maximumValue = Double.MIN_VALUE;
        for(String key : grade.keySet()){
            if(grade.get(key).getGradeStudent() > maximumValue ){
                maximumValue = grade.get(key).getGradeStudent();
            }
        }
        return maximumValue;

    }
    
    /** Method minimumGrade, return the minimum grade from all in double typr value 
     *  @ param HashMap with grades of student
    */
    public double minimumGrade() throws ArithmeticException {
         if(grade == null || grade.size() == 0){
            throw new ArithmeticException("Cannot comput, no data available");
        }
        double minimumValue = Double.MAX_VALUE;
        for(String key : grade.keySet()){
            if(grade.get(key).getGradeStudent() < minimumValue ){
                minimumValue = grade.get(key).getGradeStudent();
            }
        }
        return minimumValue;

    }
    
    /** Method passedStudent, return the percentage of passed students from all in double type 
     *  @ param HashMap with grades of student
     */ 
    public double passedStudent() throws ArithmeticException {
         if(grade == null || grade.size() == 0){
            throw new ArithmeticException("Cannot comput, no data available");
        }
        int studentPassed = 0;
        for(String key : grade.keySet()){
            if(grade.get(key).getGradeStudent() >= 40.00 ){
                studentPassed++;
            }
        }
        return (double)studentPassed / grade.size() ;

    }
}