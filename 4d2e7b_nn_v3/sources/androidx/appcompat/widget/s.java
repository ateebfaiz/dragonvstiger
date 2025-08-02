package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class s extends p {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f14373a;

    public s(Context context, Resources resources) {
        super(resources);
        this.f14373a = new WeakReference(context);
    }

    public Drawable getDrawable(int i10) {
        Drawable drawableCanonical = getDrawableCanonical(i10);
        Context context = (Context) this.f14373a.get();
        if (!(drawableCanonical == null || context == null)) {
            ResourceManagerInternal.get().tintDrawableUsingColorFilter(context, i10, drawableCanonical);
        }
        return drawableCanonical;
    }
}
