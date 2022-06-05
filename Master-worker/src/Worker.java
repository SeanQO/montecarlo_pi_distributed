import java.util.Map;  
import java.util.Queue;  
  
public class Worker implements Runnable {  
    //Task queue  
    protected Queue<Object> workQueue;  
    //Subtask Processing Result Set  
    protected Map<String, Object> resultMap;  
    public void setWorkQueue(Queue<Object> workQueue) {  
        this.workQueue = workQueue;  
    }  
  
    public void setResultMap(Map<String, Object> resultMap) {  
        this.resultMap = resultMap;  
    }  
      
    //The logic of sub-task processing is implemented by sub-class instead of concrete implementation.  
    public Object handle(Object input) {  
        return input;  
    }  
      
    @Override  
    public void run() {  
        while(true) {  
            //Getting subtasks  
            Object input = workQueue.poll();  
            if(input == null) break;  
            //Handling subtasks  
            Object re = handle(input);  
            //Write the processing results to the result set  
            resultMap.put(Integer.toString(input.hashCode()), re);  
        }  
    }  
}  