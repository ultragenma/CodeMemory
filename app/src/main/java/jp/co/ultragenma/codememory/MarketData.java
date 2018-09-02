package jp.co.ultragenma.codememory;

import android.content.Context;
import android.content.res.Resources;

import java.util.Arrays;

public final class MarketData {
    private String[][] mData;
    private int mLength;
    private static final MarketData instance = new MarketData();

    private MarketData() {}

    public static MarketData getInstance() {
        return instance;
    }

    public void init(Context context) {
        Resources res = context.getResources();
        mData = new String[3][];

        if (res != null) {
            String[] codeList = res.getStringArray(R.array.array_code);
            String[] companyList = res.getStringArray(R.array.array_company);
            String[] marketList = res.getStringArray(R.array.array_market);

            mData[0] = Arrays.copyOf(codeList, codeList.length);
            mData[1] = Arrays.copyOf(companyList, companyList.length);
            mData[2] = Arrays.copyOf(marketList, marketList.length);

            mLength = codeList.length;
        }

    }

    public String[] getData(int index) {
        String[] data = new String[3];

        for (int i = 0; i < data.length; i++){
            data[i] = mData[i][index];
        }

        return data;
    }

    public String getCode(int i) {
        return mData[0][i];
    }

    public String getCompany(int i) {
        return mData[1][i];
    }

    public String getMarket(int i) {
        return mData[2][i];
    }

    public String[] getCodeList() {
        return mData[0];
    }

    public String[] getCompanyList() {
        return mData[1];
    }

    public String[] getmMarketList() {
        return mData[2];
    }

    public int getLength() {
        return mLength;
    }


}
