package jp.co.ultragenma.codememory;

import android.content.Context;

public class Game {
    private MarketData mMarketData;
    private int mGameMode;
    static public int ANSWER_COMPANY_NAME = 0;
    static public int ANSWER_CODE = 1;
    private String[] mTest;

    /**
     * Constructor
     * @return none
     */
    public Game(Context context) {
        mMarketData = new MarketData(context);
    }

    /**
     * setGameMode()
     * @return none
     */
    public void setGameMode(int mode) {
        mGameMode = mode;
    }

    /**
     * getQuestion()
     * @return String
     */
    public String getQuestion() {
        String question;
        mTest = mMarketData.getRandomData();

        if (mGameMode == ANSWER_COMPANY_NAME) {
            question = mTest[0];
        } else if (mGameMode == ANSWER_CODE) {
            question = mTest[1];
        } else {
            question = "Get Question";
        }

        return question;
    }

    /**
     * getAnswer()
     * @return String
     */
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


}
