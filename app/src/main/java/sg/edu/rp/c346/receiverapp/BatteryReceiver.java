package sg.edu.rp.c346.receiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

/**
 * Created by 15031660 on 14/8/2017.
 */

public class BatteryReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast my_toast = Toast.makeText(context, "Low Battery" , Toast.LENGTH_LONG);
        my_toast.show();

        //Point B – Send SMS
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("5554", null, "Your Battery is low", null, null);

    }
}
