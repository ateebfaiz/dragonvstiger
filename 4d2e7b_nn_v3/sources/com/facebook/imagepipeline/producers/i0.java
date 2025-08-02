package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.ContactsContract;
import b3.i;
import e5.j;
import g3.f;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import k5.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class i0 extends m0 {

    /* renamed from: d  reason: collision with root package name */
    public static final a f20114d = new a((DefaultConstructorMarker) null);

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f20115e = {"_id", "_data"};

    /* renamed from: c  reason: collision with root package name */
    private final ContentResolver f20116c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i0(Executor executor, i iVar, ContentResolver contentResolver) {
        super(executor, iVar);
        m.f(executor, "executor");
        m.f(iVar, "pooledByteBufferFactory");
        m.f(contentResolver, "contentResolver");
        this.f20116c = contentResolver;
    }

    private final j g(Uri uri) {
        try {
            ParcelFileDescriptor openFileDescriptor = this.f20116c.openFileDescriptor(uri, "r");
            if (openFileDescriptor != null) {
                j d10 = d(new FileInputStream(openFileDescriptor.getFileDescriptor()), (int) openFileDescriptor.getStatSize());
                m.e(d10, "this.getEncodedImage(Fil…criptor.statSize.toInt())");
                openFileDescriptor.close();
                return d10;
            }
            throw new IllegalStateException("Required value was null.".toString());
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public j e(b bVar) {
        j g10;
        InputStream inputStream;
        m.f(bVar, "imageRequest");
        Uri u10 = bVar.u();
        m.e(u10, "imageRequest.sourceUri");
        if (f.k(u10)) {
            String uri = u10.toString();
            m.e(uri, "uri.toString()");
            if (kotlin.text.j.p(uri, "/photo", false, 2, (Object) null)) {
                inputStream = this.f20116c.openInputStream(u10);
            } else {
                String uri2 = u10.toString();
                m.e(uri2, "uri.toString()");
                if (kotlin.text.j.p(uri2, "/display_photo", false, 2, (Object) null)) {
                    try {
                        AssetFileDescriptor openAssetFileDescriptor = this.f20116c.openAssetFileDescriptor(u10, "r");
                        if (openAssetFileDescriptor != null) {
                            inputStream = openAssetFileDescriptor.createInputStream();
                        } else {
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                    } catch (IOException unused) {
                        throw new IOException("Contact photo does not exist: " + u10);
                    }
                } else {
                    InputStream openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.f20116c, u10);
                    if (openContactPhotoInputStream != null) {
                        inputStream = openContactPhotoInputStream;
                    } else {
                        throw new IOException("Contact photo does not exist: " + u10);
                    }
                }
            }
            if (inputStream != null) {
                return d(inputStream, -1);
            }
            throw new IllegalStateException("Required value was null.".toString());
        } else if (f.j(u10) && (g10 = g(u10)) != null) {
            return g10;
        } else {
            InputStream openInputStream = this.f20116c.openInputStream(u10);
            if (openInputStream != null) {
                return d(openInputStream, -1);
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    /* access modifiers changed from: protected */
    public String f() {
        return "LocalContentUriFetchProducer";
    }
}
