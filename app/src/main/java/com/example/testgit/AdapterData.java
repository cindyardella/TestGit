package com.example.testgit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

    ArrayList<Model> models;

    public AdapterData(Context context, ArrayList<Model> models) {
        this.models = models;
        this.inflater = LayoutInflater.from(context);
    }

    LayoutInflater inflater;

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_data,parent,false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.mNama.setText(models.get(position).getNama());
        holder.mImage.setImageResource(models.get(position).getGambar());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView mNama;
        ImageView mImage;
        public HolderData(@NonNull View itemView) {
            super(itemView);

            mNama = itemView.findViewById(R.id.nama);
            mImage = itemView.findViewById(R.id.image);
        }
    }
}
