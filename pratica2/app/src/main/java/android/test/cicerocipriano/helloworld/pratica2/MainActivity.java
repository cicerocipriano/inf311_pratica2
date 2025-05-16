package android.test.cicerocipriano.helloworld.pratica2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button report_button;
    EditText name, age, weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        report_button = (Button)findViewById(R.id.reportButton);
        name = (EditText)findViewById(R.id.nameInserter);
        age = (EditText)findViewById(R.id.ageInserter);
        weight = (EditText)findViewById(R.id.weightInserter);
        height = (EditText)findViewById(R.id.heightInserter);

        report_button.setOnClickListener(v -> onClick());
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("main", "onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("main", "onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("main", "onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("main", "onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("main", "onRestart");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("main", "onDestroy");
    }

    public void onClick(){
        //try{
            String res_name = name.getText().toString();
            double res_age = Double.parseDouble(age.getText().toString());
            double res_weight = Double.parseDouble(weight.getText().toString());
            double res_height = Double.parseDouble(height.getText().toString());
            double bmi = res_weight / (res_height * res_height);

            Bundle b = new Bundle();
            b.putString("name", res_name);
            b.putDouble("age", res_age);
            b.putDouble("weight", res_weight);
            b.putDouble("height", res_height);
            b.putDouble("bmi", bmi);

            Intent it = new Intent(getBaseContext(), report.class);
            it.putExtras(b);
            it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

            startActivity(it);
        //} catch (Exception e) {
        //    Toast.makeText(this, "An Error occurred.", Toast.LENGTH_SHORT).show();
        //}
    }
}