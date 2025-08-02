package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class AppCompatDrawableManager {
    private static final boolean DEBUG = false;
    /* access modifiers changed from: private */
    public static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    private static AppCompatDrawableManager INSTANCE = null;
    private static final String TAG = "AppCompatDrawableManag";
    private ResourceManagerInternal mResourceManager;

    class a implements ResourceManagerInternal.ResourceManagerHooks {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f14183a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b  reason: collision with root package name */
        private final int[] f14184b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c  reason: collision with root package name */
        private final int[] f14185c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};

        /* renamed from: d  reason: collision with root package name */
        private final int[] f14186d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e  reason: collision with root package name */
        private final int[] f14187e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

        /* renamed from: f  reason: collision with root package name */
        private final int[] f14188f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

        a() {
        }

        private boolean a(int[] iArr, int i10) {
            for (int i11 : iArr) {
                if (i11 == i10) {
                    return true;
                }
            }
            return false;
        }

        private ColorStateList b(Context context) {
            return c(context, 0);
        }

        private ColorStateList c(Context context, int i10) {
            int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlHighlight);
            int disabledThemeAttrColor = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorButtonNormal);
            return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.PRESSED_STATE_SET, ThemeUtils.FOCUSED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{disabledThemeAttrColor, ColorUtils.compositeColors(themeAttrColor, i10), ColorUtils.compositeColors(themeAttrColor, i10), i10});
        }

        private ColorStateList d(Context context) {
            return c(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorAccent));
        }

        private ColorStateList e(Context context) {
            return c(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorButtonNormal));
        }

        private ColorStateList f(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorSwitchThumbNormal);
            if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
                iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
                iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                iArr2[2] = ThemeUtils.getThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
            } else {
                int[] iArr3 = ThemeUtils.DISABLED_STATE_SET;
                iArr[0] = iArr3;
                iArr2[0] = themeAttrColorStateList.getColorForState(iArr3, 0);
                iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                iArr2[2] = themeAttrColorStateList.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        private LayerDrawable g(ResourceManagerInternal resourceManagerInternal, Context context, int i10) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i10);
            Drawable drawable = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_black_48dp);
            Drawable drawable2 = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_half_black_48dp);
            if ((drawable instanceof BitmapDrawable) && drawable.getIntrinsicWidth() == dimensionPixelSize && drawable.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable2 = (BitmapDrawable) drawable;
                bitmapDrawable = new BitmapDrawable(bitmapDrawable2.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawable.draw(canvas);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
                bitmapDrawable = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawable2 instanceof BitmapDrawable) && drawable2.getIntrinsicWidth() == dimensionPixelSize && drawable2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawable2;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawable2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable2, bitmapDrawable3, bitmapDrawable});
            layerDrawable.setId(0, 16908288);
            layerDrawable.setId(1, 16908303);
            layerDrawable.setId(2, 16908301);
            return layerDrawable;
        }

        private void h(Drawable drawable, int i10, PorterDuff.Mode mode) {
            if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = AppCompatDrawableManager.DEFAULT_MODE;
            }
            drawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i10, mode));
        }

        public Drawable createDrawableFor(ResourceManagerInternal resourceManagerInternal, Context context, int i10) {
            if (i10 == R.drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{resourceManagerInternal.getDrawable(context, R.drawable.abc_cab_background_internal_bg), resourceManagerInternal.getDrawable(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i10 == R.drawable.abc_ratingbar_material) {
                return g(resourceManagerInternal, context, R.dimen.abc_star_big);
            } else {
                if (i10 == R.drawable.abc_ratingbar_indicator_material) {
                    return g(resourceManagerInternal, context, R.dimen.abc_star_medium);
                }
                if (i10 == R.drawable.abc_ratingbar_small_material) {
                    return g(resourceManagerInternal, context, R.dimen.abc_star_small);
                }
                return null;
            }
        }

        public ColorStateList getTintListForDrawableRes(Context context, int i10) {
            if (i10 == R.drawable.abc_edit_text_material) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_edittext);
            }
            if (i10 == R.drawable.abc_switch_track_mtrl_alpha) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_switch_track);
            }
            if (i10 == R.drawable.abc_switch_thumb_material) {
                return f(context);
            }
            if (i10 == R.drawable.abc_btn_default_mtrl_shape) {
                return e(context);
            }
            if (i10 == R.drawable.abc_btn_borderless_material) {
                return b(context);
            }
            if (i10 == R.drawable.abc_btn_colored_material) {
                return d(context);
            }
            if (i10 == R.drawable.abc_spinner_mtrl_am_alpha || i10 == R.drawable.abc_spinner_textfield_background_material) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_spinner);
            }
            if (a(this.f14184b, i10)) {
                return ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorControlNormal);
            }
            if (a(this.f14187e, i10)) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_default);
            }
            if (a(this.f14188f, i10)) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_btn_checkable);
            }
            if (i10 == R.drawable.abc_seekbar_thumb_material) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }

        public PorterDuff.Mode getTintModeForDrawableRes(int i10) {
            if (i10 == R.drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        public boolean tintDrawable(Context context, int i10, Drawable drawable) {
            if (i10 == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                h(layerDrawable.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                h(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                h(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                return true;
            } else if (i10 != R.drawable.abc_ratingbar_material && i10 != R.drawable.abc_ratingbar_indicator_material && i10 != R.drawable.abc_ratingbar_small_material) {
                return false;
            } else {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                h(layerDrawable2.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorControlNormal), AppCompatDrawableManager.DEFAULT_MODE);
                h(layerDrawable2.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                h(layerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                return true;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x006c A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean tintDrawableUsingColorFilter(android.content.Context r8, int r9, android.graphics.drawable.Drawable r10) {
            /*
                r7 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.AppCompatDrawableManager.DEFAULT_MODE
                int[] r1 = r7.f14183a
                boolean r1 = r7.a(r1, r9)
                r2 = 1
                r3 = 0
                r4 = -1
                if (r1 == 0) goto L_0x0015
                int r9 = androidx.appcompat.R.attr.colorControlNormal
            L_0x0011:
                r1 = r0
                r5 = r2
            L_0x0013:
                r0 = r4
                goto L_0x004f
            L_0x0015:
                int[] r1 = r7.f14185c
                boolean r1 = r7.a(r1, r9)
                if (r1 == 0) goto L_0x0020
                int r9 = androidx.appcompat.R.attr.colorControlActivated
                goto L_0x0011
            L_0x0020:
                int[] r1 = r7.f14186d
                boolean r1 = r7.a(r1, r9)
                r5 = 16842801(0x1010031, float:2.3693695E-38)
                if (r1 == 0) goto L_0x0032
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            L_0x002d:
                r1 = r0
                r0 = r4
                r9 = r5
                r5 = r2
                goto L_0x004f
            L_0x0032:
                int r1 = androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha
                if (r9 != r1) goto L_0x0046
                r9 = 1109603123(0x42233333, float:40.8)
                int r9 = java.lang.Math.round(r9)
                r1 = 16842800(0x1010030, float:2.3693693E-38)
                r5 = r2
                r6 = r0
                r0 = r9
                r9 = r1
                r1 = r6
                goto L_0x004f
            L_0x0046:
                int r1 = androidx.appcompat.R.drawable.abc_dialog_material_background
                if (r9 != r1) goto L_0x004b
                goto L_0x002d
            L_0x004b:
                r1 = r0
                r9 = r3
                r5 = r9
                goto L_0x0013
            L_0x004f:
                if (r5 == 0) goto L_0x006c
                boolean r3 = androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable(r10)
                if (r3 == 0) goto L_0x005b
                android.graphics.drawable.Drawable r10 = r10.mutate()
            L_0x005b:
                int r8 = androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(r8, r9)
                android.graphics.PorterDuffColorFilter r8 = androidx.appcompat.widget.AppCompatDrawableManager.getPorterDuffColorFilter(r8, r1)
                r10.setColorFilter(r8)
                if (r0 == r4) goto L_0x006b
                r10.setAlpha(r0)
            L_0x006b:
                return r2
            L_0x006c:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatDrawableManager.a.tintDrawableUsingColorFilter(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }
    }

    public static synchronized AppCompatDrawableManager get() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            try {
                if (INSTANCE == null) {
                    preload();
                }
                appCompatDrawableManager = INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        return appCompatDrawableManager;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (AppCompatDrawableManager.class) {
            porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(i10, mode);
        }
        return porterDuffColorFilter;
    }

    public static synchronized void preload() {
        synchronized (AppCompatDrawableManager.class) {
            if (INSTANCE == null) {
                AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
                INSTANCE = appCompatDrawableManager;
                appCompatDrawableManager.mResourceManager = ResourceManagerInternal.get();
                INSTANCE.mResourceManager.setHooks(new a());
            }
        }
    }

    static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ResourceManagerInternal.tintDrawable(drawable, tintInfo, iArr);
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i10) {
        return this.mResourceManager.getDrawable(context, i10);
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList getTintList(@NonNull Context context, @DrawableRes int i10) {
        return this.mResourceManager.getTintList(context, i10);
    }

    public synchronized void onConfigurationChanged(@NonNull Context context) {
        this.mResourceManager.onConfigurationChanged(context);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable onDrawableLoadedFromResources(@NonNull Context context, @NonNull VectorEnabledTintResources vectorEnabledTintResources, @DrawableRes int i10) {
        return this.mResourceManager.onDrawableLoadedFromResources(context, vectorEnabledTintResources, i10);
    }

    /* access modifiers changed from: package-private */
    public boolean tintDrawableUsingColorFilter(@NonNull Context context, @DrawableRes int i10, @NonNull Drawable drawable) {
        return this.mResourceManager.tintDrawableUsingColorFilter(context, i10, drawable);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i10, boolean z10) {
        return this.mResourceManager.getDrawable(context, i10, z10);
    }
}
