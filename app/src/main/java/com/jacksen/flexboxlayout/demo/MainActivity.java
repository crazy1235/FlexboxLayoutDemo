package com.jacksen.flexboxlayout.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;

import java.util.Random;

/**
 * flexbox layout
 *
 * @author jacksen
 */
public class MainActivity extends AppCompatActivity {

    private FlexboxLayout flexboxLayout;

    private FloatingActionButton addFab;
    private FloatingActionButton removeFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] tags = getResources().getStringArray(R.array.tags);

        flexboxLayout = (FlexboxLayout) findViewById(R.id.flexbox_layout);
        addFab = (FloatingActionButton) findViewById(R.id.add_fab);
        removeFab = (FloatingActionButton) findViewById(R.id.remove_fab);

        addFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flexboxLayout.addView(createNewFlexItemTextView(tags[new Random().nextInt(tags.length)]));
            }
        });

        removeFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flexboxLayout.getChildCount() == 0) {
                    return;
                }
                flexboxLayout.removeViewAt(flexboxLayout.getChildCount() - 1);
            }
        });


    }

    /**
     * create new TextView item
     *
     * @param text
     * @return
     */
    private TextView createNewFlexItemTextView(String text) {
        TextView textView = new TextView(this);
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setTextSize(15);
        textView.setTextColor(Color.WHITE);
        textView.setBackgroundResource(R.drawable.shape_tag);

        int padding = Util.dpToPixel(this, 8);
        ViewCompat.setPaddingRelative(textView, padding, padding, padding, padding);

        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int margin = Util.dpToPixel(this, 6);
        layoutParams.setMargins(margin, margin, margin, 0);

        textView.setLayoutParams(layoutParams);

        return textView;
    }


}
