package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import vb.n;

@SuppressLint({"ClassVerificationFailure"})
public final class ImageDecoderKt {
    @RequiresApi(28)
    public static final Bitmap decodeBitmap(ImageDecoder.Source source, n nVar) {
        return ImageDecoder.decodeBitmap(source, v.a(new ImageDecoderKt$decodeBitmap$1(nVar)));
    }

    @RequiresApi(28)
    public static final Drawable decodeDrawable(ImageDecoder.Source source, n nVar) {
        return ImageDecoder.decodeDrawable(source, v.a(new ImageDecoderKt$decodeDrawable$1(nVar)));
    }
}
