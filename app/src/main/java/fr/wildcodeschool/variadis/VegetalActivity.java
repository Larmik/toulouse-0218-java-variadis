package fr.wildcodeschool.variadis;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class VegetalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetal);

        VegetalModel vegetal = getIntent().getParcelableExtra("EXTRA_PARCEL_VEGETAL");
        ImageView imgVegetal = findViewById(R.id.img_vegetal);
        TextView txtVegetal = findViewById(R.id.nom_vegetal);
        imgVegetal.setImageResource(vegetal.getPicture());
        txtVegetal.setText(vegetal.getName());

        FloatingActionButton returnToMap = findViewById(R.id.return_to_map);
        returnToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (VegetalActivity.this, MapsActivity.class);
                VegetalActivity.this.startActivity(intent);
            }
        });


        ImageView ivHerbier = findViewById(R.id.img_herbier);
        ivHerbier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VegetalActivity.this, HerbariumActivity.class);
                VegetalActivity.this.startActivity(intent);
            }
        });

        ImageView ivProfile = findViewById(R.id.img_profile);
        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VegetalActivity.this, ProfilActivity.class);
                VegetalActivity.this.startActivity(intent);
            }
        });

    }
}