package com.example.library_exercise2;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spannabletag.SpannableParser;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private MaterialTextView mtv;
    private MaterialButton btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        tv = findViewById(R.id.test_TV);
        mtv = findViewById(R.id.test_MTV);
        btn = findViewById(R.id.test_BTN);
        btn.setOnClickListener(v -> changeUI());
    }

    private void changeUI() {
//        String text = "hello <c#FF1744><b>world</b></c#FF1744>, <b><i>bold and italic</i></b>, <u>underline</u>, <strike>strike</strike>, <bg.red>highlight</bg.red>, <size.20>big text</size.20> and <size.30>even bigger text</size.30>";
//        String text = "<strike>hello</strike> <b>world</b>";
        String text = "<b>hello</b> <b>world</b>";
        tv.setText(SpannableParser.parse(text));
        //mtv.setText(SpannableParser.parse(text));
    }
}