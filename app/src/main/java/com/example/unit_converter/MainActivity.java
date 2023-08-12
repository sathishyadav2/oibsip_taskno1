package com.example.unit_converter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {

    private EditText inputValue;
    private Spinner unitSpinner;
    private EditText outputValue;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.inputValue);
        unitSpinner = findViewById(R.id.unitSpinner);
        outputValue = findViewById(R.id.outputValue);
        convertButton = findViewById(R.id.convertButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.unit_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitSpinner.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });
    }

    private void convert() {
        double valueToConvert = Double.parseDouble(inputValue.getText().toString());
        String selectedConversion = unitSpinner.getSelectedItem().toString();
        double result;

        if (selectedConversion.equals("cm to m")) {
            result = valueToConvert / 100;
        } else if(selectedConversion.equals("m to cm")){
            result = valueToConvert * 100;
        }

        else if (selectedConversion.equals("gr to kg")) {
            result = valueToConvert / 1000;
        } else if (selectedConversion.equals("kg to gr")){
            result = valueToConvert * 1000;
        }
        else if (selectedConversion.equals("m to km")) {
            result = valueToConvert / 1000;
        } else {
            result = valueToConvert * 1000;
        }

        outputValue.setText(String.valueOf(result));
    }
}
