package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class VectorEnabledTintResources extends p {
    public static final int MAX_SDK_WHERE_REQUIRED = 20;
    private static boolean sCompatVectorFromResourcesEnabled;
    private final WeakReference<Context> mContextRef;

    public VectorEnabledTintResources(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.mContextRef = new WeakReference<>(context);
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return sCompatVectorFromResourcesEnabled;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean z10) {
        sCompatVectorFromResourcesEnabled = z10;
    }

    public static boolean shouldBeUsed() {
        isCompatVectorFromResourcesEnabled();
        return false;
    }

    public /* bridge */ /* synthetic */ XmlResourceParser getAnimation(int i10) throws Resources.NotFoundException {
        return super.getAnimation(i10);
    }

    public /* bridge */ /* synthetic */ boolean getBoolean(int i10) throws Resources.NotFoundException {
        return super.getBoolean(i10);
    }

    public /* bridge */ /* synthetic */ int getColor(int i10) throws Resources.NotFoundException {
        return super.getColor(i10);
    }

    public /* bridge */ /* synthetic */ ColorStateList getColorStateList(int i10) throws Resources.NotFoundException {
        return super.getColorStateList(i10);
    }

    public /* bridge */ /* synthetic */ Configuration getConfiguration() {
        return super.getConfiguration();
    }

    public /* bridge */ /* synthetic */ float getDimension(int i10) throws Resources.NotFoundException {
        return super.getDimension(i10);
    }

    public /* bridge */ /* synthetic */ int getDimensionPixelOffset(int i10) throws Resources.NotFoundException {
        return super.getDimensionPixelOffset(i10);
    }

    public /* bridge */ /* synthetic */ int getDimensionPixelSize(int i10) throws Resources.NotFoundException {
        return super.getDimensionPixelSize(i10);
    }

    public /* bridge */ /* synthetic */ DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    @RequiresApi(21)
    public /* bridge */ /* synthetic */ Drawable getDrawable(int i10, Resources.Theme theme) throws Resources.NotFoundException {
        return super.getDrawable(i10, theme);
    }

    @RequiresApi(15)
    public /* bridge */ /* synthetic */ Drawable getDrawableForDensity(int i10, int i11) throws Resources.NotFoundException {
        return super.getDrawableForDensity(i10, i11);
    }

    public /* bridge */ /* synthetic */ float getFraction(int i10, int i11, int i12) {
        return super.getFraction(i10, i11, i12);
    }

    public /* bridge */ /* synthetic */ int getIdentifier(String str, String str2, String str3) {
        return super.getIdentifier(str, str2, str3);
    }

    public /* bridge */ /* synthetic */ int[] getIntArray(int i10) throws Resources.NotFoundException {
        return super.getIntArray(i10);
    }

    public /* bridge */ /* synthetic */ int getInteger(int i10) throws Resources.NotFoundException {
        return super.getInteger(i10);
    }

    public /* bridge */ /* synthetic */ XmlResourceParser getLayout(int i10) throws Resources.NotFoundException {
        return super.getLayout(i10);
    }

    public /* bridge */ /* synthetic */ Movie getMovie(int i10) throws Resources.NotFoundException {
        return super.getMovie(i10);
    }

    public /* bridge */ /* synthetic */ String getQuantityString(int i10, int i11) throws Resources.NotFoundException {
        return super.getQuantityString(i10, i11);
    }

    public /* bridge */ /* synthetic */ CharSequence getQuantityText(int i10, int i11) throws Resources.NotFoundException {
        return super.getQuantityText(i10, i11);
    }

    public /* bridge */ /* synthetic */ String getResourceEntryName(int i10) throws Resources.NotFoundException {
        return super.getResourceEntryName(i10);
    }

    public /* bridge */ /* synthetic */ String getResourceName(int i10) throws Resources.NotFoundException {
        return super.getResourceName(i10);
    }

    public /* bridge */ /* synthetic */ String getResourcePackageName(int i10) throws Resources.NotFoundException {
        return super.getResourcePackageName(i10);
    }

    public /* bridge */ /* synthetic */ String getResourceTypeName(int i10) throws Resources.NotFoundException {
        return super.getResourceTypeName(i10);
    }

    public /* bridge */ /* synthetic */ String getString(int i10) throws Resources.NotFoundException {
        return super.getString(i10);
    }

    public /* bridge */ /* synthetic */ String[] getStringArray(int i10) throws Resources.NotFoundException {
        return super.getStringArray(i10);
    }

    public /* bridge */ /* synthetic */ CharSequence getText(int i10) throws Resources.NotFoundException {
        return super.getText(i10);
    }

    public /* bridge */ /* synthetic */ CharSequence[] getTextArray(int i10) throws Resources.NotFoundException {
        return super.getTextArray(i10);
    }

    public /* bridge */ /* synthetic */ void getValue(int i10, TypedValue typedValue, boolean z10) throws Resources.NotFoundException {
        super.getValue(i10, typedValue, z10);
    }

    @RequiresApi(15)
    public /* bridge */ /* synthetic */ void getValueForDensity(int i10, int i11, TypedValue typedValue, boolean z10) throws Resources.NotFoundException {
        super.getValueForDensity(i10, i11, typedValue, z10);
    }

    public /* bridge */ /* synthetic */ XmlResourceParser getXml(int i10) throws Resources.NotFoundException {
        return super.getXml(i10);
    }

    public /* bridge */ /* synthetic */ TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return super.obtainAttributes(attributeSet, iArr);
    }

    public /* bridge */ /* synthetic */ TypedArray obtainTypedArray(int i10) throws Resources.NotFoundException {
        return super.obtainTypedArray(i10);
    }

    public /* bridge */ /* synthetic */ InputStream openRawResource(int i10) throws Resources.NotFoundException {
        return super.openRawResource(i10);
    }

    public /* bridge */ /* synthetic */ AssetFileDescriptor openRawResourceFd(int i10) throws Resources.NotFoundException {
        return super.openRawResourceFd(i10);
    }

    public /* bridge */ /* synthetic */ void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        super.parseBundleExtra(str, attributeSet, bundle);
    }

    public /* bridge */ /* synthetic */ void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        super.parseBundleExtras(xmlResourceParser, bundle);
    }

    public /* bridge */ /* synthetic */ void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }

    public Drawable getDrawable(int i10) throws Resources.NotFoundException {
        Context context = this.mContextRef.get();
        if (context != null) {
            return ResourceManagerInternal.get().onDrawableLoadedFromResources(context, this, i10);
        }
        return getDrawableCanonical(i10);
    }

    @RequiresApi(21)
    public /* bridge */ /* synthetic */ Drawable getDrawableForDensity(int i10, int i11, Resources.Theme theme) {
        return super.getDrawableForDensity(i10, i11, theme);
    }

    public /* bridge */ /* synthetic */ String getQuantityString(int i10, int i11, Object[] objArr) throws Resources.NotFoundException {
        return super.getQuantityString(i10, i11, objArr);
    }

    public /* bridge */ /* synthetic */ String getString(int i10, Object[] objArr) throws Resources.NotFoundException {
        return super.getString(i10, objArr);
    }

    public /* bridge */ /* synthetic */ CharSequence getText(int i10, CharSequence charSequence) {
        return super.getText(i10, charSequence);
    }

    public /* bridge */ /* synthetic */ void getValue(String str, TypedValue typedValue, boolean z10) throws Resources.NotFoundException {
        super.getValue(str, typedValue, z10);
    }

    public /* bridge */ /* synthetic */ InputStream openRawResource(int i10, TypedValue typedValue) throws Resources.NotFoundException {
        return super.openRawResource(i10, typedValue);
    }
}
