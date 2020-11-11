package alireza.sn.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioActivity extends AppCompatActivity implements View.OnClickListener {
    RadioGroup rg;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        rg = findViewById(R.id.radio);
        button = findViewById(R.id.btn_choose);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btn_choose){
            RadioButton rb = findViewById(rg.getCheckedRadioButtonId());
             if(rb != null)
            Toast.makeText(this, rb.getTag().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}