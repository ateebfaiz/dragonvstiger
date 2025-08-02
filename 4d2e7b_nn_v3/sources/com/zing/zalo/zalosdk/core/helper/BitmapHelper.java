package com.zing.zalo.zalosdk.core.helper;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class BitmapHelper {
    public static Bitmap b64ToImage(String str) {
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    static int calculateInSampleSize(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        if (i12 <= i11 && i13 <= i10) {
            return 1;
        }
        int round = Math.round(((float) i12) / ((float) i11));
        int round2 = Math.round(((float) i13) / ((float) i10));
        if (round >= round2) {
            round = round2;
        }
        while (((float) (i13 * i12)) / ((float) (round * round)) > ((float) (i10 * i11 * 2))) {
            round++;
        }
        return round;
    }

    public static void deleteFilePhoto(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    public static Bitmap getBitmapReSampleSize(byte[] bArr, int i10) {
        double d10;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i11 = 1;
            while (true) {
                d10 = (double) i10;
                if (((double) (options.outWidth * options.outHeight)) * (1.0d / Math.pow((double) i11, 2.0d)) <= d10) {
                    break;
                }
                i11++;
            }
            if (i11 <= 1) {
                return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i11 - 1;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options2);
            double d11 = (double) options2.outWidth;
            double d12 = (double) options2.outHeight;
            double sqrt = Math.sqrt(d10 / (d11 / d12));
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, (int) ((sqrt / d12) * d11), (int) sqrt, true);
            decodeByteArray.recycle();
            return createScaledBitmap;
        } catch (Exception unused) {
            return null;
        }
    }

    public static int getBitmapSize(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static Bitmap getDownsampledBitmap(Bitmap bitmap, int i10) {
        if (bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0 || i10 < 16) {
            return bitmap;
        }
        int i11 = 0;
        for (int bitmapSize = getBitmapSize(bitmap); bitmapSize > i10; bitmapSize /= 4) {
            i11++;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() >> i11, bitmap.getHeight() >> i11, true);
        if (createScaledBitmap == null) {
            return null;
        }
        if (getBitmapSize(createScaledBitmap) > i10) {
            return Bitmap.createScaledBitmap(createScaledBitmap, createScaledBitmap.getWidth() >> 1, createScaledBitmap.getHeight() >> 1, true);
        }
        return createScaledBitmap;
    }

    public static String getRealPathFromURI(Context context, Uri uri) {
        Cursor query = context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return uri.getPath();
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex("_data"));
        query.close();
        return string;
    }

    public static Bitmap handleSamplingAndRotationBitmap(Context context, Uri uri, int i10, int i11, String str) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        BitmapFactory.decodeStream(openInputStream, (Rect) null, options);
        openInputStream.close();
        options.inSampleSize = calculateInSampleSize(options, i10, i11);
        options.inJustDecodeBounds = false;
        return rotateImageIfRequired(BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri), (Rect) null, options), str);
    }

    public static Bitmap rotateImage(Bitmap bitmap, float f10) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f10);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e10) {
            e10.printStackTrace();
            return null;
        }
    }

    static Bitmap rotateImageIfRequired(Bitmap bitmap, String str) throws IOException {
        int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 3) {
            return rotateImage(bitmap, 180);
        }
        if (attributeInt == 6) {
            return rotateImage(bitmap, 90);
        }
        if (attributeInt != 8) {
            return bitmap;
        }
        return rotateImage(bitmap, 270);
    }

    public static byte[] toByteArray(Bitmap bitmap) {
        if (bitmap == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static Bitmap rotateImage(Bitmap bitmap, int i10) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i10);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return createBitmap;
    }
}
