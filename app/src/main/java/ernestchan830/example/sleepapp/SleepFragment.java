package ernestchan830.example.sleepapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SleepFragment extends Fragment {

    private Chronometer stopwatch;
    private boolean running;
    private long pauseOffset;

//    @Override
//    protected void onCreate(Bundle savedInstances) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        stopwatch = findViewById(R.id.stopwatch);
//    }

    public void startStopwatch(View v) {
        if(!running)  {
            stopwatch.setBase(SystemClock.elapsedRealtime()- pauseOffset);
            stopwatch.start();
            running = true;
        }
    }

    public void stopStopwatch(View v) {
//        if(running)  {
//            stopwatch.stop();
//            pauseOffset = SystemClock.elapsedRealtime() - stopwatch.getBase();
        stopwatch.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
        }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sleep, null);


    }
}
