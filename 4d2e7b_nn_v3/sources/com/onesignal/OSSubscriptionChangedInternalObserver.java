package com.onesignal;

class OSSubscriptionChangedInternalObserver {
    OSSubscriptionChangedInternalObserver() {
    }

    static void a(OSSubscriptionState oSSubscriptionState) {
        if (o3.u0().c(new a3(o3.Z, (OSSubscriptionState) oSSubscriptionState.clone()))) {
            OSSubscriptionState oSSubscriptionState2 = (OSSubscriptionState) oSSubscriptionState.clone();
            o3.Z = oSSubscriptionState2;
            oSSubscriptionState2.d();
        }
    }

    public void changed(OSSubscriptionState oSSubscriptionState) {
        a(oSSubscriptionState);
    }
}
