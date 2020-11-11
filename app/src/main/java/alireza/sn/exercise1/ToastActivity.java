package alireza.sn.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }

    public void colorToasted(View view) {
        String tag = view.getTag().toString();

        switch (tag) {

            case "warning":
                ( ColorToast.warning(this , "warning toast" , Toast.LENGTH_SHORT)).show();
                break;

            case "error":
                (ColorToast.error(this , "error toast" , Toast.LENGTH_SHORT)).show();
                break;

            case "success":
                (ColorToast.success(this , "success toast" ,Toast.LENGTH_SHORT)).show();
                break;

            default:
                break;
        }
    }

    public void imageToast(View view) {

        (ColorToast.image(this , R.drawable.o , Toast.LENGTH_SHORT)).show();
    }
}