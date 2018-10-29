package com.theannguyen.datetimepicker;

import android.app.Activity;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView tvDatePicker, tvTimePicker;
    private DatePicker dpDatePicker;
    private TimePicker tpTimePicker;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findID();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        dpDatePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(MainActivity.this,dayOfMonth + " - " + monthOfYear + " - " + year,Toast.LENGTH_SHORT).show();
            }
        });

        tpTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this,hourOfDay + " : " + minute,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void findID() {
        tvDatePicker = (TextView) findViewById(R.id.tvDatePicker);
        tvTimePicker = (TextView) findViewById(R.id.tvTimepicker);
        dpDatePicker = (DatePicker) findViewById(R.id.dpDatePicker);
        tpTimePicker = (TimePicker) findViewById(R.id.tpTimePicker);
    }
}
