package com.rightflick.dating.social;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.jsibbold.zoomage.ZoomageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class FullScreenImage extends AppCompatActivity {

    ZoomageView imageView;
    ImageView imageBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_full_screen_image);

        imageView = (ZoomageView) findViewById(R.id.imageView);
        imageBackground = (ImageView) findViewById(R.id.imageBackground);

        String url = getIntent().getExtras().getString("url");

//        imageView.setImage("https://instagram.fixc1-2.fna.fbcdn.net/vp/b710693e4dc4cb443b6fb743d2501f7c/5C35DA0C/t51.2885-15/sh0.08/e35/s640x640/31941457_1031025983720679_1139431025215012864_n.jpg");

        Picasso.get().load(url).into(imageView);

        Picasso.get().load(url).into(imageBackground);
    }

}
