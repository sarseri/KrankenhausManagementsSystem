class Termin {
    Patient patient;
    Arzt doctor;
    String datum;

    public Termin(Patient patient, Arzt doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.datum = date;
    }

    @Override
    public String toString() {
        return "Patient: " + patient.name + ", Doctor: " + doctor.name + ", Datum: " + datum;
    }
}