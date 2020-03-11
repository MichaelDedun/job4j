package ru.job4j.tracker;

public class Doctor extends Profession {
    private String experience;
    private Patient patient;

    public String getExperience() {
        return experience;
    }

    public Patient getPatient() {
        return patient;
    }

    public Diagnose heal(Patient patient) {
        return patient.getDiagnose();
    }

    public void makeDiagnose(Patient patient) {
        patient.getDiagnose().setDiagnose("Простуда");
    }

}
