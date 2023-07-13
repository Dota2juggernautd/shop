package com.example.shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Product> products;

    public ProductAdapter(Context context, List<Product> products) {
        this.products = products;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position) {
        Product product = products.get(position);
        holder.price.setText("$"+product.getPrice());
        holder.nameView.setText(product.getTitle());
        holder.rating.setText(product.getRating().toString());
        holder.description_product.setText(product.getDescription());
        Glide.with(inflater.getContext()).load(product.getThumbnail()).into(holder.img_product);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
         ImageView img_product;
         TextView price;
         TextView rating;
         TextView nameView, description_product;
        ViewHolder(View view){
            super(view);

            price = view.findViewById(R.id.price);
            img_product = view.findViewById(R.id.img_product);
            nameView = view.findViewById(R.id.name);
            rating = view.findViewById(R.id.rating);
            description_product = view.findViewById(R.id.description_product);
        }
    }
}