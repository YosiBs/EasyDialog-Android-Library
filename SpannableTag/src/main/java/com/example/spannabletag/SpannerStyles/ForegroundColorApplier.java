package com.example.spannabletag.SpannerStyles;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;

import com.example.spannabletag.Interfaces.StyleApplier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForegroundColorApplier implements StyleApplier {
    private static final String TAG_REGEX = "<c#([A-Fa-f0-9]{6})>(.*?)</c#\\1>";

    @Override
    public void apply(SpannableString spannableString, String input) {
        Pattern pattern = Pattern.compile(TAG_REGEX);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String colorCode = matcher.group(1); // Capture the hex color code
            int color = Color.parseColor("#" + colorCode); // Convert hex code to color
            int start = calculateOffset(matcher.start(2), input);
            int end = calculateOffset(matcher.end(2), input);
            spannableString.setSpan(new ForegroundColorSpan(color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private int calculateOffset(int originalPosition, String input) {
        String subString = input.substring(0, originalPosition);
        int tagsLength = subString.replaceAll("[^<]*>", "").length();
        return originalPosition - tagsLength;
    }
}