package queueQ3;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** class QueueProcessor, having method to allocate the branches to students acc to their preferences */
public class QueueProcessor {
    private QueueOfStudents qos;
    private List<Program> programs;

    public QueueProcessor(List<Program> programs) {
        this.qos = new QueueOfStudents();
        this.programs = programs;
    }

    // Add studnet to the queue
    public void addStudent(List<Student> students) {
        students.sort(Comparator.comparingInt(s -> s.getRank()));
        for(Student student : students){
            qos.enqueue(student);
        }
    }

    /** method allocatePrograms, used to allocate the branches to students acc to their preferences
     * @ param object of Student class
     * @ return LinkedHashMap having studnet name as key
    */
    public Map<String, String> allocatePrograms() {
        Map<String, String> allocatedPrograms = new LinkedHashMap<>();

        QueueNode current = qos.getFront();
        while (current != null) {
            Student stu = current.student;
            boolean allocated = false;
            for (String preferences : stu.getProgramPreference()) {
                for (Program program : programs) {
                    if (program.getName().equals(preferences) && program.getCapacity() > 0) {
                        allocatedPrograms.put(stu.getName(), program.getName());
                        program.setCapacity(program.getCapacity() - 1);
                        allocated = true;
                        break;
                    }
                }
                if (allocated)
                    break;
            }
            if (!allocated) {
                allocatedPrograms.put(stu.getName(), "Not allocated");
            }
            current = current.next;
        }
        return allocatedPrograms;
    }
}
