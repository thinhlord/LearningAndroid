package com.example.thinh.learning.modelForUetm;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A demonstration of ContactList Model by Thinh
 */
public class ModelContactList {

    private static final String TYPE_PARAMS = "type";
    private static final String TYPE_GROUP_NODE = "group";
    //private static final String TYPE_PERSON_NODE = "person";
    private static final String NAME_PARAMS = "name";
    private static final String PERSON_STD_ID = "student_id";
    private static final String PERSON_DOB = "dob";
    private static final String PERSON_GENDER = "gender";
    private static final String PERSON_ACAD_YEAR = "academic_year";
    private static final String PERSON_ACAD_YEAR_CLASS = "class";
    private static final String PERSON_CONTACT = "contact";
    private static final String PERSON_AC = "achievement";
    private static final String PERSON_STRONG = "strong_point";

    //private Node root;


    public ModelContactList() {
        //root = new GroupNode();
    }

    public List<Node> getChildNodeOfRoot() {
        return getChildNode("R");
    }

    public List<PersonNode> getChildPersonNode(String id) {
        List<Node> childList = this.getChildNode(id);
        List<PersonNode> result = new ArrayList<PersonNode>();
        for (Node i : result) {
            if (i.isPersonNode()) result.add((PersonNode) i);
        }
        return result;
    }

    public List<GroupNode> getChildGroupNode(String id) {
        List<Node> childList = this.getChildNode(id);
        List<GroupNode> result = new ArrayList<GroupNode>();
        for (Node i : result) {
            if (!i.isPersonNode()) result.add((GroupNode) i);
        }
        return result;
    }

    public List<Node> getChildNode(String id) {
        List<Node> result = new ArrayList<Node>();
        JSONArray childArray = serverContactListRequest(id);
        for (int i = 0; i < childArray.length(); i++) {
            try {
                JSONObject childObj = childArray.getJSONObject(i);
                Node child;
                String name = childObj.getString(NAME_PARAMS);
                if (childObj.getString(TYPE_PARAMS).equals(TYPE_GROUP_NODE)) {
                    child = new GroupNode(id, name, null);
                } else {
                    //if (childObj.getString(TYPE_PARAMS).equals(TYPE_PERSON_NODE))
                    String studentId = childObj.getString(PERSON_STD_ID);
                    String dob = childObj.getString(PERSON_DOB);
                    Boolean gender = childObj.getBoolean(PERSON_GENDER);
                    String acadYear = childObj.getString(PERSON_ACAD_YEAR);
                    String acadYearClass = childObj.getString(PERSON_ACAD_YEAR_CLASS);
                    String contact = childObj.getString(PERSON_CONTACT);
                    String ac = childObj.getString(PERSON_AC);
                    String strongP = childObj.getString(PERSON_STRONG);
                    child = new PersonNode(id, studentId, name, dob, gender,
                            acadYear, acadYearClass, contact, ac, strongP);
                }
                result.add(child);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private JSONArray serverContactListRequest(String id) {
        return null;
    }



    /*
    //
    private static GroupNode root;
    private ContactListDbHelper mDbHelper;
    private SQLiteDatabase db;

    public ModelContactList(Context context) {
        mDbHelper = new ContactListDbHelper(context);
        root = new GroupNode(Node.ROOT_UID);
    }

    public void open() {
        db = mDbHelper.getReadableDatabase();
    }

    public void close() {
        db.close();
    }

    public Node getTree() { return root; }
    public void addContact(UETM_Contact_Node contact) {
        ContentValues values = new ContentValues();
        values.put(ContactEntry.COLUMN_PARENT, contact.getName());
        values.put(ContactEntry.COLUMN_CHILD, contact.getType());
        db.insert(ContactEntry.TABLE_NAME, null, values);
    }

    public List<UETM_Contact_Node> getContactList() {
        List<UETM_Contact_Node> contacts = new ArrayList<UETM_Contact_Node>();

        String[] allColumn = {
                ContactEntry.COLUMN_ID,
                ContactEntry.COLUMN_PARENT,
                ContactEntry.COLUMN_CHILD
        };

        Cursor cursor = db.query(ContactEntry.TABLE_NAME, allColumn,
                null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            UETM_Contact_Node contact = cursorToContact(cursor);
            contacts.add(contact);
            cursor.moveToNext();
        }
        cursor.close();
        return contacts;
    }

    public List<String> getContactListName() {
        List<String> contacts = new ArrayList<String>();

        String[] allColumn = {
                ContactEntry.COLUMN_ID,
                ContactEntry.COLUMN_PARENT,
                ContactEntry.COLUMN_CHILD
        };

        Cursor cursor = db.query(ContactEntry.TABLE_NAME, allColumn,
                null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            UETM_Contact_Node contact = cursorToContact(cursor);
            contacts.add(contact.getName() + " " + contact.getId());
            cursor.moveToNext();
        }
        cursor.close();
        return contacts;
    }

    public void deleteContact(UETM_Contact_Node contact) {
        long id = contact.getId();
        db.delete(ContactEntry.TABLE_NAME, ContactEntry.COLUMN_ID
                + " = " + id, null);
    }

    public void deleteContact(int id) {
        db.delete(ContactEntry.TABLE_NAME, ContactEntry.COLUMN_ID
                + " = " + id, null);
    }

    public void deleteContact(String name) {
        db.delete(ContactEntry.TABLE_NAME, ContactEntry.COLUMN_PARENT
                + " = " + name, null);
    }

    public void dropDb() {
        db.execSQL(ContactEntry.SQL_DELETE_ENTRIES);
        db.execSQL(ContactEntry.SQL_CREATE_ENTRIES);
    }

    private UETM_Contact_Node cursorToContact(Cursor cursor) {
        UETM_Contact_Node contact = new UETM_Contact_Node();
        contact.setId(cursor.getInt(cursor.getColumnIndex(ContactEntry.COLUMN_ID)));
        contact.setName(cursor.getString(cursor.getColumnIndex(ContactEntry.COLUMN_PARENT)));
        contact.setType(cursor.getString(cursor.getColumnIndex(ContactEntry.COLUMN_CHILD)));
        return contact;
    }
    */

}
