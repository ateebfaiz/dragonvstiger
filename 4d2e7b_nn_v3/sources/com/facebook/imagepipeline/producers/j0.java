package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import b3.i;
import e5.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import k5.b;
import o5.e;
import y2.l;
import y4.f;
import z2.a;

public class j0 extends m0 implements u1 {

    /* renamed from: d  reason: collision with root package name */
    private static final Class f20125d = j0.class;

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f20126e = {"_id", "_data"};

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f20127f = {"_data"};

    /* renamed from: g  reason: collision with root package name */
    private static final Rect f20128g = new Rect(0, 0, 512, 384);

    /* renamed from: h  reason: collision with root package name */
    private static final Rect f20129h = new Rect(0, 0, 96, 96);

    /* renamed from: c  reason: collision with root package name */
    private final ContentResolver f20130c;

    public j0(Executor executor, i iVar, ContentResolver contentResolver) {
        super(executor, iVar);
        this.f20130c = contentResolver;
    }

    private j g(Uri uri, f fVar) {
        Cursor query;
        j j10;
        if (fVar == null || (query = this.f20130c.query(uri, f20126e, (String) null, (String[]) null, (String) null)) == null) {
            return null;
        }
        try {
            if (!query.moveToFirst() || (j10 = j(fVar, query.getLong(query.getColumnIndex("_id")))) == null) {
                query.close();
                return null;
            }
            int columnIndex = query.getColumnIndex("_data");
            if (columnIndex >= 0) {
                j10.S(i(query.getString(columnIndex)));
            }
            return j10;
        } finally {
            query.close();
        }
    }

    private static int h(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    private static int i(String str) {
        if (str != null) {
            try {
                return e.a(new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1));
            } catch (IOException e10) {
                a.i(f20125d, e10, "Unable to retrieve thumbnail rotation for %s", str);
            }
        }
        return 0;
    }

    private j j(f fVar, long j10) {
        Cursor queryMiniThumbnail;
        int columnIndex;
        int k10 = k(fVar);
        if (k10 == 0 || (queryMiniThumbnail = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.f20130c, j10, k10, f20127f)) == null) {
            return null;
        }
        try {
            if (queryMiniThumbnail.moveToFirst() && (columnIndex = queryMiniThumbnail.getColumnIndex("_data")) >= 0) {
                String str = (String) l.g(queryMiniThumbnail.getString(columnIndex));
                if (new File(str).exists()) {
                    return d(new FileInputStream(str), h(str));
                }
            }
            queryMiniThumbnail.close();
            return null;
        } finally {
            queryMiniThumbnail.close();
        }
    }

    private static int k(f fVar) {
        Rect rect = f20129h;
        if (v1.b(rect.width(), rect.height(), fVar)) {
            return 3;
        }
        Rect rect2 = f20128g;
        if (v1.b(rect2.width(), rect2.height(), fVar)) {
            return 1;
        }
        return 0;
    }

    public boolean a(f fVar) {
        Rect rect = f20128g;
        return v1.b(rect.width(), rect.height(), fVar);
    }

    /* access modifiers changed from: protected */
    public j e(b bVar) {
        Uri u10 = bVar.u();
        if (g3.f.j(u10)) {
            return g(u10, bVar.q());
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public String f() {
        return "LocalContentUriThumbnailFetchProducer";
    }
}
