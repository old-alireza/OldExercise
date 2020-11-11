package alireza.sn.exercise1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView pieceX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        pieceX = findViewById(R.id.piece_x);
        pieceX.setOnClickListener(this);


}


    @Override
    public void onClick(View v) {

        if(v.getId()==pieceX.getId())
            fade();

    }

    private void fade() {
            pieceX.animate().rotation(5*360).setDuration(3000);

    }
}