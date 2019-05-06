package com.ajs.myapplication;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: tobiasbuchholz
 * Date: 18.09.14 | Time: 13:18
 */
public abstract class BaseCircularViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<com.ajs.myapplication.Meme> mItems;
    private List<String> mTitle;

    public BaseCircularViewPagerAdapter(final FragmentManager fragmentManager, final List<Meme> items) {
        super(fragmentManager);
        mItems = items;
        mTitle = new ArrayList<>();
        for(Meme meme : mItems) {
            mTitle.add(meme.mTitle);
        }
    }

    protected abstract Fragment getFragmentForItem(final Meme item);

    @Override
    public Fragment getItem(final int position) {
        final int itemsSize = mItems.size();
        if(position == 0) {
            return getFragmentForItem(mItems.get(itemsSize - 1));
        } else if(position == itemsSize + 1) {
            return getFragmentForItem(mItems.get(0));
        } else {
            return getFragmentForItem(mItems.get(position - 1));
        }
    }

    @Override
    public int getCount() {
        final int itemsSize = mItems.size();
        return itemsSize > 1 ? itemsSize + 2 : itemsSize;
    }

    public int getCountWithoutFakePages() {
        return mItems.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0) {
            return "";
        }
        if(position ==  mItems.size() + 1)
            return "";
        return "ABC" + position;
    }

    public void setItems(final List<Meme> items) {
        mItems = items;
        notifyDataSetChanged();
    }
}
