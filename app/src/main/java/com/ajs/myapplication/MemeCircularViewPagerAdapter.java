package com.ajs.myapplication;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;


import java.util.List;

/**
 * User: tobiasbuchholz
 * Date: 18.09.14 | Time: 10:59
 */
public class MemeCircularViewPagerAdapter extends BaseCircularViewPagerAdapter {
    private final Context mContext;

    public MemeCircularViewPagerAdapter(final Context context, final FragmentManager fragmentManager, final List<Meme> memes) {
        super(fragmentManager, memes);
        mContext = context;
    }

    @Override
    protected Fragment getFragmentForItem(final Meme meme) {
        return MemeViewPagerItemFragment.instantiateWithArgs(mContext, meme);
    }
}
