package com.example.ochieng_derrick.journal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ochieng_derrick.journal.data.JournalContract;
import com.example.ochieng_derrick.journal.data.JournalDbHelper;

public class AddActivity extends AppCompatActivity {
    TextInputLayout IdWrap, titleWrap, detailsWrap;
    TextInputEditText journalID, journalTitle, journalDetails;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        IdWrap = findViewById(R.id.IdWrap);
        titleWrap = findViewById(R.id.titleWrap);
        detailsWrap = findViewById(R.id.detailsWrap);

        journalID = findViewById(R.id.journalID);
        journalTitle = findViewById(R.id.journalTitle);
        journalDetails = findViewById(R.id.journalDetails);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertJournal();
                finish();
            }
        });
    }

    private void insertJournal(){
       String journal_ID = journalID.getText().toString().trim();
       String journal_Title = journalTitle.getText().toString().trim();
       String journal_Details = journalDetails.getText().toString().trim();

        JournalDbHelper jDbHelper = new JournalDbHelper(this);
       SQLiteDatabase db = jDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(JournalContract.JournalEntry.COLUMN_JOURNAL_ID, journal_ID);
        values.put(JournalContract.JournalEntry.COLUMN_JOURNAL_TITLE, journal_Title);
        values.put(JournalContract.JournalEntry.COLUMN_JOURNAL_DETAILS, journal_Details);

        long newRowID = db.insert(JournalContract.JournalEntry.TABLE_NAME, null, values);

        if (newRowID == -1){
            Toast.makeText(AddActivity.this, "Error with saving Journal", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(AddActivity.this, "Journal saved with row id: " + newRowID, Toast.LENGTH_SHORT).show();
        }

    }
}
