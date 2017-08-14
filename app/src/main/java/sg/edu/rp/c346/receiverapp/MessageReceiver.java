package sg.edu.rp.c346.receiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by 15031660 on 14/8/2017.
 */

public class MessageReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // SMS messages are retrieved from the intent's extra using the key "pdus"
        Bundle extras = intent.getExtras();
        Object[] smsExtra = (Object[]) extras.get("pdus");
        String address = SmsMessage.createFromPdu((byte[]) smsExtra[0]).getOriginatingAddress();
        String fullMessage = "";
        for (int i = 0; i < smsExtra.length; i++) {
            // Reconstruct the SMS message
            SmsMessage sms = SmsMessage.createFromPdu((byte[]) smsExtra[i]);
            fullMessage += sms.getMessageBody();

        }
        Toast my_toast = Toast.makeText(context, "Message from: " + address + ", content: " + fullMessage, Toast.LENGTH_LONG);
        my_toast.show();
    }
}
