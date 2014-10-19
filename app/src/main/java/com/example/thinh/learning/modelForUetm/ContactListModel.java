package com.example.thinh.learning.modelForUetm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

/**
 * A demonstration of ContactList Model by Thinh
 */
public class ContactListModel {


    private static GroupNode root;
    private ContactListDbHelper mDbHelper;
    private SQLiteDatabase db;

    public ContactListModel(Context context) {
        mDbHelper = new ContactListDbHelper(context);
        root = new GroupNode(AbstractNode.ROOT_UID);
    }

    public ContactListModel() {
        root = new GroupNode(AbstractNode.ROOT_UID);
    }

    public void open() {
        db = mDbHelper.getReadableDatabase();
    }

    public void close() {
        db.close();
    }

    public void getTree() {

    }

    public List<AbstractNode> getChildNode(String uid) {
        AbstractNode parent = search(uid, root);
        if (parent.isPersonNode()) return null;
        else {
            return ((GroupNode) parent).getChildNodeList();
        }
    }

    public boolean isLeafNode(String uid) {
        AbstractNode result = search(uid, root);
        return result.isPersonNode();
    }

    private AbstractNode search(String uid, AbstractNode current) {
        Log.d("CLM", uid + " " + current.getUid());
        if (current.getUid().equals(uid)) return current;
        else if (current.isPersonNode()) return null;
        else {
            AbstractNode result = null;
            List<AbstractNode> children = ((GroupNode) current).getChildNodeList();
            for (AbstractNode i : children) {
                result = search(uid, i);
                if (result != null) return result;
            }
        }
        return null;
    }

    public AbstractNode getChild() {
        return null;
    }

    public void getDirectListNode() {

    }

    public AbstractNode getParent(String uid) {
        AbstractNode result = search(uid, root);
        return search(result.getParentUid(), root);
    }

    /*
    //
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
