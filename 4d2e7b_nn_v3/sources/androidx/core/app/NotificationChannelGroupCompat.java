package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotificationChannelGroupCompat {
    private boolean mBlocked;
    private List<NotificationChannelCompat> mChannels;
    String mDescription;
    final String mId;
    CharSequence mName;

    public static class Builder {
        final NotificationChannelGroupCompat mGroup;

        public Builder(@NonNull String str) {
            this.mGroup = new NotificationChannelGroupCompat(str);
        }

        @NonNull
        public NotificationChannelGroupCompat build() {
            return this.mGroup;
        }

        @NonNull
        public Builder setDescription(@Nullable String str) {
            this.mGroup.mDescription = str;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence charSequence) {
            this.mGroup.mName = charSequence;
            return this;
        }
    }

    static class a {
        @DoNotInline
        static NotificationChannelGroup a(String str, CharSequence charSequence) {
            return new NotificationChannelGroup(str, charSequence);
        }

        @DoNotInline
        static List<NotificationChannel> b(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getChannels();
        }

        @DoNotInline
        static String c(NotificationChannel notificationChannel) {
            return notificationChannel.getGroup();
        }

        @DoNotInline
        static String d(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        @DoNotInline
        static CharSequence e(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getName();
        }
    }

    static class b {
        @DoNotInline
        static String a(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getDescription();
        }

        @DoNotInline
        static boolean b(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.isBlocked();
        }

        @DoNotInline
        static void c(NotificationChannelGroup notificationChannelGroup, String str) {
            notificationChannelGroup.setDescription(str);
        }
    }

    NotificationChannelGroupCompat(@NonNull String str) {
        this.mChannels = Collections.emptyList();
        this.mId = (String) Preconditions.checkNotNull(str);
    }

    @RequiresApi(26)
    private List<NotificationChannelCompat> getChannelsCompat(List<NotificationChannel> list) {
        ArrayList arrayList = new ArrayList();
        for (NotificationChannel a10 : list) {
            NotificationChannel a11 = j.a(a10);
            if (this.mId.equals(a.c(a11))) {
                arrayList.add(new NotificationChannelCompat(a11));
            }
        }
        return arrayList;
    }

    @NonNull
    public List<NotificationChannelCompat> getChannels() {
        return this.mChannels;
    }

    @Nullable
    public String getDescription() {
        return this.mDescription;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    @Nullable
    public CharSequence getName() {
        return this.mName;
    }

    /* access modifiers changed from: package-private */
    public NotificationChannelGroup getNotificationChannelGroup() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            return null;
        }
        NotificationChannelGroup a10 = a.a(this.mId, this.mName);
        if (i10 >= 28) {
            b.c(a10, this.mDescription);
        }
        return a10;
    }

    public boolean isBlocked() {
        return this.mBlocked;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this.mId).setName(this.mName).setDescription(this.mDescription);
    }

    @RequiresApi(28)
    NotificationChannelGroupCompat(@NonNull NotificationChannelGroup notificationChannelGroup) {
        this(notificationChannelGroup, Collections.emptyList());
    }

    @RequiresApi(26)
    NotificationChannelGroupCompat(@NonNull NotificationChannelGroup notificationChannelGroup, @NonNull List<NotificationChannel> list) {
        this(a.d(notificationChannelGroup));
        this.mName = a.e(notificationChannelGroup);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            this.mDescription = b.a(notificationChannelGroup);
        }
        if (i10 >= 28) {
            this.mBlocked = b.b(notificationChannelGroup);
            this.mChannels = getChannelsCompat(a.b(notificationChannelGroup));
            return;
        }
        this.mChannels = getChannelsCompat(list);
    }
}
