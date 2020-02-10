package com.example.inclass04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="demo";

    private ProgressBar progressBar;

    private SeekBar seekBar;
    private TextView tv_min;
    private TextView tv_complexity;
    private TextView tv_max;
    private TextView tv_avg;
    private Button calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar=findViewById(R.id.seekBar);
        tv_min=findViewById(R.id.tv_min);
        tv_avg=findViewById(R.id.tv_avg);
        tv_max=findViewById(R.id.tv_max);
        tv_complexity=findViewById(R.id.tv_complexity);
        calc=findViewById(R.id.calc);

        progressBar=findViewById(R.id.progressBar);

        progressBar.setVisibility(ProgressBar.INVISIBLE);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_complexity.setText(progress+" "+"Times");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int complexity = seekBar.getProgress();
                if(complexity != 0){
                    new GetNumbers().execute(complexity);
                }

            }
        });

    }

    class GetNumbers extends AsyncTask<Integer, Void, ArrayList<Double>>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected ArrayList<Double> doInBackground(Integer... integers) {
            return HeavyWork.getArrayNumbers(integers[0]);
        }

        @Override
        protected void onPostExecute(ArrayList<Double> doubles) {
            super.onPostExecute(doubles);
            Log.d(TAG,"On post execute:"+doubles.toString());
            progressBar.setVisibility(ProgressBar.INVISIBLE);

            double min=findMin(doubles);
            double max=findMax(doubles);
            double avg=findAvg(doubles);

            tv_min.setText(min+"");
            tv_max.setText(max+"");
            tv_avg.setText(avg+"");
            }
        }

    private double findMax(ArrayList<Double> doubles) {
        double max=Double.MIN_VALUE;

        for (double d: doubles) {
            if(d>max){
                max=d;
            }
        }
        return max;
    }

    private double findAvg(ArrayList <Double> doubles) {
        double sum = 0;
        if(!doubles.isEmpty()) {
            for (double d : doubles) {
                sum += d;
            }
            return sum / doubles.size();
        }
        return sum;
    }
    //private double findAvg(ArrayList<Double> doubles) {

    //}

    private double findMin(ArrayList<Double> doubles) {
        double min=Double.MAX_VALUE;

        for (double d: doubles) {
            if(d<min){
                min=d;
            }
        }
        return min;
    }
}

