package com.example.comicbook.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.comicbook.Adapter.CustomAdapter;
import com.example.comicbook.Model.Comics;
import com.example.comicbook.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);    //ListView definition

        //Character Creation "Create ComicBookModeliNot.java"
        Comics maaSai = new Comics("MaaSai Mysterious","Unkown Job , Maasai gizemli kişiliği ile bir bilinmeyendir.Adı duyulmuştur ama kendisini gören tanıyan yoktur",R.drawable.maasai);
        Comics pirate = new Comics("Captain Canny","Pirate Job , Canny denizde korsanlık yapan yaptıgı yağmacılıkla hayatta kalan kurnazlıgı ile nam salmış bir korsandır",R.drawable.pirate);
        Comics santaClaus = new Comics("Santa Claus","Motorcyle Gang Leader , Santa Fimazen adlı motor siklet çetesinin gizemli lideridir seri kanlılığı ve atikliği ile bilinir.",R.drawable.santaclaus);
        Comics scareCrow = new Comics("Scare Crow","ScareCrow , ScareCrow gizemli bir karakterdir. Kendisinin en korku dolu zamanlarda ortaya cıktığı söylenmektedir.",R.drawable.scarecrow);
        Comics witch = new Comics("Witch","Witch, Büyü ile haşır neşir olan cadımız gizemli bir ormanda hüküm sürmektedir.Birgün yolunuz düşürse kurnazlıklarına karşı tetikte olmanız gerekmektedir.",R.drawable.witch);

        //ArrayList - "Create ComicBookModeliNot.java"
        ArrayList <Comics> comicsList =new ArrayList<>();
        comicsList.add(maaSai);
        comicsList.add(pirate);
        comicsList.add(santaClaus);
        comicsList.add(scareCrow);
        comicsList.add(witch);

        //ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,comicsList);
            //Neden ArrayAdapter Değil ? Açıklaması - "CustomAdapterNot.java"

        //Bağlama işlemi - Açıklaması - ListedeGösterimNot.java - Kod Zamanı 2 - 1-2'de"
        CustomAdapter customAdapter = new CustomAdapter(comicsList,MainActivity.this);
        listView.setAdapter(customAdapter);
        //

        //ClickListener //Açıklaması - "SerileştirmekNot.java - Kod Zamanı 1 -1'de"
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);    //Açıklaması - "SerileştirmekNot.java - Kod Zamanı 1 -2'de"
                intent.putExtra("selectedComics",comicsList.get(position)); //Açıklaması - "SerileştirmekNot.java Kod Zamanı 1 -4'de"
                startActivity(intent);

            }
        });
            //ClickListener Off


    }
}