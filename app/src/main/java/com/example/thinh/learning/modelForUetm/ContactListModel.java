package com.example.thinh.learning.modelForUetm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * A demonstration of ContactList Model by Thinh
 */
public class ContactListModel {


    private static AbstractNode root;
    private ContactListDbHelper mDbHelper;
    private SQLiteDatabase db;

    public ContactListModel(Context context) {
        mDbHelper = new ContactListDbHelper(context);

    }

    public void open() {
        db = mDbHelper.getReadableDatabase();
    }

    public void close() {
        db.close();
    }

    public void getTree() {

    }

    public AbstractNode getChildNode() {
        return null;
    }

    public AbstractNode getChild() {
        return null;
    }

    public void getDirectListNode() {

    }

    public void getParent() {

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
