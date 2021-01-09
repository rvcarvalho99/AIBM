import java.util.HashMap;
import java.util.Map;

public class Color {


    private Map<Integer,String> colors;
    private Integer num;
    public Color (){
        colors = new HashMap<Integer,String>();
        num=0;
    }

    public Map<Integer, String> getColors() {
        return colors;
    }

    public void setColors(Map<Integer, String> colors) {
        this.colors = colors;
    }

    public void addColor(Integer i, String color) {
        if(!colors.containsValue(color))
            colors.put(i,color);
    }

    public int getColor(String color) {
        for( Integer i : colors.keySet()){
            if (colors.get(i).equals(color))
                return i;
        }
        return -1;
    }
}
