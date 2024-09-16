package com.example.animtion;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;



public class activity_three extends AppCompatActivity {
    private ImageView img;
    private Button starts;
    private Button pausee;
    private Button backs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_three);

        img = findViewById(R.id.animImageView);
        starts = findViewById(R.id.start_tween);
        pausee = findViewById(R.id.pause_bt);
        backs = findViewById(R.id.back);

        Animation blinkAnimation = AnimationUtils.loadAnimation(this,R.anim.blink_animation);

        Animation uglAnimation = AnimationUtils.loadAnimation(this, R.anim.ugl_animation);
        img.startAnimation(uglAnimation);

        Animation vragAnimation = AnimationUtils.loadAnimation(this, R.anim.vragspravo_animation);
        starts.startAnimation(vragAnimation);

        Animation pravandlevoAnimation = AnimationUtils.loadAnimation(this, R.anim.pravolevo_animation);
        backs.startAnimation(pravandlevoAnimation);

        Animation dlinaAnimation = AnimationUtils.loadAnimation(this, R.anim.dlina_animation);
        pausee.startAnimation(dlinaAnimation);

        starts.setOnClickListener(view -> img.startAnimation(blinkAnimation));
        pausee.setOnClickListener(view -> img.clearAnimation());
        backs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_three.this, SecondActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.common_animation, R.anim.common_animation);
            }
        });

    }



}