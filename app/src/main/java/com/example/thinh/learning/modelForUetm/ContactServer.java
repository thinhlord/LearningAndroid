package com.example.thinh.learning.modelForUetm;

import java.util.ArrayList;

/**
 * Created by Nguyen Duc Thinh on 18/10/2014.
 * Project type: Android
 * This is a demo ContactSever with some fake data
 */
public class ContactServer {

    public boolean[] isLeaf = {false, false, false, true, true, true, true};
    public String[] uidDemo = {"0", "1", "2", "3", "4", "5", "6"};
    public String[] nameDemo = {"root", "cntt", "dtvt", "k56", "k57", "k56", "k57"};
    public int[] lvDemo = {0, 1, 1, 2, 2, 2, 2};
    public String[] parentUidDemo = {"", "0", "0", "1", "1", "2", "2"};
    public ArrayList<String[]> childUidDemo = new ArrayList<String[]>();

    public ContactServer() {
        String[] child0 = {"1", "2"};
        String[] child1 = {"3", "4"};
        String[] child2 = {"5", "6"};
        childUidDemo.add(child0);
        childUidDemo.add(child1);
        childUidDemo.add(child2);
    }

    public String requestName(String uid) {
        return nameDemo[Integer.parseInt(uid)];
    }

    public int requestLv(String uid) {
        return lvDemo[Integer.parseInt(uid)];
    }

    public String requestParent(String uid) {
        return parentUidDemo[Integer.parseInt(uid)];
    }

    public String[] requestChildUid(String uid) {
        return childUidDemo.get(Integer.parseInt(uid));
    }

    public String requestPersonData(String uid) {
        return "Nothing";
    }

    public boolean requestIsLeafNode(String uid) {
        return isLeaf[Integer.parseInt(uid)];
    }

}
