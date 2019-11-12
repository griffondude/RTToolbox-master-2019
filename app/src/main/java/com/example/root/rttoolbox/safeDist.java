package com.example.root.rttoolbox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicReference;

public class safeDist extends AppCompatActivity {
    public TextView tvResult;
    public double resultuncoll, resultcoll, maxDoseRate;
    public boolean radUnitGray;
    public boolean sourceUnitGbq, measUnitImp;
    float activity;
    public String strRadUnit, strSourceUnit, strdistUnit;
    public String isotopeSelect, tag;
    public int branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe_dist);
        setTitle(R.string.title_safe_dist);
        setPrefs();
        // set up listener so that app recalculates every button press.
        final Button calc = findViewById(R.id.button3);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPrefs();
                calculateDist(calc);
                Log.d(tag, "In the onCreate() event");
            }
        });

    }


    // Method to send user to settings screen when desired.
    public void gotosettings(View view) {
        Intent myIntent = new Intent(this, SettingsActivity.class);
        startActivity(myIntent);
    }

    // Method for applying preferences to this activity.
    public void setPrefs() {
        // Acquire unit selection from settings activity.
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        radUnitGray = sharedPref.getBoolean("radiation_unit_switch", false);
        sourceUnitGbq = sharedPref.getBoolean("source_unit_switch", false);
        isotopeSelect = sharedPref.getString("example_list", "Ir192");
        measUnitImp = sharedPref.getBoolean("measurement_unit_switch", false);


        if (radUnitGray) {strRadUnit = getString(R.string.mg_h);

        } else {
            strRadUnit = getString(R.string.mr_h);}
        if (sourceUnitGbq) {strSourceUnit = getString(R.string.gbq);

        } else {
            strSourceUnit = getString(R.string._ci);}

        TextView tvsourceType = findViewById(R.id.sourceType);
        tvsourceType.setText(isotopeSelect);
        TextView tvradunit = findViewById(R.id.radUnit);
        tvradunit.setText(strRadUnit);
        TextView tvsourceunit = findViewById(R.id.sourceUnit);
        tvsourceunit.setText(strSourceUnit);
    }

    public void calculateDist(View view) {
        // initialize isotope type selection
        // final RadioGroup isotopeRG = findViewById(R.id.isotope);
        // define isotope ids
        // Todo: Replace with settings activity if possible.
        //RadioButton ir192 = findViewById(R.id.ir192);
        //RadioButton co60 = findViewById(R.id.co60);
        // final int[] isotopeSel = new int[1];
        // setUnits();
        final EditText activityEdt = findViewById(R.id.editTextActivity);
        // acquire activity data
        String activityStr = activityEdt.getText().toString();
        activity = Float.parseFloat(activityStr);
        //convert activity to Ci if sourceUnitGbq is true
        if(sourceUnitGbq) {activity = activity / 37;}
        // isotopeSel[0] = isotopeRG.getCheckedRadioButtonId();
        // fetch desired dose rate
        EditText tdr = findViewById(R.id.tdr_entry);
        maxDoseRate = Double.parseDouble(tdr.getText().toString());
        // convert to MR/h if Gray is selected true
        if (radUnitGray) {maxDoseRate = maxDoseRate/10;}
        //execute calcs based on which isotope was selected
        // Data source: CNSC - Radionuclide Information Booklet Feb 2017
        switch (isotopeSelect) {
            case "Ir192":
                resultuncoll = Math.sqrt(activity*432.48 / maxDoseRate);
                resultcoll = Math.sqrt(activity*432.48*0.1 / maxDoseRate);
                branch = 1;
                break;
            case "Co60":
                resultuncoll = Math.sqrt(activity*1126.5 / maxDoseRate);
                resultcoll = Math.sqrt(activity*1126.5*0.1 / maxDoseRate);
                branch = 2;
                break;
            case "Se75":
                resultuncoll = Math.sqrt(activity*206.73 / maxDoseRate);
                resultcoll = Math.sqrt(activity*206.73*0.1 / maxDoseRate);
                branch = 3;
                break;
        }

        if (measUnitImp) {
            resultcoll = resultcoll * 3;
            resultuncoll = resultuncoll * 3;
            strdistUnit = " feet";
        } else {
            strdistUnit = " m";
        }
        AtomicReference<String> strBrnach = new AtomicReference<>(Integer.toString(branch));
        resultuncoll = Math.round(resultuncoll * 100d)/100d;
        String stringResult = Double.toString(resultuncoll);
        tvResult = findViewById(R.id.result25uncol);
        tvResult.setText(stringResult + strdistUnit);
        resultcoll = Math.round(resultcoll * 100d)/100d;
        String stringResult1 = Double.toString(resultcoll);
        tvResult = findViewById(R.id.result25col);
        tvResult.setText(stringResult1 + strdistUnit);
    }
}
