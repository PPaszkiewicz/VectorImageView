package com.github.ppaszkiewicz.vectorimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.AppCompatImageView;
import android.widget.ImageView;

import com.github.ppaszkiewicz.vectorimagelib.VectorImageView;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * imageview and supportview will fail below 21.
 */
@RunWith(AndroidJUnit4.class)
public class VectorImageViewTest {
    Context context = InstrumentationRegistry.getTargetContext();

    @Test
    public void useAppContext() {
        assertEquals("com.github.ppaszkiewicz.vectorimageview", context.getPackageName());
    }

    @Test
    public void imageViewTest() {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.ic_android_selector);
        imageView.setImageResource(R.drawable.ic_android_level_list);

    }

    @Test
    public void supportViewTest() {
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        appCompatImageView.setImageResource(R.drawable.ic_android_selector);
        appCompatImageView.setImageResource(R.drawable.ic_android_level_list);
    }

    @Test
    public void vectorViewTest() {
        VectorImageView vectorImageView = new VectorImageView(context);
        vectorImageView.setVectorsDrawable(R.drawable.ic_android_selector);
        vectorImageView.setVectorsDrawable(R.drawable.ic_android_level_list);
    }
}
