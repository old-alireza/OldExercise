package alireza.sn.exercise1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {

    TextView tvInfo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        tvInfo  =findViewById(R.id.textView_info);

        Bundle info = getIntent().getExtras();

        if(info!=null){

            if(info.getString("name")!=null)
                tvInfo.setText("name : "+info.getString("name")+"\n");

            if(info.getString("email")!=null)
                tvInfo.append("email : "+info.getString("email")+"\n");

            if(info.getString("password")!=null)
                tvInfo.append("password"+info.getString("password")+"\n");

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent();

        if(item.getItemId()==R.id.itemOK){
            setResult(RESULT_OK,intent);
            finish();
        }

        if(item.getItemId()==R.id.itemCancel){
            setResult(RESULT_CANCELED,intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}