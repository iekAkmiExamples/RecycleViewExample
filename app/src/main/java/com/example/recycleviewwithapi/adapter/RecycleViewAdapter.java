package com.example.recycleviewwithapi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewwithapi.R;
import com.example.recycleviewwithapi.models.University;
import com.google.android.material.card.MaterialCardView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{

    private ArrayList<University> universities;

    public RecycleViewAdapter() {
        this.universities = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(universities.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return universities.size();
    }

    public ArrayList<University> getUniversities() {
        return universities;
    }

    public void setUniversities(ArrayList<University> universities) {
        this.universities = universities;
        notifyDataSetChanged();
    }

    //responsible for generating the view objects
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName;
        private MaterialCardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cardView = itemView.findViewById(R.id.item);
            this.txtName = itemView.findViewById(R.id.txtName);
        }
    }

}
