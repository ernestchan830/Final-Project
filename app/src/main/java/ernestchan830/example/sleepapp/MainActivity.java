package ernestchan830.example.sleepapp;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private TextView mTextMessage;

    private RelativeLayout mHomePage;
    private RelativeLayout mStatsPage;
    private RelativeLayout mSleepPage;
    private RelativeLayout mNotesPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mHomePage = (RelativeLayout) findViewById(R.id.navigation_home);
        mStatsPage = (RelativeLayout) findViewById(R.id.navigation_stats);
        mSleepPage = (RelativeLayout) findViewById(R.id.navigation_sleep);
        mNotesPage = (RelativeLayout) findViewById(R.id.navigation_notes);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        ImageView myImageView = (ImageView) findViewById(R.id.sleepgraph);
//        myImageView.setImageResources(R.drawable.sleepgraph);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new HomeFragment());
    }

    private boolean loadFragment (Fragment fragment) {
        if(fragment != null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();

            return true;
        }
        return false;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch(item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_stats:
                fragment = new StatsFragment();
                break;

            case R.id.navigation_sleep:
                fragment = new SleepFragment();
                break;

            case R.id.navigation_notes:
                fragment = new NotesFragment();
                break;
        }

        return loadFragment(fragment);
    }
}
