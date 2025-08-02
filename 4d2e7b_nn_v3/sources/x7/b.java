package x7;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

@Deprecated
public class b extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private a f13229b;

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        this.f13229b.f(i10, i11, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f13229b = new a(this);
    }

    public void onResume() {
        super.onResume();
        this.f13229b.g();
    }
}
