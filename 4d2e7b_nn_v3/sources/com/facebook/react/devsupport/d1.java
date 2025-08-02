package com.facebook.react.devsupport;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import k6.j;

public abstract class d1 {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f3063a = Pattern.compile("^(?:(.*?)@)?(.*?)\\:([0-9]+)\\:([0-9]+)$");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f3064b = Pattern.compile("\\s*(?:at)\\s*(.+?)\\s*[@(](.*):([0-9]+):([0-9]+)[)]$");

    public static j[] a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        j[] jVarArr = new j[stackTrace.length];
        for (int i10 = 0; i10 < stackTrace.length; i10++) {
            jVarArr[i10] = new a(stackTrace[i10].getClassName(), stackTrace[i10].getFileName(), stackTrace[i10].getMethodName(), stackTrace[i10].getLineNumber(), -1);
        }
        return jVarArr;
    }

    public static j[] b(ReadableArray readableArray) {
        int i10;
        boolean z10;
        int i11;
        int i12;
        if (readableArray != null) {
            i10 = readableArray.size();
        } else {
            i10 = 0;
        }
        j[] jVarArr = new j[i10];
        for (int i13 = 0; i13 < i10; i13++) {
            ReadableType type = readableArray.getType(i13);
            if (type == ReadableType.Map) {
                ReadableMap map = readableArray.getMap(i13);
                String string = map.getString("methodName");
                String string2 = map.getString("file");
                if (!map.hasKey("collapse") || map.isNull("collapse") || !map.getBoolean("collapse")) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (!map.hasKey("lineNumber") || map.isNull("lineNumber")) {
                    i11 = -1;
                } else {
                    i11 = map.getInt("lineNumber");
                }
                if (!map.hasKey("column") || map.isNull("column")) {
                    i12 = -1;
                } else {
                    i12 = map.getInt("column");
                }
                jVarArr[i13] = new a(string2, string, i11, i12, z10);
            } else if (type == ReadableType.String) {
                jVarArr[i13] = new a((String) null, readableArray.getString(i13), -1, -1);
            }
        }
        return jVarArr;
    }

    public static JavaOnlyMap c(ReactJsExceptionHandler.ParsedError parsedError) {
        List<ReactJsExceptionHandler.ParsedError.StackFrame> frames = parsedError.getFrames();
        ArrayList arrayList = new ArrayList();
        for (ReactJsExceptionHandler.ParsedError.StackFrame next : frames) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.putDouble("column", (double) next.getColumnNumber());
            javaOnlyMap.putDouble("lineNumber", (double) next.getLineNumber());
            javaOnlyMap.putString("file", next.getFileName());
            javaOnlyMap.putString("methodName", next.getMethodName());
            arrayList.add(javaOnlyMap);
        }
        JavaOnlyMap javaOnlyMap2 = new JavaOnlyMap();
        javaOnlyMap2.putString("message", parsedError.getMessage());
        javaOnlyMap2.putArray("stack", JavaOnlyArray.from(arrayList));
        javaOnlyMap2.putInt("id", parsedError.getExceptionId());
        javaOnlyMap2.putBoolean("isFatal", parsedError.isFatal());
        return javaOnlyMap2;
    }

    public static String d(j jVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(jVar.getFileName());
        int a10 = jVar.a();
        if (a10 > 0) {
            sb2.append(":");
            sb2.append(a10);
            int e10 = jVar.e();
            if (e10 > 0) {
                sb2.append(":");
                sb2.append(e10);
            }
        }
        return sb2.toString();
    }

    public static class a implements j {

        /* renamed from: a  reason: collision with root package name */
        private final String f3065a;

        /* renamed from: b  reason: collision with root package name */
        private final String f3066b;

        /* renamed from: c  reason: collision with root package name */
        private final int f3067c;

        /* renamed from: d  reason: collision with root package name */
        private final int f3068d;

        /* renamed from: e  reason: collision with root package name */
        private final String f3069e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f3070f;

        public int a() {
            return this.f3067c;
        }

        public String b() {
            return this.f3065a;
        }

        public String c() {
            return this.f3066b;
        }

        public boolean d() {
            return this.f3070f;
        }

        public int e() {
            return this.f3068d;
        }

        public String getFileName() {
            return this.f3069e;
        }

        private a(String str, String str2, int i10, int i11, boolean z10) {
            this.f3065a = str;
            this.f3066b = str2;
            this.f3067c = i10;
            this.f3068d = i11;
            this.f3069e = str != null ? new File(str).getName() : "";
            this.f3070f = z10;
        }

        private a(String str, String str2, int i10, int i11) {
            this(str, str2, i10, i11, false);
        }

        private a(String str, String str2, String str3, int i10, int i11) {
            this.f3065a = str;
            this.f3069e = str2;
            this.f3066b = str3;
            this.f3067c = i10;
            this.f3068d = i11;
            this.f3070f = false;
        }
    }
}
