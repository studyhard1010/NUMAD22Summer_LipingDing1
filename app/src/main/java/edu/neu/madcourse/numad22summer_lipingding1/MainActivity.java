package edu.neu.madcourse.numad22summer_lipingding1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

    public void openWebService(View view) {
        Intent intent = new Intent(MainActivity.this, A7WebServiceActivity.class);
        startActivity(intent);
    }
}


