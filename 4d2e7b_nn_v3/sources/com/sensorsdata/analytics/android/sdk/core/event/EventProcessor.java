package com.sensorsdata.analytics.android.sdk.core.event;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.event.imp.AssembleDataImpl;
import com.sensorsdata.analytics.android.sdk.core.event.imp.SendDataImpl;
import com.sensorsdata.analytics.android.sdk.core.event.imp.StoreDataImpl;

public abstract class EventProcessor {
    IAssembleData mAssembleData;
    ISendData mSendData;
    IStoreData mStoreData = new StoreDataImpl();

    public interface IAssembleData {
        Event assembleData(InputData inputData);
    }

    public interface ISendData {
        void sendData(InputData inputData, int i10);
    }

    public interface IStoreData {
        int storeData(Event event);
    }

    public EventProcessor(SAContextManager sAContextManager) {
        this.mAssembleData = new AssembleDataImpl(sAContextManager);
        this.mSendData = new SendDataImpl(sAContextManager);
    }

    /* access modifiers changed from: package-private */
    public Event assembleData(InputData inputData) {
        return this.mAssembleData.assembleData(inputData);
    }

    /* access modifiers changed from: protected */
    public synchronized void process(InputData inputData) {
        try {
            sendData(inputData, storeData(assembleData(inputData)));
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        return;
    }

    /* access modifiers changed from: package-private */
    public void sendData(InputData inputData, int i10) {
        this.mSendData.sendData(inputData, i10);
    }

    /* access modifiers changed from: package-private */
    public int storeData(Event event) {
        return this.mStoreData.storeData(event);
    }

    public abstract void trackEvent(InputData inputData);
}
