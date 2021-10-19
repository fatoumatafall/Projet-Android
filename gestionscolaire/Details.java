package com.example.gestionscolaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class Details extends AppCompatActivity {

    EditText name,class£;
    Button sup,mod;
    int position;
    Parametre p = new Parametre();
    HashMap<String,String> m ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        name = findViewById(R.id.n0m);
        class£ = findViewById(R.id.ClassE);
        mod = findViewById(R.id.Modifier);
        sup = findViewById(R.id.Supprimer);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            position = extras.getInt("position");

        }
        m = p.values.get(position);
        name.setText(m.get("nom"));
        class£.setText(m.get("classe"));

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m.put("nom",name.getText().toString());
                m.put("classe",class£.getText().toString());
                Intent i = new Intent(getApplicationContext(),ListeEtudiant.class);
                startActivity(i);
                finish();
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.values.remove(position);
                Intent i = new Intent(getApplicationContext(),ListeEtudiant.class);
                startActivity(i);
                finish();
            }
        });
    }
}