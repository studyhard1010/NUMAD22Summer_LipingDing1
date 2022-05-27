package edu.neu.madcourse.numad22summer_lipingding1;
import androidx.appcompat.app.AppCompatActivity;

        import android.annotation.SuppressLint;
        import android.os.Bundle;
        import android.view.MotionEvent;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;


        public class ClickyActivity extends AppCompatActivity {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_clicky);

                TextView textView = (TextView) findViewById(R.id.textView3);

                Button textButton = (Button) findViewById(R.id.button);
                textButton.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        switch (motionEvent.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                textView.setText(R.string.A);
                                return true;
                            case MotionEvent.ACTION_UP:
                                textView.setText(R.string.dash);
                                return true;
                        }
                        return false;
                    }
                });

                Button textButton2 = (Button) findViewById(R.id.button2);
                textButton2.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        switch (motionEvent.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                textView.setText(R.string.B);
                                return true;
                            case MotionEvent.ACTION_UP:
                                textView.setText(R.string.dash);
                                return true;
                        }
                        return false;
                    }
                });

                Button textButton3 = (Button) findViewById(R.id.button3);
                textButton3.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        switch (motionEvent.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                textView.setText(R.string.C);
                                return true;
                            case MotionEvent.ACTION_UP:
                                textView.setText(R.string.dash);
                                return true;
                        }
                        return false;
                    }
                });

                Button textButton4 = (Button) findViewById(R.id.button4);
                textButton4.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        switch (motionEvent.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                textView.setText(R.string.D);
                                return true;
                            case MotionEvent.ACTION_UP:
                                textView.setText(R.string.dash);
                                return true;
                        }
                        return false;
                    }
                });

                Button textButton5 = (Button) findViewById(R.id.button5);
                textButton5.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        switch (motionEvent.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                textView.setText(R.string.E);
                                return true;
                            case MotionEvent.ACTION_UP:
                                textView.setText(R.string.dash);
                                return true;
                        }
                        return false;
                    }
                });

                Button textButton6 = (Button) findViewById(R.id.button6);
                textButton6.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        switch (motionEvent.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                textView.setText(R.string.F);
                                return true;
                            case MotionEvent.ACTION_UP:
                                textView.setText(R.string.dash);
                                return true;
                        }
                        return false;
                    }
                });
            }
        }