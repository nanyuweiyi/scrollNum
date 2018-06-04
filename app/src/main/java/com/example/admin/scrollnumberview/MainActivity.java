package com.example.admin.scrollnumberview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.library.NumAnim;

public class MainActivity extends AppCompatActivity {

    TextView tvShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvShow = findViewById(R.id.tvShow);

        //setmSpeed必须设置在startAnim之前,建议最后调用startAnim()
        NumAnim.builder()
                .setmSpeed(500)           //数字越小刷新速度越快
                .setmPoint(1)             //小数点位
                .startAnim(tvShow, 999);  //第一个参数控件，第二个参数目标数字
    }
}
