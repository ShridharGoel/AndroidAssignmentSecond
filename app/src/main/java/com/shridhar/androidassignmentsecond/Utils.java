package com.shridhar.androidassignmentsecond;

import android.content.Context;
import android.net.Uri;
import android.webkit.URLUtil;
import android.widget.Toast;

import androidx.browser.customtabs.CustomTabsIntent;

public class Utils {
    public static void openLink(Context context, String url) {
        if (!url.substring(0, 8).equals("https://") && !url.substring(0, 7).equals("http://")) {
            url = "https://" + url;
        }

        if (!URLUtil.isValidUrl(url)) {
            Toast.makeText(context, "Invalid URL", Toast.LENGTH_SHORT).show();
            return;
        }

        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(context, Uri.parse(url));
    }
}
