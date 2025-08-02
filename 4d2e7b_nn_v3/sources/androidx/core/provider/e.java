package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.adjust.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator f15074a = new c();

    private interface a {
        Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        void close();
    }

    private static class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final ContentProviderClient f15075a;

        b(Context context, Uri uri) {
            this.f15075a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f15075a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e10) {
                Log.w("FontsProvider", "Unable to query the content provider", e10);
                return null;
            }
        }

        public void close() {
            ContentProviderClient contentProviderClient = this.f15075a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    private static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        private final ContentProviderClient f15076a;

        c(Context context, Uri uri) {
            this.f15076a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f15076a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e10) {
                Log.w("FontsProvider", "Unable to query the content provider", e10);
                return null;
            }
        }

        public void close() {
            ContentProviderClient contentProviderClient = this.f15076a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    private static List b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    private static boolean c(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!Arrays.equals((byte[]) list.get(i10), (byte[]) list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    private static List d(FontRequest fontRequest, Resources resources) {
        if (fontRequest.getCertificates() != null) {
            return fontRequest.getCertificates();
        }
        return FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    static FontsContractCompat.FontFamilyResult e(Context context, FontRequest fontRequest, CancellationSignal cancellationSignal) {
        ProviderInfo f10 = f(context.getPackageManager(), fontRequest, context.getResources());
        if (f10 == null) {
            return FontsContractCompat.FontFamilyResult.create(1, (FontsContractCompat.FontInfo[]) null);
        }
        return FontsContractCompat.FontFamilyResult.create(0, h(context, fontRequest, f10.authority, cancellationSignal));
    }

    static ProviderInfo f(PackageManager packageManager, FontRequest fontRequest, Resources resources) {
        String providerAuthority = fontRequest.getProviderAuthority();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        } else if (resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
            List b10 = b(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(b10, f15074a);
            List d10 = d(fontRequest, resources);
            for (int i10 = 0; i10 < d10.size(); i10++) {
                ArrayList arrayList = new ArrayList((Collection) d10.get(i10));
                Collections.sort(arrayList, f15074a);
                if (c(b10, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            byte b11 = bArr2[i10];
            if (b10 != b11) {
                return b10 - b11;
            }
        }
        return 0;
    }

    static FontsContractCompat.FontInfo[] h(Context context, FontRequest fontRequest, String str, CancellationSignal cancellationSignal) {
        int i10;
        int i11;
        ArrayList arrayList;
        Uri uri;
        int i12;
        boolean z10;
        String str2 = str;
        ArrayList arrayList2 = new ArrayList();
        Uri build = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(str2).build();
        Uri build2 = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(str2).appendPath("file").build();
        a a10 = d.a(context, build);
        Cursor cursor = null;
        try {
            Cursor a11 = a10.a(build, new String[]{"_id", FontsContractCompat.Columns.FILE_ID, FontsContractCompat.Columns.TTC_INDEX, FontsContractCompat.Columns.VARIATION_SETTINGS, FontsContractCompat.Columns.WEIGHT, FontsContractCompat.Columns.ITALIC, FontsContractCompat.Columns.RESULT_CODE}, "query = ?", new String[]{fontRequest.getQuery()}, (String) null, cancellationSignal);
            if (a11 != null && a11.getCount() > 0) {
                int columnIndex = a11.getColumnIndex(FontsContractCompat.Columns.RESULT_CODE);
                ArrayList arrayList3 = new ArrayList();
                int columnIndex2 = a11.getColumnIndex("_id");
                int columnIndex3 = a11.getColumnIndex(FontsContractCompat.Columns.FILE_ID);
                int columnIndex4 = a11.getColumnIndex(FontsContractCompat.Columns.TTC_INDEX);
                int columnIndex5 = a11.getColumnIndex(FontsContractCompat.Columns.WEIGHT);
                int columnIndex6 = a11.getColumnIndex(FontsContractCompat.Columns.ITALIC);
                while (a11.moveToNext()) {
                    if (columnIndex != -1) {
                        i10 = a11.getInt(columnIndex);
                    } else {
                        i10 = 0;
                    }
                    if (columnIndex4 != -1) {
                        i11 = a11.getInt(columnIndex4);
                    } else {
                        i11 = 0;
                    }
                    if (columnIndex3 == -1) {
                        arrayList = arrayList3;
                        uri = ContentUris.withAppendedId(build, a11.getLong(columnIndex2));
                    } else {
                        arrayList = arrayList3;
                        uri = ContentUris.withAppendedId(build2, a11.getLong(columnIndex3));
                    }
                    if (columnIndex5 != -1) {
                        i12 = a11.getInt(columnIndex5);
                    } else {
                        i12 = Constants.MINIMAL_ERROR_STATUS_CODE;
                    }
                    if (columnIndex6 != -1) {
                        z10 = true;
                        if (a11.getInt(columnIndex6) == 1) {
                            FontsContractCompat.FontInfo create = FontsContractCompat.FontInfo.create(uri, i11, i12, z10, i10);
                            arrayList3 = arrayList;
                            arrayList3.add(create);
                        }
                    }
                    z10 = false;
                    FontsContractCompat.FontInfo create2 = FontsContractCompat.FontInfo.create(uri, i11, i12, z10, i10);
                    arrayList3 = arrayList;
                    arrayList3.add(create2);
                }
                arrayList2 = arrayList3;
            }
            if (a11 != null) {
                a11.close();
            }
            a10.close();
            return (FontsContractCompat.FontInfo[]) arrayList2.toArray(new FontsContractCompat.FontInfo[0]);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            a10.close();
            throw th;
        }
    }
}
