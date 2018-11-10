package com.example.milenal.listoapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.milenal.listoapp.R;
import com.example.milenal.listoapp.model.Roover;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{

    private List<Roover> rooverList;

    public RecyclerAdapter(List<Roover> list) {
        this.rooverList = list;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list, parent, false);
        return new RecyclerViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Roover roover = rooverList.get(position);
        holder.item.setText(roover.getItemProgression());
    }

    @Override
    public int getItemCount() {
        return rooverList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView item;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.textItem);
        }
    }
}
