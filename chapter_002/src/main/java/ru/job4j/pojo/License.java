package ru.job4j.pojo;

import java.util.Objects;

public class License {
    private String owner;
    private String model;
    private String code;
    private License created;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public License getCreated() {
        return created;
    }

    public void setCreated(License created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof License)) {
            return false;
        }
        License license = (License) o;
        return Objects.equals(getOwner(), license.getOwner())
                && Objects.equals(getModel(), license.getModel())
                && Objects.equals(getCode(), license.getCode())
                && Objects.equals(getCreated(), license.getCreated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOwner(), getModel(), getCode(), getCreated());
    }

}
