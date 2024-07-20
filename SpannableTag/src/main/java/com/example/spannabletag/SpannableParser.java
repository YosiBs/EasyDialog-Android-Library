package com.example.spannabletag;

import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;

import com.example.spannabletag.Interfaces.StyleApplier;
import com.example.spannabletag.SpannerStyles.*;

import java.util.List;
import java.util.Arrays;

public class SpannableParser {
    private static final List<StyleApplier> STYLE_APPLIERS = Arrays.asList(
            new ForegroundColorApplier(),
            new BackgroundColorApplier(),
            new BoldApplier(),
            new ItalicApplier(),
            new UnderlineApplier(),
            new StrikethroughApplier(),
            new SizeApplier()
    );

    public static SpannableString parse(String input) {
        String cleanString = input.replaceAll("<[^>]+>", "");
        SpannableString spannableString = new SpannableString(cleanString);

        for (StyleApplier applier : STYLE_APPLIERS) {
            applier.apply(spannableString, input);
            Log.d("ddd", "-------------------------------------------------");
        }

        return spannableString;
    }
}