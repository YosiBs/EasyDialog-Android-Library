package com.example.spannabletag.SpannerStyles;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;

import com.example.spannabletag.Interfaces.StyleApplier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BackgroundColorApplier implements StyleApplier {
    private static final String TAG_REGEX = "<bg\\.red>(.*?)</bg\\.red>";

    @Override
    public void apply(SpannableString spannableString, String input) {
        applyStyle(spannableString, input, TAG_REGEX, new BackgroundColorSpan(Color.RED));
    }

    private void applyStyle(SpannableString spannableString, String input, String regex, Object span) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int start = calculateOffset(matcher.start(1), input);
            int end = calculateOffset(matcher.end(1), input);
            spannableString.setSpan(span, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private int calculateOffset(int originalPosition, String input) {
        String subString = input.substring(0, originalPosition);
        int tagsLength = subString.replaceAll("[^<]*>", "").length();
        return originalPosition - tagsLength;
    }
}