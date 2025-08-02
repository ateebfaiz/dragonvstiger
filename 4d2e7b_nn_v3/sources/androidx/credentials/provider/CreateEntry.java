package androidx.credentials.provider;

import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.app.slice.SliceSpec;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.credentials.PasswordCredential;
import androidx.credentials.PublicKeyCredential;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.i0;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.t;

@RequiresApi(26)
public final class CreateEntry {
    private static final String AUTO_SELECT_FALSE_STRING = "false";
    private static final String AUTO_SELECT_TRUE_STRING = "true";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DESCRIPTION_MAX_CHAR_LIMIT = 300;
    private static final int REVISION_ID = 1;
    private static final String SLICE_HINT_ACCOUNT_NAME = "androidx.credentials.provider.createEntry.SLICE_HINT_USER_PROVIDER_ACCOUNT_NAME";
    private static final String SLICE_HINT_AUTO_SELECT_ALLOWED = "androidx.credentials.provider.createEntry.SLICE_HINT_AUTO_SELECT_ALLOWED";
    private static final String SLICE_HINT_CREDENTIAL_COUNT_INFORMATION = "androidx.credentials.provider.createEntry.SLICE_HINT_CREDENTIAL_COUNT_INFORMATION";
    private static final String SLICE_HINT_ICON = "androidx.credentials.provider.createEntry.SLICE_HINT_PROFILE_ICON";
    private static final String SLICE_HINT_LAST_USED_TIME_MILLIS = "androidx.credentials.provider.createEntry.SLICE_HINT_LAST_USED_TIME_MILLIS";
    private static final String SLICE_HINT_NOTE = "androidx.credentials.provider.createEntry.SLICE_HINT_NOTE";
    private static final String SLICE_HINT_PENDING_INTENT = "androidx.credentials.provider.createEntry.SLICE_HINT_PENDING_INTENT";
    private static final String SLICE_SPEC_TYPE = "CreateEntry";
    private static final String TAG = "CreateEntry";
    public static final String TYPE_TOTAL_CREDENTIAL = "TOTAL_CREDENTIAL_COUNT_TYPE";
    private final CharSequence accountName;
    /* access modifiers changed from: private */
    public final Map<String, Integer> credentialCountInformationMap;
    private final CharSequence description;
    private final Icon icon;
    private final boolean isAutoSelectAllowed;
    private final Instant lastUsedTime;
    private final PendingIntent pendingIntent;

    public static final class Builder {
        private final CharSequence accountName;
        private boolean autoSelectAllowed;
        private Map<String, Integer> credentialCountInformationMap = new LinkedHashMap();
        private CharSequence description;
        private Icon icon;
        private Instant lastUsedTime;
        private Integer passwordCredentialCount;
        private final PendingIntent pendingIntent;
        private Integer publicKeyCredentialCount;
        private Integer totalCredentialCount;

        public Builder(CharSequence charSequence, PendingIntent pendingIntent2) {
            m.f(charSequence, "accountName");
            m.f(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
            this.accountName = charSequence;
            this.pendingIntent = pendingIntent2;
        }

        public final CreateEntry build() {
            return new CreateEntry(this.accountName, this.pendingIntent, this.icon, this.description, this.lastUsedTime, this.credentialCountInformationMap, this.autoSelectAllowed);
        }

        public final Builder setAutoSelectAllowed(boolean z10) {
            this.autoSelectAllowed = z10;
            return this;
        }

        public final Builder setDescription(CharSequence charSequence) {
            Integer num;
            if (charSequence != null) {
                num = Integer.valueOf(charSequence.length());
            } else {
                num = null;
            }
            if (num == null || charSequence.length() <= CreateEntry.DESCRIPTION_MAX_CHAR_LIMIT) {
                this.description = charSequence;
                return this;
            }
            throw new IllegalArgumentException("Description must follow a limit of 300 characters.");
        }

        public final Builder setIcon(Icon icon2) {
            this.icon = icon2;
            return this;
        }

        public final Builder setLastUsedTime(Instant instant) {
            this.lastUsedTime = instant;
            return this;
        }

        public final Builder setPasswordCredentialCount(int i10) {
            this.passwordCredentialCount = Integer.valueOf(i10);
            this.credentialCountInformationMap.put(PasswordCredential.TYPE_PASSWORD_CREDENTIAL, Integer.valueOf(i10));
            return this;
        }

        public final Builder setPublicKeyCredentialCount(int i10) {
            this.publicKeyCredentialCount = Integer.valueOf(i10);
            this.credentialCountInformationMap.put(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL, Integer.valueOf(i10));
            return this;
        }

        public final Builder setTotalCredentialCount(int i10) {
            this.totalCredentialCount = Integer.valueOf(i10);
            this.credentialCountInformationMap.put(CreateEntry.TYPE_TOTAL_CREDENTIAL, Integer.valueOf(i10));
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final CreateEntry fromSlice(Slice slice) {
            m.f(slice, "slice");
            if (Build.VERSION.SDK_INT >= 28) {
                return a.c(slice);
            }
            return null;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final Slice toSlice(CreateEntry createEntry) {
            m.f(createEntry, "createEntry");
            if (Build.VERSION.SDK_INT >= 28) {
                return a.d(createEntry);
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f15326a = new a();

        private a() {
        }

        public static final Map a(Bundle bundle) {
            HashMap hashMap = new HashMap();
            if (bundle == null) {
                return hashMap;
            }
            Set<String> keySet = bundle.keySet();
            m.e(keySet, "bundle.keySet()");
            for (String str : keySet) {
                try {
                    m.e(str, "it");
                    hashMap.put(str, Integer.valueOf(bundle.getInt(str)));
                } catch (Exception e10) {
                    Log.i("CreateEntry", "Issue unpacking credential count info bundle: " + e10.getMessage());
                }
            }
            return hashMap;
        }

        public static final Bundle b(Map map) {
            m.f(map, "credentialCountInformationMap");
            Bundle bundle = new Bundle();
            boolean z10 = false;
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    Object value = entry.getValue();
                    m.c(value);
                    bundle.putInt((String) entry.getKey(), ((Number) value).intValue());
                    z10 = true;
                }
            }
            if (!z10) {
                return null;
            }
            return bundle;
        }

        public static final CreateEntry c(Slice slice) {
            m.f(slice, "slice");
            Map linkedHashMap = new LinkedHashMap();
            List<SliceItem> items = slice.getItems();
            m.e(items, "slice.items");
            Map map = linkedHashMap;
            CharSequence charSequence = null;
            PendingIntent pendingIntent = null;
            Icon icon = null;
            CharSequence charSequence2 = null;
            Instant instant = null;
            boolean z10 = false;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint(CreateEntry.SLICE_HINT_ACCOUNT_NAME)) {
                    charSequence = sliceItem.getText();
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_ICON)) {
                    icon = sliceItem.getIcon();
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_PENDING_INTENT)) {
                    pendingIntent = sliceItem.getAction();
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_CREDENTIAL_COUNT_INFORMATION)) {
                    Map a10 = a(sliceItem.getBundle());
                    m.d(a10, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Int?>");
                    map = c0.d(a10);
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_LAST_USED_TIME_MILLIS)) {
                    instant = Instant.ofEpochMilli(sliceItem.getLong());
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_NOTE)) {
                    charSequence2 = sliceItem.getText();
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_LAST_USED_TIME_MILLIS)) {
                    instant = Instant.ofEpochMilli(sliceItem.getLong());
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_AUTO_SELECT_ALLOWED) && m.b(sliceItem.getText(), CreateEntry.AUTO_SELECT_TRUE_STRING)) {
                    z10 = true;
                }
            }
            try {
                m.c(charSequence);
                m.c(pendingIntent);
                return new CreateEntry(charSequence, pendingIntent, icon, charSequence2, instant, map, z10);
            } catch (Exception e10) {
                Log.i("CreateEntry", "fromSlice failed with: " + e10.getMessage());
                return null;
            }
        }

        public static final Slice d(CreateEntry createEntry) {
            String str;
            m.f(createEntry, "createEntry");
            CharSequence accountName = createEntry.getAccountName();
            Icon icon = createEntry.getIcon();
            CharSequence description = createEntry.getDescription();
            Instant lastUsedTime = createEntry.getLastUsedTime();
            Map access$getCredentialCountInformationMap$p = createEntry.credentialCountInformationMap;
            PendingIntent pendingIntent = createEntry.getPendingIntent();
            Slice.Builder builder = new Slice.Builder(Uri.EMPTY, new SliceSpec("CreateEntry", 1));
            if (createEntry.isAutoSelectAllowed()) {
                str = CreateEntry.AUTO_SELECT_TRUE_STRING;
            } else {
                str = CreateEntry.AUTO_SELECT_FALSE_STRING;
            }
            builder.addText(accountName, (String) null, r.e(CreateEntry.SLICE_HINT_ACCOUNT_NAME));
            if (lastUsedTime != null) {
                builder.addLong(lastUsedTime.toEpochMilli(), (String) null, r.e(CreateEntry.SLICE_HINT_LAST_USED_TIME_MILLIS));
            }
            if (description != null) {
                builder.addText(description, (String) null, r.e(CreateEntry.SLICE_HINT_NOTE));
            }
            if (icon != null) {
                builder.addIcon(icon, (String) null, r.e(CreateEntry.SLICE_HINT_ICON));
            }
            if (b(access$getCredentialCountInformationMap$p) != null) {
                builder.addBundle(b(access$getCredentialCountInformationMap$p), (String) null, r.e(CreateEntry.SLICE_HINT_CREDENTIAL_COUNT_INFORMATION));
            }
            builder.addAction(pendingIntent, new Slice.Builder(builder).addHints(Collections.singletonList(CreateEntry.SLICE_HINT_PENDING_INTENT)).build(), (String) null).addText(str, (String) null, r.e(CreateEntry.SLICE_HINT_AUTO_SELECT_ALLOWED));
            Slice build = builder.build();
            m.e(build, "sliceBuilder.build()");
            return build;
        }
    }

    public CreateEntry(CharSequence charSequence, PendingIntent pendingIntent2, Icon icon2, CharSequence charSequence2, Instant instant, Map<String, Integer> map, boolean z10) {
        m.f(charSequence, "accountName");
        m.f(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
        m.f(map, "credentialCountInformationMap");
        this.accountName = charSequence;
        this.pendingIntent = pendingIntent2;
        this.icon = icon2;
        this.description = charSequence2;
        this.lastUsedTime = instant;
        this.credentialCountInformationMap = map;
        this.isAutoSelectAllowed = z10;
        if (charSequence.length() <= 0) {
            throw new IllegalArgumentException("accountName must not be empty".toString());
        } else if (charSequence2 != null && charSequence2.length() > DESCRIPTION_MAX_CHAR_LIMIT) {
            throw new IllegalArgumentException("Description must follow a limit of 300 characters.".toString());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final CreateEntry fromSlice(Slice slice) {
        return Companion.fromSlice(slice);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final Slice toSlice(CreateEntry createEntry) {
        return Companion.toSlice(createEntry);
    }

    public final CharSequence getAccountName() {
        return this.accountName;
    }

    public final CharSequence getDescription() {
        return this.description;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final Instant getLastUsedTime() {
        return this.lastUsedTime;
    }

    public final Integer getPasswordCredentialCount() {
        return this.credentialCountInformationMap.get(PasswordCredential.TYPE_PASSWORD_CREDENTIAL);
    }

    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public final Integer getPublicKeyCredentialCount() {
        return this.credentialCountInformationMap.get(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL);
    }

    public final Integer getTotalCredentialCount() {
        return this.credentialCountInformationMap.get(TYPE_TOTAL_CREDENTIAL);
    }

    public final boolean isAutoSelectAllowed() {
        return this.isAutoSelectAllowed;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CreateEntry(java.lang.CharSequence r14, android.app.PendingIntent r15, java.lang.CharSequence r16, java.time.Instant r17, android.graphics.drawable.Icon r18, java.lang.Integer r19, java.lang.Integer r20, java.lang.Integer r21, boolean r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r6 = r2
            goto L_0x000b
        L_0x0009:
            r6 = r16
        L_0x000b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0011
            r7 = r2
            goto L_0x0013
        L_0x0011:
            r7 = r17
        L_0x0013:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0019
            r8 = r2
            goto L_0x001b
        L_0x0019:
            r8 = r18
        L_0x001b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0021
            r9 = r2
            goto L_0x0023
        L_0x0021:
            r9 = r19
        L_0x0023:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0029
            r10 = r2
            goto L_0x002b
        L_0x0029:
            r10 = r20
        L_0x002b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0031
            r11 = r2
            goto L_0x0033
        L_0x0031:
            r11 = r21
        L_0x0033:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x003a
            r0 = 0
            r12 = r0
            goto L_0x003c
        L_0x003a:
            r12 = r22
        L_0x003c:
            r3 = r13
            r4 = r14
            r5 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.provider.CreateEntry.<init>(java.lang.CharSequence, android.app.PendingIntent, java.lang.CharSequence, java.time.Instant, android.graphics.drawable.Icon, java.lang.Integer, java.lang.Integer, java.lang.Integer, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CreateEntry(CharSequence charSequence, PendingIntent pendingIntent2, CharSequence charSequence2, Instant instant, Icon icon2, Integer num, Integer num2, Integer num3, boolean z10) {
        this(charSequence, pendingIntent2, icon2, charSequence2, instant, i0.j(t.a(PasswordCredential.TYPE_PASSWORD_CREDENTIAL, num), t.a(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL, num2), t.a(TYPE_TOTAL_CREDENTIAL, num3)), z10);
        m.f(charSequence, "accountName");
        m.f(pendingIntent2, BaseGmsClient.KEY_PENDING_INTENT);
        Integer num4 = num;
    }
}
