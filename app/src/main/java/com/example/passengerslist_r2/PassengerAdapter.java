package com.example.passengerslist_r2;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PassengerAdapter extends RecyclerView.Adapter<PassengerAdapter.ViewHolder> {

    ArrayList<Passenger> passengers;
    OnSinglePassengerClicked activity;

    public interface OnSinglePassengerClicked{
        public void onClick(int position);
    }

    public PassengerAdapter(Context context, ArrayList<Passenger> list)
    {
        passengers = list;
        activity = (OnSinglePassengerClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivPref;
        TextView tvName, tvBloodGroup, tvReligion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPref = itemView.findViewById(R.id.ivPref);
            tvName = itemView.findViewById(R.id.tvName);
            tvBloodGroup = itemView.findViewById(R.id.tvBloodGroup);
            tvReligion = itemView.findViewById(R.id.tvReligion);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onClick(passengers.indexOf((Passenger) itemView.getTag()));
                }
            });

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.single_passenger_design, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.itemView.setTag(passengers.get(position));

        holder.tvName.setText(passengers.get(position).getName());
        holder.tvReligion.setText("Religion : "+passengers.get(position).getReligion());
        holder.tvBloodGroup.setText("Blood Group :"+passengers.get(position).getBloodGroup());

        if(passengers.get(position).getPreference().equals("bus"))
        {
            holder.ivPref.setImageResource(R.drawable.bus);
        }
        else if(passengers.get(position).getPreference().equals("plane"))
        {
            holder.ivPref.setImageResource(R.drawable.plane);
        }
        else if(passengers.get(position).getPreference().equals("train"))
        {
            holder.ivPref.setImageResource(R.drawable.train);
        }

    }

    @Override
    public int getItemCount() {
        return passengers.size();
    }
}
