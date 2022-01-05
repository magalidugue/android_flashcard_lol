package com.magali.flashcardlol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class LargerImage extends AppCompatActivity {

    private int pictureId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_larger_image);


        Intent srcIntent = getIntent();
        pictureId = srcIntent.getIntExtra("pictureId", R.drawable.lol);

        ImageView largerImageView = findViewById(R.id.LargerImageView);
        largerImageView.setImageResource(pictureId);


    }
}