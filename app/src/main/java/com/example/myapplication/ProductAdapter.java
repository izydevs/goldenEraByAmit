package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.HeroViewHolder> {

    Context mCtx;
    HashMap<String, List<Product.Categorys>> productList;

    public ProductAdapter(Context mCtx, HashMap<String, List<Product.Categorys>> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.item_layout, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        if (position>productList.get("Women").size() && position<productList.get("Women").size()+productList.get("Men").size()-1 ){
            holder.textView.setText(productList.get("Men").get(0).name);

            Glide.with(mCtx)
                    .load(productList.get("Men").get(0).getImage())
                    .into(holder.imageView);
        }else if (position>productList.get("Men").size()){
            holder.textView.setText(productList.get("Kids").get(0).name);


            Glide.with(mCtx)
                    .load(productList.get("Kids").get(0).getImage())
                    .into(holder.imageView);
        }else {
            holder.textView.setText(productList.get("Women").get(position).name);


            Glide.with(mCtx)
                    .load(productList.get("Women").get(position).getImage())
                    .into(holder.imageView);
        }

}

    @Override
    public int getItemCount() {
        return productList.get("Women").size() + productList.get("Men").size() + productList.get("Kids").size();
    }

class HeroViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView;

    public HeroViewHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.image);
        textView = itemView.findViewById(R.id.name);
    }
}
}
