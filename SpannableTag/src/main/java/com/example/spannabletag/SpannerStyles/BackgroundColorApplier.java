package com.example.spannabletag.SpannerStyles;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;

import com.example.spannabletag.Interfaces.StyleApplier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BackgroundColorApplier implements StyleApplier {
    private static final String TAG_REGEX = "<bg#([A-Fa-f0-9]{6})>(.*?)</bg#\\1>";

    @Override
    public void apply(SpannableString spannableString, String input) {
        Pattern pattern = Pattern.compile(TAG_REGEX);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String colorCode = matcher.group(1); // Capture the hex color code
            int color = Color.parseColor("#" + colorCode); // Convert hex code to color
            int start = matcher.start(2);
            int end = matcher.end(2);
            int offsetStart = calculateOffset(start, input);
            int offsetEnd = calculateOffset(end, input);


            spannableString.setSpan(new BackgroundColorSpan(color), offsetStart, offsetEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            Log.d("ddd", "in~~~~BackgroundColorApplier:\n" +
                    "\tstart: " + start +
                    "\n\tend: " + end +
                    "\n\tinput: " + input +
                    "\n\toffsetStart: " + offsetStart +
                    "\n\toffsetEnd: " + offsetEnd +
                    "\n\tcolorCode: " + colorCode +
                    "\n\tcolor: " + color +
                    "\n\tspannableString: " + spannableString
            );


            for (BackgroundColorApplier appliedSpan : spannableString.getSpans(0, spannableString.length(), BackgroundColorApplier.class)) {
                Log.d("ddd", "Span: " + appliedSpan + " Start: " + spannableString.getSpanStart(appliedSpan) + " End: " + spannableString.getSpanEnd(appliedSpan));
            }

        }
    }


    private int calculateOffset(int originalPosition, String input) {
        String beforePosition = input.substring(0, originalPosition);
        int tagsLength = beforePosition.length() - beforePosition.replaceAll("<[^>]+>", "").length();
        int offset = originalPosition - tagsLength;
        return offset;
    }
}