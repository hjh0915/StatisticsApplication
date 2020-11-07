package com.work.statisticsapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button histogram = (Button)findViewById(R.id.btn_histogram);
        histogram.setOnClickListener(this);

        Button bar = (Button)findViewById(R.id.btn_bar);
        bar.setOnClickListener(this);

        Button pie = (Button)findViewById(R.id.btn_pie);
        pie.setOnClickListener(this);

        Button line = (Button)findViewById(R.id.btn_line);
        line.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_histogram:
                Intent intent1 = new Intent(this, HistogramActivity.class);
                startActivity(intent1);
                break;

            case R.id.btn_bar:
                Intent intent2 = new Intent(this, BarChartActivity.class);
                startActivity(intent2);
                break;

            case R.id.btn_pie:
                Intent intent3 = new Intent(this, PieActivity.class);
                startActivity(intent3);
                break;

            case R.id.btn_line:
                Intent intent4 = new Intent(this, LineActivity.class);
                startActivity(intent4);
                break;
            default:
                break;
        }
    }
}
