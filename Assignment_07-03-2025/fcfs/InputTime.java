package fcfs;

/** InputTime class provides constructor to initialize all values*/
public class InputTime{
   private int completionTime;
   private int turnaroundTime;
   private int waitingTime;
   
   // constructor to initialize the values
   public InputTime(){}
   public InputTime(int waitingTime, int turnaroundTime, int completionTime){
    this.waitingTime = waitingTime;
    this.turnaroundTime = turnaroundTime;
    this.completionTime = completionTime;
   }
   
   // All getters to get the values of an object
   public int getWaitingTime(){
    return waitingTime;
   }
   public int getTurnaroundTime(){
    return turnaroundTime;
   }
   public int getCompletionTime(){
    return completionTime;
   }

}