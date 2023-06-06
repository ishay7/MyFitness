package com.example.myfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class proteinAlarm extends AppCompatActivity implements View.OnClickListener {

    EditText etWeight;
    Button btnSave;
    TextView tvOutcome;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protein_alarm);


        tvOutcome = (TextView)findViewById(R.id.tvAlarmMention);
        etWeight = (EditText)findViewById(R.id.etProteinWeight);

    }

    @Override
    public void onClick(View v) {
        if(v == btnSave) {
            Toast.makeText(this, "Reminder set!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(proteinAlarm.this, ProteinReminder.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(proteinAlarm.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            long timeAtButtonClick = System.currentTimeMillis();
            long tenSeccondsMillis = 1000* 10;
            alarmManager.set(AlarmManager.RTC_WAKEUP, timeAtButtonClick + tenSeccondsMillis, pendingIntent);

            String outcome = String.valueOf(etWeight);
            int gramProtein = Integer.valueOf(outcome);
            tvOutcome.setText("You need to eat " + gramProtein + "gram of protein every day");


        }
    }

    public void createNotificationChannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            CharSequence name = "LemubitReminderChannel";
            String description = "Channel for Lemubit Reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyLemubit", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


}




