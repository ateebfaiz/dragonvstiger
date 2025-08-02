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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class RemoteEntry {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int REVISION_ID = 1;
    private static final String SLICE_HINT_PENDING_INTENT = "androidx.credentials.provider.remoteEntry.SLICE_HINT_PENDING_INTENT";
    private static final String SLICE_SPEC_TYPE = "RemoteEntry";
    private static final String TAG = "RemoteEntry";
    private final PendingIntent pendingIntent;

    public static final class Builder {
        private final PendingIntent pendingIntent;

        public Builder(PendingIntent pendingIntent2) {
            m.f(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
            this.pendingIntent = pendingIntent2;
        }

        public final RemoteEntry build() {
            return new RemoteEntry(this.pendingIntent);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        @RequiresApi(28)
        @SuppressLint({"WrongConstant"})
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final RemoteEntry fromSlice(Slice slice) {
            m.f(slice, "slice");
            List<Object> a10 = slice.getItems();
            m.e(a10, "slice.items");
            PendingIntent pendingIntent = null;
            for (Object a11 : a10) {
                SliceItem a12 = b.a(a11);
                if (a12.hasHint(RemoteEntry.SLICE_HINT_PENDING_INTENT)) {
                    pendingIntent = a12.getAction();
                }
            }
            try {
                m.c(pendingIntent);
                return new RemoteEntry(pendingIntent);
            } catch (Exception e10) {
                Log.i("RemoteEntry", "fromSlice failed with: " + e10.getMessage());
                return null;
            }
        }

        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final Slice toSlice(RemoteEntry remoteEntry) {
            m.f(remoteEntry, "remoteEntry");
            PendingIntent pendingIntent = remoteEntry.getPendingIntent();
            e.a();
            Slice.Builder a10 = d.a(Uri.EMPTY, c.a("RemoteEntry", 1));
            Slice.Builder unused = a10.addAction(pendingIntent, androidx.autofill.inline.v1.m.a(a10).addHints(Collections.singletonList(RemoteEntry.SLICE_HINT_PENDING_INTENT)).build(), (String) null);
            Slice a11 = a10.build();
            m.e(a11, "sliceBuilder.build()");
            return a11;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RemoteEntry(PendingIntent pendingIntent2) {
        m.f(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
        this.pendingIntent = pendingIntent2;
    }

    @RequiresApi(28)
    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final RemoteEntry fromSlice(Slice slice) {
        return Companion.fromSlice(slice);
    }

    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Slice toSlice(RemoteEntry remoteEntry) {
        return Companion.toSlice(remoteEntry);
    }

    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }
}
