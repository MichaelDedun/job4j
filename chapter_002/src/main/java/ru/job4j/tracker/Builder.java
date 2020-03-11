package ru.job4j.tracker;

public class Builder extends Engineer {
    private String speciality;
    private String protection;

    public String buildForClient(Client client) {
        String order = client.getOrder();
        return "Заказ на постройку: " + order + "Выполнен";
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getProtection() {
        return protection;
    }

    public void setProtection(String protection) {
        this.protection = protection;
    }

}
