package com.example.thinh.learning.modelForUetm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen Duc Thinh on 18/10/2014.
 * Project type: Android
 */
public class GroupNode extends Node {

    private List<Node> childNode = new ArrayList<Node>();

    public GroupNode() {
    }

    public GroupNode(String id, String name, List<Node> childNode) {
        super(id, name);
        this.setChildNode(childNode);
    }

    public List<Node> getChildNodeList() {
        return childNode;
    }

    public void setChildNode(List<Node> childNode) {
        this.childNode = childNode;
    }

    public void addChildNode(Node child) {
        childNode.add(child);
    }

    public boolean isPersonNode() {
        return false;
    }

    public List<GroupNode> getGroupChildNode() {
        List<GroupNode> result = new ArrayList<GroupNode>();
        for (Node i : childNode) {
            if (!i.isPersonNode()) result.add((GroupNode) i);
        }
        return result;
    }

    public List<PersonNode> getGroupPersonNode() {
        List<PersonNode> result = new ArrayList<PersonNode>();
        for (Node i : childNode) {
            if (i.isPersonNode()) result.add((PersonNode) i);
        }
        return result;
    }

}
