package com.app.androidanimationmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mediaPlayer =
                MediaPlayer.create(getApplicationContext(),R.raw.fireboy);
        mediaPlayer.start();

        imageView = findViewById(R.id.luke);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);

        imageView.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(getApplicationContext(), Welcome.class);
                startActivity(intent);
                finish();
                mediaPlayer.stop();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}
