import java.util.HashMap;
import java.util.Map;

public class District {


    private Map<Integer,String> districts;
    private Integer num;

    public District (){
        districts = new HashMap<Integer,String>();
        num=1;
    }

    public Map<Integer, String> getDistricts() {
        return districts;
    }

    public void setDistricts(Map<Integer, String> districts) {
        this.districts = districts;
    }

    public int addDistrict(String district) {
        if(!districts.containsValue(district)) {
            num++;
            districts.put(num, district);
            return num;
        }
        for( Integer i : districts.keySet()){
            if(district.equals(districts.get(i)))
                return i;
        }
        return  -1;
    }

    public int getDistrict(String district) {
        for( Integer i : districts.keySet()){
            if (districts.get(i).equals(district))
                return i;
        }
        return -1;
    }
}
