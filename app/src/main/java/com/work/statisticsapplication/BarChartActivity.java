package com.work.statisticsapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BarChartActivity extends AppCompatActivity {
    private HorizontalBarChart horizontalBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        //初始化水平柱状图
        HorizontalBarChart horizontalBarChart = findViewById(R.id.horizontal_bar_chart);
        initBarChart(horizontalBarChart);
        horizontalBarChart.setData(setBarData());
        horizontalBarChart.invalidate();
    }

    public BarChart initBarChart(BarChart barChart) {
        barChart.setDrawBarShadow(false); // 设置每条柱子的阴影不显示
        barChart.setDrawValueAboveBar(true); // 设置每条柱子的数值显示
        barChart.setPinchZoom(false);
        XAxis xAxis = barChart.getXAxis(); // 获取柱状图的x轴
        YAxis yAxisLeft = barChart.getAxisLeft(); // 获取柱状图左侧的y轴
        YAxis yAxisRight = barChart.getAxisRight(); // 获取柱状图右侧的y轴
        setAxis(xAxis, yAxisLeft, yAxisRight); //调用方法设置柱状图的轴线
        return barChart;
    }

    public BarData setBarData() {
        List<BarEntry> entries = new ArrayList<>(); //定义一个数据容器
        //生成随机数数据
        for (int i = 0; i <= 12; i++) {
            entries.add(new BarEntry(i, new Random().nextInt(300)));
        }
        BarDataSet barDataSet = new BarDataSet(entries, "测试数据");
        BarData barData = new BarData(barDataSet);
        return barData; //返回可用于柱状图的数据
    }

    //设置柱状图的x、y轴
    public void setAxis (XAxis xAxis, YAxis yAxisleft, YAxis yAxisright) {
        //设置x轴在图底部显示
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisLineWidth(1);  //x轴宽度
        xAxis.setAxisMinimum(0); //x轴从0刻度开始(最小)
        xAxis.setDrawAxisLine(true);    //x轴显示轴线
        xAxis.setDrawGridLines(true);   //x轴表格线不显示
        xAxis.setEnabled(true); //显示x轴

        //设置y轴宽度（左）同上
        yAxisleft.setAxisLineWidth(1);
        yAxisleft.setAxisMinimum(0);
        yAxisleft.setDrawAxisLine(true);    //y轴显示轴线
        yAxisleft.setDrawGridLines(false);   //y轴表格线不显示
        yAxisleft.setEnabled(false); //显示y轴

        //设置y轴宽度（右）同上
        yAxisright.setAxisLineWidth(1);
        yAxisright.setAxisMinimum(0);
        yAxisright.setDrawAxisLine(true);    //y轴显示轴线
        yAxisright.setDrawGridLines(false);   //y轴表格线不显示
        yAxisright.setEnabled(true); //显示y轴
    }
}
