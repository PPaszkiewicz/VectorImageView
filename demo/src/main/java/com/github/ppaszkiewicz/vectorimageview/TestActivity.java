package com.github.ppaszkiewicz.vectorimageview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Demo activity.
 */
public class TestActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    public static final String EXTRA_IMAGE_TYPE = "EXTRA_IMAGE_TYPE";
    public static final int IMAGE_TYPE_NATIVE = 0;
    public static final int IMAGE_TYPE_VECTOR = 1;

    private ImageView img;
    private TextView seekValue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int imgType = getIntent().getIntExtra(EXTRA_IMAGE_TYPE, IMAGE_TYPE_NATIVE);
        if(imgType == IMAGE_TYPE_NATIVE){
            setTitle("Native ImageView");
            setContentView(R.layout.activity_native);
        }else if(imgType == IMAGE_TYPE_VECTOR) {
            setTitle("VectorImageView");
            setContentView(R.layout.activity_vector);
        }
        img = findViewById(R.id.levelImg);
        seekValue = findViewById(R.id.seekValue);
        ((AppCompatSeekBar)findViewById(R.id.seek)).setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        img.setImageLevel(progress);
        seekValue.setText(String.valueOf(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
