package ib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import gb.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class a extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    private final Context f12385a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f12386b;

    /* renamed from: c  reason: collision with root package name */
    private Uri f12387c;

    /* renamed from: d  reason: collision with root package name */
    private final int f12388d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12389e;

    /* renamed from: f  reason: collision with root package name */
    private final b f12390f;

    public a(Context context, Uri uri, Uri uri2, int i10, int i11, b bVar) {
        this.f12385a = context;
        this.f12386b = uri;
        this.f12387c = uri2;
        this.f12388d = i10;
        this.f12389e = i11;
        this.f12390f = bVar;
    }

    private boolean a(Bitmap bitmap, BitmapFactory.Options options) {
        int i10;
        if (bitmap != null) {
            i10 = bitmap.getByteCount();
        } else {
            i10 = 0;
        }
        if (i10 <= 104857600) {
            return false;
        }
        options.inSampleSize *= 2;
        return true;
    }

    private void b(Uri uri, Uri uri2) {
        InputStream inputStream;
        Log.d("BitmapWorkerTask", "copyFile");
        if (uri2 != null) {
            FileOutputStream fileOutputStream = null;
            try {
                inputStream = this.f12385a.getContentResolver().openInputStream(uri);
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(uri2.getPath()));
                    if (inputStream != null) {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read > 0) {
                                    fileOutputStream2.write(bArr, 0, read);
                                } else {
                                    jb.a.c(fileOutputStream2);
                                    jb.a.c(inputStream);
                                    this.f12386b = this.f12387c;
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            jb.a.c(fileOutputStream);
                            jb.a.c(inputStream);
                            this.f12386b = this.f12387c;
                            throw th;
                        }
                    } else {
                        throw new NullPointerException("InputStream for given input Uri is null");
                    }
                } catch (Throwable th2) {
                    th = th2;
                    jb.a.c(fileOutputStream);
                    jb.a.c(inputStream);
                    this.f12386b = this.f12387c;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                jb.a.c(fileOutputStream);
                jb.a.c(inputStream);
                this.f12386b = this.f12387c;
                throw th;
            }
        } else {
            throw new NullPointerException("Output Uri is null - cannot copy image");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(android.net.Uri r6, android.net.Uri r7) {
        /*
            r5 = this;
            java.lang.String r0 = "BitmapWorkerTask"
            java.lang.String r1 = "downloadFile"
            android.util.Log.d(r0, r1)
            if (r7 == 0) goto L_0x008c
            okhttp3.OkHttpClient r0 = new okhttp3.OkHttpClient
            r0.<init>()
            r1 = 0
            okhttp3.Request$Builder r2 = new okhttp3.Request$Builder     // Catch:{ all -> 0x006e }
            r2.<init>()     // Catch:{ all -> 0x006e }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x006e }
            okhttp3.Request$Builder r6 = r2.url((java.lang.String) r6)     // Catch:{ all -> 0x006e }
            okhttp3.Request r6 = r6.build()     // Catch:{ all -> 0x006e }
            okhttp3.Call r6 = r0.newCall(r6)     // Catch:{ all -> 0x006e }
            okhttp3.Response r6 = r6.execute()     // Catch:{ all -> 0x006e }
            okhttp3.ResponseBody r2 = r6.body()     // Catch:{ all -> 0x006a }
            okio.BufferedSource r2 = r2.source()     // Catch:{ all -> 0x006a }
            android.content.Context r3 = r5.f12385a     // Catch:{ all -> 0x005c }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ all -> 0x005c }
            java.io.OutputStream r7 = r3.openOutputStream(r7)     // Catch:{ all -> 0x005c }
            if (r7 == 0) goto L_0x0062
            okio.Sink r1 = okio.Okio.sink((java.io.OutputStream) r7)     // Catch:{ all -> 0x005c }
            r2.readAll(r1)     // Catch:{ all -> 0x005c }
            jb.a.c(r2)
            jb.a.c(r1)
            okhttp3.ResponseBody r6 = r6.body()
            jb.a.c(r6)
            okhttp3.Dispatcher r6 = r0.dispatcher()
            r6.cancelAll()
            android.net.Uri r6 = r5.f12387c
            r5.f12386b = r6
            return
        L_0x005c:
            r7 = move-exception
            r4 = r2
            r2 = r6
            r6 = r1
            r1 = r4
            goto L_0x0071
        L_0x0062:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException     // Catch:{ all -> 0x005c }
            java.lang.String r3 = "OutputStream for given output Uri is null"
            r7.<init>(r3)     // Catch:{ all -> 0x005c }
            throw r7     // Catch:{ all -> 0x005c }
        L_0x006a:
            r7 = move-exception
            r2 = r6
            r6 = r1
            goto L_0x0071
        L_0x006e:
            r7 = move-exception
            r6 = r1
            r2 = r6
        L_0x0071:
            jb.a.c(r1)
            jb.a.c(r6)
            if (r2 == 0) goto L_0x0080
            okhttp3.ResponseBody r6 = r2.body()
            jb.a.c(r6)
        L_0x0080:
            okhttp3.Dispatcher r6 = r0.dispatcher()
            r6.cancelAll()
            android.net.Uri r6 = r5.f12387c
            r5.f12386b = r6
            throw r7
        L_0x008c:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "Output Uri is null - cannot download image"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ib.a.d(android.net.Uri, android.net.Uri):void");
    }

    private void f() {
        String scheme = this.f12386b.getScheme();
        Log.d("BitmapWorkerTask", "Uri scheme: " + scheme);
        if ("http".equals(scheme) || "https".equals(scheme)) {
            try {
                d(this.f12386b, this.f12387c);
            } catch (IOException | NullPointerException e10) {
                Log.e("BitmapWorkerTask", "Downloading failed", e10);
                throw e10;
            }
        } else if (FirebaseAnalytics.Param.CONTENT.equals(scheme)) {
            try {
                b(this.f12386b, this.f12387c);
            } catch (IOException | NullPointerException e11) {
                Log.e("BitmapWorkerTask", "Copying failed", e11);
                throw e11;
            }
        } else if (!"file".equals(scheme)) {
            Log.e("BitmapWorkerTask", "Invalid Uri scheme " + scheme);
            throw new IllegalArgumentException("Invalid Uri scheme" + scheme);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C0145a doInBackground(Void... voidArr) {
        InputStream openInputStream;
        if (this.f12386b == null) {
            return new C0145a(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            f();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = jb.a.a(options, this.f12388d, this.f12389e);
            boolean z10 = false;
            options.inJustDecodeBounds = false;
            Bitmap bitmap = null;
            while (!z10) {
                try {
                    openInputStream = this.f12385a.getContentResolver().openInputStream(this.f12386b);
                    bitmap = BitmapFactory.decodeStream(openInputStream, (Rect) null, options);
                    if (options.outWidth == -1 || options.outHeight == -1) {
                        C0145a aVar = new C0145a(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.f12386b + "]"));
                        jb.a.c(openInputStream);
                        return aVar;
                    }
                    jb.a.c(openInputStream);
                    if (!a(bitmap, options)) {
                        z10 = true;
                    }
                } catch (OutOfMemoryError e10) {
                    Log.e("BitmapWorkerTask", "doInBackground: BitmapFactory.decodeFileDescriptor: ", e10);
                    options.inSampleSize *= 2;
                } catch (IOException e11) {
                    Log.e("BitmapWorkerTask", "doInBackground: ImageDecoder.createSource: ", e11);
                    return new C0145a(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.f12386b + "]", e11));
                } catch (Throwable th) {
                    jb.a.c(openInputStream);
                    throw th;
                }
            }
            if (bitmap == null) {
                return new C0145a(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.f12386b + "]"));
            }
            int g10 = jb.a.g(this.f12385a, this.f12386b);
            int e12 = jb.a.e(g10);
            int f10 = jb.a.f(g10);
            hb.b bVar = new hb.b(g10, e12, f10);
            Matrix matrix = new Matrix();
            if (e12 != 0) {
                matrix.preRotate((float) e12);
            }
            if (f10 != 1) {
                matrix.postScale((float) f10, 1.0f);
            }
            if (!matrix.isIdentity()) {
                return new C0145a(jb.a.h(bitmap, matrix), bVar);
            }
            return new C0145a(bitmap, bVar);
        } catch (IOException | NullPointerException e13) {
            return new C0145a(e13);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void onPostExecute(C0145a aVar) {
        String str;
        Exception exc = aVar.f12393c;
        if (exc == null) {
            b bVar = this.f12390f;
            Bitmap bitmap = aVar.f12391a;
            hb.b bVar2 = aVar.f12392b;
            String path = this.f12386b.getPath();
            Uri uri = this.f12387c;
            if (uri == null) {
                str = null;
            } else {
                str = uri.getPath();
            }
            bVar.a(bitmap, bVar2, path, str);
            return;
        }
        this.f12390f.onFailure(exc);
    }

    /* renamed from: ib.a$a  reason: collision with other inner class name */
    public static class C0145a {

        /* renamed from: a  reason: collision with root package name */
        Bitmap f12391a;

        /* renamed from: b  reason: collision with root package name */
        hb.b f12392b;

        /* renamed from: c  reason: collision with root package name */
        Exception f12393c;

        public C0145a(Bitmap bitmap, hb.b bVar) {
            this.f12391a = bitmap;
            this.f12392b = bVar;
        }

        public C0145a(Exception exc) {
            this.f12393c = exc;
        }
    }
}
