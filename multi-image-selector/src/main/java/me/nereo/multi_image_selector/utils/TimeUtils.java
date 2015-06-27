package me.nereo.multi_image_selector.utils;

import android.content.Context;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import me.nereo.multi_image_selector.R;

/**
 * 时间处理工具
 * Created by Nereo on 2015/4/8.
 */
public class TimeUtils {

    public static String timeFormat(long timeMillis, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.CHINA);
        return format.format(new Date(timeMillis));
    }

    public static String formatPhotoDate(Context context, long time) {
        return timeFormat(time, context.getString(R.string.time_format));
    }

    public static String formatPhotoDate(Context context, String path) {
        File file = new File(path);
        if (file.exists()) {
            long time = file.lastModified();
            return formatPhotoDate(context, time);
        }
        return "1970-01-01";
    }
}
