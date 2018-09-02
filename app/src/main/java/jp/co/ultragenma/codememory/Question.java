package jp.co.ultragenma.codememory;

import android.util.Log;

import java.util.Random;

public class Question {

    private MarketData mMarketData;
    private int mGameMode;
    static final private int ANSWER_COMPANY_NAME = 0;
    static final private int ANSWER_CODE = 1;
    private String[] mTest;
    private Random mNum;

    public Question() {
    }

    protected void init(int mode) {
        long seed = System.currentTimeMillis();
        mNum = new Random(seed);
        mMarketData = MarketData.getInstance();
        mGameMode = mode;
    }

    /**
     * getQuestion()
     * @return String
     */
    public String getQuestion() {
        String question;
        mTest = getRandomData();

        switch (mGameMode) {
            case ANSWER_COMPANY_NAME:
                question = mTest[0];
                break;
            case ANSWER_CODE:
                question = mTest[1];
                break;
            default:
                question = "Get Question";
                break;
        }

        return question;
    }

    /**
     * getRandomData()
     * @return Random data
     */
    public String[] getRandomData() {
        int i = mNum.nextInt(mMarketData.getLength());
        Log.d("ZeroOne", "Question mNum i = " + i);

        return mMarketData.getData(i);
    }

    public void setGameMode(int gameMode) {
        mGameMode = gameMode;
    }

    /**
     * getAnswer()
     * @return String
     */
    public String getAnswer() {
        String answer;

        switch (mGameMode) {
            case ANSWER_COMPANY_NAME:
                answer = mTest[1];
                break;
            case ANSWER_CODE:
                answer = mTest[0];
                break;
            default:
                answer = "Get Answer";
                break;
        }

        return answer;
    }

    public String getDummyAnswer() {
        String dummy = null;

        //ランダムな答えを作る


        switch (mGameMode) {
            case ANSWER_COMPANY_NAME:
                dummy = mMarketData.getCompany(0);
                break;
            case ANSWER_CODE:
                dummy = mMarketData.getCode(0);
                break;
            default:
                break;
        }

        return dummy;
    }

}
