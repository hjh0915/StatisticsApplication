package com.work.statisticsapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class LineActivity extends AppCompatActivity {
    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);

        lineChart = findViewById(R.id.line_chart);
        initLineChart();
    }

    //初始化图表
    public void initLineChart() {
        //动画显示
        lineChart.animateXY(2000, 2000);
        //自定义
        Description description = new Description();
        description.setText("");
        lineChart.setDescription(description);
        //设置图例
        Legend legend = lineChart.getLegend();
        legend.setTextColor(Color.BLACK);

        //设置XY轴，数据
        setXAxis();
        setYAxis();
        setData();
    }

    //绘制X轴
    public void setXAxis() {
        XAxis xAxis = lineChart.getXAxis();
        //不绘制X轴、网格线
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);
        xAxis.setTextColor(Color.GREEN); // 文本颜色
        xAxis.setTextSize(15f); // 文本大小为18dp
        // 使图表左右留出点空位
        xAxis.setAxisMinimum(-0.1f); // 设置X轴最小值
        //设置颜色(白色)隐去x轴上的数据
        xAxis.setTextColor(Color.WHITE);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
    }

    //绘制Y轴
    public void setYAxis() {
        //Y轴左侧
        YAxis yAxisLeft = lineChart.getAxisLeft();
        //不绘制Y轴、网格线
        yAxisLeft.setDrawAxisLine(false);
        yAxisLeft.setDrawGridLines(false);
        yAxisLeft.setDrawLabels(false); // 不绘制标签(坐标轴数值)
        yAxisLeft.setTextColor(Color.BLACK); //设置颜色
        // 右侧Y轴
        lineChart.getAxisRight().setEnabled(false); // 不启用
    }

    //添加数据
    public  void setData() {
        //折线1
        List<Entry> y1 = new ArrayList<>();
        float[] ys1 = new float[]{80f, 90f, 80f, 90f, 80f, 80f,100f};
        //折线2
        List<Entry> y2 = new ArrayList<>();
        float[] ys2 = new float[]{60f, 75f, 60f, 77f, 55f, 65f,75f};

        for (int i=0; i<ys1.length; i++) {
            y1.add(new Entry(i, ys1[i]));
            y2.add(new Entry(i, ys2[i]));
        }

        LineDataSet lineDataSet1 = new LineDataSet(y1, "当日温度");
        LineDataSet lineDataSet2 = new LineDataSet(y2, "明日温度");

        //设置线的颜色
        lineDataSet1.setColor(Color.RED); // 设置为红色
        lineDataSet2.setColor(Color.GREEN); // 设置为绿色
        //设置节点的颜色
        lineDataSet1.setCircleColor(Color.RED);
        lineDataSet2.setCircleColor(Color.GREEN);
        //设置节点的半径
        lineDataSet1.setCircleRadius(5);
        lineDataSet2.setCircleRadius(5);
        //不绘制空心
        lineDataSet1.setDrawCircleHole(false);
        lineDataSet2.setDrawCircleHole(false);
        //数值字体大小为12dp
        lineDataSet1.setValueTextSize(12f);
        lineDataSet2.setValueTextSize(12f);

        //将每一组折线数据集添加到折线数据中
        LineData lineData = new LineData(lineDataSet1,lineDataSet2);
        //设置颜色
        lineData.setValueTextColor(Color.BLACK);
        //将折线数据设置给图表
        lineChart.setData(lineData);
    }
}
