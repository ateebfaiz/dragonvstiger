package r9;

import android.content.Context;
import android.widget.Toast;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f12969a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f12970b;

    public /* synthetic */ b(Context context, String str) {
        this.f12969a = context;
        this.f12970b = str;
    }

    public final void run() {
        Toast.makeText(this.f12969a, this.f12970b, 1).show();
    }
}
