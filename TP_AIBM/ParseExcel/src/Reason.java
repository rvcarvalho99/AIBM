import java.util.HashMap;
import java.util.Map;

public class Reason {


    private Map<Integer,String> reasons;

    public Reason (){
        reasons = new HashMap<Integer,String>();
    }

    public Map<Integer, String> getReasons() {
        return reasons;
    }

    public void setReasons(Map<Integer, String> reasons) {
        this.reasons = reasons;
    }

    public void addReason(Integer i, String reason) {
        if(!reasons.containsValue(reason))
            reasons.put(i,reason);
    }

    public int getReason(String reason) {
        for( Integer i : reasons.keySet()){
            if (reasons.get(i).equals(reason))
                return i;
        }
        return -1;
    }
}
