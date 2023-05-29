package com.example.mykiosk;
// OrderAdapter.java

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykiosk.model.Order;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private Context context;
    private ArrayList<Order> orderList;

    public OrderAdapter(Context context, ArrayList<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_item, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order order = orderList.get(position);

        holder.quantityTextView.setText(String.valueOf(order.getOrderQuantity()));
        holder.menuTextView.setText(order.getOrderMenu());
        holder.priceTextView.setText(order.getOrderPrice());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView quantityTextView;
        TextView menuTextView;
        TextView priceTextView;

        TextView totalQuantityTextView;

        TextView totalPriceTextView;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            quantityTextView = itemView.findViewById(R.id.order_menu_quentity);
            menuTextView = itemView.findViewById(R.id.order_menu_name);
            priceTextView = itemView.findViewById(R.id.order_menu_price);
            totalQuantityTextView=itemView.findViewById(R.id.order_total_price);
            totalPriceTextView=itemView.findViewById(R.id.order_total_price);

        }
    }
}

