package com.example.myquizzesapplication.Helpers;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

 public class KeyboardSettingsClass {
     //do chowania klawiatury
     public static void closeKeyboard(Activity activity){
        View view = activity.getCurrentFocus();
        if(view!=null){
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
}
