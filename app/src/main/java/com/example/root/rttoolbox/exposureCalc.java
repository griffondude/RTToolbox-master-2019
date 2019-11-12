package com.example.root.rttoolbox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Formatter;

public class exposureCalc extends AppCompatActivity {
    public float activityCi;
    public float matThick;  // in mm
    public float mediaFactor;  // D4 = 3
    public float hvlValue; // steel = 12.7mm
    public float sfdmm;  // in mm
    public float desiredDens; // To be used in later versions
    public float fFactor; // To be used in later versions
    public float gammaConst; // To be used in later versions
    public boolean gbqTru, radUnitGray;
    public boolean imperialTru;
    public double expTime, expMin, expSec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exposure_calc);
        setTitle(R.string.title_exp_calc);
        // Acquire unit selection from settings activity.
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        radUnitGray = sharedPref.getBoolean("radiation_unit_switch", false);
        imperialTru = sharedPref.getBoolean("measurement_unit_switch", false);
        gbqTru = sharedPref.getBoolean("source_unit_switch", false);
        String isotopeSelect = sharedPref.getString("example_list", "Ir192");
        //TextView tvsourceType = findViewById(R.id.sourceType);
        //tvsourceType.setText(isotopeSelect);

        // Sets listener on the CALCULATE button
        final Button calc1 = findViewById(R.id.button5);
        calc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateExp(calc1);
            }
        });
    }

    // Method to send user to settings screen when desired.
    public void gotosettings(View view) {
        Intent myIntent = new Intent(this, SettingsActivity.class);
        startActivity(myIntent);
    }

    // Activated when the CALCULATE button is clicked.
    public void calculateExp(View view) {
        setIsotope();  // To be used later if settings screen is too difficult to implement.
        setUnits();
        acquireVar();
        calcExp();
    }

    // For possible later use.
    public void setIsotope() {

    }


    public void setUnits() {
        // determine units of choice
        //Switch switch1 = findViewById(R.id.switch1);
        //gbqTru = switch1.isChecked();
        //Switch switch2 = findViewById(R.id.switch2);
        //imperialTru = switch2.isChecked();
        // change units next to editable text views.
        TextView edtActUnit = findViewById(R.id.actUnit);
        TextView edtMeasUnit1 = findViewById(R.id.measUnit1);
        TextView edtMeasUnit2 = findViewById(R.id.measUnit2);
        TextView edtMeasUnit3 = findViewById(R.id.measUnit3);
        if (gbqTru) edtActUnit.setText(getString(R.string.gbq));
        else {
            edtActUnit.setText(getString(R.string._ci));
        }

        if (imperialTru) {
            edtMeasUnit1.setText(getString(R.string.in));
            edtMeasUnit2.setText(getString(R.string.in));
            edtMeasUnit3.setText(getString(R.string.in));
        }
        else {
            edtMeasUnit1.setText(getString(R.string.mm));
            edtMeasUnit2.setText(getString(R.string.mm));
            edtMeasUnit3.setText(getString(R.string.mm));
        }
    }

    public void acquireVar() {
        // acquire activity value and convert if necessary
        TextView edtActCi = findViewById(R.id.activityEntry);
        activityCi = Float.parseFloat(edtActCi.getText().toString());
        if (gbqTru) activityCi = activityCi / 37;

        // acquire film factor.  To be replaced with media dose at a later date.
        TextView edtMedVal = findViewById(R.id.mediaExpEntry);
        mediaFactor = Float.parseFloat(edtMedVal.getText().toString());

        // acquire HVL, thickness and SFD and convert if necessary
        TextView edtMatThik = findViewById(R.id.thicknessEntry);
        matThick = Float.parseFloat(edtMatThik.getText().toString());
        TextView edtHvlEntry = findViewById(R.id.hvlEntry);
        hvlValue = Float.parseFloat(edtHvlEntry.getText().toString());
        TextView edtSFD = findViewById(R.id.sfdEntry);
        sfdmm =Float.parseFloat(edtSFD.getText().toString());
        if (imperialTru) {
            matThick = (float) (matThick*25.4);
            hvlValue = (float) (hvlValue*25.4);
            sfdmm = (float) (sfdmm*25.4);
        }
    }


    public void calcExp() {
        // Calculate exposure time
        expTime = ((mediaFactor*Math.pow(sfdmm, 2)*Math.pow(2,(matThick/hvlValue))*60)/(activityCi*0.48*1000000));
        TextView tvExpTimeResult = findViewById(R.id.resultTime);
        //truncate seconds
        expMin = Math.floor(expTime);

        // find seconds
        expSec = ((expTime - expMin) * 60);
        // Convert to strings after conversion.  Time formatter is based on miliseconds so a second is 1000 msec and a minute is 60000 msec.
        long longmin = (long) expMin*60000;
        long longsec = (long) expSec*1000;
        // Create a formatter and link it to a string builder
        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);
        // variable for testing
        fmt.format ("%tM:", longmin);
        fmt.format ("%tS", longsec);
        //final Formatter format = fmt.format("%tT", 2.5);
        tvExpTimeResult.setText(sbuf.toString());
    }
}
