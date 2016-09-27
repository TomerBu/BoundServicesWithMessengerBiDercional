package tomerbu.edu.alarmsalertsschedualer;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Created by tomerbuzaglo on 27/09/2016.
 * Copyright 2016 tomerbuzaglo. All Rights Reserved
 * <p/>
 * Licensed under the Apache License, Version 2.0
 * you may not use this file except
 * in compliance with the License
 */
public class ServiceUtils {
    private static ServiceUtils mInstance;
    private Context context;

    public ServiceUtils(Context context) {
        this.context = context;
    }

    public static ServiceUtils with(Context context) {
        if (mInstance == null) {
            mInstance = new ServiceUtils(context);
        }
        return mInstance;
    }

    public boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
         return false;
    }

    /***
     *
     * @param name full name including package
     * @return is the service running?
     */
    public boolean isMyServiceRunning(String name) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (name.equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
