package com.example.spannabletag.SpannerStyles;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;

import com.example.spannabletag.Interfaces.StyleApplier;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SizeApplier implements StyleApplier {
    private static final String TAG_REGEX = "<size\\.(\\d+)>(.*?)</size\\.\\1>";

    @Override
    public void apply(SpannableString spannableString, String input) {
        applyStyle(spannableString, input, TAG_REGEX);
    }

    private void applyStyle(SpannableString spannableString, String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);


        while (matcher.find()) {
            int size = Integer.parseInt(matcher.group(1)); // Capture the size value

            int start = matcher.start(2);
            int end = matcher.end(2);
            int offsetStart = calculateOffset(start, input);
            int offsetEnd = calculateOffset(end, input);


            spannableString.setSpan(new RelativeSizeSpan(size), offsetStart, offsetEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


            Log.d("ddd", "in~~~~SizeApplier:\n" +
                    "\tstart: " + start +
                    "\n\tend: " + end +
                    "\n\tinput: " + input +
                    "\n\toffsetStart: " + offsetStart +
                    "\n\toffsetEnd: " + offsetEnd +
                    "\n\tsize: " + size +
                    "\n\tspannableString: " + spannableString
            );


            for (RelativeSizeSpan appliedSpan : spannableString.getSpans(0, spannableString.length(), RelativeSizeSpan.class)) {
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