package com.example.thinh.learning.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * A demonstration of ContactList Model by Thinh
 */
public class UETM_ContactList_Model {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ContactEntry.TABLE_NAME + " (" +
                    ContactEntry.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    ContactEntry.COLUMN_USER_NAME + TEXT_TYPE + COMMA_SEP +
                    ContactEntry.COLUMN_TYPE + TEXT_TYPE +
                    " )";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ContactEntry.TABLE_NAME;
    private ContactListDbHelper mDbHelper;
    private SQLiteDatabase db;

    public UETM_ContactList_Model(Context context) {
        mDbHelper = new ContactListDbHelper(context);
    }

    public void open() {
        db = mDbHelper.getReadableDatabase();
    }

    public void close() {
        db.close();
    }


    public void addContact(UETM_Contact_Model contact) {
        ContentValues values = new ContentValues();
        values.put(ContactEntry.COLUMN_USER_NAME, contact.getName());
        values.put(ContactEntry.COLUMN_TYPE, contact.getType());
        db.insert(ContactEntry.TABLE_NAME, null, values);
    }

    public void addContact(String name, String type) {
        ContentValues values = new ContentValues();
        values.put(ContactEntry.COLUMN_USER_NAME, name);
        values.put(ContactEntry.COLUMN_TYPE, type);
        db.insert(ContactEntry.TABLE_NAME, null, values);
    }

    public List<UETM_Contact_Model> getContactList() {
        List<UETM_Contact_Model> contacts = new ArrayList<UETM_Contact_Model>();

        String[] allColumn = {
                ContactEntry._ID,
                ContactEntry.COLUMN_ID,
                ContactEntry.COLUMN_USER_NAME,
                ContactEntry.COLUMN_TYPE
        };

        Cursor cursor = db.query(ContactEntry.TABLE_NAME, allColumn,
                null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            UETM_Contact_Model contact = cursorToContact(cursor);
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
                ContactEntry.COLUMN_USER_NAME,
                ContactEntry.COLUMN_TYPE
        };

        Cursor cursor = db.query(ContactEntry.TABLE_NAME, allColumn,
                null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            UETM_Contact_Model contact = cursorToContact(cursor);
            contacts.add(contact.getName() + " " + contact.getId());
            cursor.moveToNext();
        }
        cursor.close();
        return contacts;
    }

    public void deleteContact(UETM_Contact_Model contact) {
        long id = contact.getId();
        db.delete(ContactEntry.TABLE_NAME, ContactEntry.COLUMN_ID
                + " = " + id, null);
    }

    public void deleteContact(int id) {
        db.delete(ContactEntry.TABLE_NAME, ContactEntry.COLUMN_ID
                + " = " + id, null);
    }

    public void deleteContact(String name) {
        db.delete(ContactEntry.TABLE_NAME, ContactEntry.COLUMN_USER_NAME
                + " = " + name, null);
    }

    public void dropDb() {
        db.execSQL(SQL_DELETE_ENTRIES);
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    private UETM_Contact_Model cursorToContact(Cursor cursor) {
        UETM_Contact_Model contact = new UETM_Contact_Model();
        contact.setId(cursor.getInt(cursor.getColumnIndex(ContactEntry.COLUMN_ID)));
        contact.setName(cursor.getString(cursor.getColumnIndex(ContactEntry.COLUMN_USER_NAME)));
        contact.setType(cursor.getString(cursor.getColumnIndex(ContactEntry.COLUMN_TYPE)));
        return contact;
    }

    public static abstract class ContactEntry implements BaseColumns {
        public static final String TABLE_NAME = "contact";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_USER_NAME = "name";
        public static final String COLUMN_TYPE = "type";
    }

    public class ContactListDbHelper extends SQLiteOpenHelper {
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "ContactList.db";

        public ContactListDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
    }


}
