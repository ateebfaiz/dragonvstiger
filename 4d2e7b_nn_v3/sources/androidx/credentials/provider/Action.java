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

public final class Action {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SLICE_HINT_PENDING_INTENT = "androidx.credentials.provider.action.SLICE_HINT_PENDING_INTENT";
    private static final String SLICE_HINT_SUBTITLE = "androidx.credentials.provider.action.HINT_ACTION_SUBTEXT";
    private static final String SLICE_HINT_TITLE = "androidx.credentials.provider.action.HINT_ACTION_TITLE";
    private static final int SLICE_SPEC_REVISION = 0;
    private static final String SLICE_SPEC_TYPE = "Action";
    private static final String TAG = "Action";
    private final PendingIntent pendingIntent;
    private final CharSequence subtitle;
    private final CharSequence title;

    public static final class Builder {
        private final PendingIntent pendingIntent;
        private CharSequence subtitle;
        private final CharSequence title;

        public Builder(CharSequence charSequence, PendingIntent pendingIntent2) {
            m.f(charSequence, "title");
            m.f(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
            this.title = charSequence;
            this.pendingIntent = pendingIntent2;
        }

        public final Action build() {
            return new Action(this.title, this.pendingIntent, this.subtitle);
        }

        public final Builder setSubtitle(CharSequence charSequence) {
            this.subtitle = charSequence;
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        @RequiresApi(28)
        @SuppressLint({"WrongConstant"})
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final Action fromSlice(Slice slice) {
            m.f(slice, "slice");
            List<Object> a10 = slice.getItems();
            m.e(a10, "slice.items");
            CharSequence charSequence = "";
            PendingIntent pendingIntent = null;
            CharSequence charSequence2 = null;
            for (Object a11 : a10) {
                SliceItem a12 = b.a(a11);
                if (a12.hasHint(Action.SLICE_HINT_TITLE)) {
                    charSequence = a12.getText();
                    m.e(charSequence, "it.text");
                } else if (a12.hasHint(Action.SLICE_HINT_SUBTITLE)) {
                    charSequence2 = a12.getText();
                } else if (a12.hasHint(Action.SLICE_HINT_PENDING_INTENT)) {
                    pendingIntent = a12.getAction();
                }
            }
            try {
                m.c(pendingIntent);
                return new Action(charSequence, pendingIntent, charSequence2);
            } catch (Exception e10) {
                Log.i("Action", "fromSlice failed with: " + e10.getMessage());
                return null;
            }
        }

        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final Slice toSlice(Action action) {
            m.f(action, "action");
            CharSequence title = action.getTitle();
            CharSequence subtitle = action.getSubtitle();
            PendingIntent pendingIntent = action.getPendingIntent();
            e.a();
            Uri uri = Uri.EMPTY;
            b.a();
            Slice.Builder a10 = d.a(uri, c.a("Action", 0)).addText(title, (String) null, r.e(Action.SLICE_HINT_TITLE)).addText(subtitle, (String) null, r.e(Action.SLICE_HINT_SUBTITLE));
            Slice.Builder unused = a10.addAction(pendingIntent, androidx.autofill.inline.v1.m.a(a10).addHints(Collections.singletonList(Action.SLICE_HINT_PENDING_INTENT)).build(), (String) null);
            Slice a11 = a10.build();
            m.e(a11, "sliceBuilder.build()");
            return a11;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Action(CharSequence charSequence, PendingIntent pendingIntent2, CharSequence charSequence2) {
        m.f(charSequence, "title");
        m.f(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
        this.title = charSequence;
        this.pendingIntent = pendingIntent2;
        this.subtitle = charSequence2;
        if (charSequence.length() <= 0) {
            throw new IllegalArgumentException("title must not be empty".toString());
        }
    }

    @RequiresApi(28)
    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Action fromSlice(Slice slice) {
        return Companion.fromSlice(slice);
    }

    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Slice toSlice(Action action) {
        return Companion.toSlice(action);
    }

    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public final CharSequence getSubtitle() {
        return this.subtitle;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Action(CharSequence charSequence, PendingIntent pendingIntent2, CharSequence charSequence2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, pendingIntent2, (i10 & 4) != 0 ? null : charSequence2);
    }
}
