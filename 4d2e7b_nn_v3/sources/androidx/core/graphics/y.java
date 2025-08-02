package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class y extends a0 {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi21Impl";
    private static Method sAddFontWeightStyle;
    private static Method sCreateFromFamiliesWithDefault;
    private static Class<?> sFontFamily;
    private static Constructor<?> sFontFamilyCtor;
    private static boolean sHasInitBeenCalled;

    y() {
    }

    private static Typeface createFromFamiliesWithDefault(Object obj) {
        h();
        try {
            Object newInstance = Array.newInstance(sFontFamily, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) sCreateFromFamiliesWithDefault.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static boolean f(Object obj, String str, int i10, boolean z10) {
        h();
        try {
            return ((Boolean) sAddFontWeightStyle.invoke(obj, new Object[]{str, Integer.valueOf(i10), Boolean.valueOf(z10)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    private File g(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void h() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!sHasInitBeenCalled) {
            sHasInitBeenCalled = true;
            Constructor<?> constructor = null;
            try {
                cls = Class.forName(FONT_FAMILY_CLASS);
                Constructor<?> constructor2 = cls.getConstructor((Class[]) null);
                method = cls.getMethod(ADD_FONT_WEIGHT_STYLE_METHOD, new Class[]{String.class, Integer.TYPE, Boolean.TYPE});
                method2 = Typeface.class.getMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(cls, 1).getClass()});
                constructor = constructor2;
            } catch (ClassNotFoundException | NoSuchMethodException e10) {
                Log.e(TAG, e10.getClass().getName(), e10);
                method2 = null;
                cls = null;
                method = null;
            }
            sFontFamilyCtor = constructor;
            sFontFamily = cls;
            sAddFontWeightStyle = method;
            sCreateFromFamiliesWithDefault = method2;
        }
    }

    private static Object newFamily() {
        h();
        try {
            return sFontFamilyCtor.newInstance((Object[]) null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i10) {
        Object newFamily = newFamily();
        FontResourcesParserCompat.FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
        int length = entries.length;
        int i11 = 0;
        while (i11 < length) {
            FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = entries[i11];
            File tempFile = TypefaceCompatUtil.getTempFile(context);
            if (tempFile == null) {
                return null;
            }
            try {
                if (!TypefaceCompatUtil.copyToFile(tempFile, resources, fontFileResourceEntry.getResourceId())) {
                    tempFile.delete();
                    return null;
                } else if (!f(newFamily, tempFile.getPath(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic())) {
                    return null;
                } else {
                    tempFile.delete();
                    i11++;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                tempFile.delete();
            }
        }
        return createFromFamiliesWithDefault(newFamily);
    }

    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i10) {
        ParcelFileDescriptor openFileDescriptor;
        FileInputStream fileInputStream;
        if (fontInfoArr.length < 1) {
            return null;
        }
        FontsContractCompat.FontInfo findBestInfo = findBestInfo(fontInfoArr, i10);
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(findBestInfo.getUri(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            File g10 = g(openFileDescriptor);
            if (g10 != null) {
                if (g10.canRead()) {
                    Typeface createFromFile = Typeface.createFromFile(g10);
                    openFileDescriptor.close();
                    return createFromFile;
                }
            }
            fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            Typeface createFromInputStream = super.createFromInputStream(context, fileInputStream);
            fileInputStream.close();
            openFileDescriptor.close();
            return createFromInputStream;
        } catch (IOException unused) {
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
        throw th;
    }

    /* access modifiers changed from: package-private */
    public Typeface createWeightStyle(Context context, Typeface typeface, int i10, boolean z10) {
        Typeface typeface2;
        try {
            typeface2 = c0.b(typeface, i10, z10);
        } catch (RuntimeException unused) {
            typeface2 = null;
        }
        if (typeface2 == null) {
            return super.createWeightStyle(context, typeface, i10, z10);
        }
        return typeface2;
    }
}
