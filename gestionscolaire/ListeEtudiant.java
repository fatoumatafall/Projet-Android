package com.example.gestionscolaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

public class ListeEtudiant extends AppCompatActivity {

     ListView ls;
     String N0m,class£;
     HashMap<String,String> map ;
     Parametre p = new Parametre();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_etudiant);

        ls = findViewById(R.id.lst);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            N0m = extras.getString("nom");
            class£ = extras.getString("classe");
            map = new HashMap<String, String>();
            map.put("nom",N0m);
            map.put("classe",class£);
            p.values.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(ListeEtudiant.this,
                p.values,R.layout.item,new String[]{"nom","classe"},
                new int[]{R.id.Nom,R.id.Classe});
        ls.setAdapter(adapter);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent n = new Intent(getApplicationContext(),Details.class);
                n.putExtra("position",i);
                startActivity(n);
            }
        });

    }
}