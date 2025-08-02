package s2;

import s2.i;

public class f implements m {

    class a implements l {
        a() {
        }

        /* renamed from: a */
        public int compare(i.a aVar, i.a aVar2) {
            long a10 = aVar.a();
            long a11 = aVar2.a();
            if (a10 < a11) {
                return -1;
            }
            if (a11 == a10) {
                return 0;
            }
            return 1;
        }
    }

    public l get() {
        return new a();
    }
}
