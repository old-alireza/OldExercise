package alireza.sn.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {
    Spinner spinner;
    SpinnerCustom spinnerCustom;
    int flag []  = {R.drawable.state_1 , R.drawable.state_2 , R.drawable.state_1 , R.drawable.state_2 , R.drawable.state_1 ,R.drawable.state_2
           , R.drawable.state_1 , R.drawable.state_2 , R.drawable.state_1 , R.drawable.state_2};
    String name [] ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinner = findViewById(R.id.spinner_view);
        name = getResources().getStringArray(R.array.citiesName);

        spinnerCustom = new SpinnerCustom(this,flag ,name);
        spinner.setAdapter(spinnerCustom);
    }
}