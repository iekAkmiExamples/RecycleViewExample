package com.example.recycleviewwithapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.hardware.biometrics.BiometricManager;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recycleviewwithapi.Details;
import com.example.recycleviewwithapi.R;
import com.example.recycleviewwithapi.models.University;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class DomainRecycleViewAdapter extends RecyclerView.Adapter<DomainRecycleViewAdapter.ViewHolder>{

    private String[] domains;
    private Context context;

    public DomainRecycleViewAdapter(Context context) {
        this.domains = new String[]{};
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.basic_list_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.domainText.setText(domains[position]);
    }

    @Override
    public int getItemCount() {
        return domains.length;
    }

    public String[] getUniversities() {
        return domains;
    }

    public void setDomains(String[] domains) {
        this.domains = domains;
        notifyDataSetChanged();
    }

    //responsible for generating the view objects
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView domainText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.domainText = itemView.findViewById(R.id.domainText);
        }
    }

}
