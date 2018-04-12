package fr.wildcodeschool.variadis;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class VegetalHelperActivity extends AppCompatActivity {

    public static final String EXTRA_PARCEL_FOUNDVEGETAL = "EXTRA_PARCEL_FOUNDVEGETAL";
    Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_popup);


        ImageView ivVegetal = findViewById(R.id.img_found_vegetal);
        ivVegetal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), 0);

            }
        });

        Button goToVegetal = findViewById(R.id.btn_goto_vegetal);
        goToVegetal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Parcelable foundVegetal = new VegetalModel(mBitmap, "Testname");
                Intent intent = new Intent(VegetalHelperActivity.this, VegetalActivity.class);
                intent.putExtra(EXTRA_PARCEL_FOUNDVEGETAL, foundVegetal);
                startActivity(intent);
            }
        });

        Button quit = findViewById(R.id.btn_quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView ivVegetal = findViewById(R.id.img_found_vegetal);
        TextView addPicture = findViewById(R.id.add_picture);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        Glide.with(this).load(bitmap).into(ivVegetal);
        ivVegetal.setClickable(false);
        addPicture.setVisibility(View.INVISIBLE);
        mBitmap = bitmap.copy(bitmap.getConfig(), true);


    }


}
