package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class InputContentInfoCompat {
    private final c mImpl;

    private static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f15263a;

        /* renamed from: b  reason: collision with root package name */
        private final ClipDescription f15264b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f15265c;

        b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f15263a = uri;
            this.f15264b = clipDescription;
            this.f15265c = uri2;
        }

        public Uri a() {
            return this.f15265c;
        }

        public Uri b() {
            return this.f15263a;
        }

        public void c() {
        }

        public Object d() {
            return null;
        }

        public void e() {
        }

        public ClipDescription getDescription() {
            return this.f15264b;
        }
    }

    private interface c {
        Uri a();

        Uri b();

        void c();

        Object d();

        void e();

        ClipDescription getDescription();
    }

    public InputContentInfoCompat(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.mImpl = new a(uri, clipDescription, uri2);
        } else {
            this.mImpl = new b(uri, clipDescription, uri2);
        }
    }

    @Nullable
    public static InputContentInfoCompat wrap(@Nullable Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new InputContentInfoCompat(new a(obj));
        }
        return null;
    }

    @NonNull
    public Uri getContentUri() {
        return this.mImpl.b();
    }

    @NonNull
    public ClipDescription getDescription() {
        return this.mImpl.getDescription();
    }

    @Nullable
    public Uri getLinkUri() {
        return this.mImpl.a();
    }

    public void releasePermission() {
        this.mImpl.e();
    }

    public void requestPermission() {
        this.mImpl.c();
    }

    @Nullable
    public Object unwrap() {
        return this.mImpl.d();
    }

    private static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        final InputContentInfo f15262a;

        a(Object obj) {
            this.f15262a = (InputContentInfo) obj;
        }

        public Uri a() {
            return this.f15262a.getLinkUri();
        }

        public Uri b() {
            return this.f15262a.getContentUri();
        }

        public void c() {
            this.f15262a.requestPermission();
        }

        public Object d() {
            return this.f15262a;
        }

        public void e() {
            this.f15262a.releasePermission();
        }

        public ClipDescription getDescription() {
            return this.f15262a.getDescription();
        }

        a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f15262a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    private InputContentInfoCompat(@NonNull c cVar) {
        this.mImpl = cVar;
    }
}
