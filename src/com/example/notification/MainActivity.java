package com.example.notification;

import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	Button b1;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1 = (Button) findViewById(R.id.b1);

		b1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				PendingIntent pIntent = PendingIntent.getActivity(
						MainActivity.this, 0, intent, 0);

				Notification notify = new Notification.Builder(
						MainActivity.this).setTicker("TicketerTitle")
						.setContentTitle("Content Title")
						.setContentText(" hello Everyone it's notification prgrm??")
						.setSmallIcon(R.drawable.ic_launcher)
						.addAction(R.drawable.ic_launcher, "Action 1", pIntent)
						.setContentIntent(pIntent).getNotification();

				notify.flags = Notification.FLAG_AUTO_CANCEL;
				NotificationManager notif = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				notif.notify(0, notify);
			}
		});
	}
}