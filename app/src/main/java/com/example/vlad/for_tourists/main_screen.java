package com.example.vlad.for_tourists;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class main_screen extends AppCompatActivity {

    private Button save, cancel;
    private EditText name, desc, location;
    private DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        dbref = FirebaseDatabase.getInstance().getReference("Attractions");

        Intent i = getIntent();
        final String downloadURL = i.getStringExtra("url");


        save = findViewById(R.id.save_btn);
        cancel = findViewById(R.id.canc_btn);


        name = findViewById(R.id.et_desc);
        desc = findViewById(R.id.att_loc);
        location = findViewById(R.id.att_loc);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Attraction attr = new Attraction(name.getText().toString(), desc.getText().toString(), location.getText().toString(), downloadURL, "", false);
                dbref.child(attr.getName()).setValue(attr);
            }
        });


    }
}
