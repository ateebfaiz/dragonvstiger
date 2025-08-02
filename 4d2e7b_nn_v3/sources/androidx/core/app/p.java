package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class p implements NotificationBuilderWithBuilderAccessor {

    /* renamed from: a  reason: collision with root package name */
    private final Context f14860a;

    /* renamed from: b  reason: collision with root package name */
    private final Notification.Builder f14861b;

    /* renamed from: c  reason: collision with root package name */
    private final NotificationCompat.Builder f14862c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f14863d;

    /* renamed from: e  reason: collision with root package name */
    private RemoteViews f14864e;

    /* renamed from: f  reason: collision with root package name */
    private final List f14865f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f14866g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    private int f14867h;

    /* renamed from: i  reason: collision with root package name */
    private RemoteViews f14868i;

    static class a {
        @DoNotInline
        static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        @DoNotInline
        static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        @DoNotInline
        static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        @DoNotInline
        static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        @DoNotInline
        static Notification.Action.Builder e(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i10, charSequence, pendingIntent);
        }

        @DoNotInline
        static String f(Notification notification) {
            return notification.getGroup();
        }

        @DoNotInline
        static Notification.Builder g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        @DoNotInline
        static Notification.Builder h(Notification.Builder builder, boolean z10) {
            return builder.setGroupSummary(z10);
        }

        @DoNotInline
        static Notification.Builder i(Notification.Builder builder, boolean z10) {
            return builder.setLocalOnly(z10);
        }

        @DoNotInline
        static Notification.Builder j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    static class b {
        @DoNotInline
        static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        @DoNotInline
        static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        @DoNotInline
        static Notification.Builder c(Notification.Builder builder, int i10) {
            return builder.setColor(i10);
        }

        @DoNotInline
        static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        @DoNotInline
        static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        @DoNotInline
        static Notification.Builder f(Notification.Builder builder, int i10) {
            return builder.setVisibility(i10);
        }
    }

    static class c {
        @DoNotInline
        static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        @DoNotInline
        static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        @DoNotInline
        static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    static class d {
        @DoNotInline
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
            return builder.setAllowGeneratedReplies(z10);
        }

        @DoNotInline
        static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        @DoNotInline
        static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        @DoNotInline
        static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        @DoNotInline
        static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    static class e {
        @DoNotInline
        static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        @DoNotInline
        static Notification.Builder b(Notification.Builder builder, int i10) {
            return builder.setBadgeIconType(i10);
        }

        @DoNotInline
        static Notification.Builder c(Notification.Builder builder, boolean z10) {
            return builder.setColorized(z10);
        }

        @DoNotInline
        static Notification.Builder d(Notification.Builder builder, int i10) {
            return builder.setGroupAlertBehavior(i10);
        }

        @DoNotInline
        static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        @DoNotInline
        static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        @DoNotInline
        static Notification.Builder g(Notification.Builder builder, long j10) {
            return builder.setTimeoutAfter(j10);
        }
    }

    static class f {
        @DoNotInline
        static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        @DoNotInline
        static Notification.Action.Builder b(Notification.Action.Builder builder, int i10) {
            return builder.setSemanticAction(i10);
        }
    }

    static class g {
        @DoNotInline
        static Notification.Builder a(Notification.Builder builder, boolean z10) {
            return builder.setAllowSystemGeneratedContextualActions(z10);
        }

        @DoNotInline
        static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        @DoNotInline
        static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z10) {
            return builder.setContextual(z10);
        }

        @DoNotInline
        static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    static class h {
        @DoNotInline
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
            return builder.setAuthenticationRequired(z10);
        }

        @DoNotInline
        static Notification.Builder b(Notification.Builder builder, int i10) {
            return builder.setForegroundServiceBehavior(i10);
        }
    }

    p(NotificationCompat.Builder builder) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        Icon icon;
        List<String> list;
        int i10;
        this.f14862c = builder;
        Context context = builder.mContext;
        this.f14860a = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f14861b = e.a(context, builder.mChannelId);
        } else {
            this.f14861b = new Notification.Builder(builder.mContext);
        }
        Notification notification = builder.mNotification;
        Notification.Builder lights = this.f14861b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.mTickerView).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        if ((notification.flags & 2) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Notification.Builder ongoing = lights.setOngoing(z10);
        if ((notification.flags & 8) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z11);
        if ((notification.flags & 16) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z12).setDefaults(notification.defaults).setContentTitle(builder.mContentTitle).setContentText(builder.mContentText).setContentInfo(builder.mContentInfo).setContentIntent(builder.mContentIntent).setDeleteIntent(notification.deleteIntent);
        PendingIntent pendingIntent = builder.mFullScreenIntent;
        if ((notification.flags & 128) != 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        deleteIntent.setFullScreenIntent(pendingIntent, z13).setNumber(builder.mNumber).setProgress(builder.mProgressMax, builder.mProgress, builder.mProgressIndeterminate);
        Notification.Builder builder2 = this.f14861b;
        IconCompat iconCompat = builder.mLargeIcon;
        if (iconCompat == null) {
            icon = null;
        } else {
            icon = iconCompat.toIcon(context);
        }
        c.b(builder2, icon);
        this.f14861b.setSubText(builder.mSubText).setUsesChronometer(builder.mUseChronometer).setPriority(builder.mPriority);
        NotificationCompat.Style style = builder.mStyle;
        if (style instanceof NotificationCompat.CallStyle) {
            for (NotificationCompat.Action a10 : ((NotificationCompat.CallStyle) style).getActionsListWithSystemActions()) {
                a(a10);
            }
        } else {
            Iterator<NotificationCompat.Action> it = builder.mActions.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        }
        Bundle bundle = builder.mExtras;
        if (bundle != null) {
            this.f14866g.putAll(bundle);
        }
        int i11 = Build.VERSION.SDK_INT;
        this.f14863d = builder.mContentView;
        this.f14864e = builder.mBigContentView;
        this.f14861b.setShowWhen(builder.mShowWhen);
        a.i(this.f14861b, builder.mLocalOnly);
        a.g(this.f14861b, builder.mGroupKey);
        a.j(this.f14861b, builder.mSortKey);
        a.h(this.f14861b, builder.mGroupSummary);
        this.f14867h = builder.mGroupAlertBehavior;
        b.b(this.f14861b, builder.mCategory);
        b.c(this.f14861b, builder.mColor);
        b.f(this.f14861b, builder.mVisibility);
        b.d(this.f14861b, builder.mPublicVersion);
        b.e(this.f14861b, notification.sound, notification.audioAttributes);
        if (i11 < 28) {
            list = d(f(builder.mPersonList), builder.mPeople);
        } else {
            list = builder.mPeople;
        }
        if (list != null && !list.isEmpty()) {
            for (String a11 : list) {
                b.a(this.f14861b, a11);
            }
        }
        this.f14868i = builder.mHeadsUpContentView;
        if (builder.mInvisibleActions.size() > 0) {
            Bundle bundle2 = builder.getExtras().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i12 = 0; i12 < builder.mInvisibleActions.size(); i12++) {
                bundle4.putBundle(Integer.toString(i12), q.e(builder.mInvisibleActions.get(i12)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            builder.getExtras().putBundle("android.car.EXTENSIONS", bundle2);
            this.f14866g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i13 = Build.VERSION.SDK_INT;
        Object obj = builder.mSmallIcon;
        if (obj != null) {
            c.c(this.f14861b, obj);
        }
        if (i13 >= 24) {
            this.f14861b.setExtras(builder.mExtras);
            d.e(this.f14861b, builder.mRemoteInputHistory);
            RemoteViews remoteViews = builder.mContentView;
            if (remoteViews != null) {
                d.c(this.f14861b, remoteViews);
            }
            RemoteViews remoteViews2 = builder.mBigContentView;
            if (remoteViews2 != null) {
                d.b(this.f14861b, remoteViews2);
            }
            RemoteViews remoteViews3 = builder.mHeadsUpContentView;
            if (remoteViews3 != null) {
                d.d(this.f14861b, remoteViews3);
            }
        }
        if (i13 >= 26) {
            e.b(this.f14861b, builder.mBadgeIcon);
            e.e(this.f14861b, builder.mSettingsText);
            e.f(this.f14861b, builder.mShortcutId);
            e.g(this.f14861b, builder.mTimeout);
            e.d(this.f14861b, builder.mGroupAlertBehavior);
            if (builder.mColorizedSet) {
                e.c(this.f14861b, builder.mColorized);
            }
            if (!TextUtils.isEmpty(builder.mChannelId)) {
                this.f14861b.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
        if (i13 >= 28) {
            Iterator<Person> it2 = builder.mPersonList.iterator();
            while (it2.hasNext()) {
                f.a(this.f14861b, it2.next().toAndroidPerson());
            }
        }
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 29) {
            g.a(this.f14861b, builder.mAllowSystemGeneratedContextualActions);
            g.b(this.f14861b, NotificationCompat.BubbleMetadata.toPlatform(builder.mBubbleMetadata));
            LocusIdCompat locusIdCompat = builder.mLocusId;
            if (locusIdCompat != null) {
                g.d(this.f14861b, locusIdCompat.toLocusId());
            }
        }
        if (i14 >= 31 && (i10 = builder.mFgsDeferBehavior) != 0) {
            h.b(this.f14861b, i10);
        }
        if (builder.mSilent) {
            if (this.f14862c.mGroupSummary) {
                this.f14867h = 2;
            } else {
                this.f14867h = 1;
            }
            this.f14861b.setVibrate((long[]) null);
            this.f14861b.setSound((Uri) null);
            int i15 = notification.defaults & -4;
            notification.defaults = i15;
            this.f14861b.setDefaults(i15);
            if (i14 >= 26) {
                if (TextUtils.isEmpty(this.f14862c.mGroupKey)) {
                    a.g(this.f14861b, NotificationCompat.GROUP_KEY_SILENT);
                }
                e.d(this.f14861b, this.f14867h);
            }
        }
    }

    private void a(NotificationCompat.Action action) {
        Icon icon;
        Bundle bundle;
        IconCompat iconCompat = action.getIconCompat();
        if (iconCompat != null) {
            icon = iconCompat.toIcon();
        } else {
            icon = null;
        }
        Notification.Action.Builder a10 = c.a(icon, action.getTitle(), action.getActionIntent());
        if (action.getRemoteInputs() != null) {
            for (RemoteInput c10 : RemoteInput.fromCompat(action.getRemoteInputs())) {
                a.c(a10, c10);
            }
        }
        if (action.getExtras() != null) {
            bundle = new Bundle(action.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            d.a(a10, action.getAllowGeneratedReplies());
        }
        bundle.putInt("android.support.action.semanticAction", action.getSemanticAction());
        if (i10 >= 28) {
            f.b(a10, action.getSemanticAction());
        }
        if (i10 >= 29) {
            g.c(a10, action.isContextual());
        }
        if (i10 >= 31) {
            h.a(a10, action.isAuthenticationRequired());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", action.getShowsUserInterface());
        a.b(a10, bundle);
        a.a(this.f14861b, a.d(a10));
    }

    private static List d(List list, List list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        ArraySet arraySet = new ArraySet(list.size() + list2.size());
        arraySet.addAll(list);
        arraySet.addAll(list2);
        return new ArrayList(arraySet);
    }

    private static List f(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Person) it.next()).resolveToLegacyUri());
        }
        return arrayList;
    }

    private void g(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }

    public Notification b() {
        RemoteViews remoteViews;
        Bundle extras;
        RemoteViews makeHeadsUpContentView;
        RemoteViews makeBigContentView;
        NotificationCompat.Style style = this.f14862c.mStyle;
        if (style != null) {
            style.apply(this);
        }
        if (style != null) {
            remoteViews = style.makeContentView(this);
        } else {
            remoteViews = null;
        }
        Notification c10 = c();
        if (remoteViews != null) {
            c10.contentView = remoteViews;
        } else {
            RemoteViews remoteViews2 = this.f14862c.mContentView;
            if (remoteViews2 != null) {
                c10.contentView = remoteViews2;
            }
        }
        if (!(style == null || (makeBigContentView = style.makeBigContentView(this)) == null)) {
            c10.bigContentView = makeBigContentView;
        }
        if (!(style == null || (makeHeadsUpContentView = this.f14862c.mStyle.makeHeadsUpContentView(this)) == null)) {
            c10.headsUpContentView = makeHeadsUpContentView;
        }
        if (!(style == null || (extras = NotificationCompat.getExtras(c10)) == null)) {
            style.addCompatExtras(extras);
        }
        return c10;
    }

    /* access modifiers changed from: protected */
    public Notification c() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            return this.f14861b.build();
        }
        if (i10 >= 24) {
            Notification build = this.f14861b.build();
            if (this.f14867h != 0) {
                if (!(a.f(build) == null || (build.flags & 512) == 0 || this.f14867h != 2)) {
                    g(build);
                }
                if (a.f(build) != null && (build.flags & 512) == 0 && this.f14867h == 1) {
                    g(build);
                }
            }
            return build;
        }
        this.f14861b.setExtras(this.f14866g);
        Notification build2 = this.f14861b.build();
        RemoteViews remoteViews = this.f14863d;
        if (remoteViews != null) {
            build2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f14864e;
        if (remoteViews2 != null) {
            build2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.f14868i;
        if (remoteViews3 != null) {
            build2.headsUpContentView = remoteViews3;
        }
        if (this.f14867h != 0) {
            if (!(a.f(build2) == null || (build2.flags & 512) == 0 || this.f14867h != 2)) {
                g(build2);
            }
            if (a.f(build2) != null && (build2.flags & 512) == 0 && this.f14867h == 1) {
                g(build2);
            }
        }
        return build2;
    }

    /* access modifiers changed from: package-private */
    public Context e() {
        return this.f14860a;
    }

    public Notification.Builder getBuilder() {
        return this.f14861b;
    }
}
