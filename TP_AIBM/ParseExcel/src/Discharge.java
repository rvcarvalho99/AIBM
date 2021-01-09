public class Discharge {

    private int date;
    private int reason;
    private int destination;
    private int prof;

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public Discharge() {
    }

    public int getProf() {
        return prof;
    }

    public void setProf(int prof) {
        this.prof = prof;
    }

    public int getReason() {
        return reason;
    }

    public void setReason(int cause) {
        this.reason = cause;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
