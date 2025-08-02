package com.reactnative.ivpusic.imagepicker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.os.Environment;
import android.util.Log;
import android.util.Pair;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.reactnativecommunity.clipboard.ClipboardModule;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

class a {
    a() {
    }

    private int a(int i10, int i11, int i12, int i13) {
        int i14 = 1;
        if (i10 > i12 || i11 > i13) {
            int i15 = i10 / 2;
            int i16 = i11 / 2;
            while (i15 / i14 >= i12 && i16 / i14 >= i13) {
                i14 *= 2;
            }
        }
        return i14;
    }

    private Pair b(int i10, int i11, int i12, int i13) {
        if (i10 > i12) {
            i11 = (int) (((float) i11) * (((float) i12) / ((float) i10)));
            i10 = i12;
        }
        if (i11 > i13) {
            i10 = (int) (((float) i10) * (((float) i13) / ((float) i11)));
        } else {
            i13 = i11;
        }
        return Pair.create(Integer.valueOf(i10), Integer.valueOf(i13));
    }

    private boolean f(String str) {
        if (str.equals(String.valueOf(1)) || str.equals(String.valueOf(0))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public File c(Context context, ReadableMap readableMap, String str, BitmapFactory.Options options) {
        Integer num;
        Integer num2;
        boolean z10;
        boolean z11;
        boolean z12;
        int i10;
        ReadableMap readableMap2 = readableMap;
        BitmapFactory.Options options2 = options;
        Double d10 = null;
        if (readableMap2.hasKey("compressImageMaxWidth")) {
            num = Integer.valueOf(readableMap2.getInt("compressImageMaxWidth"));
        } else {
            num = null;
        }
        if (readableMap2.hasKey("compressImageMaxHeight")) {
            num2 = Integer.valueOf(readableMap2.getInt("compressImageMaxHeight"));
        } else {
            num2 = null;
        }
        if (readableMap2.hasKey("compressImageQuality")) {
            d10 = Double.valueOf(readableMap2.getDouble("compressImageQuality"));
        }
        boolean z13 = true;
        if (d10 == null || d10.doubleValue() == 1.0d) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (num == null || num.intValue() >= options2.outWidth) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (num2 == null || num2.intValue() >= options2.outHeight) {
            z12 = true;
        } else {
            z12 = false;
        }
        List asList = Arrays.asList(new String[]{ClipboardModule.MIMETYPE_JPEG, ClipboardModule.MIMETYPE_JPG, ClipboardModule.MIMETYPE_PNG, "image/gif", "image/tiff"});
        String str2 = options2.outMimeType;
        if (str2 == null || !asList.contains(str2.toLowerCase())) {
            z13 = false;
        }
        if (!z10 || !z11 || !z12 || !z13) {
            String str3 = str;
            Log.d("image-crop-picker", "Image compression activated");
            if (d10 != null) {
                i10 = (int) (d10.doubleValue() * 100.0d);
            } else {
                i10 = 100;
            }
            int i11 = i10;
            Log.d("image-crop-picker", "Compressing image with quality " + i11);
            if (num == null) {
                num = Integer.valueOf(options2.outWidth);
            }
            if (num2 == null) {
                num2 = Integer.valueOf(options2.outHeight);
            }
            return e(context, str, options2.outWidth, options2.outHeight, num.intValue(), num2.intValue(), i11);
        }
        Log.d("image-crop-picker", "Skipping image compression");
        return new File(str);
    }

    /* access modifiers changed from: package-private */
    public synchronized void d(Activity activity, ReadableMap readableMap, String str, String str2, Promise promise) {
        promise.resolve(str);
    }

    /* access modifiers changed from: package-private */
    public File e(Context context, String str, int i10, int i11, int i12, int i13, int i14) {
        Bitmap bitmap;
        Pair b10 = b(i10, i11, i12, i13);
        int intValue = ((Integer) b10.first).intValue();
        int intValue2 = ((Integer) b10.second).intValue();
        if (i10 > i12 || i11 > i13) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = a(i10, i11, intValue, intValue2);
            bitmap = BitmapFactory.decodeFile(str, options);
        } else {
            bitmap = BitmapFactory.decodeFile(str);
        }
        String attribute = new ExifInterface(str).getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, intValue, intValue2, true);
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (!externalFilesDir.exists()) {
            Log.d("image-crop-picker", "Pictures Directory is not existing. Will create this directory.");
            externalFilesDir.mkdirs();
        }
        File file = new File(externalFilesDir, UUID.randomUUID() + ".jpg");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, i14, bufferedOutputStream);
        if (f(attribute)) {
            ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
            exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, attribute);
            exifInterface.saveAttributes();
        }
        bufferedOutputStream.close();
        createScaledBitmap.recycle();
        return file;
    }
}
