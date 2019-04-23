package com.example.coordinatorlayout;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.coordinatorlayout.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mBinding.layoutScrollArea.setMinimumHeight(convertDpToPx(this, 56)); // 최저 높이 : 코디네이터(툴바적인 성격?? 툴바선언?? 무튼) 가 줄어드는 마지노선.
        k();
    }




    // 투명도 조절
    public void k(){
        mBinding.layoutAppbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float alpha = 1f - (-1) * (float) verticalOffset / (float) mBinding.layoutAppbar.getTotalScrollRange();
                mBinding.imageView01.setAlpha(alpha); // verticalOffset = 음수값
            }
        });
    }


    // dp -> px
    public static int convertDpToPx(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) Math.round(dp * density + 0.5);
    }

    public static float convertDpToPx(Context context, float dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return dp * density;
    }

}
