package com.example.kaving.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by KavinG on 10/19/2015.
 */
public class InstagramCloneActivity extends Activity {

    ImageView ivResult;
    Bitmap original;
    Intent intentFromOtherApps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram_clone);
        ivResult = (ImageView)findViewById(R.id.imageView);
        intentFromOtherApps = getIntent();
        Uri getImagePath= (Uri)intentFromOtherApps.getExtras().get(Intent.EXTRA_STREAM);
        ivResult.setImageURI(getImagePath);
    }

    public void doImageEffects(View v) {
        switch (v.getId()) {
            case R.id.btnGrayScale:
                ivResult.buildDrawingCache();
                Bitmap original = ivResult.getDrawingCache();
               Bitmap toGray= toGrayScale(original);
                ivResult.setImageBitmap(toGray);
                break;

        }
    }


    public Bitmap toGrayScale(Bitmap bmpOriginal) {

        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;
    }
}