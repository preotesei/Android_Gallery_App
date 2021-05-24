package com.example.galleryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ZoomControls;

public class FullView extends AppCompatActivity {

    ImageView imageView;
    ZoomControls zoomControls;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_view);

        imageView=findViewById(R.id.img_full);
        int img_id = getIntent().getExtras().getInt("img_id");
        imageView.setImageResource(img_id);

        zoomControls=findViewById(R.id.zoom_controls);

        zoomControls.setBackgroundColor(Color.BLACK);
        zoomControls.show();



        // onTouch listener function  when the image is clicked
        imageView.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        zoomControls.show();
                        return false;
                    }
                }
        );

        // This function will be automatically called out,when
        // zoom in button is being pressed
        zoomControls.setOnZoomInClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        float x=imageView.getScaleX();
                        float y=imageView.getScaleY();

                        // setting the new scale
                        imageView.setScaleX((float)(x+0.5f));
                        imageView.setScaleY((float)(y+0.5f));
                        zoomControls.hide();
                    }
                }
        );

        // This function will be called when
        // zoom out button is pressed
        zoomControls.setOnZoomOutClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        float x=imageView.getScaleX();
                        float y=imageView.getScaleY();
                        if(x==1 && y==1)
                        {
                            // the scale will remain same,since
                            // it is maximum possible zoom out
                            imageView.setScaleX((float)(x));
                            imageView.setScaleY((float)(y));
                            zoomControls.hide();
                        }
                        else
                        {
                            // setting the new scale
                            imageView.setScaleX((float)(x-0.5f));
                            imageView.setScaleY((float)(y-0.5f));
                            // hiding the zoom controls
                            zoomControls.hide();
                        }
                    }
                }
        );
    }
}







//public class FullView extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_full_view);
//
//        ImageView imageView = findViewById(R.id.img_full);
//
//        int img_id = getIntent().getExtras().getInt("img_id");
//        imageView.setImageResource(img_id);
//    }
//}

