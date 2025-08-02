package androidx.core.view.contentcapture;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewStructureCompat;
import androidx.core.view.autofill.AutofillIdCompat;
import java.util.List;
import java.util.Objects;

public class ContentCaptureSessionCompat {
    private static final String KEY_VIEW_TREE_APPEARED = "TREAT_AS_VIEW_TREE_APPEARED";
    private static final String KEY_VIEW_TREE_APPEARING = "TREAT_AS_VIEW_TREE_APPEARING";
    private final View mView;
    private final Object mWrappedObj;

    private static class a {
        @DoNotInline
        static Bundle a(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }
    }

    private static class b {
        @DoNotInline
        static AutofillId a(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j10) {
            return contentCaptureSession.newAutofillId(autofillId, j10);
        }

        @DoNotInline
        static ViewStructure b(ContentCaptureSession contentCaptureSession, View view) {
            return contentCaptureSession.newViewStructure(view);
        }

        @DoNotInline
        static ViewStructure c(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j10) {
            return contentCaptureSession.newVirtualViewStructure(autofillId, j10);
        }

        @DoNotInline
        static void d(ContentCaptureSession contentCaptureSession, ViewStructure viewStructure) {
            contentCaptureSession.notifyViewAppeared(viewStructure);
        }

        @DoNotInline
        public static void e(ContentCaptureSession contentCaptureSession, AutofillId autofillId, CharSequence charSequence) {
            contentCaptureSession.notifyViewTextChanged(autofillId, charSequence);
        }

        @DoNotInline
        static void f(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long[] jArr) {
            contentCaptureSession.notifyViewsDisappeared(autofillId, jArr);
        }
    }

    private static class c {
        @DoNotInline
        static void a(ContentCaptureSession contentCaptureSession, List<ViewStructure> list) {
            contentCaptureSession.notifyViewsAppeared(list);
        }
    }

    @RequiresApi(29)
    private ContentCaptureSessionCompat(@NonNull ContentCaptureSession contentCaptureSession, @NonNull View view) {
        this.mWrappedObj = contentCaptureSession;
        this.mView = view;
    }

    @RequiresApi(29)
    @NonNull
    public static ContentCaptureSessionCompat toContentCaptureSessionCompat(@NonNull ContentCaptureSession contentCaptureSession, @NonNull View view) {
        return new ContentCaptureSessionCompat(contentCaptureSession, view);
    }

    @Nullable
    public AutofillId newAutofillId(long j10) {
        if (Build.VERSION.SDK_INT < 29) {
            return null;
        }
        ContentCaptureSession a10 = a.a(this.mWrappedObj);
        AutofillIdCompat autofillId = ViewCompat.getAutofillId(this.mView);
        Objects.requireNonNull(autofillId);
        return b.a(a10, autofillId.toAutofillId(), j10);
    }

    @Nullable
    public ViewStructureCompat newVirtualViewStructure(@NonNull AutofillId autofillId, long j10) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ViewStructureCompat.toViewStructureCompat(b.c(a.a(this.mWrappedObj), autofillId, j10));
        }
        return null;
    }

    public void notifyViewTextChanged(@NonNull AutofillId autofillId, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.e(a.a(this.mWrappedObj), autofillId, charSequence);
        }
    }

    public void notifyViewsAppeared(@NonNull List<ViewStructure> list) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 34) {
            c.a(a.a(this.mWrappedObj), list);
        } else if (i10 >= 29) {
            ViewStructure b10 = b.b(a.a(this.mWrappedObj), this.mView);
            a.a(b10).putBoolean(KEY_VIEW_TREE_APPEARING, true);
            b.d(a.a(this.mWrappedObj), b10);
            for (int i11 = 0; i11 < list.size(); i11++) {
                b.d(a.a(this.mWrappedObj), list.get(i11));
            }
            ViewStructure b11 = b.b(a.a(this.mWrappedObj), this.mView);
            a.a(b11).putBoolean(KEY_VIEW_TREE_APPEARED, true);
            b.d(a.a(this.mWrappedObj), b11);
        }
    }

    public void notifyViewsDisappeared(@NonNull long[] jArr) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 34) {
            ContentCaptureSession a10 = a.a(this.mWrappedObj);
            AutofillIdCompat autofillId = ViewCompat.getAutofillId(this.mView);
            Objects.requireNonNull(autofillId);
            b.f(a10, autofillId.toAutofillId(), jArr);
        } else if (i10 >= 29) {
            ViewStructure b10 = b.b(a.a(this.mWrappedObj), this.mView);
            a.a(b10).putBoolean(KEY_VIEW_TREE_APPEARING, true);
            b.d(a.a(this.mWrappedObj), b10);
            ContentCaptureSession a11 = a.a(this.mWrappedObj);
            AutofillIdCompat autofillId2 = ViewCompat.getAutofillId(this.mView);
            Objects.requireNonNull(autofillId2);
            b.f(a11, autofillId2.toAutofillId(), jArr);
            ViewStructure b11 = b.b(a.a(this.mWrappedObj), this.mView);
            a.a(b11).putBoolean(KEY_VIEW_TREE_APPEARED, true);
            b.d(a.a(this.mWrappedObj), b11);
        }
    }

    @RequiresApi(29)
    @NonNull
    public ContentCaptureSession toContentCaptureSession() {
        return a.a(this.mWrappedObj);
    }
}
