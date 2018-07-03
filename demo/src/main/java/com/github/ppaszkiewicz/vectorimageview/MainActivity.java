package com.github.ppaszkiewicz.vectorimageview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Entry activity for test selection.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnNative).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TestActivity.class);
                i.putExtra(TestActivity.EXTRA_IMAGE_TYPE, TestActivity.IMAGE_TYPE_NATIVE);
                startActivity(i);
            }
        });

        findViewById(R.id.btnVector).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TestActivity.class);
                i.putExtra(TestActivity.EXTRA_IMAGE_TYPE, TestActivity.IMAGE_TYPE_VECTOR);
                startActivity(i);
            }
        });
    }
}
