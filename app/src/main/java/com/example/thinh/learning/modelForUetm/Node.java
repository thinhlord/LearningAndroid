package com.example.thinh.learning.modelForUetm;

/**
 * Created by Nguyen Duc Thinh on 04/10/2014.
 * Project type: Android
 */

public abstract class Node {

    private String id;
    private String name;


    public Node() {
    }

    public Node(String id, String name) {
        setId(id);
        setName(name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String _name) {
        name = _name;
    }

    public abstract boolean isPersonNode();

    public String toString() {
        return getId();
    }

}
