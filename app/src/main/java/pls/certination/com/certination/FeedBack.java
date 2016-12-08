package pls.certination.com.certination;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class FeedBack extends AppCompatActivity implements OnSeekBarChangeListener {
    SeekBar seekBar;
    int progressVal=0;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        seekBar= (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener( this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        progressVal=progress;
        text= (TextView) findViewById(R.id.texx);
        text.setText("You Scored Us :"+progressVal);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
