package com.sensorsdata.analytics.android.sdk.core.event;

import com.sensorsdata.analytics.android.sdk.core.SAContextManager;

public class TrackEventProcessor extends EventProcessor {
    public TrackEventProcessor(SAContextManager sAContextManager) {
        super(sAContextManager);
    }

    public void trackEvent(InputData inputData) {
        process(inputData);
    }
}
