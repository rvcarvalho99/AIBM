import java.util.HashMap;
import java.util.Map;

public class Cause {


    private Map<Integer,String> causes;

    public Cause (){
        causes = new HashMap<Integer,String>();
    }

    public Map<Integer, String> getCauses() {
        return causes;
    }

    public void setCauses(Map<Integer, String> causes) {
        this.causes = causes;
    }

    public void addCause(Integer i,String cause) {
        if(!causes.containsValue(cause))
            causes.put(i,cause);
    }

    public int getCause(String cause) {
        for( Integer i : causes.keySet()){
            if (causes.get(i).equals(cause))
                return i;
        }
        return -1;
    }
}
