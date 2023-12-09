package com.fatemeh.digitoon

import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

fun isInternetReachable(): Boolean {

    var isReachable: Boolean = false;

    try {
        val urlConnection =
            URL("https://www.google.com/").openConnection() as HttpURLConnection
        urlConnection.setRequestProperty("User-Agent", "Android Application");
        urlConnection.setRequestProperty("Connection", "close");
        urlConnection.connectTimeout = 10 * 1000;
        urlConnection.connect();
        isReachable = (urlConnection.responseCode == 200)
    } catch (e: IOException) {
    }

    return isReachable;

}