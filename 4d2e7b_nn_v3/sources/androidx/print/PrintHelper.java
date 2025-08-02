package androidx.print;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileNotFoundException;

public final class PrintHelper {
    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_COLOR = 2;
    @SuppressLint({"InlinedApi"})
    public static final int COLOR_MODE_MONOCHROME = 1;
    static final boolean IS_MIN_MARGINS_HANDLING_CORRECT;
    private static final String LOG_TAG = "PrintHelper";
    private static final int MAX_PRINT_SIZE = 3500;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    static final boolean PRINT_ACTIVITY_RESPECTS_ORIENTATION;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;
    int mColorMode = 2;
    final Context mContext;
    BitmapFactory.Options mDecodeOptions = null;
    final Object mLock = new Object();
    int mOrientation = 1;
    int mScaleMode = 2;

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    class a extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CancellationSignal f16041a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PrintAttributes f16042b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Bitmap f16043c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ PrintAttributes f16044d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f16045e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ParcelFileDescriptor f16046f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ PrintDocumentAdapter.WriteResultCallback f16047g;

        a(CancellationSignal cancellationSignal, PrintAttributes printAttributes, Bitmap bitmap, PrintAttributes printAttributes2, int i10, ParcelFileDescriptor parcelFileDescriptor, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            this.f16041a = cancellationSignal;
            this.f16042b = printAttributes;
            this.f16043c = bitmap;
            this.f16044d = printAttributes2;
            this.f16045e = i10;
            this.f16046f = parcelFileDescriptor;
            this.f16047g = writeResultCallback;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00a5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00c5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00d7 */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00a9 A[Catch:{ all -> 0x0041, all -> 0x00a3 }] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9 A[Catch:{ all -> 0x0041, all -> 0x00a3 }] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00db A[Catch:{ all -> 0x0041, all -> 0x00a3 }] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Throwable doInBackground(java.lang.Void... r9) {
            /*
                r8 = this;
                android.os.CancellationSignal r9 = r8.f16041a     // Catch:{ all -> 0x00a3 }
                boolean r9 = r9.isCanceled()     // Catch:{ all -> 0x00a3 }
                r0 = 0
                if (r9 == 0) goto L_0x000a
                return r0
            L_0x000a:
                android.print.pdf.PrintedPdfDocument r9 = new android.print.pdf.PrintedPdfDocument     // Catch:{ all -> 0x00a3 }
                androidx.print.PrintHelper r1 = androidx.print.PrintHelper.this     // Catch:{ all -> 0x00a3 }
                android.content.Context r1 = r1.mContext     // Catch:{ all -> 0x00a3 }
                android.print.PrintAttributes r2 = r8.f16042b     // Catch:{ all -> 0x00a3 }
                r9.<init>(r1, r2)     // Catch:{ all -> 0x00a3 }
                android.graphics.Bitmap r1 = r8.f16043c     // Catch:{ all -> 0x00a3 }
                android.print.PrintAttributes r2 = r8.f16042b     // Catch:{ all -> 0x00a3 }
                int r2 = r2.getColorMode()     // Catch:{ all -> 0x00a3 }
                android.graphics.Bitmap r1 = androidx.print.PrintHelper.convertBitmapForColorMode(r1, r2)     // Catch:{ all -> 0x00a3 }
                android.os.CancellationSignal r2 = r8.f16041a     // Catch:{ all -> 0x00a3 }
                boolean r2 = r2.isCanceled()     // Catch:{ all -> 0x00a3 }
                if (r2 == 0) goto L_0x002a
                return r0
            L_0x002a:
                r2 = 1
                android.graphics.pdf.PdfDocument$Page r3 = r9.startPage(r2)     // Catch:{ all -> 0x0041 }
                boolean r4 = androidx.print.PrintHelper.IS_MIN_MARGINS_HANDLING_CORRECT     // Catch:{ all -> 0x0041 }
                if (r4 == 0) goto L_0x0044
                android.graphics.RectF r2 = new android.graphics.RectF     // Catch:{ all -> 0x0041 }
                android.graphics.pdf.PdfDocument$PageInfo r5 = r3.getInfo()     // Catch:{ all -> 0x0041 }
                android.graphics.Rect r5 = r5.getContentRect()     // Catch:{ all -> 0x0041 }
                r2.<init>(r5)     // Catch:{ all -> 0x0041 }
                goto L_0x0067
            L_0x0041:
                r0 = move-exception
                goto L_0x00cd
            L_0x0044:
                android.print.pdf.PrintedPdfDocument r5 = new android.print.pdf.PrintedPdfDocument     // Catch:{ all -> 0x0041 }
                androidx.print.PrintHelper r6 = androidx.print.PrintHelper.this     // Catch:{ all -> 0x0041 }
                android.content.Context r6 = r6.mContext     // Catch:{ all -> 0x0041 }
                android.print.PrintAttributes r7 = r8.f16044d     // Catch:{ all -> 0x0041 }
                r5.<init>(r6, r7)     // Catch:{ all -> 0x0041 }
                android.graphics.pdf.PdfDocument$Page r2 = r5.startPage(r2)     // Catch:{ all -> 0x0041 }
                android.graphics.RectF r6 = new android.graphics.RectF     // Catch:{ all -> 0x0041 }
                android.graphics.pdf.PdfDocument$PageInfo r7 = r2.getInfo()     // Catch:{ all -> 0x0041 }
                android.graphics.Rect r7 = r7.getContentRect()     // Catch:{ all -> 0x0041 }
                r6.<init>(r7)     // Catch:{ all -> 0x0041 }
                r5.finishPage(r2)     // Catch:{ all -> 0x0041 }
                r5.close()     // Catch:{ all -> 0x0041 }
                r2 = r6
            L_0x0067:
                int r5 = r1.getWidth()     // Catch:{ all -> 0x0041 }
                int r6 = r1.getHeight()     // Catch:{ all -> 0x0041 }
                int r7 = r8.f16045e     // Catch:{ all -> 0x0041 }
                android.graphics.Matrix r5 = androidx.print.PrintHelper.getMatrix(r5, r6, r2, r7)     // Catch:{ all -> 0x0041 }
                if (r4 == 0) goto L_0x0078
                goto L_0x0086
            L_0x0078:
                float r4 = r2.left     // Catch:{ all -> 0x0041 }
                float r6 = r2.top     // Catch:{ all -> 0x0041 }
                r5.postTranslate(r4, r6)     // Catch:{ all -> 0x0041 }
                android.graphics.Canvas r4 = r3.getCanvas()     // Catch:{ all -> 0x0041 }
                r4.clipRect(r2)     // Catch:{ all -> 0x0041 }
            L_0x0086:
                android.graphics.Canvas r2 = r3.getCanvas()     // Catch:{ all -> 0x0041 }
                r2.drawBitmap(r1, r5, r0)     // Catch:{ all -> 0x0041 }
                r9.finishPage(r3)     // Catch:{ all -> 0x0041 }
                android.os.CancellationSignal r2 = r8.f16041a     // Catch:{ all -> 0x0041 }
                boolean r2 = r2.isCanceled()     // Catch:{ all -> 0x0041 }
                if (r2 == 0) goto L_0x00ad
                r9.close()     // Catch:{ all -> 0x00a3 }
                android.os.ParcelFileDescriptor r9 = r8.f16046f     // Catch:{ all -> 0x00a3 }
                if (r9 == 0) goto L_0x00a5
                r9.close()     // Catch:{ IOException -> 0x00a5 }
                goto L_0x00a5
            L_0x00a3:
                r9 = move-exception
                goto L_0x00df
            L_0x00a5:
                android.graphics.Bitmap r9 = r8.f16043c     // Catch:{ all -> 0x00a3 }
                if (r1 == r9) goto L_0x00ac
                r1.recycle()     // Catch:{ all -> 0x00a3 }
            L_0x00ac:
                return r0
            L_0x00ad:
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0041 }
                android.os.ParcelFileDescriptor r3 = r8.f16046f     // Catch:{ all -> 0x0041 }
                java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x0041 }
                r2.<init>(r3)     // Catch:{ all -> 0x0041 }
                r9.writeTo(r2)     // Catch:{ all -> 0x0041 }
                r9.close()     // Catch:{ all -> 0x00a3 }
                android.os.ParcelFileDescriptor r9 = r8.f16046f     // Catch:{ all -> 0x00a3 }
                if (r9 == 0) goto L_0x00c5
                r9.close()     // Catch:{ IOException -> 0x00c5 }
            L_0x00c5:
                android.graphics.Bitmap r9 = r8.f16043c     // Catch:{ all -> 0x00a3 }
                if (r1 == r9) goto L_0x00cc
                r1.recycle()     // Catch:{ all -> 0x00a3 }
            L_0x00cc:
                return r0
            L_0x00cd:
                r9.close()     // Catch:{ all -> 0x00a3 }
                android.os.ParcelFileDescriptor r9 = r8.f16046f     // Catch:{ all -> 0x00a3 }
                if (r9 == 0) goto L_0x00d7
                r9.close()     // Catch:{ IOException -> 0x00d7 }
            L_0x00d7:
                android.graphics.Bitmap r9 = r8.f16043c     // Catch:{ all -> 0x00a3 }
                if (r1 == r9) goto L_0x00de
                r1.recycle()     // Catch:{ all -> 0x00a3 }
            L_0x00de:
                throw r0     // Catch:{ all -> 0x00a3 }
            L_0x00df:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.print.PrintHelper.a.doInBackground(java.lang.Void[]):java.lang.Throwable");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(Throwable th) {
            if (this.f16041a.isCanceled()) {
                this.f16047g.onWriteCancelled();
            } else if (th == null) {
                this.f16047g.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
            } else {
                Log.e(PrintHelper.LOG_TAG, "Error writing printed content", th);
                this.f16047g.onWriteFailed((CharSequence) null);
            }
        }
    }

    private class b extends PrintDocumentAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final String f16049a;

        /* renamed from: b  reason: collision with root package name */
        private final int f16050b;

        /* renamed from: c  reason: collision with root package name */
        private final Bitmap f16051c;

        /* renamed from: d  reason: collision with root package name */
        private final OnPrintFinishCallback f16052d;

        /* renamed from: e  reason: collision with root package name */
        private PrintAttributes f16053e;

        b(String str, int i10, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
            this.f16049a = str;
            this.f16050b = i10;
            this.f16051c = bitmap;
            this.f16052d = onPrintFinishCallback;
        }

        public void onFinish() {
            OnPrintFinishCallback onPrintFinishCallback = this.f16052d;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
        }

        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            this.f16053e = printAttributes2;
            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.f16049a).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
        }

        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.writeBitmap(this.f16053e, this.f16050b, this.f16051c, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    private class c extends PrintDocumentAdapter {

        /* renamed from: a  reason: collision with root package name */
        final String f16055a;

        /* renamed from: b  reason: collision with root package name */
        final Uri f16056b;

        /* renamed from: c  reason: collision with root package name */
        final OnPrintFinishCallback f16057c;

        /* renamed from: d  reason: collision with root package name */
        final int f16058d;

        /* renamed from: e  reason: collision with root package name */
        PrintAttributes f16059e;

        /* renamed from: f  reason: collision with root package name */
        AsyncTask f16060f;

        /* renamed from: g  reason: collision with root package name */
        Bitmap f16061g = null;

        class a extends AsyncTask {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CancellationSignal f16063a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ PrintAttributes f16064b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ PrintAttributes f16065c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ PrintDocumentAdapter.LayoutResultCallback f16066d;

            /* renamed from: androidx.print.PrintHelper$c$a$a  reason: collision with other inner class name */
            class C0204a implements CancellationSignal.OnCancelListener {
                C0204a() {
                }

                public void onCancel() {
                    c.this.a();
                    a.this.cancel(false);
                }
            }

            a(CancellationSignal cancellationSignal, PrintAttributes printAttributes, PrintAttributes printAttributes2, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback) {
                this.f16063a = cancellationSignal;
                this.f16064b = printAttributes;
                this.f16065c = printAttributes2;
                this.f16066d = layoutResultCallback;
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Bitmap doInBackground(Uri... uriArr) {
                try {
                    c cVar = c.this;
                    return PrintHelper.this.loadConstrainedBitmap(cVar.f16056b);
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            /* renamed from: b */
            public void onCancelled(Bitmap bitmap) {
                this.f16066d.onLayoutCancelled();
                c.this.f16060f = null;
            }

            /* access modifiers changed from: protected */
            /* renamed from: c */
            public void onPostExecute(Bitmap bitmap) {
                PrintAttributes.MediaSize mediaSize;
                super.onPostExecute(bitmap);
                if (bitmap != null && (!PrintHelper.PRINT_ACTIVITY_RESPECTS_ORIENTATION || PrintHelper.this.mOrientation == 0)) {
                    synchronized (this) {
                        mediaSize = c.this.f16059e.getMediaSize();
                    }
                    if (!(mediaSize == null || mediaSize.isPortrait() == PrintHelper.isPortrait(bitmap))) {
                        Matrix matrix = new Matrix();
                        matrix.postRotate(90.0f);
                        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                    }
                }
                c.this.f16061g = bitmap;
                if (bitmap != null) {
                    this.f16066d.onLayoutFinished(new PrintDocumentInfo.Builder(c.this.f16055a).setContentType(1).setPageCount(1).build(), true ^ this.f16064b.equals(this.f16065c));
                } else {
                    this.f16066d.onLayoutFailed((CharSequence) null);
                }
                c.this.f16060f = null;
            }

            /* access modifiers changed from: protected */
            public void onPreExecute() {
                this.f16063a.setOnCancelListener(new C0204a());
            }
        }

        c(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback, int i10) {
            this.f16055a = str;
            this.f16056b = uri;
            this.f16057c = onPrintFinishCallback;
            this.f16058d = i10;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            synchronized (PrintHelper.this.mLock) {
                try {
                    BitmapFactory.Options options = PrintHelper.this.mDecodeOptions;
                    if (options != null) {
                        if (Build.VERSION.SDK_INT < 24) {
                            options.requestCancelDecode();
                        }
                        PrintHelper.this.mDecodeOptions = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void onFinish() {
            super.onFinish();
            a();
            AsyncTask asyncTask = this.f16060f;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            OnPrintFinishCallback onPrintFinishCallback = this.f16057c;
            if (onPrintFinishCallback != null) {
                onPrintFinishCallback.onFinish();
            }
            Bitmap bitmap = this.f16061g;
            if (bitmap != null) {
                bitmap.recycle();
                this.f16061g = null;
            }
        }

        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            synchronized (this) {
                this.f16059e = printAttributes2;
            }
            if (cancellationSignal.isCanceled()) {
                layoutResultCallback.onLayoutCancelled();
            } else if (this.f16061g != null) {
                layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.f16055a).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
            } else {
                this.f16060f = new a(cancellationSignal, printAttributes2, printAttributes, layoutResultCallback).execute(new Uri[0]);
            }
        }

        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            PrintHelper.this.writeBitmap(this.f16059e, this.f16058d, this.f16061g, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    static {
        boolean z10;
        int i10 = Build.VERSION.SDK_INT;
        boolean z11 = true;
        if (i10 > 23) {
            z10 = true;
        } else {
            z10 = false;
        }
        PRINT_ACTIVITY_RESPECTS_ORIENTATION = z10;
        if (i10 == 23) {
            z11 = false;
        }
        IS_MIN_MARGINS_HANDLING_CORRECT = z11;
    }

    public PrintHelper(@NonNull Context context) {
        this.mContext = context;
    }

    static Bitmap convertBitmapForColorMode(Bitmap bitmap, int i10) {
        if (i10 != 1) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap((Bitmap) null);
        return createBitmap;
    }

    @RequiresApi(19)
    private static PrintAttributes.Builder copyAttributes(PrintAttributes printAttributes) {
        PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
        if (printAttributes.getColorMode() != 0) {
            minMargins.setColorMode(printAttributes.getColorMode());
        }
        if (printAttributes.getDuplexMode() != 0) {
            minMargins.setDuplexMode(printAttributes.getDuplexMode());
        }
        return minMargins;
    }

    static Matrix getMatrix(int i10, int i11, RectF rectF, int i12) {
        float f10;
        Matrix matrix = new Matrix();
        float f11 = (float) i10;
        float width = rectF.width() / f11;
        if (i12 == 2) {
            f10 = Math.max(width, rectF.height() / ((float) i11));
        } else {
            f10 = Math.min(width, rectF.height() / ((float) i11));
        }
        matrix.postScale(f10, f10);
        matrix.postTranslate((rectF.width() - (f11 * f10)) / 2.0f, (rectF.height() - (((float) i11) * f10)) / 2.0f);
        return matrix;
    }

    static boolean isPortrait(Bitmap bitmap) {
        if (bitmap.getWidth() <= bitmap.getHeight()) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028 A[SYNTHETIC, Splitter:B:19:0x0028] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap loadBitmap(android.net.Uri r5, android.graphics.BitmapFactory.Options r6) throws java.io.FileNotFoundException {
        /*
            r4 = this;
            java.lang.String r0 = "close fail "
            java.lang.String r1 = "PrintHelper"
            if (r5 == 0) goto L_0x0031
            android.content.Context r2 = r4.mContext
            if (r2 == 0) goto L_0x0031
            r3 = 0
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ all -> 0x0025 }
            java.io.InputStream r5 = r2.openInputStream(r5)     // Catch:{ all -> 0x0025 }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r5, r3, r6)     // Catch:{ all -> 0x0022 }
            if (r5 == 0) goto L_0x0021
            r5.close()     // Catch:{ IOException -> 0x001d }
            goto L_0x0021
        L_0x001d:
            r5 = move-exception
            android.util.Log.w(r1, r0, r5)
        L_0x0021:
            return r6
        L_0x0022:
            r6 = move-exception
            r3 = r5
            goto L_0x0026
        L_0x0025:
            r6 = move-exception
        L_0x0026:
            if (r3 == 0) goto L_0x0030
            r3.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r5 = move-exception
            android.util.Log.w(r1, r0, r5)
        L_0x0030:
            throw r6
        L_0x0031:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "bad argument to loadBitmap"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.print.PrintHelper.loadBitmap(android.net.Uri, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    public static boolean systemSupportsPrint() {
        return true;
    }

    public int getColorMode() {
        return this.mColorMode;
    }

    public int getOrientation() {
        int i10 = this.mOrientation;
        if (i10 == 0) {
            return 1;
        }
        return i10;
    }

    public int getScaleMode() {
        return this.mScaleMode;
    }

    /* access modifiers changed from: package-private */
    public Bitmap loadConstrainedBitmap(Uri uri) throws FileNotFoundException {
        BitmapFactory.Options options;
        if (uri == null || this.mContext == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        loadBitmap(uri, options2);
        int i10 = options2.outWidth;
        int i11 = options2.outHeight;
        if (i10 > 0 && i11 > 0) {
            int max = Math.max(i10, i11);
            int i12 = 1;
            while (max > MAX_PRINT_SIZE) {
                max >>>= 1;
                i12 <<= 1;
            }
            if (i12 > 0 && Math.min(i10, i11) / i12 > 0) {
                synchronized (this.mLock) {
                    options = new BitmapFactory.Options();
                    this.mDecodeOptions = options;
                    options.inMutable = true;
                    options.inSampleSize = i12;
                }
                try {
                    Bitmap loadBitmap = loadBitmap(uri, options);
                    synchronized (this.mLock) {
                        this.mDecodeOptions = null;
                    }
                    return loadBitmap;
                } catch (Throwable th) {
                    synchronized (this.mLock) {
                        this.mDecodeOptions = null;
                        throw th;
                    }
                }
            }
        }
        return null;
    }

    public void printBitmap(@NonNull String str, @NonNull Bitmap bitmap) {
        printBitmap(str, bitmap, (OnPrintFinishCallback) null);
    }

    public void setColorMode(int i10) {
        this.mColorMode = i10;
    }

    public void setOrientation(int i10) {
        this.mOrientation = i10;
    }

    public void setScaleMode(int i10) {
        this.mScaleMode = i10;
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(19)
    public void writeBitmap(PrintAttributes printAttributes, int i10, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        PrintAttributes printAttributes2;
        if (IS_MIN_MARGINS_HANDLING_CORRECT) {
            printAttributes2 = printAttributes;
        } else {
            printAttributes2 = copyAttributes(printAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build();
        }
        new a(cancellationSignal, printAttributes2, bitmap, printAttributes, i10, parcelFileDescriptor, writeResultCallback).execute(new Void[0]);
    }

    public void printBitmap(@NonNull String str, @NonNull Bitmap bitmap, @Nullable OnPrintFinishCallback onPrintFinishCallback) {
        PrintAttributes.MediaSize mediaSize;
        if (bitmap != null) {
            PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
            if (isPortrait(bitmap)) {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
            } else {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
            }
            printManager.print(str, new b(str, this.mScaleMode, bitmap, onPrintFinishCallback), new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.mColorMode).build());
        }
    }

    public void printBitmap(@NonNull String str, @NonNull Uri uri) throws FileNotFoundException {
        printBitmap(str, uri, (OnPrintFinishCallback) null);
    }

    public void printBitmap(@NonNull String str, @NonNull Uri uri, @Nullable OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        c cVar = new c(str, uri, onPrintFinishCallback, this.mScaleMode);
        PrintManager printManager = (PrintManager) this.mContext.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.mColorMode);
        int i10 = this.mOrientation;
        if (i10 == 1 || i10 == 0) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (i10 == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, cVar, builder.build());
    }
}
