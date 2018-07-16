package jp.co.ultragenma.codememory;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.os.Bundle;
import android.print.PrinterId;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Remove the below line after defining your own ad unit ID.
    private static final String TOAST_TEXT = "Test ads are being shown. "
            + "To show live ads, replace the ad unit ID in res/values/strings.xml with your own ad unit ID.";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        setScreenMain();    // set main activity

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        // Toasts the test ad message on the screen. Remove this after defining your own ad unit ID.
//        Toast.makeText(this, TOAST_TEXT, Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            setScreenGameChoice();      // set game choice screen
            return true;gi
        }

        return super.onOptionsItemSelected(item);
    }

    private void setScreenMain() {
        setContentView(R.layout.activity_main);

        ImageButton btn = findViewById(R.id.app_icon);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenGameChoice();      // set game choice screen
            }
        });
    }

    private void setScreenGameChoice() {
        setContentView(R.layout.layout_game_choice);

        Button btn_all = findViewById(R.id.tokyo_all);
        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setScreenGame();
            }
        });
    }

    private void setScreenGame() {
        setContentView(R.layout.layout_game);

        final TextView answer = findViewById(R.id.field_answer);
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setVisibility(View.INVISIBLE);
                // Toasts the test ad message on the screen. Remove this after defining your own ad unit ID.
                Toast.makeText(view.getContext(), TOAST_TEXT, Toast.LENGTH_LONG).show();
            }
        });
    }

}
