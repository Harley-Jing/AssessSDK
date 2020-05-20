package com.umisdk.sdkdemo;

import com.umisdk.assesslib.ChannelAppliaction;
import com.umisdk.assesslib.SdkSettting;

public class GameApplication extends ChannelAppliaction {
    @Override
    public void onCreate() {
        super.onCreate();

        SdkSettting.isDebug = true;
    }
}
