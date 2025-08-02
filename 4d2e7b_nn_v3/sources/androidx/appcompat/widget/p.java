package androidx.appcompat.widget;

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
import androidx.appcompat.resources.Compatibility;
import androidx.core.content.res.ResourcesCompat;
import java.io.InputStream;

abstract class p extends Resources {
    private final Resources mResources;

    public p(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mResources = resources;
    }

    public XmlResourceParser getAnimation(int i10) {
        return this.mResources.getAnimation(i10);
    }

    public boolean getBoolean(int i10) {
        return this.mResources.getBoolean(i10);
    }

    public int getColor(int i10) {
        return this.mResources.getColor(i10);
    }

    public ColorStateList getColorStateList(int i10) {
        return this.mResources.getColorStateList(i10);
    }

    public Configuration getConfiguration() {
        return this.mResources.getConfiguration();
    }

    public float getDimension(int i10) {
        return this.mResources.getDimension(i10);
    }

    public int getDimensionPixelOffset(int i10) {
        return this.mResources.getDimensionPixelOffset(i10);
    }

    public int getDimensionPixelSize(int i10) {
        return this.mResources.getDimensionPixelSize(i10);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.mResources.getDisplayMetrics();
    }

    public Drawable getDrawable(int i10, Resources.Theme theme) {
        return ResourcesCompat.getDrawable(this.mResources, i10, theme);
    }

    /* access modifiers changed from: package-private */
    public final Drawable getDrawableCanonical(int i10) throws Resources.NotFoundException {
        return super.getDrawable(i10);
    }

    public Drawable getDrawableForDensity(int i10, int i11) {
        return ResourcesCompat.getDrawableForDensity(this.mResources, i10, i11, (Resources.Theme) null);
    }

    public float getFraction(int i10, int i11, int i12) {
        return this.mResources.getFraction(i10, i11, i12);
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.mResources.getIdentifier(str, str2, str3);
    }

    public int[] getIntArray(int i10) {
        return this.mResources.getIntArray(i10);
    }

    public int getInteger(int i10) {
        return this.mResources.getInteger(i10);
    }

    public XmlResourceParser getLayout(int i10) {
        return this.mResources.getLayout(i10);
    }

    public Movie getMovie(int i10) {
        return this.mResources.getMovie(i10);
    }

    public String getQuantityString(int i10, int i11, Object... objArr) {
        return this.mResources.getQuantityString(i10, i11, objArr);
    }

    public CharSequence getQuantityText(int i10, int i11) {
        return this.mResources.getQuantityText(i10, i11);
    }

    public String getResourceEntryName(int i10) {
        return this.mResources.getResourceEntryName(i10);
    }

    public String getResourceName(int i10) {
        return this.mResources.getResourceName(i10);
    }

    public String getResourcePackageName(int i10) {
        return this.mResources.getResourcePackageName(i10);
    }

    public String getResourceTypeName(int i10) {
        return this.mResources.getResourceTypeName(i10);
    }

    public String getString(int i10) {
        return this.mResources.getString(i10);
    }

    public String[] getStringArray(int i10) {
        return this.mResources.getStringArray(i10);
    }

    public CharSequence getText(int i10) {
        return this.mResources.getText(i10);
    }

    public CharSequence[] getTextArray(int i10) {
        return this.mResources.getTextArray(i10);
    }

    public void getValue(int i10, TypedValue typedValue, boolean z10) {
        this.mResources.getValue(i10, typedValue, z10);
    }

    public void getValueForDensity(int i10, int i11, TypedValue typedValue, boolean z10) {
        Compatibility.Api15Impl.getValueForDensity(this.mResources, i10, i11, typedValue, z10);
    }

    public XmlResourceParser getXml(int i10) {
        return this.mResources.getXml(i10);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.mResources.obtainAttributes(attributeSet, iArr);
    }

    public TypedArray obtainTypedArray(int i10) {
        return this.mResources.obtainTypedArray(i10);
    }

    public InputStream openRawResource(int i10) {
        return this.mResources.openRawResource(i10);
    }

    public AssetFileDescriptor openRawResourceFd(int i10) {
        return this.mResources.openRawResourceFd(i10);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        this.mResources.parseBundleExtra(str, attributeSet, bundle);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        this.mResources.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.mResources;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    public Drawable getDrawableForDensity(int i10, int i11, Resources.Theme theme) {
        return ResourcesCompat.getDrawableForDensity(this.mResources, i10, i11, theme);
    }

    public String getQuantityString(int i10, int i11) {
        return this.mResources.getQuantityString(i10, i11);
    }

    public String getString(int i10, Object... objArr) {
        return this.mResources.getString(i10, objArr);
    }

    public CharSequence getText(int i10, CharSequence charSequence) {
        return this.mResources.getText(i10, charSequence);
    }

    public void getValue(String str, TypedValue typedValue, boolean z10) {
        this.mResources.getValue(str, typedValue, z10);
    }

    public InputStream openRawResource(int i10, TypedValue typedValue) {
        return this.mResources.openRawResource(i10, typedValue);
    }
}
