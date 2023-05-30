package com.example.mykiosk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykiosk.model.Menu;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    Context context;

    ArrayList<? extends Menu> menuArrayList;
    private OnItemClickListener listener;

    public MyAdapter(Context context, ArrayList<? extends Menu> menuArrayList,OnItemClickListener listener) {

        this.context = context;
        this.menuArrayList=menuArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.menu_item,parent,false);
        return new MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Menu menu=menuArrayList.get(position);

        holder.menuImage.setImageResource(menu.getMenuImage());
        holder.menuName.setText(menu.getMenuName());
        holder.menuPrice.setText(menu.getMenuPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(menu);
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ShapeableImageView menuImage;
        TextView menuName;
        TextView menuPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            menuImage = itemView.findViewById(R.id.menu_image);
            menuName = itemView.findViewById(R.id.menu_name);
            menuPrice = itemView.findViewById(R.id.menu_price);


        }

    }
    public interface OnItemClickListener{
        public void onItemClick(Menu menu);
    }
}
