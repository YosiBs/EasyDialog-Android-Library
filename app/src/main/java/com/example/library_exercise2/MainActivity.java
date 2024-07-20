package com.example.library_exercise2;


import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
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
        btn = findViewById(R.id.test_BTN);
        btn.setOnClickListener(v -> changeUI());
    }

    private void changeUI() {
        String text = "hello <c#FF1744>world</c#FF1744>, <b><i>bold and italic</i></b>, <u>underline</u>, <strike>strike</strike>, <bg#AE52D4>highlight</bg#AE52D4>, <size.1>big text</size.1> and <size.2>even bigger text</size.2>";
        tv.setText(SpannableParser.parse(text));
    }
}