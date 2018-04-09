package com.example.draya.currencyconversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    double conversionRate = 1.28;
    double amountEntered = 0.0;
    double convertedCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText currency = (EditText) findViewById(R.id.txtConvert);
        final RadioButton Usd_to_Cad = (RadioButton) findViewById(R.id.radUSDtoCAD);
        final RadioButton Cad_to_Usd = (RadioButton) findViewById(R.id.radCADtoUSD);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button convert = (Button) findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amountEntered = Double.parseDouble(currency.getText().toString());
                DecimalFormat hundreth = new DecimalFormat("#.##");
                if(Usd_to_Cad.isChecked()){
                    if (amountEntered <= 10000){  //cannot come out to be more than 10,000.
                        convertedCurrency = amountEntered * conversionRate;
                        result.setText(hundreth.format(convertedCurrency) + "CAD");

                    }else{
                        Toast.makeText(MainActivity.this,"USD Amount must be less than " +
                                "10,000", Toast.LENGTH_LONG).show();
                    }
                }
                if(Cad_to_Usd.isChecked()){
                    if(amountEntered <= 10000){
                        convertedCurrency = amountEntered / conversionRate;
                        result.setText(hundreth.format(convertedCurrency)+ "USD");
                    }
                    else{
                        Toast.makeText(MainActivity.this,"CAD amount must be less than 10,000",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        }



    }

