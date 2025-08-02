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
import androidx.autofill.HintConstants;
import androidx.credentials.CredentialOption;
import androidx.credentials.PublicKeyCredential;
import androidx.credentials.R;
import androidx.credentials.provider.BeginGetPublicKeyCredentialOption;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@RequiresApi(26)
public final class PublicKeyCredentialEntry extends CredentialEntry {
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
    private static final String TAG = "PublicKeyCredEntry";
    private final boolean autoSelectAllowedFromOption;
    private final CharSequence displayName;
    private final Icon icon;
    private final boolean isAutoSelectAllowed;
    private final boolean isDefaultIcon;
    private final Instant lastUsedTime;
    private final PendingIntent pendingIntent;
    private final CharSequence typeDisplayName;
    private final CharSequence username;

    public static final class Builder {
        private boolean autoSelectAllowed;
        private final BeginGetPublicKeyCredentialOption beginGetPublicKeyCredentialOption;
        private final Context context;
        private CharSequence displayName;
        private Icon icon;
        private Instant lastUsedTime;
        private final PendingIntent pendingIntent;
        private final CharSequence username;

        public Builder(Context context2, CharSequence charSequence, PendingIntent pendingIntent2, BeginGetPublicKeyCredentialOption beginGetPublicKeyCredentialOption2) {
            m.f(context2, "context");
            m.f(charSequence, HintConstants.AUTOFILL_HINT_USERNAME);
            m.f(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
            m.f(beginGetPublicKeyCredentialOption2, "beginGetPublicKeyCredentialOption");
            this.context = context2;
            this.username = charSequence;
            this.pendingIntent = pendingIntent2;
            this.beginGetPublicKeyCredentialOption = beginGetPublicKeyCredentialOption2;
        }

        public final PublicKeyCredentialEntry build() {
            if (this.icon == null) {
                this.icon = Icon.createWithResource(this.context, R.drawable.ic_passkey);
            }
            String string = this.context.getString(R.string.androidx_credentials_TYPE_PUBLIC_KEY_CREDENTIAL);
            m.e(string, "context.getString(\n     …_CREDENTIAL\n            )");
            CharSequence charSequence = this.username;
            CharSequence charSequence2 = this.displayName;
            PendingIntent pendingIntent2 = this.pendingIntent;
            Icon icon2 = this.icon;
            m.c(icon2);
            return new PublicKeyCredentialEntry(charSequence, charSequence2, string, pendingIntent2, icon2, this.lastUsedTime, this.autoSelectAllowed, this.beginGetPublicKeyCredentialOption, false, false, 768, (DefaultConstructorMarker) null);
        }

        public final Builder setAutoSelectAllowed(boolean z10) {
            this.autoSelectAllowed = z10;
            return this;
        }

        public final Builder setDisplayName(CharSequence charSequence) {
            this.displayName = charSequence;
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
    }

    public static final class Companion {
        private Companion() {
        }

        @SuppressLint({"WrongConstant"})
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final PublicKeyCredentialEntry fromSlice(Slice slice) {
            m.f(slice, "slice");
            if (Build.VERSION.SDK_INT >= 28) {
                return a.a(slice);
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final Slice toSlice(PublicKeyCredentialEntry publicKeyCredentialEntry) {
            m.f(publicKeyCredentialEntry, "entry");
            if (Build.VERSION.SDK_INT >= 28) {
                return a.b(publicKeyCredentialEntry);
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f15330a = new a();

        private a() {
        }

        public static final PublicKeyCredentialEntry a(Slice slice) {
            m.f(slice, "slice");
            List<SliceItem> items = slice.getItems();
            m.e(items, "slice.items");
            CharSequence charSequence = null;
            CharSequence charSequence2 = null;
            CharSequence charSequence3 = null;
            PendingIntent pendingIntent = null;
            Icon icon = null;
            Instant instant = null;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            CharSequence charSequence4 = null;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME)) {
                    charSequence3 = sliceItem.getText();
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_TITLE)) {
                    charSequence = sliceItem.getText();
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_SUBTITLE)) {
                    charSequence2 = sliceItem.getText();
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_ICON)) {
                    icon = sliceItem.getIcon();
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_PENDING_INTENT)) {
                    pendingIntent = sliceItem.getAction();
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_OPTION_ID)) {
                    charSequence4 = sliceItem.getText();
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS)) {
                    instant = Instant.ofEpochMilli(sliceItem.getLong());
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_AUTO_ALLOWED)) {
                    if (m.b(sliceItem.getText(), PublicKeyCredentialEntry.AUTO_SELECT_TRUE_STRING)) {
                        z10 = true;
                    }
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION)) {
                    z11 = true;
                } else if (sliceItem.hasHint(PublicKeyCredentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID)) {
                    z12 = true;
                }
            }
            try {
                m.c(charSequence);
                m.c(charSequence3);
                m.c(pendingIntent);
                m.c(icon);
                BeginGetPublicKeyCredentialOption.Companion companion = BeginGetPublicKeyCredentialOption.Companion;
                Bundle bundle = new Bundle();
                m.c(charSequence4);
                return new PublicKeyCredentialEntry(charSequence, charSequence2, charSequence3, pendingIntent, icon, instant, z10, companion.createFromEntrySlice$credentials_release(bundle, charSequence4.toString()), z11, z12);
            } catch (Exception e10) {
                Log.i(PublicKeyCredentialEntry.TAG, "fromSlice failed with: " + e10.getMessage());
                return null;
            }
        }

        public static final Slice b(PublicKeyCredentialEntry publicKeyCredentialEntry) {
            String str;
            m.f(publicKeyCredentialEntry, "entry");
            String type = publicKeyCredentialEntry.getType();
            CharSequence username = publicKeyCredentialEntry.getUsername();
            CharSequence displayName = publicKeyCredentialEntry.getDisplayName();
            PendingIntent pendingIntent = publicKeyCredentialEntry.getPendingIntent();
            CharSequence typeDisplayName = publicKeyCredentialEntry.getTypeDisplayName();
            Instant lastUsedTime = publicKeyCredentialEntry.getLastUsedTime();
            Icon icon = publicKeyCredentialEntry.getIcon();
            boolean isAutoSelectAllowed = publicKeyCredentialEntry.isAutoSelectAllowed();
            BeginGetCredentialOption beginGetCredentialOption = publicKeyCredentialEntry.getBeginGetCredentialOption();
            if (isAutoSelectAllowed) {
                str = PublicKeyCredentialEntry.AUTO_SELECT_TRUE_STRING;
            } else {
                str = PublicKeyCredentialEntry.AUTO_SELECT_FALSE_STRING;
            }
            Slice.Builder addIcon = new Slice.Builder(Uri.EMPTY, new SliceSpec(type, 1)).addText(typeDisplayName, (String) null, r.e(PublicKeyCredentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME)).addText(username, (String) null, r.e(PublicKeyCredentialEntry.SLICE_HINT_TITLE)).addText(displayName, (String) null, r.e(PublicKeyCredentialEntry.SLICE_HINT_SUBTITLE)).addText(str, (String) null, r.e(PublicKeyCredentialEntry.SLICE_HINT_AUTO_ALLOWED)).addText(beginGetCredentialOption.getId(), (String) null, r.e(PublicKeyCredentialEntry.SLICE_HINT_OPTION_ID)).addIcon(icon, (String) null, r.e(PublicKeyCredentialEntry.SLICE_HINT_ICON));
            try {
                if (icon.getResId() == R.drawable.ic_passkey) {
                    addIcon.addInt(1, (String) null, r.e(PublicKeyCredentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID));
                }
            } catch (IllegalStateException unused) {
            }
            if (CredentialOption.Companion.extractAutoSelectValue$credentials_release(beginGetCredentialOption.getCandidateQueryData())) {
                addIcon.addInt(1, (String) null, r.e(PublicKeyCredentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION));
            }
            if (lastUsedTime != null) {
                addIcon.addLong(lastUsedTime.toEpochMilli(), (String) null, r.e(PublicKeyCredentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS));
            }
            addIcon.addAction(pendingIntent, new Slice.Builder(addIcon).addHints(Collections.singletonList(PublicKeyCredentialEntry.SLICE_HINT_PENDING_INTENT)).build(), (String) null);
            Slice build = addIcon.build();
            m.e(build, "sliceBuilder.build()");
            return build;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PublicKeyCredentialEntry(java.lang.CharSequence r15, java.lang.CharSequence r16, java.lang.CharSequence r17, android.app.PendingIntent r18, android.graphics.drawable.Icon r19, java.time.Instant r20, boolean r21, androidx.credentials.provider.BeginGetPublicKeyCredentialOption r22, boolean r23, boolean r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 256(0x100, float:3.59E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r12 = r2
            goto L_0x000b
        L_0x0009:
            r12 = r23
        L_0x000b:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0011
            r13 = r2
            goto L_0x0013
        L_0x0011:
            r13 = r24
        L_0x0013:
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r10 = r21
            r11 = r22
            r3.<init>((java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (java.lang.CharSequence) r6, (android.app.PendingIntent) r7, (android.graphics.drawable.Icon) r8, (java.time.Instant) r9, (boolean) r10, (androidx.credentials.provider.BeginGetPublicKeyCredentialOption) r11, (boolean) r12, (boolean) r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.PublicKeyCredentialEntry.<init>(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, android.app.PendingIntent, android.graphics.drawable.Icon, java.time.Instant, boolean, androidx.credentials.provider.BeginGetPublicKeyCredentialOption, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final PublicKeyCredentialEntry fromSlice(Slice slice) {
        return Companion.fromSlice(slice);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Slice toSlice(PublicKeyCredentialEntry publicKeyCredentialEntry) {
        return Companion.toSlice(publicKeyCredentialEntry);
    }

    public final CharSequence getDisplayName() {
        return this.displayName;
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

    public final CharSequence getTypeDisplayName() {
        return this.typeDisplayName;
    }

    public final CharSequence getUsername() {
        return this.username;
    }

    public final boolean isAutoSelectAllowed() {
        return this.isAutoSelectAllowed;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublicKeyCredentialEntry(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, PendingIntent pendingIntent2, Icon icon2, Instant instant, boolean z10, BeginGetPublicKeyCredentialOption beginGetPublicKeyCredentialOption, boolean z11, boolean z12) {
        super(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL, beginGetPublicKeyCredentialOption);
        m.f(charSequence, HintConstants.AUTOFILL_HINT_USERNAME);
        m.f(charSequence3, "typeDisplayName");
        m.f(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
        m.f(icon2, "icon");
        m.f(beginGetPublicKeyCredentialOption, "beginGetPublicKeyCredentialOption");
        this.username = charSequence;
        this.displayName = charSequence2;
        this.typeDisplayName = charSequence3;
        this.pendingIntent = pendingIntent2;
        this.icon = icon2;
        this.lastUsedTime = instant;
        this.isAutoSelectAllowed = z10;
        this.autoSelectAllowedFromOption = z11;
        this.isDefaultIcon = z12;
        if (charSequence.length() <= 0) {
            throw new IllegalArgumentException("username must not be empty".toString());
        } else if (charSequence3.length() <= 0) {
            throw new IllegalArgumentException("typeDisplayName must not be empty".toString());
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PublicKeyCredentialEntry(android.content.Context r13, java.lang.CharSequence r14, android.app.PendingIntent r15, androidx.credentials.provider.BeginGetPublicKeyCredentialOption r16, java.lang.CharSequence r17, java.time.Instant r18, android.graphics.drawable.Icon r19, boolean r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r8 = r2
            goto L_0x000b
        L_0x0009:
            r8 = r17
        L_0x000b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0011
            r9 = r2
            goto L_0x0013
        L_0x0011:
            r9 = r18
        L_0x0013:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0025
            int r1 = androidx.credentials.R.drawable.ic_passkey
            r2 = r13
            android.graphics.drawable.Icon r1 = android.graphics.drawable.Icon.createWithResource(r13, r1)
            java.lang.String r3 = "createWithResource(context, R.drawable.ic_passkey)"
            kotlin.jvm.internal.m.e(r1, r3)
            r10 = r1
            goto L_0x0028
        L_0x0025:
            r2 = r13
            r10 = r19
        L_0x0028:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x002f
            r0 = 0
            r11 = r0
            goto L_0x0031
        L_0x002f:
            r11 = r20
        L_0x0031:
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.PublicKeyCredentialEntry.<init>(android.content.Context, java.lang.CharSequence, android.app.PendingIntent, androidx.credentials.provider.BeginGetPublicKeyCredentialOption, java.lang.CharSequence, java.time.Instant, android.graphics.drawable.Icon, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PublicKeyCredentialEntry(android.content.Context r16, java.lang.CharSequence r17, android.app.PendingIntent r18, androidx.credentials.provider.BeginGetPublicKeyCredentialOption r19, java.lang.CharSequence r20, java.time.Instant r21, android.graphics.drawable.Icon r22, boolean r23) {
        /*
            r15 = this;
            r0 = r16
            java.lang.String r1 = "context"
            kotlin.jvm.internal.m.f(r0, r1)
            java.lang.String r1 = "username"
            r3 = r17
            kotlin.jvm.internal.m.f(r3, r1)
            java.lang.String r1 = "pendingIntent"
            r6 = r18
            kotlin.jvm.internal.m.f(r6, r1)
            java.lang.String r1 = "beginGetPublicKeyCredentialOption"
            r10 = r19
            kotlin.jvm.internal.m.f(r10, r1)
            java.lang.String r1 = "icon"
            r7 = r22
            kotlin.jvm.internal.m.f(r7, r1)
            int r1 = androidx.credentials.R.string.androidx_credentials_TYPE_PUBLIC_KEY_CREDENTIAL
            java.lang.String r5 = r0.getString(r1)
            java.lang.String r0 = "context.getString(\n     …_KEY_CREDENTIAL\n        )"
            kotlin.jvm.internal.m.e(r5, r0)
            r13 = 768(0x300, float:1.076E-42)
            r14 = 0
            r11 = 0
            r12 = 0
            r2 = r15
            r4 = r20
            r8 = r21
            r9 = r23
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.PublicKeyCredentialEntry.<init>(android.content.Context, java.lang.CharSequence, android.app.PendingIntent, androidx.credentials.provider.BeginGetPublicKeyCredentialOption, java.lang.CharSequence, java.time.Instant, android.graphics.drawable.Icon, boolean):void");
    }
}
