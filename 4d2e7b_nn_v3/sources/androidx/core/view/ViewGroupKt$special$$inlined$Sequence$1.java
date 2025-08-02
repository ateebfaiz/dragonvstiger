package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import java.util.Iterator;
import kotlin.sequences.Sequence;

public final class ViewGroupKt$special$$inlined$Sequence$1 implements Sequence<View> {
    final /* synthetic */ ViewGroup $this_descendants$inlined;

    public ViewGroupKt$special$$inlined$Sequence$1(ViewGroup viewGroup) {
        this.$this_descendants$inlined = viewGroup;
    }

    public Iterator<View> iterator() {
        return new TreeIterator(ViewGroupKt.getChildren(this.$this_descendants$inlined).iterator(), ViewGroupKt.a.f15175a);
    }
}
