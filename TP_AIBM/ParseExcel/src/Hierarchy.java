public class Hierarchy {
    String code;
    String level1desc;

    public String getLevel1desc() {
        return level1desc;
    }

    public void setLevel1desc(String level1desc) {
        this.level1desc = level1desc;
    }

    String level2desc;
    String level3desc;
    String level4desc;
    String level5desc;

    public Hierarchy() {
        code=level2desc=level3desc=level4desc=level5desc="";
    }

    public String getLevel5desc() {
        return level5desc;
    }

    public void setLevel5desc(String level5desc) {
        this.level5desc = level5desc;
    }

    public String getLevel4desc() {
        return level4desc;
    }

    public void setLevel4desc(String level4desc) {
        this.level4desc = level4desc;
    }

    public String getLevel3desc() {
        return level3desc;
    }

    public void setLevel3desc(String level3desc) {
        this.level3desc = level3desc;
    }

    public String getLevel2desc() {
        return level2desc;
    }

    public void setLevel2desc(String level2desc) {
        this.level2desc = level2desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
