package alireza.sn.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class AudioActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mediaPlayer;
    Button btnPlay,btnPause;
    SeekBar seekBarVolume,seekBarRol;
    AudioManager ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        btnPlay = findViewById(R.id.btn_play);
        btnPause = findViewById(R.id.btn_pause);
        seekBarVolume = findViewById(R.id.seekBar);
        seekBarRol = findViewById(R.id.seekBarRol);
        btnPlay.setOnClickListener(this);
        btnPause.setOnClickListener(this);

        //media player
        ad = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        seekBarVolume.setProgress(ad.getStreamVolume(AudioManager.STREAM_MUSIC));
        seekBarVolume.setMax(ad.getStreamMaxVolume(AudioManager.STREAM_MUSIC));

        //position

        seekBarRol.setProgress(0);
        seekBarRol.setMax(mediaPlayer.getDuration());
        new Timer().scheduleAtFixedRate(new TimerTask() {

            @Override

            public void run() {
                seekBarRol.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,100);

        seekBarRol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if(fromUser)
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ad.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_play :
                mediaPlayer.start();
                break;

            case R.id.btn_pause :
                mediaPlayer.pause();
                break;

            default:
                break;
        }
    }
}