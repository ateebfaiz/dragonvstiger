package androidx.credentials.provider;

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
import androidx.credentials.PasswordCredential;
import androidx.credentials.R;
import androidx.credentials.provider.BeginGetPasswordOption;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@RequiresApi(26)
public final class PasswordCredentialEntry extends CredentialEntry {
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
    private static final String TAG = "PasswordCredentialEntry";
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
        private final BeginGetPasswordOption beginGetPasswordOption;
        private final Context context;
        private CharSequence displayName;
        private Icon icon;
        private Instant lastUsedTime;
        private final PendingIntent pendingIntent;
        private final CharSequence username;

        public Builder(Context context2, CharSequence charSequence, PendingIntent pendingIntent2, BeginGetPasswordOption beginGetPasswordOption2) {
            m.f(context2, "context");
            m.f(charSequence, HintConstants.AUTOFILL_HINT_USERNAME);
            m.f(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
            m.f(beginGetPasswordOption2, "beginGetPasswordOption");
            this.context = context2;
            this.username = charSequence;
            this.pendingIntent = pendingIntent2;
            this.beginGetPasswordOption = beginGetPasswordOption2;
        }

        public final PasswordCredentialEntry build() {
            if (this.icon == null) {
                this.icon = Icon.createWithResource(this.context, R.drawable.ic_password);
            }
            String string = this.context.getString(R.string.android_credentials_TYPE_PASSWORD_CREDENTIAL);
            m.e(string, "context.getString(\n     …_CREDENTIAL\n            )");
            CharSequence charSequence = this.username;
            CharSequence charSequence2 = this.displayName;
            PendingIntent pendingIntent2 = this.pendingIntent;
            Instant instant = this.lastUsedTime;
            Icon icon2 = this.icon;
            m.c(icon2);
            return new PasswordCredentialEntry(charSequence, charSequence2, string, pendingIntent2, instant, icon2, this.autoSelectAllowed, this.beginGetPasswordOption, false, false, 768, (DefaultConstructorMarker) null);
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

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final PasswordCredentialEntry fromSlice(Slice slice) {
            m.f(slice, "slice");
            if (Build.VERSION.SDK_INT >= 28) {
                return a.a(slice);
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final Slice toSlice(PasswordCredentialEntry passwordCredentialEntry) {
            m.f(passwordCredentialEntry, "entry");
            if (Build.VERSION.SDK_INT >= 28) {
                return a.b(passwordCredentialEntry);
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f15328a = new a();

        private a() {
        }

        public static final PasswordCredentialEntry a(Slice slice) {
            m.f(slice, "slice");
            List<SliceItem> items = slice.getItems();
            m.e(items, "slice.items");
            CharSequence charSequence = null;
            CharSequence charSequence2 = null;
            CharSequence charSequence3 = null;
            PendingIntent pendingIntent = null;
            Instant instant = null;
            Icon icon = null;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            CharSequence charSequence4 = null;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME)) {
                    charSequence3 = sliceItem.getText();
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_TITLE)) {
                    charSequence = sliceItem.getText();
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_SUBTITLE)) {
                    charSequence2 = sliceItem.getText();
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_ICON)) {
                    icon = sliceItem.getIcon();
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_PENDING_INTENT)) {
                    pendingIntent = sliceItem.getAction();
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_OPTION_ID)) {
                    charSequence4 = sliceItem.getText();
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS)) {
                    instant = Instant.ofEpochMilli(sliceItem.getLong());
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_AUTO_ALLOWED)) {
                    if (m.b(sliceItem.getText(), PasswordCredentialEntry.AUTO_SELECT_TRUE_STRING)) {
                        z10 = true;
                    }
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION)) {
                    z11 = true;
                } else if (sliceItem.hasHint(PasswordCredentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID)) {
                    z12 = true;
                }
            }
            try {
                m.c(charSequence);
                m.c(charSequence3);
                m.c(pendingIntent);
                m.c(icon);
                BeginGetPasswordOption.Companion companion = BeginGetPasswordOption.Companion;
                Bundle bundle = new Bundle();
                m.c(charSequence4);
                return new PasswordCredentialEntry(charSequence, charSequence2, charSequence3, pendingIntent, instant, icon, z10, companion.createFrom$credentials_release(bundle, charSequence4.toString()), z11, z12);
            } catch (Exception e10) {
                Log.i(PasswordCredentialEntry.TAG, "fromSlice failed with: " + e10.getMessage());
                return null;
            }
        }

        public static final Slice b(PasswordCredentialEntry passwordCredentialEntry) {
            String str;
            m.f(passwordCredentialEntry, "entry");
            String type = passwordCredentialEntry.getType();
            CharSequence username = passwordCredentialEntry.getUsername();
            CharSequence displayName = passwordCredentialEntry.getDisplayName();
            PendingIntent pendingIntent = passwordCredentialEntry.getPendingIntent();
            CharSequence typeDisplayName = passwordCredentialEntry.getTypeDisplayName();
            Instant lastUsedTime = passwordCredentialEntry.getLastUsedTime();
            Icon icon = passwordCredentialEntry.getIcon();
            boolean isAutoSelectAllowed = passwordCredentialEntry.isAutoSelectAllowed();
            BeginGetCredentialOption beginGetCredentialOption = passwordCredentialEntry.getBeginGetCredentialOption();
            if (isAutoSelectAllowed) {
                str = PasswordCredentialEntry.AUTO_SELECT_TRUE_STRING;
            } else {
                str = PasswordCredentialEntry.AUTO_SELECT_FALSE_STRING;
            }
            Slice.Builder addIcon = new Slice.Builder(Uri.EMPTY, new SliceSpec(type, 1)).addText(typeDisplayName, (String) null, r.e(PasswordCredentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME)).addText(username, (String) null, r.e(PasswordCredentialEntry.SLICE_HINT_TITLE)).addText(displayName, (String) null, r.e(PasswordCredentialEntry.SLICE_HINT_SUBTITLE)).addText(str, (String) null, r.e(PasswordCredentialEntry.SLICE_HINT_AUTO_ALLOWED)).addText(beginGetCredentialOption.getId(), (String) null, r.e(PasswordCredentialEntry.SLICE_HINT_OPTION_ID)).addIcon(icon, (String) null, r.e(PasswordCredentialEntry.SLICE_HINT_ICON));
            try {
                if (icon.getResId() == R.drawable.ic_password) {
                    addIcon.addInt(1, (String) null, r.e(PasswordCredentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID));
                }
            } catch (IllegalStateException unused) {
            }
            if (CredentialOption.Companion.extractAutoSelectValue$credentials_release(beginGetCredentialOption.getCandidateQueryData())) {
                addIcon.addInt(1, (String) null, r.e(PasswordCredentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION));
            }
            if (lastUsedTime != null) {
                addIcon.addLong(lastUsedTime.toEpochMilli(), (String) null, r.e(PasswordCredentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS));
            }
            addIcon.addAction(pendingIntent, new Slice.Builder(addIcon).addHints(Collections.singletonList(PasswordCredentialEntry.SLICE_HINT_PENDING_INTENT)).build(), (String) null);
            Slice build = addIcon.build();
            m.e(build, "sliceBuilder.build()");
            return build;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PasswordCredentialEntry(java.lang.CharSequence r15, java.lang.CharSequence r16, java.lang.CharSequence r17, android.app.PendingIntent r18, java.time.Instant r19, android.graphics.drawable.Icon r20, boolean r21, androidx.credentials.provider.BeginGetPasswordOption r22, boolean r23, boolean r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
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
            r3.<init>((java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (java.lang.CharSequence) r6, (android.app.PendingIntent) r7, (java.time.Instant) r8, (android.graphics.drawable.Icon) r9, (boolean) r10, (androidx.credentials.provider.BeginGetPasswordOption) r11, (boolean) r12, (boolean) r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.PasswordCredentialEntry.<init>(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, android.app.PendingIntent, java.time.Instant, android.graphics.drawable.Icon, boolean, androidx.credentials.provider.BeginGetPasswordOption, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final PasswordCredentialEntry fromSlice(Slice slice) {
        return Companion.fromSlice(slice);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Slice toSlice(PasswordCredentialEntry passwordCredentialEntry) {
        return Companion.toSlice(passwordCredentialEntry);
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
    public PasswordCredentialEntry(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, PendingIntent pendingIntent2, Instant instant, Icon icon2, boolean z10, BeginGetPasswordOption beginGetPasswordOption, boolean z11, boolean z12) {
        super(PasswordCredential.TYPE_PASSWORD_CREDENTIAL, beginGetPasswordOption);
        m.f(charSequence, HintConstants.AUTOFILL_HINT_USERNAME);
        m.f(charSequence3, "typeDisplayName");
        m.f(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
        m.f(icon2, "icon");
        m.f(beginGetPasswordOption, "beginGetPasswordOption");
        this.username = charSequence;
        this.displayName = charSequence2;
        this.typeDisplayName = charSequence3;
        this.pendingIntent = pendingIntent2;
        this.lastUsedTime = instant;
        this.icon = icon2;
        this.isAutoSelectAllowed = z10;
        this.autoSelectAllowedFromOption = z11;
        this.isDefaultIcon = z12;
        if (charSequence.length() <= 0) {
            throw new IllegalArgumentException("username must not be empty".toString());
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PasswordCredentialEntry(android.content.Context r13, java.lang.CharSequence r14, android.app.PendingIntent r15, androidx.credentials.provider.BeginGetPasswordOption r16, java.lang.CharSequence r17, java.time.Instant r18, android.graphics.drawable.Icon r19, boolean r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
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
            int r1 = androidx.credentials.R.drawable.ic_password
            r2 = r13
            android.graphics.drawable.Icon r1 = android.graphics.drawable.Icon.createWithResource(r13, r1)
            java.lang.String r3 = "createWithResource(conte…, R.drawable.ic_password)"
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.PasswordCredentialEntry.<init>(android.content.Context, java.lang.CharSequence, android.app.PendingIntent, androidx.credentials.provider.BeginGetPasswordOption, java.lang.CharSequence, java.time.Instant, android.graphics.drawable.Icon, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PasswordCredentialEntry(android.content.Context r16, java.lang.CharSequence r17, android.app.PendingIntent r18, androidx.credentials.provider.BeginGetPasswordOption r19, java.lang.CharSequence r20, java.time.Instant r21, android.graphics.drawable.Icon r22, boolean r23) {
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
            java.lang.String r1 = "beginGetPasswordOption"
            r10 = r19
            kotlin.jvm.internal.m.f(r10, r1)
            java.lang.String r1 = "icon"
            r8 = r22
            kotlin.jvm.internal.m.f(r8, r1)
            int r1 = androidx.credentials.R.string.android_credentials_TYPE_PASSWORD_CREDENTIAL
            java.lang.String r5 = r0.getString(r1)
            java.lang.String r0 = "context.getString(\n     …WORD_CREDENTIAL\n        )"
            kotlin.jvm.internal.m.e(r5, r0)
            r13 = 768(0x300, float:1.076E-42)
            r14 = 0
            r11 = 0
            r12 = 0
            r2 = r15
            r4 = r20
            r7 = r21
            r9 = r23
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.PasswordCredentialEntry.<init>(android.content.Context, java.lang.CharSequence, android.app.PendingIntent, androidx.credentials.provider.BeginGetPasswordOption, java.lang.CharSequence, java.time.Instant, android.graphics.drawable.Icon, boolean):void");
    }
}
