package com.asmat.rolando.popularmovies.utilities;

import android.content.Context;
import android.content.res.Configuration;

public class ViewUtils {

    public static int calculateNumberOfColumns(Context context) {
        int orientation = context.getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return 3;
        } else {
            return 2;
        }

    }
}
