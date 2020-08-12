package com.alpha.mainmenu.authenticationModule;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.alpha.mainmenu.R;
import com.alpha.mainmenu.utility.AppSession;
import com.alpha.mainmenu.utility.CheckNetwork;
import com.alpha.mainmenu.utility.Constants;


public class Splash_Activity extends AppCompatActivity {
    private String loginEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       try {
            loginEntry = AppSession.getStringPreferences(getApplicationContext(), Constants.STATUS);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (loginEntry == null || loginEntry.isEmpty()) {
                        CheckNetwork.nextScreenWithFinish(Splash_Activity.this, Login_Activity.class);
                    } else {
                        CheckNetwork.nextScreenWithFinish(Splash_Activity.this, Login_Activity.class);
                    }
                }
            }, 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
