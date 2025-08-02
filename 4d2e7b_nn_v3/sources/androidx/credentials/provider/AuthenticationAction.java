package androidx.credentials.provider;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.autofill.inline.common.c;
import androidx.autofill.inline.common.d;
import androidx.autofill.inline.common.e;
import androidx.autofill.inline.v1.b;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Collections;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class AuthenticationAction {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SLICE_HINT_PENDING_INTENT = "androidx.credentials.provider.authenticationAction.SLICE_HINT_PENDING_INTENT";
    private static final String SLICE_HINT_TITLE = "androidx.credentials.provider.authenticationAction.SLICE_HINT_TITLE";
    private static final int SLICE_SPEC_REVISION = 0;
    private static final String SLICE_SPEC_TYPE = "AuthenticationAction";
    private static final String TAG = "AuthenticationAction";
    private final PendingIntent pendingIntent;
    private final CharSequence title;

    public static final class Builder {
        private final PendingIntent pendingIntent;
        private final CharSequence title;

        public Builder(CharSequence charSequence, PendingIntent pendingIntent2) {
            m.f(charSequence, "title");
            m.f(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
            this.title = charSequence;
            this.pendingIntent = pendingIntent2;
        }

        public final AuthenticationAction build() {
            return new AuthenticationAction(this.title, this.pendingIntent);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        @RequiresApi(28)
        @SuppressLint({"WrongConstant"})
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final AuthenticationAction fromSlice(Slice slice) {
            m.f(slice, "slice");
            List<Object> a10 = slice.getItems();
            m.e(a10, "slice.items");
            CharSequence charSequence = null;
            PendingIntent pendingIntent = null;
            for (Object a11 : a10) {
                SliceItem a12 = b.a(a11);
                if (a12.hasHint(AuthenticationAction.SLICE_HINT_PENDING_INTENT)) {
                    pendingIntent = a12.getAction();
                } else if (a12.hasHint(AuthenticationAction.SLICE_HINT_TITLE)) {
                    charSequence = a12.getText();
                }
            }
            try {
                m.c(charSequence);
                m.c(pendingIntent);
                return new AuthenticationAction(charSequence, pendingIntent);
            } catch (Exception e10) {
                Log.i("AuthenticationAction", "fromSlice failed with: " + e10.getMessage());
                return null;
            }
        }

        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final Slice toSlice(AuthenticationAction authenticationAction) {
            m.f(authenticationAction, "authenticationAction");
            CharSequence title = authenticationAction.getTitle();
            PendingIntent pendingIntent = authenticationAction.getPendingIntent();
            e.a();
            Uri uri = Uri.EMPTY;
            b.a();
            Slice.Builder a10 = d.a(uri, c.a("AuthenticationAction", 0));
            Slice.Builder unused = a10.addAction(pendingIntent, androidx.autofill.inline.v1.m.a(a10).addHints(Collections.singletonList(AuthenticationAction.SLICE_HINT_PENDING_INTENT)).build(), (String) null).addText(title, (String) null, r.e(AuthenticationAction.SLICE_HINT_TITLE));
            Slice a11 = a10.build();
            m.e(a11, "sliceBuilder.build()");
            return a11;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AuthenticationAction(CharSequence charSequence, PendingIntent pendingIntent2) {
        m.f(charSequence, "title");
        m.f(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
        this.title = charSequence;
        this.pendingIntent = pendingIntent2;
        if (charSequence.length() <= 0) {
            throw new IllegalArgumentException("title must not be empty".toString());
        }
    }

    @RequiresApi(28)
    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final AuthenticationAction fromSlice(Slice slice) {
        return Companion.fromSlice(slice);
    }

    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Slice toSlice(AuthenticationAction authenticationAction) {
        return Companion.toSlice(authenticationAction);
    }

    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public final CharSequence getTitle() {
        return this.title;
    }
}
