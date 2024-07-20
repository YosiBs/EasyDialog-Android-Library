package com.example.spannabletag.SpannerStyles;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;

import com.example.spannabletag.Interfaces.StyleApplier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SizeApplier implements StyleApplier {
    private static final String TAG_REGEX = "<size\\.(\\d+)>(.*?)</size\\.\\1>";

    @Override
    public void apply(SpannableString spannableString, String input) {
        applyStyle(spannableString, input, TAG_REGEX, new AbsoluteSizeSpan(20, true));
    }

    private void applyStyle(SpannableString spannableString, String input, String regex, Object span) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int size = Integer.parseInt(matcher.group(1)); // Capture the size value
            int start = calculateOffset(matcher.start(2), input);
            int end = calculateOffset(matcher.end(2), input);
            spannableString.setSpan(new AbsoluteSizeSpan(size, true), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
    }

    private int calculateOffset(int originalPosition, String input) {
        String subString = input.substring(0, originalPosition);
        int tagsLength = subString.replaceAll("[^<]*>", "").length();
        return originalPosition - tagsLength;
    }
}