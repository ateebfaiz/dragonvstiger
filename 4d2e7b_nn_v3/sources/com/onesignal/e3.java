package com.onesignal;

import java.util.Arrays;
import java.util.HashSet;

class e3 extends d3 {

    /* renamed from: f  reason: collision with root package name */
    static final HashSet f10618f = new HashSet(Arrays.asList(new String[]{"getTags()", "setSMSNumber()", "setEmail()", "logoutSMSNumber()", "logoutEmail()", "syncHashedEmail()", "setExternalUserId()", "setLanguage()", "setSubscription()", "promptLocation()", "idsAvailable()", "sendTag()", "sendTags()", "setLocationShared()", "setDisableGMSMissingPrompt()", "setRequiresUserPrivacyConsent()", "unsubscribeWhenNotificationsAreDisabled()", "handleNotificationOpen()", "onAppLostFocus()", "sendOutcome()", "sendUniqueOutcome()", "sendOutcomeWithValue()", "removeGroupedNotifications()", "removeNotification()", "clearOneSignalNotifications()"}));

    /* renamed from: e  reason: collision with root package name */
    private final u2 f10619e;

    e3(u2 u2Var, c2 c2Var) {
        super(c2Var);
        this.f10619e = u2Var;
    }

    /* access modifiers changed from: package-private */
    public boolean g(String str) {
        if (this.f10619e.k() || !f10618f.contains(str)) {
            return false;
        }
        return true;
    }
}
