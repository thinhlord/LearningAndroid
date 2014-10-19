package com.example.thinh.learning.modelForUetm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen Duc Thinh on 18/10/2014.
 * Project type: Android
 */
public class GroupNode extends AbstractNode {

    private List<AbstractNode> childNode = new ArrayList<AbstractNode>();

    public List<AbstractNode> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<AbstractNode> childNode) {
        this.childNode = childNode;
    }

    public boolean isPersonNode() {
        return false;
    }
}
