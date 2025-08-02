package o5;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InputStream;
import z2.a;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f23018a = new c();

    private c() {
    }

    public static final int a(InputStream inputStream) {
        if (inputStream == null) {
            a.b("HeifExifUtil", "Trying to read Heif Exif from null inputStream -> ignoring");
            return 0;
        }
        try {
            return new ExifInterface(inputStream).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        } catch (IOException e10) {
            a.e("HeifExifUtil", "Failed reading Heif Exif orientation -> ignoring", e10);
            return 0;
        }
    }
}
