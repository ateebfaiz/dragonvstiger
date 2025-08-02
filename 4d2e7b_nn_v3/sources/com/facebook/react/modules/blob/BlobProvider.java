package com.facebook.react.modules.blob;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.facebook.react.u;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class BlobProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f3204a = Executors.newSingleThreadExecutor();

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ParcelFileDescriptor f3205a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ byte[] f3206b;

        a(ParcelFileDescriptor parcelFileDescriptor, byte[] bArr) {
            this.f3205a = parcelFileDescriptor;
            this.f3206b = bArr;
        }

        public void run() {
            ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
            try {
                autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(this.f3205a);
                autoCloseOutputStream.write(this.f3206b);
                autoCloseOutputStream.close();
                return;
            } catch (IOException unused) {
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        BlobModule blobModule;
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        if (str.equals("r")) {
            Context applicationContext = getContext().getApplicationContext();
            if (applicationContext instanceof u) {
                blobModule = (BlobModule) ((u) applicationContext).getReactNativeHost().p().C().getNativeModule(BlobModule.class);
            } else {
                blobModule = null;
            }
            if (blobModule != null) {
                byte[] resolve = blobModule.resolve(uri);
                if (resolve != null) {
                    try {
                        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                        ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
                        ParcelFileDescriptor parcelFileDescriptor2 = createPipe[1];
                        if (resolve.length <= 65536) {
                            try {
                                autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor2);
                                autoCloseOutputStream.write(resolve);
                                autoCloseOutputStream.close();
                            } catch (IOException unused) {
                                return null;
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        } else {
                            this.f3204a.submit(new a(parcelFileDescriptor2, resolve));
                        }
                        return parcelFileDescriptor;
                    } catch (IOException unused2) {
                        return null;
                    }
                } else {
                    throw new FileNotFoundException("Cannot open " + uri + ", blob not found.");
                }
            } else {
                throw new RuntimeException("No blob module associated with BlobProvider");
            }
        } else {
            throw new FileNotFoundException("Cannot open " + uri.toString() + " in mode '" + str + "'");
        }
        throw th;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
