package com.example.testgit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

    ArrayList<Model> models;
    Context ctx;
    public AdapterData(Context context, ArrayList<Model> models) {
        this.models = models;
        this.inflater = LayoutInflater.from(context);
        ctx=context;
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
        Model model = models.get(position);
        holder.mNama.setText(model.getNama());
        Glide.with(ctx)
                .load(model.getGambar())
                .into(holder.mImage);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctx.startActivity(new Intent(ctx,DetailHotel.class).putExtra("id", model.getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView mNama;
        ImageView mImage;
        RelativeLayout container;
        public HolderData(@NonNull View itemView) {
            super(itemView);
            mNama = itemView.findViewById(R.id.nama);
            mImage = itemView.findViewById(R.id.image);
            container = itemView.findViewById(R.id.data_container);
        }
    }
}
