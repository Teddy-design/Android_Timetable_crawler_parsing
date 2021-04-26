package com.teddy.android_timetable_crawler_parsing.tool;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import com.microsoft.officeuifabric.snackbar.Snackbar;
import com.microsoft.officeuifabric.widget.ProgressBar;

import com.teddy.android_timetable_crawler_parsing.R;


import static com.microsoft.officeuifabric.util.ViewUtilsKt.createImageView;

public class Show_Snackbar {

    public static void Show_circularProgress(View view, Context context, String text){
        ProgressBar circularProgress = new ProgressBar(context, null, 0, R.style.Widget_UIFabric_CircularProgress_Small);
        circularProgress.getIndeterminateDrawable().setColorFilter(
                ContextCompat.getColor(context,R.color.button),
                PorterDuff.Mode.SRC_IN
        );

        Snackbar.Companion.make(view, text, Snackbar.LENGTH_SHORT, Snackbar.Style.REGULAR)
                .setCustomView(circularProgress, Snackbar.CustomViewSize.SMALL)
                .show();
    }

    public static void Show_erro(View view, Context context, String text){
        ImageView checkmarkIconImageView = (ImageView) createImageView(
                context,
                R.drawable.ic_erro,
                ContextCompat.getColor(context, R.color.button)
        );
        Snackbar.Companion.make(view, text, Snackbar.LENGTH_SHORT, Snackbar.Style.REGULAR)
                .setCustomView(checkmarkIconImageView, Snackbar.CustomViewSize.SMALL)
                .show();
    }
}
