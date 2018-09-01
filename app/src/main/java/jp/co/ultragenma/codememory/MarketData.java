package jp.co.ultragenma.codememory;

import android.content.Context;
import android.content.res.Resources;

import java.util.Arrays;
import java.util.Random;

public class MarketData {
    private String[] mCodeList;
    private String[] mCompanyList;
    private String[] mMarketList;
    private String[][] mData;

    public MarketData(Context context) {
        Resources res = context.getResources();
        mData = new String[3][];

        if (res != null) {
            mCodeList = res.getStringArray(R.array.array_code);
            mCompanyList = res.getStringArray(R.array.array_company);
            mMarketList = res.getStringArray(R.array.array_market);

            mData[0] = Arrays.copyOf(mCodeList, mCodeList.length);
            mData[1] = Arrays.copyOf(mCompanyList, mCompanyList.length);
            mData[2] = Arrays.copyOf(mMarketList, mMarketList.length);
        }
    }

    public String[] getData(int index) {
        String[] data = new String[3];

        for (int i = 0; i < data.length; i++){
            data[i] = mData[i][index];
        }

        return data;
    }

    public int getLength() {
        return mCodeList.length;
    }

    /**
     * getRandomData()
     * @return Random data
     */
    public String[] getRandomData() {
        Random num = new Random();
        int i = num.nextInt(getLength());

        return getData(i);
    }
}
