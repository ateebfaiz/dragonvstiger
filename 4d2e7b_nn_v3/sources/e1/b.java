package e1;

import android.util.JsonReader;
import android.util.JsonToken;
import com.bugsnag.android.NativeInterface;
import com.bugsnag.android.s2;
import java.util.Collection;
import kotlin.jvm.internal.m;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final s2 f21117a;

    /* renamed from: b  reason: collision with root package name */
    private final Collection f21118b;

    public b(s2 s2Var, Collection collection) {
        this.f21117a = s2Var;
        this.f21118b = collection;
    }

    private final boolean c(JsonReader jsonReader) {
        jsonReader.beginObject();
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            if (!m.b(jsonReader.nextName(), "errorClass")) {
                jsonReader.skipValue();
            } else if (NativeInterface.isDiscardErrorClass(jsonReader.nextString())) {
                return true;
            }
        }
        jsonReader.endObject();
        return false;
    }

    private final boolean d(JsonReader jsonReader) {
        if (this.f21118b.isEmpty()) {
            jsonReader.skipValue();
            return false;
        }
        jsonReader.beginObject();
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            if (m.b(jsonReader.nextName(), "releaseStage")) {
                if (!this.f21118b.contains(jsonReader.nextString())) {
                    return true;
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return false;
    }

    private final boolean e(JsonReader jsonReader) {
        jsonReader.beginArray();
        while (jsonReader.peek() != JsonToken.END_ARRAY) {
            if (c(jsonReader)) {
                this.f21117a.d("Discarding native report due to errorClass");
                return true;
            }
        }
        jsonReader.endArray();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        tb.c.a(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0050, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        tb.c.a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0056, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.io.File r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.getName()
            java.lang.String r1 = ".json"
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r0 = kotlin.text.j.p(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L_0x0058
            java.lang.String r0 = r6.getName()
            java.lang.String r1 = ".static_data.json"
            boolean r0 = kotlin.text.j.p(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L_0x001c
            goto L_0x0058
        L_0x001c:
            java.nio.charset.Charset r0 = kotlin.text.d.f797b     // Catch:{ Exception -> 0x0057 }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0057 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0057 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0057 }
            r6.<init>(r1, r0)     // Catch:{ Exception -> 0x0057 }
            boolean r0 = r6 instanceof java.io.BufferedReader     // Catch:{ Exception -> 0x0057 }
            if (r0 == 0) goto L_0x002f
            java.io.BufferedReader r6 = (java.io.BufferedReader) r6     // Catch:{ Exception -> 0x0057 }
            goto L_0x0037
        L_0x002f:
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0057 }
            r1 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r6, r1)     // Catch:{ Exception -> 0x0057 }
            r6 = r0
        L_0x0037:
            android.util.JsonReader r0 = new android.util.JsonReader     // Catch:{ all -> 0x0048 }
            r0.<init>(r6)     // Catch:{ all -> 0x0048 }
            boolean r1 = r5.b(r0)     // Catch:{ all -> 0x004a }
            tb.c.a(r0, r4)     // Catch:{ all -> 0x0048 }
            tb.c.a(r6, r4)     // Catch:{ Exception -> 0x0057 }
            r2 = r1
            goto L_0x0057
        L_0x0048:
            r0 = move-exception
            goto L_0x0051
        L_0x004a:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x004c }
        L_0x004c:
            r3 = move-exception
            tb.c.a(r0, r1)     // Catch:{ all -> 0x0048 }
            throw r3     // Catch:{ all -> 0x0048 }
        L_0x0051:
            throw r0     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r1 = move-exception
            tb.c.a(r6, r0)     // Catch:{ Exception -> 0x0057 }
            throw r1     // Catch:{ Exception -> 0x0057 }
        L_0x0057:
            return r2
        L_0x0058:
            r6 = 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.b.a(java.io.File):boolean");
    }

    public final boolean b(JsonReader jsonReader) {
        boolean z10;
        jsonReader.beginObject();
        boolean z11 = true;
        boolean z12 = true;
        do {
            z10 = false;
            if (!jsonReader.hasNext() || (!z11 && !z12)) {
                return false;
            }
            String nextName = jsonReader.nextName();
            if (m.b(nextName, "app")) {
                z10 = d(jsonReader);
                z11 = false;
                continue;
            } else if (m.b(nextName, "exceptions")) {
                z10 = e(jsonReader);
                z12 = false;
                continue;
            } else {
                jsonReader.skipValue();
                continue;
            }
        } while (!z10);
        return true;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b(com.bugsnag.android.s2 r1, java.util.Collection<java.lang.String> r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0010
            java.util.Collection r2 = com.bugsnag.android.NativeInterface.getEnabledReleaseStages()
            if (r2 != 0) goto L_0x0010
            java.util.Set r2 = kotlin.collections.r0.d()
            java.util.Collection r2 = (java.util.Collection) r2
        L_0x0010:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.b.<init>(com.bugsnag.android.s2, java.util.Collection, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
