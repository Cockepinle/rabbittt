package com.example.animtion;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    private Button first;
    private Button second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        first = findViewById(R.id.buttonFirst);
        second = findViewById(R.id.buttonSecond);
        Animation plusAnimation = AnimationUtils.loadAnimation(this, R.anim.plus_animation);
        first.startAnimation(plusAnimation);

        Animation minusAnimation = AnimationUtils.loadAnimation(this, R.anim.minus_animation);
        second.startAnimation(minusAnimation);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_animation, R.anim.slide_animation);
            }
        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup rootLayout = findViewById(android.R.id.content);
                Animation shakeAnimation = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.verh_animation);
                shakeAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Intent intent = new Intent(SecondActivity.this, activity_three.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {}
                });

                rootLayout.startAnimation(shakeAnimation);
            }
        });
    }
}