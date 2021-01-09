public class Prescription {
    private int code;
    private int prof;
    private int date;
    private int code_drug;
    private int qt;
    private int pvp;
    private int compart;
    private String posology;
    private String desc;
    private int joinid;

    public int getJoinid() {
        return joinid;
    }

    public void setJoinid(int joinid) {
        this.joinid = joinid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPosology() {
        return posology;
    }

    public void setPosology(String posology) {
        this.posology = posology;
    }

    public int getCompart() {
        return compart;
    }

    public void setCompart(int compart) {
        this.compart = compart;
    }

    public int getPvp() {
        return pvp;
    }

    public void setPvp(int pvp) {
        this.pvp = pvp;
    }

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public int getCode_drug() {
        return code_drug;
    }

    public void setCode_drug(int code_drug) {
        this.code_drug = code_drug;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getProf() {
        return prof;
    }

    public void setProf(int prof) {
        this.prof = prof;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
