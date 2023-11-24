package com.example.passengerslist_r2;

public class Passenger {
    private String preference; // bus, plane, train
    private String name;
    private String bloodGroup;
    private String religion;

    public Passenger() {
    }

    public Passenger(String preference, String name, String bloodGroup, String religion) {
        this.preference = preference;
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.religion = religion;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "preference='" + preference + '\'' +
                ", name='" + name + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", religion='" + religion + '\'' +
                '}';
    }
}
