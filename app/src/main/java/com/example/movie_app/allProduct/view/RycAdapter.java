package com.example.movie_app.allProduct.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie_app.Model.Product;
import com.example.movie_app.R;

import java.util.ArrayList;
import java.util.List;

public  class RycAdapter extends RecyclerView.Adapter<RycAdapter.MyViewHolder> {


    Context context;
    List<Product> products;
    private  PutInFavListener listner;

    public RycAdapter(Context context, List<Product> products ,PutInFavListener _listener){
        this.context = context;
        this.products = products;
        this.listner=_listener;
        products=new ArrayList<>();

    }
    public  void SetList(List<Product>updateProducts){
        this.products=updateProducts;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.rv_product,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Product product = products.get(position);
        holder.tvTitle.setText("Title:  " +products.get(position).getTitle());
        holder.tvPrice.setText("Price:  " + products.get(position).getProductPrice () );
        holder.tvBrand.setText("Brand:  " +products.get(position).getProductBrand());
        holder.tvDesc.setText("Desc:  " +products.get(position).getProductcategory());
        holder.ratingBar.setText("Rating:  " +products.get(position).getRating().toString());
        Glide.with(context).load(products.get(position).getProductthumbnail()).into(holder.img);
        holder.Fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listner != null) {
                    listner.oPutInFavClick(product);
                }
            }
        });



//        class Downloader extends AsyncTask<String,Void, Bitmap> {
//
//            @Override
//            protected Bitmap doInBackground(String... url) {
//                return downloadImage(url[0]);
//            }
//
//            @Override
//            protected void onPostExecute(Bitmap bitmap) {
//                super.onPostExecute(bitmap);
//                holder.img.setImageBitmap(bitmap);
//            }
//        }
//        Downloader downloader =new Downloader();
//        downloader.execute(products.get(position).getProductthumbnail());

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        TextView tvPrice;
        TextView tvBrand;
        TextView tvDesc;
        ImageView img;
        TextView ratingBar;
        Button Fav;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            tvBrand=itemView.findViewById(R.id.tvBrand);
            tvDesc=itemView.findViewById(R.id.tvDesc);
            ratingBar=itemView.findViewById(R.id.tvRating);
            img=itemView.findViewById(R.id.imageView);
            Fav=itemView.findViewById(R.id.FAV);

        }
    }}
