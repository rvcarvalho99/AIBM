import java.util.HashMap;
import java.util.Map;

public class Dates {


    private Map<Integer,String> datas;
    private int num;

    public Dates (){

        num=0;
        datas = new HashMap<Integer,String>();
    }

    public Map<Integer, String> getDatas() {
        return datas;
    }

    public void setDatas(Map<Integer, String> datas) {
        this.datas = datas;
    }

    public int addData(String data) {

        if(!datas.containsValue(data)) {
            num++;
            datas.put(num, data);
        }
        for( Integer i : datas.keySet()){
            if(data.equals(datas.get(i)))
                return i;
        }
        return  -1;
    }

    public int getData(String data) {
        for( Integer i : datas.keySet()){
            if (datas.get(i).equals(data))
                return i;
        }
        return -1;
    }
}
