package com.example.movie_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.movie_app.Fav.view.FavActivity;
import com.example.movie_app.allProduct.view.AllProductsActivity;

public class MainActivity extends AppCompatActivity {
    Button Exit ;
    Button All;
    Button Fav ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Exit=findViewById(R.id.Exit);
        All=findViewById(R.id.All);
        Fav=findViewById(R.id.Fav);
        All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AllProductsActivity.class);
                startActivity(myIntent);
            }
        });
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), FavActivity.class);
                startActivity(myIntent);
            }
        });
    }

}