package com.example.recycleviewwithapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recycleviewwithapi.models.University;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerView = findViewById(R.id.recycleView);

        ArrayList<University> universities = new ArrayList<>();
        universities.add(
                new University(
                        "Greece", "Hellenic Open University",
                        new String[]{"http://www.eap.gr/"}, "GR", null, new String[]{"http://www.eap.gr/"}));
        universities.add(
                new University(
                        "Greece", "Hellenic Open University",
                        new String[]{"http://www.eap.gr/"}, "GR", null, new String[]{"http://www.eap.gr/"}));


    }
}