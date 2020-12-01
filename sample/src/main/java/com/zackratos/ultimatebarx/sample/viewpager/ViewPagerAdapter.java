package com.zackratos.ultimatebarx.sample.viewpager;

import android.graphics.Color;
import android.util.SparseArray;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.zackratos.ultimatebarx.library.UltimateBarX;
import com.zackratos.ultimatebarx.sample.R;
import com.zackratos.ultimatebarx.sample.TextFragment2;

/**
 * @Author : zhangwenchao
 * @Date : 2020/7/8  2:57 PM
 * @email : zhangwenchao@soulapp.cn
 * @Describe :
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private SparseArray<Fragment> fragments;

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fragments = new SparseArray<>();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = fragments.get(position);
        if (fragment != null) {
            return fragment;
        }
        switch (position) {
            case 0:
                fragment = TextFragment2
                        .Companion
                        .newInstance(Color.RED, "Android", Color.WHITE, f -> {
                            UltimateBarX.with(f)
                                    .fitWindow(true)
                                    .color(Color.RED)
                                    .applyStatusBar();
                            return null;
                        });
                break;
            case 1:
                fragment = ImageTextFragment
                        .Companion
                        .newInstance(R.drawable.yurisa__001, f -> {
                            UltimateBarX.with(f)
                                    .fitWindow(false)
                                    .colorRes(R.color.alphaBlack)
                                    .applyStatusBar();
                            return null;
                        });
                break;
            case 2:
                fragment = TextFragment2
                        .Companion
//                        .newInstance(Color.YELLOW, "Camera", Color.BLACK, f -> {
//                            return null;
//                        });
                        .newInstance(Color.BLUE, "Camera", Color.WHITE, f -> {
                            UltimateBarX.with(f)
                                    .fitWindow(true)
                                    .color(Color.BLUE)
                                    .applyStatusBar();
                            return null;
                        });
                break;
            case 3:
                fragment = ImageTextFragment
                        .Companion
                        .newInstance(R.drawable.yurisa__006, f -> {
                            UltimateBarX.with(f)
                                    .transparent()
                                    .applyStatusBar();
                            return null;
                        });
                break;
            default:
                fragment = new Fragment();
                break;
        }
        fragments.put(position, fragment);
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
