
package com.example.root.rttoolbox;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EMERG extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 0;

    public String RSOnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emerg);
        setTitle(R.string.emergency_checklist);
        //Pull RSOnumber from the shared settings
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        RSOnumber = sharedPref.getString("rsonumber", "1");
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
    }

    public void callRSO(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+RSOnumber));
        startActivity(intent);
    }

        public void sendLocation2(View view) {
        Intent myIntent = new Intent(this, sendLocation2.class);
        startActivity(myIntent);
    }
}
