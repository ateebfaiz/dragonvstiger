package com.zing.zalo.zalosdk.core.type;

import com.google.firebase.analytics.FirebaseAnalytics;

public enum EventType {
    OPEN_APP(1),
    DEEP_LINKING(2),
    SHARE(3),
    OPEN_APP_BY_NOTIFICATION(4),
    RECEIVE_NOTIFICATION(5),
    POST_FEED(6),
    SEND_APP_REQUEST(7),
    SEND_MSG(8),
    SEND_OA_MSG(9),
    GET_FRIEND(10),
    GET_INVITABLE_FRIEND(11),
    GET_PROFILE(12),
    AUTHEN(13),
    RECOVERY(14),
    PROTECT_ACC(15),
    START_SCREEN(16),
    CRASH_LOG(17);
    
    int code;

    private EventType(int i10) {
        this.code = i10;
    }

    public int getCode() {
        return this.code;
    }

    public String getEventName() {
        int i10 = this.code;
        if (i10 == 1) {
            return "open_app";
        }
        if (i10 == 2) {
            return "deep_linking";
        }
        if (i10 == 3) {
            return FirebaseAnalytics.Event.SHARE;
        }
        if (i10 == 4) {
            return "open_app_by_notification";
        }
        if (i10 == 5) {
            return "receive_notification";
        }
        if (i10 == 6) {
            return "post_feed";
        }
        if (i10 == 7) {
            return "send_app_request";
        }
        if (i10 == 8) {
            return "send_msg";
        }
        if (i10 == 9) {
            return "send_oa_msg";
        }
        if (i10 == 10) {
            return "get_friend";
        }
        if (i10 == 11) {
            return "get_invitable_friend";
        }
        if (i10 == 12) {
            return "get_profile";
        }
        if (i10 == 13) {
            return "authen";
        }
        if (i10 == 14) {
            return "recovery";
        }
        if (i10 == 15) {
            return "protect_acc";
        }
        if (i10 == 16) {
            return "start_screen";
        }
        return "crash_log";
    }
}
