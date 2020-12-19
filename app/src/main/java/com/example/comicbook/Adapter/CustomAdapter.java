package com.example.comicbook.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.comicbook.Model.Comics;
import com.example.comicbook.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Comics> {

    private ArrayList<Comics> comics;
    private Activity context;

            //CustomAdapter Create - "CustomADapterNot.java"
    public CustomAdapter(ArrayList<Comics> comics,Activity context) {
        super(context, R.layout.custom_view,comics);
        this.comics = comics;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();    //Açıklaması - ListedeGösterimNot.java - Kod Zamanı 1 -1'de."
        View customView = layoutInflater.inflate(R.layout.custom_view,null,true); //Açıklaması - Listede GösterimNot.java - Kod Zamanı 1 -2'de."
        TextView nameView = customView.findViewById(R.id.customTextView);   //Açıklaması - ListedeGösterimNot.java - Kod Zamanı 1 -3'de"
        nameView.setText(comics.get(position).getName());   //Açıklaması - ListedeGösterimNot.java - Kod Zamanı 1 - 4'de"



        return customView;
    }
}
