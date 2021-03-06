package ikbal.mulalic.reflektor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class IntroActivity extends AppCompatActivity {

    SharedPreferences pref = null;
    private static int SPLASH_TIME_OUT = 1750;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());


    }

    @Override
    protected void onResume() {
        super.onResume();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(pref.getBoolean("firstrun", true))
                {
                    //prvi put
                    Intent intent = new Intent (IntroActivity.this,InstructionsActivity.class);
                    startActivity(intent);

                    pref.edit().putBoolean("firstrun",false).apply();
                }
                else
                {
                    Intent intent = new Intent (IntroActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        },SPLASH_TIME_OUT);


    }

}