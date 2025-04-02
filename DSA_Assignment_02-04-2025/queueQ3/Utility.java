package queueQ3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * class UTility, used to create the available progrm list and
 * take the name and preference list of students and print the allocated branch
 * to students
 */
public class Utility {
    public void execute(){
        Scanner sc = new Scanner(System.in);
        List<Program> programList = new ArrayList<>();
        programList.add(new Program("Civil", 10));
        programList.add(new Program("Mechanical", 10));
        programList.add(new Program("IT", 10));
        programList.add(new Program("CSE", 10));
        programList.add(new Program("Electronics", 10));
        programList.add(new Program("Biotechnical", 10));
        programList.add(new Program("Printing", 10));
        programList.add(new Program("Chemical", 10));
        programList.add(new Program("Electrical", 10));
        
        //Printing available program list
        System.out.println("Available Programs");
        for(int index = 0; index < programList.size(); index++){
            System.out.println(programList.get(index).getName());
        }

        // Take name, preference list of student and add into queue
        QueueProcessor qp = new QueueProcessor(programList);
        try{
            System.out.println("Enter the number of student");
            int numStudents = sc.nextInt();
            if(numStudents <= 0){
                throw new AssertionError("Size cannot be less than 1");
            }
            List<Student> students = new ArrayList<>();
            for(int index = 0; index < numStudents; index++){
                System.out.println("Enter the name of student");
                String name = sc.next();
                System.out.println("Enter the rank of student");
                int rank = sc.nextInt();
                List<String> programPreferenceListOfStudent = new ArrayList<>();
                System.out.println("Enter the branch preference : ");
                for(int j = 0; j < 5; j++ ){
                    programPreferenceListOfStudent.add(sc.next());
                }
                students.add(new Student(name, rank,programPreferenceListOfStudent));
            }

            qp.addStudent(students);
            // Printing the alloted branches to students
            Map<String, String> studentAllocations = qp.allocatePrograms();
            for(Map.Entry<String, String> entry : studentAllocations.entrySet()){
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }catch(AssertionError e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("Unwanted error" + e.getMessage());
        }finally{
            sc.close();
        }
    }
}
