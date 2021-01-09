public class Episódio {
    private int episodio;
    private int dateofbirth;
    private int gender;
    private int district;
    private int prof_admition;
    private int triage;
    private int discharge;
    private int diagnosis;
    private int exam;
    private int prescription;
    private int procedure;

    public Episódio() {
        exam=-1;
        prescription=-1;
        procedure=-1;
    }

    public int getProcedure() {
        return procedure;
    }

    public void setProcedure(int procedure) {
        this.procedure = procedure;
    }


    public int getPrescription() {
        return prescription;
    }

    public void setPrescription(int prescription) {
        this.prescription = prescription;
    }

    public int getExam() {
        return exam;
    }

    public void setExam(int exam) {
        this.exam = exam;
    }


    public int getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(int diagnosis) {
        this.diagnosis = diagnosis;
    }

    public int getDischarge() {
        return discharge;
    }

    public void setDischarge(int discharge) {
        this.discharge = discharge;
    }

    public int getTriage() {
        return triage;
    }

    public void setTriage(int triage) {
        this.triage = triage;
    }

    public int getProf_admition() {
        return prof_admition;
    }

    public void setProf_admition(int prof_admition) {
        this.prof_admition = prof_admition;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(int dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public int getEpisodio() {
        return episodio;
    }

    public void setEpisodio(int episodio) {
        this.episodio = episodio;
    }
}
