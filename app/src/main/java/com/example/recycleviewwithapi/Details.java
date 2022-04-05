package com.example.recycleviewwithapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.recycleviewwithapi.adapter.DomainRecycleViewAdapter;
import com.example.recycleviewwithapi.adapter.RecycleViewAdapter;
import com.example.recycleviewwithapi.models.University;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Details extends AppCompatActivity {

    TextView uniName, uniCountry, uniState, uniCode;
    ImageView image;
    Button domainButton;
    RecyclerView domainsRecyclerView, websitesRecyclerView;
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
        //recycle View
        this.domainsRecyclerView = findViewById(R.id.domainsList);
        this.websitesRecyclerView = findViewById(R.id.websitesList);
        //data from previous view
        this.university = getIntent().getExtras().getParcelable("university");
        //set values
        this.uniName.setText(this.university.getName());
        this.uniCountry.setText(this.university.getCountry());
        this.uniState.setText(this.university.getState()==null ? "-" : this.university.getState());
        this.uniCode.setText(this.university.getCountryCode());
        Glide.with(this)
                .asBitmap()
                .load(this.university.getImageUri())
                .into(this.image);

        //setup recycle view
        DomainRecycleViewAdapter domainsAdapter = new DomainRecycleViewAdapter(this);
        domainsAdapter.setDomains(university.getDomains());

        DomainRecycleViewAdapter websitesAdapter = new DomainRecycleViewAdapter(this);
        websitesAdapter.setDomains(university.getWebpages());

        this.domainsRecyclerView.setAdapter(domainsAdapter);
        this.domainsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        this.websitesRecyclerView.setAdapter(websitesAdapter);
        this.websitesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

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