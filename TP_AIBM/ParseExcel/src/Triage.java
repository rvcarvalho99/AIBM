public class Triage {

    private int date;
    private int color;
    private int pain;
    private int prof;

    public Triage() {
    }

    public int getProf() {
        return prof;
    }

    public void setProf(int prof) {
        this.prof = prof;
    }

    public int getPain() {
        return pain;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setPain(int cause) {
        this.pain = cause;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}

