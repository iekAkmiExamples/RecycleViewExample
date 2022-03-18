package com.example.recycleviewwithapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.recycleviewwithapi.models.University;

public class Details extends AppCompatActivity {

    TextView uniName, uniCountry, uniState, uniCode;
    ImageView image;
    Button domainButton;
    University university;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //textViews
        this.uniName = findViewById(R.id.UniName);
        this.uniCountry = findViewById(R.id.countryName);
        this.uniState = findViewById(R.id.stateName);
        this.uniCode = findViewById(R.id.codeName);
        //image
        this.image = findViewById(R.id.uniImage);
        //buttons
        this.domainButton = findViewById(R.id.domainButton);
        //data from previous view
        this.university = getIntent().getExtras().getParcelable("university");
        //set values
        this.uniName.setText(this.university.getName());
        this.uniCountry.setText(this.university.getCountry());
        this.uniState.setText(this.university.getState());
        this.uniCode.setText(this.university.getCountryCode());
        Glide.with(this)
                .asBitmap()
                .load(this.university.getImageUri())
                .into(this.image);

        //action listeners
        if (university.getDomains().length > 0) {
            this.domainButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse(university.getDomains()[0]);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
        } else
            domainButton.setEnabled(false);
    }
}