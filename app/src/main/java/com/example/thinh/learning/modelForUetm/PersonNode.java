package com.example.thinh.learning.modelForUetm;

/**
 * Created by Nguyen Duc Thinh on 18/10/2014.
 * Project type: Android
 */
public class PersonNode extends AbstractNode {

    private String personalData;

    public String getPersonalData() {
        return personalData;
    }

    public void setPersonalData(String personalData) {
        this.personalData = personalData;
    }

    public boolean isPersonNode() {
        return true;
    }
}
