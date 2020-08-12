package com.test.icare_patient;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.ParseException;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Constant {
    public static final String PACKAGE_NAME = "com.test.test";
    private static SharedPreferences pref;
    private static SharedPreferences.Editor editor;

    // Constructor
    @SuppressLint("CommitPrefEdits")
    public Constant(Context context) {
        pref = context.getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public static boolean isValidEmail(String target) {
        boolean flag;
        if (TextUtils.isEmpty(target)) {
            return true;
        } else {
            flag = emailValidator(target);
            if (flag) {
                // return flag;
            }
            return flag;
        }
        // return (!TextUtils.isEmpty || Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public static boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }



    public static String parseDate(String time) {
//        String inputPattern = "yyyy-MM-dd HH:mm:ss";
//        String outputPattern = "dd-MMM-yyyy h:mm a";
        String inputPattern = "yyyy-MM-dd";
        String outputPattern = "dd-MMM-yyyy";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    public String getLoginAS() { return pref.getString("loginas", "0"); }
    public void setLoginAS(String loginas) {
        editor.putString("loginas", loginas);
        editor.commit();
    }


}