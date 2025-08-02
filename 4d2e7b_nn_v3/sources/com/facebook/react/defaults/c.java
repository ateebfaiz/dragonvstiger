package com.facebook.react.defaults;

import com.facebook.soloader.SoLoader;
import kotlin.jvm.internal.DefaultConstructorMarker;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f2950a = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public final synchronized void a() {
            SoLoader.t("react_newarchdefaults");
            try {
                SoLoader.t("appmodules");
            } catch (UnsatisfiedLinkError unused) {
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
