package jp.co.ultragenma.codememory;

import android.content.Context;


public class Game {
    private MarketData mMarketData;
    static public int ANSWER_COMPANY_NAME = 0;
    static public int ANSWER_CODE = 1;
    private Question mQuestion;

    /**
     * Constructor
     * @return none
     */
    public Game(Context context) {
        mMarketData = MarketData.getInstance();
        mMarketData.init(context);
    }

    /**
     * setGameMode()
     * @return none
     */
    public void setGameMode(int mode) {
        mQuestion = new Question();
        mQuestion.init(mode);
    }

    /**
     * getQuestion()
     * @return String
     */
    public String getQuestion() {
        String question;
        question = mQuestion.getQuestion();

        return question;
    }

    /**
     * getAnswer()
     * @return String
     */
    public String getAnswer() {
        String answer;
        answer = mQuestion.getAnswer();

        return answer;
    }

}
