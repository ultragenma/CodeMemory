package jp.co.ultragenma.codememory;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private Game mGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setScreenMain();    // set main activity

        // Load an ad into the AdMob banner view.
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        adView.loadAd(adRequest);

        mGame = new Game(this);

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
            return true;
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

        Button btn_company_mode = findViewById(R.id.mode_company);
        btn_company_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGame.setGameMode(Game.ANSWER_COMPANY_NAME);
                setScreenGame();
            }
        });

        Button btn_code_mode = findViewById(R.id.mode_code);
        btn_code_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGame.setGameMode(Game.ANSWER_CODE);
                setScreenGame();
            }
        });
    }

    private void setScreenGame() {
        setContentView(R.layout.layout_game);

        final Button question = findViewById(R.id.button_question);
        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String questionData = mGame.getQuestion();
                question.setText(questionData);
            }
        });


        final Button answer = findViewById(R.id.button_answer1);
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answerData = mGame.getAnswer();
                answer.setText(answerData);
            }
        });
    }

}
