package com.bugsnag.android;

import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public enum BreadcrumbType {
    ERROR(Constants.IPC_BUNDLE_KEY_SEND_ERROR),
    LOG("log"),
    MANUAL("manual"),
    NAVIGATION(NotificationCompat.CATEGORY_NAVIGATION),
    PROCESS("process"),
    REQUEST("request"),
    STATE("state"),
    USER("user");
    
    public static final a Companion = null;
    /* access modifiers changed from: private */
    public final String type;

    public static final class a {
        private a() {
        }

        public final BreadcrumbType a(String str) {
            BreadcrumbType[] values = BreadcrumbType.values();
            int length = values.length;
            int i10 = 0;
            BreadcrumbType breadcrumbType = null;
            boolean z10 = false;
            while (i10 < length) {
                BreadcrumbType breadcrumbType2 = values[i10];
                i10++;
                if (m.b(breadcrumbType2.type, str)) {
                    if (z10) {
                        return null;
                    }
                    z10 = true;
                    breadcrumbType = breadcrumbType2;
                }
            }
            if (!z10) {
                return null;
            }
            return breadcrumbType;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Companion = new a((DefaultConstructorMarker) null);
    }

    private BreadcrumbType(String str) {
        this.type = str;
    }

    public String toString() {
        return this.type;
    }
}
