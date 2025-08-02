package androidx.credentials.provider;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.app.slice.SliceSpec;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.credentials.CredentialOption;
import androidx.credentials.R;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@RequiresApi(26)
public final class CustomCredentialEntry extends CredentialEntry {
    private static final String AUTO_SELECT_FALSE_STRING = "false";
    private static final String AUTO_SELECT_TRUE_STRING = "true";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int REVISION_ID = 1;
    private static final String SLICE_HINT_AUTO_ALLOWED = "androidx.credentials.provider.credentialEntry.SLICE_HINT_AUTO_ALLOWED";
    private static final String SLICE_HINT_AUTO_SELECT_FROM_OPTION = "androidx.credentials.provider.credentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION";
    private static final String SLICE_HINT_DEFAULT_ICON_RES_ID = "androidx.credentials.provider.credentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID";
    private static final String SLICE_HINT_ICON = "androidx.credentials.provider.credentialEntry.SLICE_HINT_PROFILE_ICON";
    private static final String SLICE_HINT_LAST_USED_TIME_MILLIS = "androidx.credentials.provider.credentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS";
    private static final String SLICE_HINT_OPTION_ID = "androidx.credentials.provider.credentialEntry.SLICE_HINT_OPTION_ID";
    private static final String SLICE_HINT_PENDING_INTENT = "androidx.credentials.provider.credentialEntry.SLICE_HINT_PENDING_INTENT";
    private static final String SLICE_HINT_SUBTITLE = "androidx.credentials.provider.credentialEntry.SLICE_HINT_CREDENTIAL_TYPE_DISPLAY_NAME";
    private static final String SLICE_HINT_TITLE = "androidx.credentials.provider.credentialEntry.SLICE_HINT_USER_NAME";
    private static final String SLICE_HINT_TYPE_DISPLAY_NAME = "androidx.credentials.provider.credentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME";
    private static final String TAG = "CredentialEntry";
    private final boolean autoSelectAllowedFromOption;
    private final Icon icon;
    private final boolean isAutoSelectAllowed;
    private final boolean isDefaultIcon;
    private final Instant lastUsedTime;
    private final PendingIntent pendingIntent;
    private final CharSequence subtitle;
    private final CharSequence title;
    private final String type;
    private final CharSequence typeDisplayName;

    public static final class Builder {
        private boolean autoSelectAllowed;
        private final BeginGetCredentialOption beginGetCredentialOption;
        private final Context context;
        private Icon icon;
        private Instant lastUsedTime;
        private final PendingIntent pendingIntent;
        private CharSequence subtitle;
        private final CharSequence title;
        private final String type;
        private CharSequence typeDisplayName;

        public Builder(Context context2, String str, CharSequence charSequence, PendingIntent pendingIntent2, BeginGetCredentialOption beginGetCredentialOption2) {
            m.f(context2, "context");
            m.f(str, "type");
            m.f(charSequence, "title");
            m.f(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
            m.f(beginGetCredentialOption2, "beginGetCredentialOption");
            this.context = context2;
            this.type = str;
            this.title = charSequence;
            this.pendingIntent = pendingIntent2;
            this.beginGetCredentialOption = beginGetCredentialOption2;
        }

        public final CustomCredentialEntry build() {
            if (this.icon == null) {
                this.icon = Icon.createWithResource(this.context, R.drawable.ic_other_sign_in);
            }
            String str = this.type;
            CharSequence charSequence = this.title;
            PendingIntent pendingIntent2 = this.pendingIntent;
            boolean z10 = this.autoSelectAllowed;
            CharSequence charSequence2 = this.subtitle;
            CharSequence charSequence3 = this.typeDisplayName;
            Icon icon2 = this.icon;
            m.c(icon2);
            return new CustomCredentialEntry(str, charSequence, pendingIntent2, z10, charSequence2, charSequence3, icon2, this.lastUsedTime, this.beginGetCredentialOption, false, false, 1536, (DefaultConstructorMarker) null);
        }

        public final Builder setAutoSelectAllowed(boolean z10) {
            this.autoSelectAllowed = z10;
            return this;
        }

        public final Builder setIcon(Icon icon2) {
            m.f(icon2, "icon");
            this.icon = icon2;
            return this;
        }

        public final Builder setLastUsedTime(Instant instant) {
            this.lastUsedTime = instant;
            return this;
        }

        public final Builder setSubtitle(CharSequence charSequence) {
            this.subtitle = charSequence;
            return this;
        }

        public final Builder setTypeDisplayName(CharSequence charSequence) {
            this.typeDisplayName = charSequence;
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        @SuppressLint({"WrongConstant"})
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final CustomCredentialEntry fromSlice(Slice slice) {
            m.f(slice, "slice");
            if (Build.VERSION.SDK_INT >= 28) {
                return a.a(slice);
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final Slice toSlice(CustomCredentialEntry customCredentialEntry) {
            m.f(customCredentialEntry, "entry");
            if (Build.VERSION.SDK_INT >= 28) {
                return a.b(customCredentialEntry);
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f15327a = new a();

        private a() {
        }

        public static final CustomCredentialEntry a(Slice slice) {
            m.f(slice, "slice");
            SliceSpec spec = slice.getSpec();
            m.c(spec);
            String type = spec.getType();
            m.e(type, "slice.spec!!.type");
            List<SliceItem> items = slice.getItems();
            m.e(items, "slice.items");
            CharSequence charSequence = null;
            PendingIntent pendingIntent = null;
            CharSequence charSequence2 = null;
            CharSequence charSequence3 = null;
            Icon icon = null;
            Instant instant = null;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            CharSequence charSequence4 = null;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME)) {
                    charSequence3 = sliceItem.getText();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_TITLE)) {
                    charSequence = sliceItem.getText();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_SUBTITLE)) {
                    charSequence2 = sliceItem.getText();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_ICON)) {
                    icon = sliceItem.getIcon();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_PENDING_INTENT)) {
                    pendingIntent = sliceItem.getAction();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_OPTION_ID)) {
                    charSequence4 = sliceItem.getText();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS)) {
                    instant = Instant.ofEpochMilli(sliceItem.getLong());
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_AUTO_ALLOWED)) {
                    if (m.b(sliceItem.getText(), CustomCredentialEntry.AUTO_SELECT_TRUE_STRING)) {
                        z10 = true;
                    }
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION)) {
                    z11 = true;
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID)) {
                    z12 = true;
                }
            }
            try {
                m.c(charSequence);
                m.c(pendingIntent);
                m.c(icon);
                m.c(charSequence4);
                return new CustomCredentialEntry(type, charSequence, pendingIntent, z10, charSequence2, charSequence3, icon, instant, (BeginGetCredentialOption) new BeginGetCustomCredentialOption(charSequence4.toString(), type, new Bundle()), z11, z12);
            } catch (Exception e10) {
                Log.i(CustomCredentialEntry.TAG, "fromSlice failed with: " + e10.getMessage());
                return null;
            }
        }

        public static final Slice b(CustomCredentialEntry customCredentialEntry) {
            String str;
            m.f(customCredentialEntry, "entry");
            String type = customCredentialEntry.getType();
            CharSequence title = customCredentialEntry.getTitle();
            CharSequence subtitle = customCredentialEntry.getSubtitle();
            PendingIntent pendingIntent = customCredentialEntry.getPendingIntent();
            CharSequence typeDisplayName = customCredentialEntry.getTypeDisplayName();
            Instant lastUsedTime = customCredentialEntry.getLastUsedTime();
            Icon icon = customCredentialEntry.getIcon();
            boolean isAutoSelectAllowed = customCredentialEntry.isAutoSelectAllowed();
            BeginGetCredentialOption beginGetCredentialOption = customCredentialEntry.getBeginGetCredentialOption();
            if (isAutoSelectAllowed) {
                str = CustomCredentialEntry.AUTO_SELECT_TRUE_STRING;
            } else {
                str = CustomCredentialEntry.AUTO_SELECT_FALSE_STRING;
            }
            Slice.Builder addIcon = new Slice.Builder(Uri.EMPTY, new SliceSpec(type, 1)).addText(typeDisplayName, (String) null, r.e(CustomCredentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME)).addText(title, (String) null, r.e(CustomCredentialEntry.SLICE_HINT_TITLE)).addText(subtitle, (String) null, r.e(CustomCredentialEntry.SLICE_HINT_SUBTITLE)).addText(str, (String) null, r.e(CustomCredentialEntry.SLICE_HINT_AUTO_ALLOWED)).addText(beginGetCredentialOption.getId(), (String) null, r.e(CustomCredentialEntry.SLICE_HINT_OPTION_ID)).addIcon(icon, (String) null, r.e(CustomCredentialEntry.SLICE_HINT_ICON));
            try {
                if (icon.getResId() == R.drawable.ic_other_sign_in) {
                    addIcon.addInt(1, (String) null, r.e(CustomCredentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID));
                }
            } catch (IllegalStateException unused) {
            }
            if (CredentialOption.Companion.extractAutoSelectValue$credentials_release(beginGetCredentialOption.getCandidateQueryData())) {
                addIcon.addInt(1, (String) null, r.e(CustomCredentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION));
            }
            if (lastUsedTime != null) {
                addIcon.addLong(lastUsedTime.toEpochMilli(), (String) null, r.e(CustomCredentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS));
            }
            addIcon.addAction(pendingIntent, new Slice.Builder(addIcon).addHints(Collections.singletonList(CustomCredentialEntry.SLICE_HINT_PENDING_INTENT)).build(), (String) null);
            Slice build = addIcon.build();
            m.e(build, "sliceBuilder.build()");
            return build;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CustomCredentialEntry(java.lang.String r16, java.lang.CharSequence r17, android.app.PendingIntent r18, boolean r19, java.lang.CharSequence r20, java.lang.CharSequence r21, android.graphics.drawable.Icon r22, java.time.Instant r23, androidx.credentials.provider.BeginGetCredentialOption r24, boolean r25, boolean r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r15 = this;
            r0 = r27
            r1 = r0 & 512(0x200, float:7.175E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r13 = r2
            goto L_0x000b
        L_0x0009:
            r13 = r25
        L_0x000b:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0011
            r14 = r2
            goto L_0x0013
        L_0x0011:
            r14 = r26
        L_0x0013:
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r11 = r23
            r12 = r24
            r3.<init>((java.lang.String) r4, (java.lang.CharSequence) r5, (android.app.PendingIntent) r6, (boolean) r7, (java.lang.CharSequence) r8, (java.lang.CharSequence) r9, (android.graphics.drawable.Icon) r10, (java.time.Instant) r11, (androidx.credentials.provider.BeginGetCredentialOption) r12, (boolean) r13, (boolean) r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.CustomCredentialEntry.<init>(java.lang.String, java.lang.CharSequence, android.app.PendingIntent, boolean, java.lang.CharSequence, java.lang.CharSequence, android.graphics.drawable.Icon, java.time.Instant, androidx.credentials.provider.BeginGetCredentialOption, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final CustomCredentialEntry fromSlice(Slice slice) {
        return Companion.fromSlice(slice);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Slice toSlice(CustomCredentialEntry customCredentialEntry) {
        return Companion.toSlice(customCredentialEntry);
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final Instant getLastUsedTime() {
        return this.lastUsedTime;
    }

    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public final CharSequence getSubtitle() {
        return this.subtitle;
    }

    public final CharSequence getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public final CharSequence getTypeDisplayName() {
        return this.typeDisplayName;
    }

    public final boolean isAutoSelectAllowed() {
        return this.isAutoSelectAllowed;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomCredentialEntry(String str, CharSequence charSequence, PendingIntent pendingIntent2, boolean z10, CharSequence charSequence2, CharSequence charSequence3, Icon icon2, Instant instant, BeginGetCredentialOption beginGetCredentialOption, boolean z11, boolean z12) {
        super(str, beginGetCredentialOption);
        m.f(str, "type");
        m.f(charSequence, "title");
        m.f(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
        m.f(icon2, "icon");
        m.f(beginGetCredentialOption, "beginGetCredentialOption");
        this.type = str;
        this.title = charSequence;
        this.pendingIntent = pendingIntent2;
        this.isAutoSelectAllowed = z10;
        this.subtitle = charSequence2;
        this.typeDisplayName = charSequence3;
        this.icon = icon2;
        this.lastUsedTime = instant;
        this.autoSelectAllowedFromOption = z11;
        this.isDefaultIcon = z12;
        if (getType().length() <= 0) {
            throw new IllegalArgumentException("type must not be empty".toString());
        } else if (charSequence.length() <= 0) {
            throw new IllegalArgumentException("title must not be empty".toString());
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CustomCredentialEntry(android.content.Context r14, java.lang.CharSequence r15, android.app.PendingIntent r16, androidx.credentials.provider.BeginGetCredentialOption r17, java.lang.CharSequence r18, java.lang.CharSequence r19, java.time.Instant r20, android.graphics.drawable.Icon r21, boolean r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r8 = r2
            goto L_0x000b
        L_0x0009:
            r8 = r18
        L_0x000b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0011
            r9 = r2
            goto L_0x0013
        L_0x0011:
            r9 = r19
        L_0x0013:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0019
            r10 = r2
            goto L_0x001b
        L_0x0019:
            r10 = r20
        L_0x001b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x002d
            int r1 = androidx.credentials.R.drawable.ic_other_sign_in
            r2 = r14
            android.graphics.drawable.Icon r1 = android.graphics.drawable.Icon.createWithResource(r14, r1)
            java.lang.String r3 = "createWithResource(conte…rawable.ic_other_sign_in)"
            kotlin.jvm.internal.m.e(r1, r3)
            r11 = r1
            goto L_0x0030
        L_0x002d:
            r2 = r14
            r11 = r21
        L_0x0030:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0037
            r0 = 0
            r12 = r0
            goto L_0x0039
        L_0x0037:
            r12 = r22
        L_0x0039:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.CustomCredentialEntry.<init>(android.content.Context, java.lang.CharSequence, android.app.PendingIntent, androidx.credentials.provider.BeginGetCredentialOption, java.lang.CharSequence, java.lang.CharSequence, java.time.Instant, android.graphics.drawable.Icon, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CustomCredentialEntry(android.content.Context r16, java.lang.CharSequence r17, android.app.PendingIntent r18, androidx.credentials.provider.BeginGetCredentialOption r19, java.lang.CharSequence r20, java.lang.CharSequence r21, java.time.Instant r22, android.graphics.drawable.Icon r23, boolean r24) {
        /*
            r15 = this;
            java.lang.String r0 = "context"
            r1 = r16
            kotlin.jvm.internal.m.f(r1, r0)
            java.lang.String r0 = "title"
            r3 = r17
            kotlin.jvm.internal.m.f(r3, r0)
            java.lang.String r0 = "pendingIntent"
            r4 = r18
            kotlin.jvm.internal.m.f(r4, r0)
            java.lang.String r0 = "beginGetCredentialOption"
            r10 = r19
            kotlin.jvm.internal.m.f(r10, r0)
            java.lang.String r0 = "icon"
            r8 = r23
            kotlin.jvm.internal.m.f(r8, r0)
            java.lang.String r2 = r19.getType()
            r13 = 1536(0x600, float:2.152E-42)
            r14 = 0
            r11 = 0
            r12 = 0
            r1 = r15
            r5 = r24
            r6 = r20
            r7 = r21
            r9 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.CustomCredentialEntry.<init>(android.content.Context, java.lang.CharSequence, android.app.PendingIntent, androidx.credentials.provider.BeginGetCredentialOption, java.lang.CharSequence, java.lang.CharSequence, java.time.Instant, android.graphics.drawable.Icon, boolean):void");
    }
}
