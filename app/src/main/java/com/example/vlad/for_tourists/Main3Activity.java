package com.example.vlad.for_tourists;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Attr;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {


    private RecyclerView rv;
    private RecyclerView.LayoutManager manager;
    private AttractionAdapter adapter;
    DatabaseReference dbref;
    ArrayList<Attraction> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        rv = findViewById(R.id.id_rv);
        manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);

        dbref = FirebaseDatabase.getInstance().getReference("Attractions");
        dbref.addListenerForSingleValueEvent(listener);

    }

    ValueEventListener listener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            for (DataSnapshot dss:dataSnapshot.getChildren()){

                Attraction attr = dss.getValue(Attraction.class);
                list.add(attr);
            }

            adapter = new AttractionAdapter(list);
            rv.setAdapter(adapter);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
}
