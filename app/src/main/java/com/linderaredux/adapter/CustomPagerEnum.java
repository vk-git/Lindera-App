package com.linderaredux.adapter;

import com.linderaredux.R;

public enum CustomPagerEnum {

    tutorial_1(1, R.layout.tutorial_1),
    tutorial_2(2, R.layout.tutorial_2),
    tutorial_3(3, R.layout.tutorial_3),
    tutorial_4(4, R.layout.tutorial_4),
    tutorial_5(5, R.layout.tutorial_5),
    tutorial_6(6, R.layout.tutorial_6);

    private int mTitleResId;
    private int mLayoutResId;

    CustomPagerEnum(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }
}