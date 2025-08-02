package q0;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.c;
import com.airbnb.lottie.n0;
import java.io.IOException;
import java.util.Map;
import y0.f;
import y0.l;

public class b {

    /* renamed from: d  reason: collision with root package name */
    private static final Object f23178d = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Context f23179a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23180b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f23181c;

    public b(Drawable.Callback callback, String str, c cVar, Map map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.f23180b = str;
        } else {
            this.f23180b = str + '/';
        }
        this.f23181c = map;
        d(cVar);
        if (!(callback instanceof View)) {
            this.f23179a = null;
        } else {
            this.f23179a = ((View) callback).getContext().getApplicationContext();
        }
    }

    private Bitmap c(String str, Bitmap bitmap) {
        synchronized (f23178d) {
            ((n0) this.f23181c.get(str)).g(bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        n0 n0Var = (n0) this.f23181c.get(str);
        if (n0Var == null) {
            return null;
        }
        Bitmap b10 = n0Var.b();
        if (b10 != null) {
            return b10;
        }
        Context context = this.f23179a;
        if (context == null) {
            return null;
        }
        String c10 = n0Var.c();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!c10.startsWith("data:") || c10.indexOf("base64,") <= 0) {
            try {
                if (!TextUtils.isEmpty(this.f23180b)) {
                    AssetManager assets = context.getAssets();
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(assets.open(this.f23180b + c10), (Rect) null, options);
                        if (decodeStream != null) {
                            return c(str, l.m(decodeStream, n0Var.f(), n0Var.d()));
                        }
                        f.c("Decoded image `" + str + "` is null.");
                        return null;
                    } catch (IllegalArgumentException e10) {
                        f.d("Unable to decode image `" + str + "`.", e10);
                        return null;
                    }
                } else {
                    throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                }
            } catch (IOException e11) {
                f.d("Unable to open asset.", e11);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(c10.substring(c10.indexOf(44) + 1), 0);
                return c(str, l.m(BitmapFactory.decodeByteArray(decode, 0, decode.length, options), n0Var.f(), n0Var.d()));
            } catch (IllegalArgumentException e12) {
                f.d("data URL did not have correct base64 format.", e12);
                return null;
            }
        }
    }

    public boolean b(Context context) {
        if (context != null) {
            if (this.f23179a instanceof Application) {
                context = context.getApplicationContext();
            }
            if (context == this.f23179a) {
                return true;
            }
            return false;
        } else if (this.f23179a == null) {
            return true;
        } else {
            return false;
        }
    }

    public void d(c cVar) {
    }
}
