# scrollNum
数字滚动

效果图

![image](./help.gif)

使用

在build.grade中引用
```
implementation 'com.github.nanyuweiyi:scrollNum:1.0.0'
```

具体使用
```
//setmSpeed必须设置在startAnim之前,建议最后调用startAnim()
NumAnim.builder()
       .setmSpeed(500)           //数字越小刷新速度越快
       .setmPoint(1)             //小数点位
       .startAnim(tvShow, 999);  //第一个参数控件，第二个参数目标数字
```    
            
使用过程中有问题随时提出，谢谢。            




