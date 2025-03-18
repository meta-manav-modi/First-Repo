package fcfs;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.lang.Math;

/** Calculation class provides Hashmap to create and store all types of calculated time
 * Like completion, turnaround, waiting time and a method to perform,
 * calculate all and add it into the hashmap
 */
public class Calculation{   
        public int[][] processes;
        public Map<Integer, InputTime> items = new HashMap<>();
        public Calculation(){}
        public Calculation(int[][] processes){
            this.processes = processes;
            Arrays.sort(this.processes, Comparator.comparingInt(a -> a[0]));
        }

        // Function to calculate all times and store into hashmap
        public void calculationTimes(){
            int completionTime = 0;
            for(int index = 0; index < processes.length; index++){
                int arrivalTime = processes[index][0];
                int burstTime = processes[index][1];
                completionTime = Math.max(completionTime, arrivalTime) + burstTime;
                int turnaroundTime = completionTime - arrivalTime;
                int waitingTime = turnaroundTime - burstTime;
                items.put(index+1, new InputTime(waitingTime, turnaroundTime, completionTime));
            }
        }
    }