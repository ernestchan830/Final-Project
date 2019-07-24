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

    private Chronometer stopwatch;
    private boolean running;
    private long pauseOffset;
    private ImageButton mSleepButton;
    private Button mStopButton;



    public void startStopwatch() {
        if(!running)  {
            stopwatch.setBase(SystemClock.elapsedRealtime()- pauseOffset);
            stopwatch.start();
            running = true;
        }
    }

    public void stopStopwatch() {
        if (running) {
            stopwatch.stop();
            pauseOffset = SystemClock.elapsedRealtime() - stopwatch.getBase();
            stopwatch.setBase(SystemClock.elapsedRealtime());
            pauseOffset = 0;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sleep, null);
        mSleepButton = (ImageButton) view.findViewById(R.id.sleep_button);
        mSleepButton.setOnClickListener(this);
        mStopButton = (Button) view.findViewById(R.id.stop_button);
        mStopButton.setOnClickListener(this);
        stopwatch = view.findViewById(R.id.stopwatch);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.sleep_button) {
            startStopwatch();
        }
        else if (view.getId() == R.id.stop_button) {
            stopStopwatch();
        }
    }
}
