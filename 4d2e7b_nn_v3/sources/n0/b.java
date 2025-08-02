package n0;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import y0.l;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final List f22678a = new ArrayList();

    /* access modifiers changed from: package-private */
    public void a(u uVar) {
        this.f22678a.add(uVar);
    }

    public void b(Path path) {
        for (int size = this.f22678a.size() - 1; size >= 0; size--) {
            l.b(path, (u) this.f22678a.get(size));
        }
    }
}
