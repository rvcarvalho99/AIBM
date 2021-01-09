public class Procedure {
    private int prof;
    private int procedure;
    private int date;
    private int begin;
    private int joinid;

    public int getJoinid() {
        return joinid;
    }

    public void setJoinid(int joinid) {
        this.joinid = joinid;
    }

    private String note;
    private int canceldate;
    private int profcancel;

    public Procedure() {
        canceldate=-1;
        profcancel=-1;

    }

    private String notecancel;
    private int intervention;


    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }


    public int getIntervention() {
        return intervention;
    }

    public void setIntervention(int intervention) {
        this.intervention = intervention;
    }

    public String getNotecancel() {
        return notecancel;
    }

    public void setNotecancel(String notecancel) {
        this.notecancel = notecancel;
    }

    public int getProfcancel() {
        return profcancel;
    }

    public void setProfcancel(int profcancel) {
        this.profcancel = profcancel;
    }

    public int getCanceldate() {
        return canceldate;
    }

    public void setCanceldate(int canceldate) {
        this.canceldate = canceldate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getProcedure() {
        return procedure;
    }

    public void setProcedure(int procedure) {
        this.procedure = procedure;
    }

    public int getProf() {
        return prof;
    }

    public void setProf(int prof) {
        this.prof = prof;
    }


}
