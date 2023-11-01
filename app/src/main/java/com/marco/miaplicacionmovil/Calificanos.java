package com.marco.miaplicacionmovil;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.content.Intent;


import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;


public class Calificanos extends Dialog {

    //Hola
    private float userrate = 0;
    public Calificanos(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calificanos_layout);

        final AppCompatButton rateNowBtn = findViewById(R.id.rateNowBtn);
        final AppCompatButton laterBtn = findViewById(R.id.rateNowBtn);
        final RatingBar ratingBar = findViewById(R.id.ratingBar);
        final ImageView ratingImage = findViewById(R.id.ratingImage);

        rateNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });

        laterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                if(rating <=1){
                    ratingImage.setImageResource(R.drawable.logo);
                } else if (rating <=2) {
                    ratingImage.setImageResource(R.drawable.logo);
                }
                else if (rating <=3) {
                    ratingImage.setImageResource(R.drawable.logo);
                }
                else if (rating <=4) {
                    ratingImage.setImageResource(R.drawable.logo);
                }
                else if (rating <=5) {
                    ratingImage.setImageResource(R.drawable.logo);
                }

                animateImage(ratingImage);

                userrate = rating;

            }
        });
    }

    private void animateImage(ImageView ratingImage){

        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1f, 0, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(200);
        ratingImage.startAnimation(scaleAnimation);




    }

}
