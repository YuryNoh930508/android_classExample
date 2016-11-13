package com.example.yurynoh.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static android.app.ProgressDialog.show;

public class MainActivity extends AppCompatActivity {
    Button      ok;
    Button      no;
    TextView    hello;
    RatingBar   ratings;
    CheckBox    chkBox;
    View        thisLayout;
    DatePicker  datePicker;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));

        ok = (Button)findViewById(R.id.button1);
        no = (Button)findViewById(R.id.button2);
        hello = (TextView)findViewById(R.id.TextView1);
        ratings = (RatingBar)findViewById(R.id.ratingBar);
        chkBox = (CheckBox)findViewById(R.id.CheckBox);
        thisLayout = (View)findViewById(R.id.activity_main);
        datePicker = (DatePicker)findViewById(R.id.datePicker2);

        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Date d1 = new Date(year, monthOfYear, dayOfMonth);
                Date d2 = new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
                long result = (d1.getTime() - d2.getTime())/((24 * 60 * 60 * 1000));
                Toast.makeText(getApplicationContext(), result + " DAYS LEFT \nUNTIL\t" + year + "/" + monthOfYear + "/" + dayOfMonth + "\nFROM\t"
                        + calendar.get(Calendar.YEAR) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.DATE), Toast.LENGTH_SHORT).show();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "ACCEPTED", Toast.LENGTH_SHORT).show();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "DECLINED", Toast.LENGTH_SHORT).show();
            }
        });
        hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "HELLO WORLD", Toast.LENGTH_SHORT).show();
            }
        });
        ratings.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(), ratingBar.getRating() + "점 입니다!", Toast.LENGTH_SHORT).show();
            }
        });
        chkBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String s;
                if(isChecked) {
                    thisLayout.setBackgroundColor(Color.BLACK);
                    s = "OFF";
                } else {
                    thisLayout.setBackgroundColor(Color.WHITE);
                    s = "ON";
                }
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
