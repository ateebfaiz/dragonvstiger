package com.sensorsdata.analytics.android.sdk.core.event.imp;

import android.content.Context;
import com.sensorsdata.analytics.android.sdk.AnalyticsMessages;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.business.instantevent.InstantEventUtils;
import com.sensorsdata.analytics.android.sdk.core.event.EventProcessor;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions;

public class SendDataImpl implements EventProcessor.ISendData {
    private final Context mContext;
    private final InternalConfigOptions mInternalConfigs;

    public SendDataImpl(SAContextManager sAContextManager) {
        this.mInternalConfigs = sAContextManager.getInternalConfigs();
        this.mContext = sAContextManager.getContext();
    }

    public void sendData(InputData inputData, int i10) {
        boolean z10;
        try {
            if (InstantEventUtils.isInstantEvent(inputData)) {
                AnalyticsMessages.getInstance(this.mContext.getApplicationContext()).flushInstanceEvent();
                return;
            }
            AnalyticsMessages instance = AnalyticsMessages.getInstance(this.mContext.getApplicationContext());
            if (i10 >= 0 && i10 <= this.mInternalConfigs.saConfigOptions.getFlushBulkSize() && !this.mInternalConfigs.debugMode.isDebugMode()) {
                if (inputData.getEventType() != EventType.TRACK_SIGNUP) {
                    z10 = false;
                    instance.flushEventMessage(z10);
                }
            }
            z10 = true;
            instance.flushEventMessage(z10);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }
}
