package com.github.ppaszkiewicz.vectorimageview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.ppaszkiewicz.vectorimagelib.VectorImageView;

/**
 * Demo activity.
 */
public class TestActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    public static final String EXTRA_IMAGE_TYPE = "EXTRA_IMAGE_TYPE";
    public static final int IMAGE_TYPE_NATIVE = 0;
    public static final int IMAGE_TYPE_VECTOR = 1;

    private int imgType;
    private ImageView clickImage;
    private ImageView levelImage;
    private TextView seekValue;
    private boolean isLevelListDrawableChanged = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imgType = getIntent().getIntExtra(EXTRA_IMAGE_TYPE, IMAGE_TYPE_NATIVE);
        if (imgType == IMAGE_TYPE_NATIVE) {
            setTitle("Native ImageView");
            setContentView(R.layout.activity_native);
        } else if (imgType == IMAGE_TYPE_VECTOR) {
            setTitle("VectorImageView");
            setContentView(R.layout.activity_vector);
        }

        initClickable();
        initLevelList();
    }

    private void initClickable(){
        clickImage = findViewById(R.id.clickableImg);
        // select clickable image on checkbox click
        findViewById(R.id.checkbox).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickImage.setSelected(((CompoundButton)v).isChecked());
            }
        });
    }

    private void initLevelList(){
        levelImage = findViewById(R.id.levelImg);
        seekValue = findViewById(R.id.seekValue);
        ((AppCompatSeekBar) findViewById(R.id.seek)).setOnSeekBarChangeListener(this);

        // changing level list at runtime
        if (imgType == IMAGE_TYPE_NATIVE) {
            levelImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isLevelListDrawableChanged) {
                        levelImage.setImageResource(R.drawable.ic_android_level_list);
                    } else {
                        levelImage.setImageResource(R.drawable.ic_vintage_filter_level_list);
                    }
                    isLevelListDrawableChanged = !isLevelListDrawableChanged;
                }
            });
        } else if (imgType == IMAGE_TYPE_VECTOR) {
            levelImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isLevelListDrawableChanged) {
                        ((VectorImageView) levelImage).setVectorsDrawableResource(R.drawable.ic_android_level_list);
                    } else {
                        ((VectorImageView) levelImage).setVectorsDrawableResource(R.drawable.ic_vintage_filter_level_list);
                    }
                    isLevelListDrawableChanged = !isLevelListDrawableChanged;
                }
            });
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //modify level list drawable level
        levelImage.setImageLevel(progress);
        seekValue.setText(String.valueOf(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
