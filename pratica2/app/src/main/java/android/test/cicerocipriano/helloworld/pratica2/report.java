package android.test.cicerocipriano.helloworld.pratica2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class report extends AppCompatActivity {

    TextView resName, resAge, resWeight, resHeight, resBmi, resClassificacao;
    Button recalc_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("report", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);

        resName = findViewById(R.id.resNameBox);
        resAge = findViewById(R.id.resAgeBox);
        resWeight = findViewById(R.id.resWeightBox);
        resHeight = findViewById(R.id.resHeightBox);
        resBmi = findViewById(R.id.resBmiBox);
        resClassificacao = findViewById(R.id.resClassificationBox);
        recalc_button = (Button)findViewById(R.id.returnButtton);

        Intent it = getIntent();
        Bundle b = it.getExtras();
        String name = b.getString("name");
        double age = b.getDouble("age"), weight = b.getDouble("weight");
        double height = b.getDouble("height"), bmi = b.getDouble("bmi");

        resName.setText(name);
        resAge.setText(Double.toString(age));
        resWeight.setText(Double.toString(weight));
        resHeight.setText(Double.toString(height));
        resBmi.setText(Double.toString(bmi));

        if(bmi < 18.5){
            String s = "Abaixo do peso";
            resClassificacao.setText(s);
        }else if(bmi >= 18.5 && bmi < 25.0){
            String s = "Saudavel";
            resClassificacao.setText(s);
        }else if(bmi >= 25.0 && bmi < 30.0){
            String s = "Sobrepeso";
            resClassificacao.setText(s);
        }else if(bmi >= 30.0 && bmi < 35.0){
            String s = "Obesidade Grau I";
            resClassificacao.setText(s);
        }else if(bmi >= 35.0 && bmi < 40.0){
            String s = "Obesidade Grau II (severa)";
            resClassificacao.setText(s);
        }else{
            String s = "Obesidade Grau III (morbida)";
            resClassificacao.setText(s);
        }

        recalc_button.setOnClickListener(v -> redo());

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("report", "onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("report", "onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("report", "onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("report", "onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("report", "onRestart");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("report", "onDestroy");
    }

    public void redo(){finish();}
}