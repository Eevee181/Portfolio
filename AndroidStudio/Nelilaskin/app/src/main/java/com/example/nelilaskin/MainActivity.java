package com.example.nelilaskin;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   Button buttonLaske;
   EditText number1, number2, resuText;
   TextView text2, text3;

   float value1, value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLaske = (Button) findViewById(R.id.button);
        number1 = (EditText) findViewById(R.id.editTextNumber);
        number2 = (EditText) findViewById(R.id.editTextNumber2);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        resuText = (EditText) findViewById(R.id.editTextNumber5);

        buttonLaske.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number1 == null || number2 == null) {
                    number1.setText("");
                    number2.setText(""); }
                else{
                    value1 = Float.parseFloat(number1.getText() + "");
                    value2 = Float.parseFloat(number2.getText() + "");

                    resuText.setText(value1 + value2 + "");
                }

                }

        });
    }
}



