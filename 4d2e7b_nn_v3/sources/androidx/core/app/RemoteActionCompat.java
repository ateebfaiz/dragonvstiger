package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;

public final class RemoteActionCompat implements VersionedParcelable {
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PendingIntent mActionIntent;
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence mContentDescription;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean mEnabled;
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public IconCompat mIcon;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean mShouldShowIcon;
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CharSequence mTitle;

    static class a {
        @DoNotInline
        static RemoteAction a(Icon icon, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
            return new RemoteAction(icon, charSequence, charSequence2, pendingIntent);
        }

        @DoNotInline
        static PendingIntent b(RemoteAction remoteAction) {
            return remoteAction.getActionIntent();
        }

        @DoNotInline
        static CharSequence c(RemoteAction remoteAction) {
            return remoteAction.getContentDescription();
        }

        @DoNotInline
        static Icon d(RemoteAction remoteAction) {
            return remoteAction.getIcon();
        }

        @DoNotInline
        static CharSequence e(RemoteAction remoteAction) {
            return remoteAction.getTitle();
        }

        @DoNotInline
        static boolean f(RemoteAction remoteAction) {
            return remoteAction.isEnabled();
        }

        @DoNotInline
        static void g(RemoteAction remoteAction, boolean z10) {
            remoteAction.setEnabled(z10);
        }
    }

    static class b {
        @DoNotInline
        static void a(RemoteAction remoteAction, boolean z10) {
            remoteAction.setShouldShowIcon(z10);
        }

        @DoNotInline
        static boolean b(RemoteAction remoteAction) {
            return remoteAction.shouldShowIcon();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteActionCompat() {
    }

    @RequiresApi(26)
    @NonNull
    public static RemoteActionCompat createFromRemoteAction(@NonNull RemoteAction remoteAction) {
        Preconditions.checkNotNull(remoteAction);
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat(IconCompat.createFromIcon(a.d(remoteAction)), a.e(remoteAction), a.c(remoteAction), a.b(remoteAction));
        remoteActionCompat.setEnabled(a.f(remoteAction));
        if (Build.VERSION.SDK_INT >= 28) {
            remoteActionCompat.setShouldShowIcon(b.b(remoteAction));
        }
        return remoteActionCompat;
    }

    @NonNull
    public PendingIntent getActionIntent() {
        return this.mActionIntent;
    }

    @NonNull
    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    @NonNull
    public IconCompat getIcon() {
        return this.mIcon;
    }

    @NonNull
    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean z10) {
        this.mEnabled = z10;
    }

    public void setShouldShowIcon(boolean z10) {
        this.mShouldShowIcon = z10;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public boolean shouldShowIcon() {
        return this.mShouldShowIcon;
    }

    @RequiresApi(26)
    @NonNull
    public RemoteAction toRemoteAction() {
        RemoteAction a10 = a.a(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
        a.g(a10, isEnabled());
        if (Build.VERSION.SDK_INT >= 28) {
            b.a(a10, shouldShowIcon());
        }
        return a10;
    }

    public RemoteActionCompat(@NonNull IconCompat iconCompat, @NonNull CharSequence charSequence, @NonNull CharSequence charSequence2, @NonNull PendingIntent pendingIntent) {
        this.mIcon = (IconCompat) Preconditions.checkNotNull(iconCompat);
        this.mTitle = (CharSequence) Preconditions.checkNotNull(charSequence);
        this.mContentDescription = (CharSequence) Preconditions.checkNotNull(charSequence2);
        this.mActionIntent = (PendingIntent) Preconditions.checkNotNull(pendingIntent);
        this.mEnabled = true;
        this.mShouldShowIcon = true;
    }

    public RemoteActionCompat(@NonNull RemoteActionCompat remoteActionCompat) {
        Preconditions.checkNotNull(remoteActionCompat);
        this.mIcon = remoteActionCompat.mIcon;
        this.mTitle = remoteActionCompat.mTitle;
        this.mContentDescription = remoteActionCompat.mContentDescription;
        this.mActionIntent = remoteActionCompat.mActionIntent;
        this.mEnabled = remoteActionCompat.mEnabled;
        this.mShouldShowIcon = remoteActionCompat.mShouldShowIcon;
    }
}
