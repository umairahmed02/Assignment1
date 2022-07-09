package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.time.LocalDate;

public class NoteEdit extends AppCompatActivity {

    TextView txtTitle;
    EditText txtNote;
    Button btnPublish;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);

        getSupportActionBar().setTitle("New Note");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        txtNote = findViewById(R.id.txtBody);
        txtTitle = findViewById(R.id.txtTitle);
        btnPublish = findViewById(R.id.btnPublish);

        txtTitle.setText(Note.getInstance("a", "b", "s", "t", "d").title);
        btnPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inboundIntent = getIntent();
                String activity = inboundIntent.getStringExtra("Activity");
                Note note = new Note(txtNote.getText().toString(), User.getInstance("u", "p", "e").username, activity, txtTitle.getText().toString(), LocalDate.now().toString());
                db.collection("Note").document(note.title).set(note);

                switch(activity) {
                    case "Subject1":
                        Intent outboundIntent = new Intent(NoteEdit.this, Subject1.class);
                        startActivity(outboundIntent);
                        break;
                    case "Subject2":
                        Intent outboundIntent2 = new Intent(NoteEdit.this, Subject2.class);
                        startActivity(outboundIntent2);
                        break;
                    case "Subject3":
                        Intent outboundIntent3 = new Intent(NoteEdit.this, Subject3.class);
                        startActivity(outboundIntent3);
                        break;
                    case "Subject4":
                        Intent outboundIntent4 = new Intent(NoteEdit.this, Subject4.class);
                        startActivity(outboundIntent4);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}