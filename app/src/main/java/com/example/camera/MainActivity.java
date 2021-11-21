package com.example.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final int requestcamera = 12;

    ImageView imageView;
    Button takebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.imgid);
        takebtn=findViewById(R.id.take_btn);

        takebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera,requestcamera);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==requestcamera){
            Bitmap imgbitmap = (Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(imgbitmap);
        }
    }
}