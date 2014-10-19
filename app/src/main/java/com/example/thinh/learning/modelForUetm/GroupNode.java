package com.example.thinh.learning.modelForUetm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen Duc Thinh on 18/10/2014.
 * Project type: Android
 */
public class GroupNode extends AbstractNode {

    private List<AbstractNode> childNode = new ArrayList<AbstractNode>();

    GroupNode(String _uid) {
        super(_uid);
        String[] childUid = data.requestChildUid(_uid);
        for (String i : childUid) {
            if (data.requestIsLeafNode(i)) {
                addChildNode(new PersonNode(i));
            } else {
                addChildNode(new GroupNode(i));
            }
        }
    }

    public List<AbstractNode> getChildNodeList() {
        return childNode;
    }

    public void setChildNode(List<AbstractNode> childNode) {
        this.childNode = childNode;
    }

    public void addChildNode(AbstractNode child) {
        childNode.add(child);
    }

    public boolean isPersonNode() {
        return false;
    }

}
