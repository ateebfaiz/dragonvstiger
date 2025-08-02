package androidx.core.app;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.PendingIntentCompat;

public final /* synthetic */ class s implements PendingIntent.OnFinished {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PendingIntentCompat.c f14871a;

    public /* synthetic */ s(PendingIntentCompat.c cVar) {
        this.f14871a = cVar;
    }

    public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i10, String str, Bundle bundle) {
        this.f14871a.j(pendingIntent, intent, i10, str, bundle);
    }
}
