package com.example.thinh.learning.modelForUetm;

/**
 * Created by Nguyen Duc Thinh on 04/10/2014.
 * Project type: Android
 */

public abstract class AbstractNode {

    public static final String ROOT_UID = "0";
    protected ContactServer data = new ContactServer();
    private String uid;
    private String name;
    private int level;
    private String parentUid;


    public AbstractNode() {
    }

    // Create a contact node using its uid only, the rests will be got from server
    public AbstractNode(String _uid) {
        setUid(_uid);
        setName(data.requestName(_uid));
        setLevel(data.requestLv(_uid));
        setParentUid(data.requestParent(_uid));
    }

    public String getParentUid() {
        return parentUid;
    }

    public void setParentUid(String parentUid) {
        this.parentUid = parentUid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String _name) {
        name = _name;
    }

    public abstract boolean isPersonNode();

    public String toString() {
        return getName();
    }

}
