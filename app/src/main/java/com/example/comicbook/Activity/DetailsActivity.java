package com.example.comicbook.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.comicbook.Model.Comics;
import com.example.comicbook.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

            //App Desing Definition
        ImageView imageView = findViewById(R.id.imageView);
        TextView nameText = findViewById(R.id.nameText);
        TextView bioText = findViewById(R.id.bioText);
            //

        //Try Bitmap.
        //Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.maasai);
        //imageView.setImageBitmap(bitmap);

                //İntent açıklaması - SerileştirmekNot.java - Kod Zamanı 1 - 6-7'de"
        Intent intent = getIntent();
        Comics selectedComics = (Comics) intent.getSerializableExtra("selectedComics");
            //İntent fnish.

        //Update bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(),selectedComics.getPictureInteger());
        imageView.setImageBitmap(bitmap);
        //

        nameText.setText(selectedComics.getName());
        bioText.setText(selectedComics.getBio());


    }
}