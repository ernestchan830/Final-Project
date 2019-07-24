package ernestchan830.example.sleepapp;

import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SleepFragment extends Fragment implements View.OnClickListener {

    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    private ImageButton mSleepButton;


    public void startStopwatch(View v) {
        if(!running)  {
            chronometer.setBase(SystemClock.elapsedRealtime()- pauseOffset);
            chronometer.start();
            running = true;
        }
    }

    public void stopStopwatch(View v) {
        if (running) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            chronometer.setBase(SystemClock.elapsedRealtime());
            pauseOffset = 0;
        }
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sleep, null);
        mSleepButton = (ImageButton) view.findViewById(R.id.sleep_button);
        mSleepButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
    
    }
}
