import java.util.HashMap;  
import java.util.Map;  
import java.util.Queue;  
import java.util.concurrent.ConcurrentHashMap;  
import java.util.concurrent.ConcurrentLinkedQueue;  
  
public class Master {  
    //Task queue  
    protected Queue<Object> workQueue =   
            new ConcurrentLinkedQueue<Object>();  
    //Worker process queue  
    protected Map<String, Thread> threadMap =   
            new HashMap<String, Thread>();  
    //Subtask Processing Result Set  
    protected Map<String, Object> resultMap =  
            new ConcurrentHashMap<String, Object>();  
      

    public Master(Worker worker, int countWorker) {  
        worker.setWorkQueue(workQueue);  
        worker.setResultMap(resultMap);  
        
        for(int i=0; i<countWorker; i++) {  
            threadMap.put(Integer.toString(i),   
                    new Thread(worker, Integer.toString(i)));  
        }  
    }  
      
    //Are all subtasks introduced?  
    public boolean isComplete() {  
        for(Map.Entry<String, Thread> entry : threadMap.entrySet()) {  
            if(entry.getValue().getState() != Thread.State.TERMINATED)  
                //Threads exist for completion  
                return false;  
        }  
        return true;  
    }  
      
    //Submit a subtask  
    public void submit(Object job) {  
        workQueue.add(job);  
    }  
      
    //Returns the subtask result set  
    public Map<String, Object> getResultMap() {  
        return resultMap;  
    }  
      
    //Execute all Worker processes and process them  
    public void execute() {  
        for(Map.Entry<String, Thread> entry : threadMap.entrySet()) {  
            entry.getValue().start();  
        }  
    }  
}  
