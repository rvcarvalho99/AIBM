import java.util.HashMap;
import java.util.Map;

public class Destination {


    private Map<Integer,String> destinations;

    public Destination (){
        destinations = new HashMap<Integer,String>();
    }

    public Map<Integer, String> getDestinations() {
        return destinations;
    }

    public void setDestinations(Map<Integer, String> destinations) {
        this.destinations = destinations;
    }

    public void addDestination(Integer i, String destination) {
        if(!destinations.containsValue(destination))
            destinations.put(i,destination);
    }

    public int getDestination(String destination) {
        for( Integer i : destinations.keySet()){
            if (destinations.get(i).equals(destination))
                return i;
        }
        return -1;
    }
}
