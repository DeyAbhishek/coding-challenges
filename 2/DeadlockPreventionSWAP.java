public class DeadlockPreventionSWAP{
    public final int ID;
    private int value;
    public DeadlockPreventionSWAP(int id, int val){
    ID = id; value = val;
    }
    public synchronized int getValue(){  return value; }
    public synchronized void setValue(int val){ value = val; }
    
    //if you do a.swapValue(b)and b.swapValue(a) 
    //it will cause Deadlock
    public synchronized void swapValue(DeadlockPreventionSWAP other){
      if(this.ID == other.ID) return; //you can do if(this == other) and
                                      //implement equals(...) and check for the ID
      othersValue = other.getValue();
      other.setValue(this.getValue());
      this.setValue(othersValue);
    }
    
    //the below method is Deadlock Free
    public void deadlockFreeSwapValue(DeadlockPreventionSWAP other){
      if(this.ID == other.ID) return;
      
      if(this.ID < other.ID) this.swapValue(other);
      else other.swapValue(this);
    }
    //you can make swapValue(...) private now
    
    


}
