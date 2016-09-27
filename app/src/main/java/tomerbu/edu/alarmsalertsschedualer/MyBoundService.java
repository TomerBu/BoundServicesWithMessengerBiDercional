package tomerbu.edu.alarmsalertsschedualer;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

import java.lang.ref.WeakReference;

public class MyBoundService extends Service {

    public static final int SAY_HELLO = 0;

    private void handleMessage(Message msg) {
        if (msg.what == SAY_HELLO) {
            Log.d(Constants.TAG, "Hello");
        }
    }

    Messenger mMessenger = new Messenger(new IncomingHandler(this));

    static class IncomingHandler extends Handler {
        private final WeakReference<MyBoundService> mService;

        IncomingHandler(MyBoundService service) {
            mService = new WeakReference<MyBoundService>(service);
        }

        @Override
        public void handleMessage(Message msg) {
            MyBoundService service = mService.get();
            if (service != null) {
                service.handleMessage(msg);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }
}
