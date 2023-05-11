package sg.edu.rp.c346.id22024905.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;

    Button btnReset;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnReset = findViewById(R.id.buttonReset);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = tp.getHour();
                int min = tp.getMinute();
                String formattedTime = String.format("%02d:%02d", hour, min);
                tvDisplay.setText("Time is " + formattedTime);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = new String();
                String b = new String();

               int dom = dp.getDayOfMonth();
               int month = dp.getMonth();
               int year = dp.getYear();
               Calendar calendar = Calendar.getInstance();
               calendar.set(year, month, dom);
               SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
               String date = dateFormat.format(calendar.getTime());
               tvDisplay.setText("Date is " + date);

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.setHour(0);
                tp.setMinute(0);
                dp.updateDate(2020, 01, 01);
            }
        });

    }

}