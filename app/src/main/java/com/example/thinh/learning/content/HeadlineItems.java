package com.example.thinh.learning.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeadlineItems {

    public static List<HeadlineText> ITEMS = new ArrayList<HeadlineText>();

    public static Map<String, HeadlineText> ITEM_MAP = new HashMap<String, HeadlineText>();

    public static boolean[] saved = {false, false, false};
    static {
        // Add 3 sample items.
        addItem(new HeadlineText("1", "Option 1"));
        addItem(new HeadlineText("2", "Option 2"));
        addItem(new HeadlineText("3", "Option 3"));
    }

    private static void addItem(HeadlineText item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static class HeadlineText {
        public String id;
        public String content;

        public HeadlineText(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }

    public static void setSaved(int option) {
        saved[option] = true;
    }

    public static void setNoSaved(int option) {
        saved[option] = false;
    }
}
