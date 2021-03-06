package com.example.library;

import android.widget.TextView;

import java.util.LinkedList;
import java.util.Random;

/**
 * ================================================
 * 描   述: 数字滚动
 * 作   者：tnn
 * 创建日期：2018/5/16
 * 版   本：1.0.0
 * ================================================
 */
public class NumAnim {

    public NumAnim() {
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        int mSpeed = 1000;   //每秒刷新多少次
        int mPoint = 0;         //小数点位数,整数设置为0即可

        public int getmSpeed() {
            return mSpeed;
        }

        public Builder setmSpeed(int mSpeed) {
            this.mSpeed = mSpeed;
            return this;
        }

        public int getmPoint() {
            return mPoint;
        }

        public Builder setmPoint(int mPoint) {
            this.mPoint = mPoint;
            return this;
        }

        public Builder startAnim(TextView textV, float num) {
            if(num < 1){
                throw new RuntimeException("请输入大于等于1的数");
            }

            Float[] nums = splitnum(num, (int) ((mSpeed / 1000f) * mSpeed));

            Counter counter = new Counter(textV, nums, mSpeed);

            textV.removeCallbacks(counter);
            textV.post(counter);
            return this;
        }

        Float[] splitnum(float num, int count) {
            Random random = new Random();
            float numtemp = num;
            float sum = 0;
            LinkedList<Float> nums = new LinkedList<>();
            nums.add(0f);
            while (true) {
                float nextFloat = NumberFormatFloat(
                        (random.nextFloat() * num * 2f) / (float) count,
                        mPoint);
                System.out.println("next:" + nextFloat);
                if (numtemp - nextFloat >= 0) {
                    sum = NumberFormatFloat(sum + nextFloat, mPoint);
                    nums.add(sum);
                    numtemp -= nextFloat;
                } else {
                    nums.add(num);
                    return nums.toArray(new Float[0]);
                }
            }
        }

        class Counter implements Runnable {
            private final TextView view;
            private Float[] nums;
            private long pertime;

            private int i = 0;

            Counter(TextView view, Float[] nums, long time) {
                this.view = view;
                this.nums = nums;
                this.pertime = time / nums.length;
            }

            @Override
            public void run() {
                if (i > nums.length - 1) {
                    view.removeCallbacks(Counter.this);
                    return;
                }
                view.setText(NumberFormat(nums[i++], mPoint));
                view.removeCallbacks(Counter.this);
                view.postDelayed(Counter.this, pertime);
            }
        }

        String NumberFormat(float f, int m) {
            return String.format("%." + m + "f", f);
        }

        float NumberFormatFloat(float f, int m) {
            String strfloat = NumberFormat(f, m);
            return Float.parseFloat(strfloat);
        }
    }

}
