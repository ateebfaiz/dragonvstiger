package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.adjust.sdk.Constants;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

abstract class a0 {
    private static final int INVALID_KEY = 0;
    private static final String TAG = "TypefaceCompatBaseImpl";
    @SuppressLint({"BanConcurrentHashMap"})
    private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> mFontFamilies = new ConcurrentHashMap<>();

    class a implements c {
        a() {
        }

        /* renamed from: c */
        public int a(FontsContractCompat.FontInfo fontInfo) {
            return fontInfo.getWeight();
        }

        /* renamed from: d */
        public boolean b(FontsContractCompat.FontInfo fontInfo) {
            return fontInfo.isItalic();
        }
    }

    class b implements c {
        b() {
        }

        /* renamed from: c */
        public int a(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.getWeight();
        }

        /* renamed from: d */
        public boolean b(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.isItalic();
        }
    }

    private interface c {
        int a(Object obj);

        boolean b(Object obj);
    }

    a0() {
    }

    private void a(Typeface typeface, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry) {
        long e10 = e(typeface);
        if (e10 != 0) {
            this.mFontFamilies.put(Long.valueOf(e10), fontFamilyFilesResourceEntry);
        }
    }

    private FontResourcesParserCompat.FontFileResourceEntry b(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i10, boolean z10) {
        return (FontResourcesParserCompat.FontFileResourceEntry) d(fontFamilyFilesResourceEntry.getEntries(), i10, z10, new b());
    }

    private static Object c(Object[] objArr, int i10, c cVar) {
        int i11;
        boolean z10;
        if ((i10 & 1) == 0) {
            i11 = Constants.MINIMAL_ERROR_STATUS_CODE;
        } else {
            i11 = 700;
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        return d(objArr, i11, z10, cVar);
    }

    private static Object d(Object[] objArr, int i10, boolean z10, c cVar) {
        int i11;
        Object obj = null;
        int i12 = Integer.MAX_VALUE;
        for (Object obj2 : objArr) {
            int abs = Math.abs(cVar.a(obj2) - i10) * 2;
            if (cVar.b(obj2) == z10) {
                i11 = 0;
            } else {
                i11 = 1;
            }
            int i13 = abs + i11;
            if (obj == null || i12 > i13) {
                obj = obj2;
                i12 = i13;
            }
        }
        return obj;
    }

    private static long e(Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (NoSuchFieldException e10) {
            Log.e(TAG, "Could not retrieve font from family.", e10);
            return 0;
        } catch (IllegalAccessException e11) {
            Log.e(TAG, "Could not retrieve font from family.", e11);
            return 0;
        }
    }

    public abstract Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i10);

    /* access modifiers changed from: package-private */
    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i10, boolean z10) {
        FontResourcesParserCompat.FontFileResourceEntry b10 = b(fontFamilyFilesResourceEntry, i10, z10);
        if (b10 == null) {
            return null;
        }
        Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, b10.getResourceId(), b10.getFileName(), 0, 0);
        a(createFromResourcesFontFile, fontFamilyFilesResourceEntry);
        return createFromResourcesFontFile;
    }

    public abstract Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i10);

    /* access modifiers changed from: protected */
    public Typeface createFromInputStream(Context context, InputStream inputStream) {
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.copyToFile(tempFile, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(tempFile.getPath());
            tempFile.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i10, String str, int i11) {
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.copyToFile(tempFile, resources, i10)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(tempFile.getPath());
            tempFile.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    /* access modifiers changed from: package-private */
    public Typeface createWeightStyle(Context context, Typeface typeface, int i10, boolean z10) {
        Typeface typeface2;
        try {
            typeface2 = b0.a(this, context, typeface, i10, z10);
        } catch (RuntimeException unused) {
            typeface2 = null;
        }
        if (typeface2 == null) {
            return typeface;
        }
        return typeface2;
    }

    /* access modifiers changed from: protected */
    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArr, int i10) {
        return (FontsContractCompat.FontInfo) c(fontInfoArr, i10, new a());
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public FontResourcesParserCompat.FontFamilyFilesResourceEntry getFontFamily(Typeface typeface) {
        long e10 = e(typeface);
        if (e10 == 0) {
            return null;
        }
        return this.mFontFamilies.get(Long.valueOf(e10));
    }
}
