package com.example.milenal.listoapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.applandeo.materialcalendarview.CalendarView;
import com.example.milenal.listoapp.R;
import com.example.milenal.listoapp.conection.Conection;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddNoteActivity extends AppCompatActivity {

    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        final CalendarView datePicker = findViewById(R.id.datePicker);
        Button button = findViewById(R.id.addNoteButton);
        final EditText noteEditText = findViewById(R.id.noteEditText);

        reference = FirebaseDatabase.getInstance().getReference();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();

                if(noteEditText.getText().length() == 0){
                    Toast.makeText(AddNoteActivity.this, "Preencha uma anotação.", Toast.LENGTH_SHORT).show();
                }else{
                    MyEventDay myEventDay = new MyEventDay(datePicker.getSelectedDate(),
                            R.drawable.ic_pet, noteEditText.getText().toString());
                    returnIntent.putExtra(Planner.RESULT, myEventDay);
                    setResult(Activity.RESULT_OK, returnIntent);

                    reference.child("User").child("Event").setValue(returnIntent);

                    finish();
                }
            }
        });
    }
}
