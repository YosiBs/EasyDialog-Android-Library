package com.example.spannabletag.SpannerStyles;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.Log;

import com.example.spannabletag.Interfaces.StyleApplier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoldApplier implements StyleApplier {
    private static final String TAG_REGEX = "<b>(.*?)</b>";

    @Override
    public void apply(SpannableString spannableString, String input) {

        applyStyle(spannableString, input, TAG_REGEX, new StyleSpan(Typeface.BOLD));

    }

    private void applyStyle(SpannableString spannableString, String input, String regex, Object span) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            int start = matcher.start(1);
            int end = matcher.end(1);
            int offsetStart = calculateOffset(start, input);
            int offsetEnd = calculateOffset(end, input);


            spannableString.setSpan(span, offsetStart, offsetEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            Log.d("ddd", "in~~~~BoldApplier:\n" +
                    "\tstart: " + start +
                    "\n\tend: " + end +
                    "\n\tinput: " + input +
                    "\n\toffsetStart: " + offsetStart +
                    "\n\toffsetEnd: " + offsetEnd +
                    "\n\tspannableString: " + spannableString
            );
            // Additional logging to verify spans
            for (StyleSpan appliedSpan : spannableString.getSpans(0, spannableString.length(), StyleSpan.class)) {
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