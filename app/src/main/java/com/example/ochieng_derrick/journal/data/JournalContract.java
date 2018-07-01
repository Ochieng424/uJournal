package com.example.ochieng_derrick.journal.data;

import android.provider.BaseColumns;

public final class JournalContract {

    private JournalContract(){};

    public static final class JournalEntry implements BaseColumns{
        public final static String TABLE_NAME = "journals";
        public final static String COLUMN_JOURNAL_ID = "journal_ID";
        public final static String COLUMN_JOURNAL_TITLE = "journalTitle";
        public final static String COLUMN_JOURNAL_DETAILS = "journalDetails";
    }
}
