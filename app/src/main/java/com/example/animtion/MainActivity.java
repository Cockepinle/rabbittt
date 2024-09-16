package com.example.animtion;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    private ImageView animationTV;
    private AnimationDrawable frameAnimation;
    private Button start;
    private Button pauseBt;

    private Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animationTV = findViewById(R.id.animImageView);
        frameAnimation = (AnimationDrawable) animationTV.getDrawable();
        start = findViewById(R.id.start_bt);
        pauseBt = findViewById(R.id.pause);
        btnBack = findViewById(R.id.backButton);

        Animation slideAnimation = AnimationUtils.loadAnimation(this, R.anim.imgverh_animation);
        animationTV.startAnimation(slideAnimation);

        Animation plavAnimation = AnimationUtils.loadAnimation(this, R.anim.startcolor_animation);
        start.startAnimation(plavAnimation);

        Animation pauseAnimation = AnimationUtils.loadAnimation(this, R.anim.pausevniz_animation);
        pauseBt.startAnimation(pauseAnimation);

        Animation slideRightAnimation = AnimationUtils.loadAnimation(this, R.anim.pravoglav_animation);
        btnBack.startAnimation(slideRightAnimation);

        start.setOnClickListener(view -> {
            if (!frameAnimation.isRunning()) {
                frameAnimation.start();
            }
        });
        pauseBt.setOnClickListener(view -> {
            if (frameAnimation.isRunning()) {
                frameAnimation.stop();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.list_animation, R.anim.end_animation);            }
        });


    }

}