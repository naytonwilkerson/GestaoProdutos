package com.example.gestodeprodutos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static com.example.gestodeprodutos.MainActivity.REQUEST_IMAGE_CAPTURE;

public class CriaItem extends AppCompatActivity {

    ImageView imageid;
    Button btnslv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria_item);

        initialWork();
        Clickimg();

    }

    private void initialWork() {
        btnslv = findViewById(R.id.buttonSalvar);
        imageid = findViewById(R.id.imageid);
    }

    private void Clickimg() {

        btnslv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent( CriaItem.this, MainActivity.class);
                startActivity(intent);
            }
        });

        imageid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });

    }

    ///////////////////////////////////////////////////////////Camera///////////////////////////////////
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
///////////////////////////////////////////////////////////Camera///////////////////////////////////

}