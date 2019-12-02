package com.example.cimbatweek1.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.cimbatweek1.R;
import com.example.cimbatweek1.base.BaseActivity;
import com.example.cimbatweek1.view.fragment.HomFeagment;
import com.example.cimbatweek1.view.fragment.MyFeagment;
import com.example.cimbatweek1.view.fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private ViewPager vp;
    private RadioGroup rg;
    List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void initData() {
    fragmentList.add(new HomFeagment());
    fragmentList.add(new NewsFragment());
    fragmentList.add(new MyFeagment());
    vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    });
    }

    @Override
    protected void initView() {
        vp = findViewById(R.id.vp);
        rg = findViewById(R.id.rg);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                      rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        vp.setCurrentItem(2);
                        break;
                }
            }
        });

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
    public void toMyPage() {
        vp.setCurrentItem(2);
    }
}
