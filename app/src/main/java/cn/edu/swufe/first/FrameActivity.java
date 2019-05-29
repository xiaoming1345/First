package cn.edu.swufe.first;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FrameActivity extends FragmentActivity {

    private Fragment mFragments[];
    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private RadioButton rbtHome,rbtFunc,rbtSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        mFragments = new Fragment[3];
        fragmentManager = getSupportFragmentManager();
        mFragments[0] = fragmentManager.findFragmentById(R.id.fragment_main);
        mFragments[1] = fragmentManager.findFragmentById(R.id.fragment_func);
        mFragments[2] = fragmentManager.findFragmentById(R.id.fragment_setting);
        fragmentTransaction =
                fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);
        fragmentTransaction.show(mFragments[0]).commit();

        rbtHome = findViewById(R.id.radioHome);
        Drawable drawable1 = getResources().getDrawable(R.drawable.a);//找到图片
        drawable1.setBounds(0, 0, 60, 60);//最关键的一步，给图片设置大小,4个参数分别是左上右下，我看好多人对这个左上右下不理解，看下源码
        rbtHome.setCompoundDrawables(null, drawable1, null, null);
        rbtHome.setBackgroundResource(R.drawable.shape3);

        rbtFunc = findViewById(R.id.radioFunc);
        Drawable drawable2 = getResources().getDrawable(R.drawable.b);//找到图片
        drawable2.setBounds(0, 0, 60, 60);//最关键的一步，给图片设置大小,4个参数分别是左上右下，我看好多人对这个左上右下不理解，看下源码
        rbtFunc.setCompoundDrawables(null, drawable2, null, null);
        rbtFunc.setBackgroundResource(R.drawable.shape3);

        rbtSetting = findViewById(R.id.radioSetting);
        Drawable drawable3 = getResources().getDrawable(R.drawable.c);//找到图片
        drawable3.setBounds(0, 0, 60, 60);//最关键的一步，给图片设置大小,4个参数分别是左上右下，我看好多人对这个左上右下不理解，看下源码
        rbtSetting.setCompoundDrawables(null, drawable3, null, null);
        rbtSetting.setBackgroundResource(R.drawable.shape3);




        radioGroup = findViewById(R.id.bottomGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i("radioGroup","checkId=" + checkedId);
                fragmentTransaction =
                        fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);
                rbtHome.setBackgroundResource(R.drawable.shape2);
                rbtFunc.setBackgroundResource(R.drawable.shape2);
                rbtSetting.setBackgroundResource(R.drawable.shape2);

                switch (checkedId){
                    case R.id.radioHome:
                        fragmentTransaction.show(mFragments[0]).commit();
                        rbtHome.setBackgroundResource(R.drawable.shape3);
                        break;
                    case R.id.radioFunc:
                        fragmentTransaction.show(mFragments[1]).commit();
                        rbtFunc.setBackgroundResource(R.drawable.shape3);
                        break;
                    case R.id.radioSetting:
                        fragmentTransaction.show(mFragments[2]).commit();
                        rbtSetting.setBackgroundResource(R.drawable.shape3);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
