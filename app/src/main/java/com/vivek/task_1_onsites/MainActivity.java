package com.vivek.task_1_onsites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        MyCanvas myCanvasView = new MyCanvas(this);
        myCanvasView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        myCanvasView.setContentDescription("it is canvas for Rectangle");

        setContentView(myCanvasView);

    }
}
