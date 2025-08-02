package com.sensorsdata.analytics.android.sdk.core.event.imp;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.event.Event;
import com.sensorsdata.analytics.android.sdk.core.event.EventProcessor;
import com.sensorsdata.analytics.android.sdk.core.event.InputData;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;

public class AssembleDataImpl implements EventProcessor.IAssembleData {
    private final H5TrackAssemble mH5EventAssemble;
    private final ItemEventAssemble mItemEventAssemble;
    private final TrackEventAssemble mTrackEventAssemble;

    public AssembleDataImpl(SAContextManager sAContextManager) {
        this.mTrackEventAssemble = new TrackEventAssemble(sAContextManager);
        this.mItemEventAssemble = new ItemEventAssemble(sAContextManager);
        this.mH5EventAssemble = new H5TrackAssemble(sAContextManager);
    }

    public Event assembleData(InputData inputData) {
        if (!TextUtils.isEmpty(inputData.getExtras())) {
            return this.mH5EventAssemble.assembleData(inputData);
        }
        if (inputData.getEventType() == EventType.ITEM_DELETE || inputData.getEventType() == EventType.ITEM_SET) {
            return this.mItemEventAssemble.assembleData(inputData);
        }
        return this.mTrackEventAssemble.assembleData(inputData);
    }
}
