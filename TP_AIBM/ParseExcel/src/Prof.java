import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prof {


    private List<String> profs;

    public Prof (){
        profs = new ArrayList<String>();
    }

    public List<String> getProfs() {
        return profs;
    }

    public void setProfs(List<String> profs) {
        this.profs = profs;
    }

    public void addProf(String prof) {

        if(!profs.contains(prof))
            profs.add(prof);
    }

}
