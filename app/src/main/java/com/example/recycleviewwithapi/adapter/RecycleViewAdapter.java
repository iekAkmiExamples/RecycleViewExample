package com.example.recycleviewwithapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{

    private ArrayList<University> universities;
    private Context context;

    public RecycleViewAdapter(Context context) {
        this.universities = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(universities.get(position).getName());
        holder.txtCountry.setText(universities.get(position).getCountry());
        holder.txtState.setText(universities.get(position).getState() == null ? "-" : universities.get(position).getState());
        holder.downArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(holder.parent);
                holder.collapsableMenu.setVisibility(View.VISIBLE);
                holder.downArrow.setVisibility(View.GONE);
            }
        });
        holder.upArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                TransitionManager.beginDelayedTransition(holder.parent);
                holder.collapsableMenu.setVisibility(View.GONE);
                holder.downArrow.setVisibility(View.VISIBLE);
            }
        });
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, universities.get(holder.getAdapterPosition()).getName() + " clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Details.class);
                intent.putExtra("university", universities.get(holder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });

        Glide.with(context)
                .asBitmap()
                .load(universities.get(holder.getAdapterPosition()).getImageUri())
                .into(holder.image);
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

        private TextView txtName,txtCountry,txtState;
        private ImageView image,downArrow, upArrow;
        private MaterialCardView parent;
        private RelativeLayout collapsableMenu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.parent = itemView.findViewById(R.id.itemParent);
            this.txtCountry = itemView.findViewById(R.id.txtCountry);
            this.txtState = itemView.findViewById(R.id.txtState);
            this.txtName = itemView.findViewById(R.id.txtName);
            this.image = itemView.findViewById(R.id.image);
            this.downArrow = itemView.findViewById(R.id.openMenuButton);
            this.upArrow = itemView.findViewById(R.id.upArrow);
            this.collapsableMenu = itemView.findViewById(R.id.collapsableLayout);
        }
    }

}
