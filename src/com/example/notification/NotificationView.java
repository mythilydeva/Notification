package com.example.notification;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationView extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity);
		CharSequence s = "Inside the activity of Notification one ";
		int id = 0;
		Bundle extras = getIntent().getExtras();
		if (extras == null) {
			s = "error";
		}
		else {
			id = extras.getInt("notificationId");
		}
		TextView t = (TextView) findViewById(R.id.text1);
		s = s + "with id = " + id;
		t.setText(s);
		NotificationManager myNotificationManager =
		(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		myNotificationManager.cancel(id);

	}

}
