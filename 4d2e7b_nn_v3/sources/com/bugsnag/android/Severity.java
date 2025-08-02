package com.bugsnag.android;

import com.bugsnag.android.k2;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public enum Severity implements k2.a {
    ERROR(Constants.IPC_BUNDLE_KEY_SEND_ERROR),
    WARNING("warning"),
    INFO("info");
    
    public static final a Companion = null;
    /* access modifiers changed from: private */
    public final String str;

    public static final class a {
        private a() {
        }

        public final Severity a(String str) {
            Severity[] values = Severity.values();
            int length = values.length;
            int i10 = 0;
            while (i10 < length) {
                Severity severity = values[i10];
                i10++;
                if (m.b(severity.str, str)) {
                    return severity;
                }
            }
            return null;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Companion = new a((DefaultConstructorMarker) null);
    }

    private Severity(String str2) {
        this.str = str2;
    }

    public void toStream(k2 k2Var) throws IOException {
        k2Var.K(this.str);
    }
}
