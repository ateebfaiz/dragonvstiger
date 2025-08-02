package org.cocos2dx.javascript;

import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.io.File;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class DownloadUtil {
    private static DownloadUtil downloadUtil;
    private final OkHttpClient okHttpClient = new OkHttpClient();

    public interface OnDownloadListener {
        void onDownloadFailed();

        void onDownloadStart(long j10);

        void onDownloadSuccess(String str);

        void onDownloading(int i10);
    }

    class a implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OnDownloadListener f1396a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1397b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f1398c;

        a(OnDownloadListener onDownloadListener, String str, String str2) {
            this.f1396a = onDownloadListener;
            this.f1397b = str;
            this.f1398c = str2;
        }

        public void onFailure(Call call, IOException iOException) {
            this.f1396a.onDownloadFailed();
            iOException.printStackTrace();
        }

        /* JADX WARNING: Removed duplicated region for block: B:39:0x00a5 A[SYNTHETIC, Splitter:B:39:0x00a5] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00af A[SYNTHETIC, Splitter:B:44:0x00af] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00b6 A[SYNTHETIC, Splitter:B:48:0x00b6] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x00c0 A[SYNTHETIC, Splitter:B:53:0x00c0] */
        /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResponse(okhttp3.Call r11, okhttp3.Response r12) {
            /*
                r10 = this;
                r11 = 2048(0x800, float:2.87E-42)
                byte[] r11 = new byte[r11]
                org.cocos2dx.javascript.DownloadUtil r0 = org.cocos2dx.javascript.DownloadUtil.this
                java.lang.String r1 = r10.f1397b
                java.lang.String r0 = r0.isExistDir(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                java.lang.String r0 = java.io.File.separator
                r1.append(r0)
                org.cocos2dx.javascript.DownloadUtil r0 = org.cocos2dx.javascript.DownloadUtil.this
                java.lang.String r2 = r10.f1398c
                java.lang.String r0 = r0.getNameFromUrl(r2)
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                r1 = 0
                okhttp3.ResponseBody r2 = r12.body()     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
                java.io.InputStream r2 = r2.byteStream()     // Catch:{ Exception -> 0x0099, all -> 0x0096 }
                okhttp3.ResponseBody r12 = r12.body()     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
                long r3 = r12.contentLength()     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
                java.io.File r12 = new java.io.File     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
                r12.<init>(r0)     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
                java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
                r5.<init>(r12)     // Catch:{ Exception -> 0x0093, all -> 0x0090 }
                org.cocos2dx.javascript.DownloadUtil$OnDownloadListener r12 = r10.f1396a     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
                r12.onDownloadStart(r3)     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
                r6 = 0
            L_0x004a:
                int r12 = r2.read(r11)     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
                r1 = -1
                if (r12 == r1) goto L_0x006d
                r1 = 0
                r5.write(r11, r1, r12)     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
                long r8 = (long) r12     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
                long r6 = r6 + r8
                float r12 = (float) r6     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
                r1 = 1065353216(0x3f800000, float:1.0)
                float r12 = r12 * r1
                float r1 = (float) r3     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
                float r12 = r12 / r1
                r1 = 1120403456(0x42c80000, float:100.0)
                float r12 = r12 * r1
                int r12 = (int) r12     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
                org.cocos2dx.javascript.DownloadUtil$OnDownloadListener r1 = r10.f1396a     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
                r1.onDownloading(r12)     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
                goto L_0x004a
            L_0x0067:
                r11 = move-exception
            L_0x0068:
                r1 = r2
                goto L_0x00b4
            L_0x006a:
                r11 = move-exception
            L_0x006b:
                r1 = r2
                goto L_0x009b
            L_0x006d:
                r5.flush()     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
                int r11 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                if (r11 < 0) goto L_0x008a
                org.cocos2dx.javascript.DownloadUtil$OnDownloadListener r11 = r10.f1396a     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
                r11.onDownloadSuccess(r0)     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
                r2.close()     // Catch:{ IOException -> 0x007d }
                goto L_0x0081
            L_0x007d:
                r11 = move-exception
                r11.printStackTrace()
            L_0x0081:
                r5.close()     // Catch:{ IOException -> 0x0085 }
                goto L_0x00b2
            L_0x0085:
                r11 = move-exception
                r11.printStackTrace()
                goto L_0x00b2
            L_0x008a:
                java.lang.Exception r11 = new java.lang.Exception     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
                r11.<init>()     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
                throw r11     // Catch:{ Exception -> 0x006a, all -> 0x0067 }
            L_0x0090:
                r11 = move-exception
                r5 = r1
                goto L_0x0068
            L_0x0093:
                r11 = move-exception
                r5 = r1
                goto L_0x006b
            L_0x0096:
                r11 = move-exception
                r5 = r1
                goto L_0x00b4
            L_0x0099:
                r11 = move-exception
                r5 = r1
            L_0x009b:
                org.cocos2dx.javascript.DownloadUtil$OnDownloadListener r12 = r10.f1396a     // Catch:{ all -> 0x00b3 }
                r12.onDownloadFailed()     // Catch:{ all -> 0x00b3 }
                r11.printStackTrace()     // Catch:{ all -> 0x00b3 }
                if (r1 == 0) goto L_0x00ad
                r1.close()     // Catch:{ IOException -> 0x00a9 }
                goto L_0x00ad
            L_0x00a9:
                r11 = move-exception
                r11.printStackTrace()
            L_0x00ad:
                if (r5 == 0) goto L_0x00b2
                r5.close()     // Catch:{ IOException -> 0x0085 }
            L_0x00b2:
                return
            L_0x00b3:
                r11 = move-exception
            L_0x00b4:
                if (r1 == 0) goto L_0x00be
                r1.close()     // Catch:{ IOException -> 0x00ba }
                goto L_0x00be
            L_0x00ba:
                r12 = move-exception
                r12.printStackTrace()
            L_0x00be:
                if (r5 == 0) goto L_0x00c8
                r5.close()     // Catch:{ IOException -> 0x00c4 }
                goto L_0x00c8
            L_0x00c4:
                r12 = move-exception
                r12.printStackTrace()
            L_0x00c8:
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.javascript.DownloadUtil.a.onResponse(okhttp3.Call, okhttp3.Response):void");
        }
    }

    private DownloadUtil() {
    }

    public static DownloadUtil get() {
        if (downloadUtil == null) {
            downloadUtil = new DownloadUtil();
        }
        return downloadUtil;
    }

    /* access modifiers changed from: private */
    @NonNull
    public String getNameFromUrl(String str) {
        String substring = str.substring(str.lastIndexOf(DomExceptionUtils.SEPARATOR) + 1);
        if (substring.indexOf(63) != -1) {
            return substring.substring(0, substring.indexOf(63));
        }
        return substring;
    }

    /* access modifiers changed from: private */
    public String isExistDir(String str) throws IOException {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), str);
        if (!file.mkdirs()) {
            file.createNewFile();
        }
        return file.getAbsolutePath();
    }

    public void download(String str, String str2, OnDownloadListener onDownloadListener) {
        this.okHttpClient.newCall(new Request.Builder().url(str).build()).enqueue(new a(onDownloadListener, str2, str));
    }
}
