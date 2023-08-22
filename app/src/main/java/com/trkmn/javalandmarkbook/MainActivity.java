package com.trkmn.javalandmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.trkmn.javalandmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landmarkArrayList = new ArrayList<>();

        //data
        Landmark anitkabir = new Landmark("Anıtkabir","Türkiye",R.drawable.anitkabir);
        Landmark cleopatrasGate = new Landmark("Kleopatra Kapısı", "Türkiye", R.drawable.cleopatrasgate);
        Landmark colosseum = new Landmark("Kolezyum","İtalya",R.drawable.colosseum);
        Landmark eiffel = new Landmark("Eyfel Kulesi", "Fransa", R.drawable.eiffel);
        Landmark galata = new Landmark("Galata Kulesi", "Türkiye", R.drawable.galata);
        Landmark londonBridge = new Landmark("Londra Köprüsü", "İngiltere", R.drawable.londonbridge);
        Landmark tacmahal = new Landmark("Tac Mahal", "Hindistan", R.drawable.tacmahal);

        landmarkArrayList.add(anitkabir);
        landmarkArrayList.add(cleopatrasGate);
        landmarkArrayList.add(colosseum);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(galata);
        landmarkArrayList.add(londonBridge);
        landmarkArrayList.add(tacmahal);

        //RecyclerView'un kendine ait bir adapter sınıfı var

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);


        /*
        //ListView
        //Adapter -> Veri kaynağı ve listView 'u birbirine bağlıyor
        //Mapping -> Bir yapıyı başka uyumlu yapıya dönüştürmek için kullanılır. Örneğin burda landmark objesini sadece name'lere dönüştürüyoruz
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,
                landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList())
                //landmark'ları landmark.name'lere dönüştürüyor ve sonra tekrar toplayıp liste yapıyor
        );
        binding.listView.setAdapter(arrayAdapter);

        //tıklama
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) { // int i -> position
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("landmark", landmarkArrayList.get(i));
                startActivity(intent);
            }
        });

        //Serializable
        //Bir yerden bir yere veri yollarken bunu veriye çevirip diğer tarafta eski haline getirebiliyor
        *

         */

    }
}