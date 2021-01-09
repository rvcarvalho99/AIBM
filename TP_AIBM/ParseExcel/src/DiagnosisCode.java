public class DiagnosisCode {
    private String code;
    private String diagnosis;
    private String note;
    private int hierarchy;

    public int getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(int hierarchy) {
        this.hierarchy = hierarchy;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
