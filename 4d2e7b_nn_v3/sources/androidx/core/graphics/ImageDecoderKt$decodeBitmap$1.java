package androidx.core.graphics;

import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import vb.n;

public final class ImageDecoderKt$decodeBitmap$1 implements ImageDecoder$OnHeaderDecodedListener {
    final /* synthetic */ n $action;

    public ImageDecoderKt$decodeBitmap$1(n nVar) {
        this.$action = nVar;
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        this.$action.e(imageDecoder, imageInfo, source);
    }
}
