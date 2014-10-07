package com.example.thinh.learning.model;

/**
 * Created by Nguyen Duc Thinh on 04/10/2014.
 * Project type: Android
 */
public class UETM_Contact_Model {

    private int id;
    private String name;
    private String type;

    public UETM_Contact_Model() {
        id = 0;
        name = "";
        type = "";
    }

    public UETM_Contact_Model(int _id, String _name, String _type) {
        id = _id;
        name = _name;
        type = _type;
    }

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        name = _name;
    }

    public String getType() {
        return type;
    }

    public void setType(String _type) {
        type = _type;
    }


}
