package alireza.sn.exercise1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText inputName,inputEmail,inputPassword;
    Button btnLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputName = findViewById(R.id.edName);
        inputEmail = findViewById(R.id.edEmail);
        inputPassword = findViewById(R.id.edPassword);
        btnLogIn = findViewById(R.id.btn_logIn);
        btnLogIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String name,password,email;
                name=inputName.getText().toString();
                password=inputPassword.getText().toString();
                email=inputEmail.getText().toString();

                Intent intent = new Intent(MainActivity.this,LogIn.class);
                intent.putExtra("name",name);
                intent.putExtra("password",password);
                intent.putExtra("email",email);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK)
            Toast.makeText(this, "SAVED", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "FAILED", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_1 , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.menu_sms) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:"));
            startActivity(intent);
        }

        if(item.getItemId() == R.id.menu_browser) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.google.com"));
            startActivity(intent);
        }

        if(item.getItemId() == R.id.menu_image){

            Intent intent = new Intent(MainActivity.this , ImageActivity.class);
            startActivity(intent);
        }

        if(item.getItemId() == R.id.menu_audio){
            Intent intent = new Intent(MainActivity.this , AudioActivity.class);
            startActivity(intent);
        }

        if(item.getItemId() == R.id.menu_Video){
            Intent intent = new Intent(MainActivity.this , VideoActivity.class);
            startActivity(intent);
        }

        if(item.getItemId() == R.id.dialog){
            Intent intent = new Intent(this , DialogActivity.class);
            startActivity(intent);
        }

        if(item.getItemId() == R.id.simple_list)
            startActivity(new Intent(this, ListActivity.class));

        if(item.getItemId() == R.id.simple_toast)
            startActivity(new Intent(this, ToastActivity.class));

        if(item.getItemId() == R.id.radio)
            startActivity(new Intent(this , RadioActivity.class));

        if(item.getItemId() == R.id.ratingBar)
            startActivity(new Intent(this , RatingActivity.class));

        if(item.getItemId() == R.id.spinner)
            startActivity(new Intent(this , SpinnerActivity.class));

        return super.onOptionsItemSelected(item);
    }

    public void onClickExercise(View view) {
        startActivity(new Intent(MainActivity.this ,Example.class));
    }
}