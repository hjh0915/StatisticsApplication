package com.work.statisticsapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HistogramActivity extends AppCompatActivity {
    private BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_histogram);

        barChart = findViewById(R.id.bar_chart);
        barChart = initBarChart(barChart);
        BarData barData = setBarData();
        barChart.setData(barData);
        barChart.invalidate();
    }

    //设置轴线数据
    public BarData setBarData() {
        List<BarEntry> entries = new ArrayList<>();
        //12个200以内的随机数
        for (int i=0; i<12; i++) {
            entries.add(new BarEntry(i,new Random().nextInt(200)));
        }
        //数据集
        BarDataSet barDataSet = new BarDataSet(entries, "测试数据");
        BarData barData = new BarData(barDataSet);
        return barData;
    }

    //初始化图表
    public BarChart initBarChart(BarChart barChart) {
        barChart.setDescription(null);
        barChart.setDrawBarShadow(false);   //设置柱状图每一条柱子的阴影不显示
        barChart.setDrawValueAboveBar(true);    //显示每一条柱子的数值
        //获取x轴
        XAxis xAxis = barChart.getXAxis();
        //获取柱状图左、右侧的y轴
        YAxis yAxisLeft = barChart.getAxisLeft();
        YAxis yAxisRight = barChart.getAxisRight();
        //设置轴线
        setAxis(xAxis, yAxisLeft, yAxisRight);
        return barChart;
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
        yAxisleft.setEnabled(true); //显示y轴

        //设置y轴宽度（右）同上
        yAxisright.setAxisLineWidth(1);
        yAxisright.setAxisMinimum(0);
        yAxisright.setDrawAxisLine(true);    //y轴显示轴线
        yAxisright.setDrawGridLines(false);   //y轴表格线不显示
        yAxisright.setEnabled(true); //显示y轴
    }
}
