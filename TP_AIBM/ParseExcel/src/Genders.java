import java.util.HashMap;
import java.util.Map;

public class Genders {


    private Map<Integer,String> genders;
    private  Integer num;

    public Genders (){
        genders = new HashMap<Integer,String>();
        num=0;
    }

    public Map<Integer, String> getgenders() {
        return genders;
    }

    public void setgenders(Map<Integer, String> genders) {
        this.genders = genders;
    }

    public int addgender(String gender) {
        if(!genders.containsValue(gender)) {
            num++;
            genders.put(num, gender);
            return num;
        }
        for( Integer i : genders.keySet()){
            if(gender.equals(genders.get(i)))
                return i;
        }
        return  -1;
    }

    public int getgender(String gender) {
        for( Integer i : genders.keySet()){
            if (genders.get(i).equals(gender))
                return i;
        }
        return -1;
    }
}
