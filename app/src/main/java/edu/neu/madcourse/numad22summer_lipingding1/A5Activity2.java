package edu.neu.madcourse.numad22summer_lipingding1;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class A5Activity2 extends AppCompatActivity {
    private Handler textHandler = new Handler();
    boolean exit = false;
    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);


        Button button1 = findViewById(R.id.findPrimesButton);
        button1.setOnClickListener(v -> {
            Thread thread = new FindPrime();
            thread.start();
        });

        Button button2 = findViewById(R.id.terminateSearchButton);
        button2.setOnClickListener(v -> exit = true);
    }


    class FindPrime extends Thread {
        public void run() {
            exit = false;
            int n = 2;
            while(!exit) {
                boolean flag = isPrime(n);
                if(flag) {
                    updateLatestPrime(n);
                }
                if(n % 10000 == 0) {
                    updateCurrentNumber(n);
                }
                n++;
            }
        }
    }

    private boolean isPrime(int num) {
        for (int i = 2; i < num; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void updateLatestPrime(int num) {
        textHandler.post(new Runnable() {
            @Override
            public void run() {
                textView1.setText("latest prime found: " + num);
            }
        });
    }

    private void updateCurrentNumber(int num) {
        textHandler.post(new Runnable() {
            @Override
            public void run() {
                textView2.setText("current number being checked: " + num);
            }
        });
    }
}
