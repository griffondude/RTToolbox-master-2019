package com.example.root.rttoolbox;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import static android.Manifest.permission;

public class sendLocation2 extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 0;
    private static final int REQUEST_CHECK_SETTINGS = 0;
    private TextView locationTv;
    public String RSOnumber, message, strlatitude, strlongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Newest API for location services
        FusedLocationProviderClient mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        setContentView(R.layout.activity_send_location2);
        locationTv = findViewById(R.id.location);

        //Pull RSOnumber from the shared settings
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        RSOnumber = sharedPref.getString("rsonumber", "1");

        // Take appropriate action if permission denied to avoid a crash.
        if (ContextCompat.checkSelfPermission(this, permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            ActivityCompat.requestPermissions(this,
                    new String[]{permission.ACCESS_FINE_LOCATION},
                    // Request permissions.
                    MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
                    locationTv.setText(getString(R.string.Back_out_message));

        } else {
            Log.d("debug", "onCreate: permissions granted");
            // Permission has already been granted
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {
                                // Logic to handle location object
                                Context context = getApplicationContext();
                                CharSequence text = "NOT NULL return";
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                                createLocationRequest();
                                strlatitude = Double.toString(location.getLatitude());
                                strlongitude = Double.toString(location.getLongitude());
                                //TODO: Modify this builder so this will format to something MAPS can open for navigation.
                                message = (getString(R.string.lat) + strlatitude + getString(R.string.longi) + strlongitude);
                                locationTv.setText(message);
                                composeSmsMessage(message);

                            }else{
                                locationTv.setText(getString(R.string.indoors_warning));
                                createLocationRequest();
                            }

                        }
                    });
        }


    }

    // Checks if location services are ON.
    protected void createLocationRequest() {
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(mLocationRequest);
        SettingsClient client = LocationServices.getSettingsClient(this);
        Task<LocationSettingsResponse> task = client.checkLocationSettings(builder.build());

        task.addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                // All location settings are satisfied.
            }
        });

        task.addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ResolvableApiException) {
                    // Location settings are not satisfied, but this can be fixed
                    // by showing the user a dialog.
                    try {
                        // Show the dialog by calling startResolutionForResult(),
                        // and check the result in onActivityResult().
                        ResolvableApiException resolvable = (ResolvableApiException) e;
                        resolvable.startResolutionForResult(sendLocation2.this,
                                REQUEST_CHECK_SETTINGS);
                    } catch (IntentSender.SendIntentException sendEx) {
                        // Ignore the error.
                    }
                }
            }
        });

    }

    public void composeSmsMessage(String message) {
        Intent sendSms = new Intent(Intent.ACTION_VIEW);
        String title = getResources().getString(R.string.chooser_title);
        sendSms.setData(Uri.parse("smsto:" + RSOnumber));
        final Intent sms_body = sendSms.putExtra("sms_body", (getString(R.string.emerg_loc)+message));

        //Force chooser so user can pick an app to handle SMS. Facebook messenger takes over if allowed.
        if (sendSms.resolveActivity(getPackageManager()) != null) {
            Intent chooser = Intent.createChooser(sendSms, title);
            startActivity(chooser);

        }
    }

    }