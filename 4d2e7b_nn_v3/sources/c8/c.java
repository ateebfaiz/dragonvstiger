package c8;

import java.util.Iterator;

public abstract /* synthetic */ class c {
    public static /* synthetic */ String a(CharSequence charSequence, Iterable iterable) {
        if (charSequence != null) {
            StringBuilder sb2 = new StringBuilder();
            Iterator it = iterable.iterator();
            if (it.hasNext()) {
                while (true) {
                    sb2.append((CharSequence) it.next());
                    if (!it.hasNext()) {
                        break;
                    }
                    sb2.append(charSequence);
                }
            }
            return sb2.toString();
        }
        throw new NullPointerException("delimiter");
    }
}
