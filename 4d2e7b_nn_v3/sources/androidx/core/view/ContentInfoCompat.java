package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public final class ContentInfoCompat {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_AUTOFILL = 4;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;
    public static final int SOURCE_PROCESS_TEXT = 5;
    @NonNull
    private final f mCompat;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    private static final class a {
        @DoNotInline
        @NonNull
        public static Pair<ContentInfo, ContentInfo> a(@NonNull ContentInfo contentInfo, @NonNull Predicate<ClipData.Item> predicate) {
            ContentInfo contentInfo2;
            ClipData clip = contentInfo.getClip();
            if (clip.getItemCount() == 1) {
                boolean test = predicate.test(clip.getItemAt(0));
                if (test) {
                    contentInfo2 = contentInfo;
                } else {
                    contentInfo2 = null;
                }
                if (test) {
                    contentInfo = null;
                }
                return Pair.create(contentInfo2, contentInfo);
            }
            Objects.requireNonNull(predicate);
            Pair<ClipData, ClipData> partition = ContentInfoCompat.partition(clip, (androidx.core.util.Predicate<ClipData.Item>) new b(predicate));
            if (partition.first == null) {
                return Pair.create((Object) null, contentInfo);
            }
            if (partition.second == null) {
                return Pair.create(contentInfo, (Object) null);
            }
            return Pair.create(new ContentInfo.Builder(contentInfo).setClip((ClipData) partition.first).build(), new ContentInfo.Builder(contentInfo).setClip((ClipData) partition.second).build());
        }
    }

    private interface c {
        void a(int i10);

        void b(Uri uri);

        ContentInfoCompat build();

        void c(int i10);

        void d(ClipData clipData);

        void setExtras(Bundle bundle);
    }

    private static final class e implements f {

        /* renamed from: a  reason: collision with root package name */
        private final ContentInfo f15149a;

        e(ContentInfo contentInfo) {
            this.f15149a = a.a(Preconditions.checkNotNull(contentInfo));
        }

        public Uri a() {
            return this.f15149a.getLinkUri();
        }

        public ClipData b() {
            return this.f15149a.getClip();
        }

        public ContentInfo c() {
            return this.f15149a;
        }

        public int d() {
            return this.f15149a.getSource();
        }

        public Bundle getExtras() {
            return this.f15149a.getExtras();
        }

        public int getFlags() {
            return this.f15149a.getFlags();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f15149a + "}";
        }
    }

    private interface f {
        Uri a();

        ClipData b();

        ContentInfo c();

        int d();

        Bundle getExtras();

        int getFlags();
    }

    private static final class g implements f {

        /* renamed from: a  reason: collision with root package name */
        private final ClipData f15150a;

        /* renamed from: b  reason: collision with root package name */
        private final int f15151b;

        /* renamed from: c  reason: collision with root package name */
        private final int f15152c;

        /* renamed from: d  reason: collision with root package name */
        private final Uri f15153d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f15154e;

        g(d dVar) {
            this.f15150a = (ClipData) Preconditions.checkNotNull(dVar.f15144a);
            this.f15151b = Preconditions.checkArgumentInRange(dVar.f15145b, 0, 5, "source");
            this.f15152c = Preconditions.checkFlagsArgument(dVar.f15146c, 1);
            this.f15153d = dVar.f15147d;
            this.f15154e = dVar.f15148e;
        }

        public Uri a() {
            return this.f15153d;
        }

        public ClipData b() {
            return this.f15150a;
        }

        public ContentInfo c() {
            return null;
        }

        public int d() {
            return this.f15151b;
        }

        public Bundle getExtras() {
            return this.f15154e;
        }

        public int getFlags() {
            return this.f15152c;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ContentInfoCompat{clip=");
            sb2.append(this.f15150a.getDescription());
            sb2.append(", source=");
            sb2.append(ContentInfoCompat.sourceToString(this.f15151b));
            sb2.append(", flags=");
            sb2.append(ContentInfoCompat.flagsToString(this.f15152c));
            String str2 = "";
            if (this.f15153d == null) {
                str = str2;
            } else {
                str = ", hasLinkUri(" + this.f15153d.toString().length() + ")";
            }
            sb2.append(str);
            if (this.f15154e != null) {
                str2 = ", hasExtras";
            }
            sb2.append(str2);
            sb2.append("}");
            return sb2.toString();
        }
    }

    ContentInfoCompat(@NonNull f fVar) {
        this.mCompat = fVar;
    }

    @NonNull
    static ClipData buildClipData(@NonNull ClipDescription clipDescription, @NonNull List<ClipData.Item> list) {
        ClipData clipData = new ClipData(new ClipDescription(clipDescription), list.get(0));
        for (int i10 = 1; i10 < list.size(); i10++) {
            clipData.addItem(list.get(i10));
        }
        return clipData;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static String flagsToString(int i10) {
        if ((i10 & 1) != 0) {
            return "FLAG_CONVERT_TO_PLAIN_TEXT";
        }
        return String.valueOf(i10);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static String sourceToString(int i10) {
        if (i10 == 0) {
            return "SOURCE_APP";
        }
        if (i10 == 1) {
            return "SOURCE_CLIPBOARD";
        }
        if (i10 == 2) {
            return "SOURCE_INPUT_METHOD";
        }
        if (i10 == 3) {
            return "SOURCE_DRAG_AND_DROP";
        }
        if (i10 == 4) {
            return "SOURCE_AUTOFILL";
        }
        if (i10 != 5) {
            return String.valueOf(i10);
        }
        return "SOURCE_PROCESS_TEXT";
    }

    @RequiresApi(31)
    @NonNull
    public static ContentInfoCompat toContentInfoCompat(@NonNull ContentInfo contentInfo) {
        return new ContentInfoCompat(new e(contentInfo));
    }

    @NonNull
    public ClipData getClip() {
        return this.mCompat.b();
    }

    @Nullable
    public Bundle getExtras() {
        return this.mCompat.getExtras();
    }

    public int getFlags() {
        return this.mCompat.getFlags();
    }

    @Nullable
    public Uri getLinkUri() {
        return this.mCompat.a();
    }

    public int getSource() {
        return this.mCompat.d();
    }

    @NonNull
    public Pair<ContentInfoCompat, ContentInfoCompat> partition(@NonNull androidx.core.util.Predicate<ClipData.Item> predicate) {
        ClipData b10 = this.mCompat.b();
        ContentInfoCompat contentInfoCompat = null;
        if (b10.getItemCount() == 1) {
            boolean test = predicate.test(b10.getItemAt(0));
            ContentInfoCompat contentInfoCompat2 = test ? this : null;
            if (!test) {
                contentInfoCompat = this;
            }
            return Pair.create(contentInfoCompat2, contentInfoCompat);
        }
        Pair<ClipData, ClipData> partition = partition(b10, predicate);
        if (partition.first == null) {
            return Pair.create((Object) null, this);
        }
        if (partition.second == null) {
            return Pair.create(this, (Object) null);
        }
        return Pair.create(new Builder(this).setClip((ClipData) partition.first).build(), new Builder(this).setClip((ClipData) partition.second).build());
    }

    @RequiresApi(31)
    @NonNull
    public ContentInfo toContentInfo() {
        ContentInfo c10 = this.mCompat.c();
        Objects.requireNonNull(c10);
        return a.a(c10);
    }

    @NonNull
    public String toString() {
        return this.mCompat.toString();
    }

    private static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ContentInfo.Builder f15143a;

        b(ClipData clipData, int i10) {
            this.f15143a = i.a(clipData, i10);
        }

        public void a(int i10) {
            ContentInfo.Builder unused = this.f15143a.setSource(i10);
        }

        public void b(Uri uri) {
            ContentInfo.Builder unused = this.f15143a.setLinkUri(uri);
        }

        public ContentInfoCompat build() {
            return new ContentInfoCompat(new e(this.f15143a.build()));
        }

        public void c(int i10) {
            ContentInfo.Builder unused = this.f15143a.setFlags(i10);
        }

        public void d(ClipData clipData) {
            ContentInfo.Builder unused = this.f15143a.setClip(clipData);
        }

        public void setExtras(Bundle bundle) {
            ContentInfo.Builder unused = this.f15143a.setExtras(bundle);
        }

        b(ContentInfoCompat contentInfoCompat) {
            k.a();
            this.f15143a = j.a(contentInfoCompat.toContentInfo());
        }
    }

    private static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        ClipData f15144a;

        /* renamed from: b  reason: collision with root package name */
        int f15145b;

        /* renamed from: c  reason: collision with root package name */
        int f15146c;

        /* renamed from: d  reason: collision with root package name */
        Uri f15147d;

        /* renamed from: e  reason: collision with root package name */
        Bundle f15148e;

        d(ClipData clipData, int i10) {
            this.f15144a = clipData;
            this.f15145b = i10;
        }

        public void a(int i10) {
            this.f15145b = i10;
        }

        public void b(Uri uri) {
            this.f15147d = uri;
        }

        public ContentInfoCompat build() {
            return new ContentInfoCompat(new g(this));
        }

        public void c(int i10) {
            this.f15146c = i10;
        }

        public void d(ClipData clipData) {
            this.f15144a = clipData;
        }

        public void setExtras(Bundle bundle) {
            this.f15148e = bundle;
        }

        d(ContentInfoCompat contentInfoCompat) {
            this.f15144a = contentInfoCompat.getClip();
            this.f15145b = contentInfoCompat.getSource();
            this.f15146c = contentInfoCompat.getFlags();
            this.f15147d = contentInfoCompat.getLinkUri();
            this.f15148e = contentInfoCompat.getExtras();
        }
    }

    public static final class Builder {
        @NonNull
        private final c mBuilderCompat;

        public Builder(@NonNull ContentInfoCompat contentInfoCompat) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.mBuilderCompat = new b(contentInfoCompat);
            } else {
                this.mBuilderCompat = new d(contentInfoCompat);
            }
        }

        @NonNull
        public ContentInfoCompat build() {
            return this.mBuilderCompat.build();
        }

        @NonNull
        public Builder setClip(@NonNull ClipData clipData) {
            this.mBuilderCompat.d(clipData);
            return this;
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle bundle) {
            this.mBuilderCompat.setExtras(bundle);
            return this;
        }

        @NonNull
        public Builder setFlags(int i10) {
            this.mBuilderCompat.c(i10);
            return this;
        }

        @NonNull
        public Builder setLinkUri(@Nullable Uri uri) {
            this.mBuilderCompat.b(uri);
            return this;
        }

        @NonNull
        public Builder setSource(int i10) {
            this.mBuilderCompat.a(i10);
            return this;
        }

        public Builder(@NonNull ClipData clipData, int i10) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.mBuilderCompat = new b(clipData, i10);
            } else {
                this.mBuilderCompat = new d(clipData, i10);
            }
        }
    }

    @NonNull
    static Pair<ClipData, ClipData> partition(@NonNull ClipData clipData, @NonNull androidx.core.util.Predicate<ClipData.Item> predicate) {
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (int i10 = 0; i10 < clipData.getItemCount(); i10++) {
            ClipData.Item itemAt = clipData.getItemAt(i10);
            if (predicate.test(itemAt)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(itemAt);
            } else {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(itemAt);
            }
        }
        if (arrayList == null) {
            return Pair.create((Object) null, clipData);
        }
        if (arrayList2 == null) {
            return Pair.create(clipData, (Object) null);
        }
        return Pair.create(buildClipData(clipData.getDescription(), arrayList), buildClipData(clipData.getDescription(), arrayList2));
    }

    @RequiresApi(31)
    @NonNull
    public static Pair<ContentInfo, ContentInfo> partition(@NonNull ContentInfo contentInfo, @NonNull Predicate<ClipData.Item> predicate) {
        return a.a(contentInfo, predicate);
    }
}
