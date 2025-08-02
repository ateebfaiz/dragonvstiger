package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

public class NotificationChannelCompat {
    public static final String DEFAULT_CHANNEL_ID = "miscellaneous";
    private static final int DEFAULT_LIGHT_COLOR = 0;
    private static final boolean DEFAULT_SHOW_BADGE = true;
    AudioAttributes mAudioAttributes;
    private boolean mBypassDnd;
    private boolean mCanBubble;
    String mConversationId;
    String mDescription;
    String mGroupId;
    @NonNull
    final String mId;
    int mImportance;
    private boolean mImportantConversation;
    int mLightColor;
    boolean mLights;
    private int mLockscreenVisibility;
    CharSequence mName;
    String mParentId;
    boolean mShowBadge;
    Uri mSound;
    boolean mVibrationEnabled;
    long[] mVibrationPattern;

    public static class Builder {
        private final NotificationChannelCompat mChannel;

        public Builder(@NonNull String str, int i10) {
            this.mChannel = new NotificationChannelCompat(str, i10);
        }

        @NonNull
        public NotificationChannelCompat build() {
            return this.mChannel;
        }

        @NonNull
        public Builder setConversationId(@NonNull String str, @NonNull String str2) {
            if (Build.VERSION.SDK_INT >= 30) {
                NotificationChannelCompat notificationChannelCompat = this.mChannel;
                notificationChannelCompat.mParentId = str;
                notificationChannelCompat.mConversationId = str2;
            }
            return this;
        }

        @NonNull
        public Builder setDescription(@Nullable String str) {
            this.mChannel.mDescription = str;
            return this;
        }

        @NonNull
        public Builder setGroup(@Nullable String str) {
            this.mChannel.mGroupId = str;
            return this;
        }

        @NonNull
        public Builder setImportance(int i10) {
            this.mChannel.mImportance = i10;
            return this;
        }

        @NonNull
        public Builder setLightColor(int i10) {
            this.mChannel.mLightColor = i10;
            return this;
        }

        @NonNull
        public Builder setLightsEnabled(boolean z10) {
            this.mChannel.mLights = z10;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence charSequence) {
            this.mChannel.mName = charSequence;
            return this;
        }

        @NonNull
        public Builder setShowBadge(boolean z10) {
            this.mChannel.mShowBadge = z10;
            return this;
        }

        @NonNull
        public Builder setSound(@Nullable Uri uri, @Nullable AudioAttributes audioAttributes) {
            NotificationChannelCompat notificationChannelCompat = this.mChannel;
            notificationChannelCompat.mSound = uri;
            notificationChannelCompat.mAudioAttributes = audioAttributes;
            return this;
        }

        @NonNull
        public Builder setVibrationEnabled(boolean z10) {
            this.mChannel.mVibrationEnabled = z10;
            return this;
        }

        @NonNull
        public Builder setVibrationPattern(@Nullable long[] jArr) {
            boolean z10;
            NotificationChannelCompat notificationChannelCompat = this.mChannel;
            if (jArr == null || jArr.length <= 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            notificationChannelCompat.mVibrationEnabled = z10;
            notificationChannelCompat.mVibrationPattern = jArr;
            return this;
        }
    }

    static class a {
        @DoNotInline
        static boolean a(NotificationChannel notificationChannel) {
            return notificationChannel.canBypassDnd();
        }

        @DoNotInline
        static boolean b(NotificationChannel notificationChannel) {
            return notificationChannel.canShowBadge();
        }

        @DoNotInline
        static NotificationChannel c(String str, CharSequence charSequence, int i10) {
            return new NotificationChannel(str, charSequence, i10);
        }

        @DoNotInline
        static void d(NotificationChannel notificationChannel, boolean z10) {
            notificationChannel.enableLights(z10);
        }

        @DoNotInline
        static void e(NotificationChannel notificationChannel, boolean z10) {
            notificationChannel.enableVibration(z10);
        }

        @DoNotInline
        static AudioAttributes f(NotificationChannel notificationChannel) {
            return notificationChannel.getAudioAttributes();
        }

        @DoNotInline
        static String g(NotificationChannel notificationChannel) {
            return notificationChannel.getDescription();
        }

        @DoNotInline
        static String h(NotificationChannel notificationChannel) {
            return notificationChannel.getGroup();
        }

        @DoNotInline
        static String i(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        @DoNotInline
        static int j(NotificationChannel notificationChannel) {
            return notificationChannel.getImportance();
        }

        @DoNotInline
        static int k(NotificationChannel notificationChannel) {
            return notificationChannel.getLightColor();
        }

        @DoNotInline
        static int l(NotificationChannel notificationChannel) {
            return notificationChannel.getLockscreenVisibility();
        }

        @DoNotInline
        static CharSequence m(NotificationChannel notificationChannel) {
            return notificationChannel.getName();
        }

        @DoNotInline
        static Uri n(NotificationChannel notificationChannel) {
            return notificationChannel.getSound();
        }

        @DoNotInline
        static long[] o(NotificationChannel notificationChannel) {
            return notificationChannel.getVibrationPattern();
        }

        @DoNotInline
        static void p(NotificationChannel notificationChannel, String str) {
            notificationChannel.setDescription(str);
        }

        @DoNotInline
        static void q(NotificationChannel notificationChannel, String str) {
            notificationChannel.setGroup(str);
        }

        @DoNotInline
        static void r(NotificationChannel notificationChannel, int i10) {
            notificationChannel.setLightColor(i10);
        }

        @DoNotInline
        static void s(NotificationChannel notificationChannel, boolean z10) {
            notificationChannel.setShowBadge(z10);
        }

        @DoNotInline
        static void t(NotificationChannel notificationChannel, Uri uri, AudioAttributes audioAttributes) {
            notificationChannel.setSound(uri, audioAttributes);
        }

        @DoNotInline
        static void u(NotificationChannel notificationChannel, long[] jArr) {
            notificationChannel.setVibrationPattern(jArr);
        }

        @DoNotInline
        static boolean v(NotificationChannel notificationChannel) {
            return notificationChannel.shouldShowLights();
        }

        @DoNotInline
        static boolean w(NotificationChannel notificationChannel) {
            return notificationChannel.shouldVibrate();
        }
    }

    static class b {
        @DoNotInline
        static boolean a(NotificationChannel notificationChannel) {
            return notificationChannel.canBubble();
        }
    }

    static class c {
        @DoNotInline
        static String a(NotificationChannel notificationChannel) {
            return notificationChannel.getConversationId();
        }

        @DoNotInline
        static String b(NotificationChannel notificationChannel) {
            return notificationChannel.getParentChannelId();
        }

        @DoNotInline
        static boolean c(NotificationChannel notificationChannel) {
            return notificationChannel.isImportantConversation();
        }

        @DoNotInline
        static void d(NotificationChannel notificationChannel, String str, String str2) {
            notificationChannel.setConversationId(str, str2);
        }
    }

    NotificationChannelCompat(@NonNull String str, int i10) {
        this.mShowBadge = true;
        this.mSound = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.mLightColor = 0;
        this.mId = (String) Preconditions.checkNotNull(str);
        this.mImportance = i10;
        this.mAudioAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    }

    public boolean canBubble() {
        return this.mCanBubble;
    }

    public boolean canBypassDnd() {
        return this.mBypassDnd;
    }

    public boolean canShowBadge() {
        return this.mShowBadge;
    }

    @Nullable
    public AudioAttributes getAudioAttributes() {
        return this.mAudioAttributes;
    }

    @Nullable
    public String getConversationId() {
        return this.mConversationId;
    }

    @Nullable
    public String getDescription() {
        return this.mDescription;
    }

    @Nullable
    public String getGroup() {
        return this.mGroupId;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public int getLightColor() {
        return this.mLightColor;
    }

    public int getLockscreenVisibility() {
        return this.mLockscreenVisibility;
    }

    @Nullable
    public CharSequence getName() {
        return this.mName;
    }

    /* access modifiers changed from: package-private */
    public NotificationChannel getNotificationChannel() {
        String str;
        String str2;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            return null;
        }
        NotificationChannel c10 = a.c(this.mId, this.mName, this.mImportance);
        a.p(c10, this.mDescription);
        a.q(c10, this.mGroupId);
        a.s(c10, this.mShowBadge);
        a.t(c10, this.mSound, this.mAudioAttributes);
        a.d(c10, this.mLights);
        a.r(c10, this.mLightColor);
        a.u(c10, this.mVibrationPattern);
        a.e(c10, this.mVibrationEnabled);
        if (!(i10 < 30 || (str = this.mParentId) == null || (str2 = this.mConversationId) == null)) {
            c.d(c10, str, str2);
        }
        return c10;
    }

    @Nullable
    public String getParentChannelId() {
        return this.mParentId;
    }

    @Nullable
    public Uri getSound() {
        return this.mSound;
    }

    @Nullable
    public long[] getVibrationPattern() {
        return this.mVibrationPattern;
    }

    public boolean isImportantConversation() {
        return this.mImportantConversation;
    }

    public boolean shouldShowLights() {
        return this.mLights;
    }

    public boolean shouldVibrate() {
        return this.mVibrationEnabled;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this.mId, this.mImportance).setName(this.mName).setDescription(this.mDescription).setGroup(this.mGroupId).setShowBadge(this.mShowBadge).setSound(this.mSound, this.mAudioAttributes).setLightsEnabled(this.mLights).setLightColor(this.mLightColor).setVibrationEnabled(this.mVibrationEnabled).setVibrationPattern(this.mVibrationPattern).setConversationId(this.mParentId, this.mConversationId);
    }

    @RequiresApi(26)
    NotificationChannelCompat(@NonNull NotificationChannel notificationChannel) {
        this(a.i(notificationChannel), a.j(notificationChannel));
        this.mName = a.m(notificationChannel);
        this.mDescription = a.g(notificationChannel);
        this.mGroupId = a.h(notificationChannel);
        this.mShowBadge = a.b(notificationChannel);
        this.mSound = a.n(notificationChannel);
        this.mAudioAttributes = a.f(notificationChannel);
        this.mLights = a.v(notificationChannel);
        this.mLightColor = a.k(notificationChannel);
        this.mVibrationEnabled = a.w(notificationChannel);
        this.mVibrationPattern = a.o(notificationChannel);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.mParentId = c.b(notificationChannel);
            this.mConversationId = c.a(notificationChannel);
        }
        this.mBypassDnd = a.a(notificationChannel);
        this.mLockscreenVisibility = a.l(notificationChannel);
        if (i10 >= 29) {
            this.mCanBubble = b.a(notificationChannel);
        }
        if (i10 >= 30) {
            this.mImportantConversation = c.c(notificationChannel);
        }
    }
}
