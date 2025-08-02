package com.android.vending.expansion.zipfile;

import android.content.ContentProvider;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.android.vending.expansion.zipfile.b;
import java.io.IOException;
import java.util.ArrayList;

public abstract class APEZProvider extends ContentProvider {

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f18326c = {"_id", "ZPFN", "ZFIL", "ZMOD", "ZCRC", "ZCOL", "ZUNL", "ZTYP"};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f18327d = {0, 1, 2, 3, 4, 5, 6, 7};

    /* renamed from: a  reason: collision with root package name */
    private b f18328a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18329b;

    private boolean b() {
        int i10;
        if (!this.f18329b) {
            Context context = getContext();
            PackageManager packageManager = context.getPackageManager();
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(a(), 128);
            try {
                int i11 = packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
                Bundle bundle = resolveContentProvider.metaData;
                String[] strArr = null;
                if (bundle != null) {
                    int i12 = bundle.getInt("mainVersion", i11);
                    int i13 = resolveContentProvider.metaData.getInt("patchVersion", i11);
                    String string = resolveContentProvider.metaData.getString("mainFilename", "N");
                    if ("N" != string) {
                        String string2 = resolveContentProvider.metaData.getString("patchFilename", "N");
                        strArr = "N" != string2 ? new String[]{string, string2} : new String[]{string};
                    }
                    i10 = i13;
                    i11 = i12;
                } else {
                    i10 = i11;
                }
                if (strArr == null) {
                    try {
                        this.f18328a = a.b(context, i11, i10);
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                } else {
                    this.f18328a = a.c(strArr);
                }
                this.f18329b = true;
                return true;
            } catch (PackageManager.NameNotFoundException e11) {
                e11.printStackTrace();
            }
        }
        return false;
    }

    public abstract String a();

    public ContentProviderResult[] applyBatch(ArrayList arrayList) {
        b();
        return super.applyBatch(arrayList);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return "vnd.android.cursor.item/asset";
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public AssetFileDescriptor openAssetFile(Uri uri, String str) {
        b();
        String encodedPath = uri.getEncodedPath();
        if (encodedPath.startsWith(DomExceptionUtils.SEPARATOR)) {
            encodedPath = encodedPath.substring(1);
        }
        return this.f18328a.c(encodedPath);
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        b();
        AssetFileDescriptor openAssetFile = openAssetFile(uri, str);
        if (openAssetFile != null) {
            return openAssetFile.getParcelFileDescriptor();
        }
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        b.a[] aVarArr;
        int[] iArr;
        b();
        b bVar = this.f18328a;
        if (bVar == null) {
            aVarArr = new b.a[0];
        } else {
            aVarArr = bVar.b();
        }
        if (strArr == null) {
            iArr = f18327d;
            strArr = f18326c;
        } else {
            int length = strArr.length;
            iArr = new int[length];
            for (int i10 = 0; i10 < length; i10++) {
                if (strArr[i10].equals("_id")) {
                    iArr[i10] = 0;
                } else if (strArr[i10].equals("ZPFN")) {
                    iArr[i10] = 1;
                } else if (strArr[i10].equals("ZFIL")) {
                    iArr[i10] = 2;
                } else if (strArr[i10].equals("ZMOD")) {
                    iArr[i10] = 3;
                } else if (strArr[i10].equals("ZCRC")) {
                    iArr[i10] = 4;
                } else if (strArr[i10].equals("ZCOL")) {
                    iArr[i10] = 5;
                } else if (strArr[i10].equals("ZUNL")) {
                    iArr[i10] = 6;
                } else if (strArr[i10].equals("ZTYP")) {
                    iArr[i10] = 7;
                } else {
                    throw new RuntimeException();
                }
            }
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr, aVarArr.length);
        int length2 = iArr.length;
        for (b.a aVar : aVarArr) {
            MatrixCursor.RowBuilder newRow = matrixCursor.newRow();
            for (int i11 = 0; i11 < length2; i11++) {
                switch (iArr[i11]) {
                    case 0:
                        newRow.add(Integer.valueOf(i11));
                        break;
                    case 1:
                        newRow.add(aVar.f18334b);
                        break;
                    case 2:
                        newRow.add(aVar.c());
                        break;
                    case 3:
                        newRow.add(Long.valueOf(aVar.f18338f));
                        break;
                    case 4:
                        newRow.add(Long.valueOf(aVar.f18339g));
                        break;
                    case 5:
                        newRow.add(Long.valueOf(aVar.f18340h));
                        break;
                    case 6:
                        newRow.add(Long.valueOf(aVar.f18341i));
                        break;
                    case 7:
                        newRow.add(Integer.valueOf(aVar.f18337e));
                        break;
                }
            }
        }
        return matrixCursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
