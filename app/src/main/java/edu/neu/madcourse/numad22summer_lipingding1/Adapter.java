package edu.neu.madcourse.numad22summer_lipingding1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private ArrayList<LinkItem> linksList;
    private ItemClickListener listener;

    public Adapter(ArrayList<LinkItem> linksList, ItemClickListener listener) {
        this.linksList = linksList;
        this.listener = listener;
    }

    public void setOnItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.link_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        LinkItem currentItem = linksList.get(position);
        holder.nameText.setText(currentItem.getName());
        holder.urlText.setText(currentItem.getUrl());
    }

    @Override
    public int getItemCount() {
        return linksList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nameText;
        private TextView urlText;
        private ConstraintLayout linkLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.nameText);
            urlText = itemView.findViewById(R.id.urlText);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getLayoutPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
