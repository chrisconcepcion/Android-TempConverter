package tempconverter.androidapps.com.temperatureconverter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView tempResult;
    private EditText enteredValue;
    private Button fButton;
    private Button cButton;
    DecimalFormat round  = new DecimalFormat("0.0");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tempResult = (TextView)findViewById(R.id.temp_result_id);
        enteredValue = (EditText)findViewById(R.id.entered_text_id);
        fButton = (Button)findViewById(R.id.f_btn_id);
        cButton = (Button)findViewById(R.id.c_btn_id);

        fButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String editTextVal = enteredValue.getText().toString();

                if(editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter a Value", Toast.LENGTH_LONG).show();
                } else {
                    double converterResult;
                    double doubleEditTextVal = Double.parseDouble(editTextVal);
                    converterResult = convertToFahrenheit(doubleEditTextVal);
                    String stringResult = String.valueOf(round.format(converterResult));
                    tempResult.setText(stringResult + " F");
                }

            }
        });

        cButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String editTextVal = enteredValue.getText().toString();

                if(editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter a Value", Toast.LENGTH_LONG).show();
                } else {
                    double converterResult;
                    double doubleEditTextVal = Double.parseDouble(editTextVal);
                    converterResult = convertToCelsius(doubleEditTextVal);

                    String stringResult = String.valueOf(round.format(converterResult));
                    tempResult.setText(stringResult + " C");
                }
            }
        });
    }

    public double convertToCelsius(double fVal){
        double result;
        double multiplier;
        multiplier = 5.0/9.0;
        result = (fVal - 32) * multiplier;
        return result;
    }

    public double convertToFahrenheit(double cVal){
        double result;
        double multiplier;
        multiplier = 5.0/9.0;
        result = cVal  * multiplier + 32;
        return result;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
