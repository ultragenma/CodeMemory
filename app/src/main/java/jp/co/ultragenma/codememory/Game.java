package jp.co.ultragenma.codememory;

import android.content.Context;

import java.util.Random;

public class Game {
    private MarketData mMarketData;
    private int mGameMode;
    static public int ANSWER_COMPANY_NAME = 0;
    static public int ANSWER_CODE = 1;
    private String[] mTest;

    public Game(Context context) {
        mMarketData = new MarketData(context);
    }

    public void setGameMode(int mode) {
        mGameMode = mode;
    }

    public String getQuestion() {
        String question;
        mTest = getRandomData();

        if (mGameMode == ANSWER_COMPANY_NAME) {
            question = mTest[0];
        } else if (mGameMode == ANSWER_CODE) {
            question = mTest[1];
        } else {
            question = "Get Question";
        }

        return question;
    }

    public String getAnswer() {
        String answer;

        if (mGameMode == ANSWER_COMPANY_NAME) {
            answer = mTest[1];
        } else if (mGameMode == ANSWER_CODE) {
            answer = mTest[0];
        } else {
            answer = "Get Answer";
        }
        return answer;
    }

    /**
     * getRandomData()
     * @return Random data
     */
    public String[] getRandomData() {
        Random num = new Random();
        int i = num.nextInt(mMarketData.getLength());

        return mMarketData.getData(i);
    }

}
