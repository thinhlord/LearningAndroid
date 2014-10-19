package com.example.thinh.learning.modelForUetm;

import android.provider.BaseColumns;

/**
 * Created by Nguyen Duc Thinh on 12/10/2014.
 * Project type: Android
 * Description: This class contains some strings for SQLite commands and SQLite table structure
 */
public abstract class ContactEntry implements BaseColumns {
    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA_SEP = ",";
    public static final String TABLE_NAME = "contact";
    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ContactEntry.TABLE_NAME;
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PARENT = "name";
    public static final String COLUMN_CHILD = "child";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ContactEntry.TABLE_NAME + " (" +
                    ContactEntry.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    ContactEntry.COLUMN_PARENT + TEXT_TYPE + COMMA_SEP +
                    ContactEntry.COLUMN_CHILD + TEXT_TYPE +
                    " )";
}
