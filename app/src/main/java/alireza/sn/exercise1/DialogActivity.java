package alireza.sn.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class DialogActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }


    public void onClick(View view) {

        if(view.getId() == R.id.btn1){

            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMessage("please wait...");
            progressDialog.show();
            progressDialog.setProgress(0);

            new Timer().scheduleAtFixedRate(new TimerTask() {

                @Override
                public void run() {
                    if(progressDialog.getProgress() < progressDialog.getMax())
                        progressDialog.incrementProgressBy(5);

                    else
                        progressDialog.dismiss();
                }
            }, 0, 100);
        }

        if(view.getId() == R.id.btn2){
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("hello baby :)");
            builder.setNeutralButton("Tnx",null);
            builder.show();
        }

        if(view.getId() == R.id.btn3){

            Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.activity_dialog);
            dialog.show();
        }


    }
}