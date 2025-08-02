package h5;

import android.util.SparseArray;
import java.util.LinkedList;

public class l {

    /* renamed from: a  reason: collision with root package name */
    protected final SparseArray f21962a = new SparseArray();

    /* renamed from: b  reason: collision with root package name */
    a f21963b;

    /* renamed from: c  reason: collision with root package name */
    a f21964c;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        a f21965a;

        /* renamed from: b  reason: collision with root package name */
        int f21966b;

        /* renamed from: c  reason: collision with root package name */
        LinkedList f21967c;

        /* renamed from: d  reason: collision with root package name */
        a f21968d;

        public String toString() {
            return "LinkedEntry(key: " + this.f21966b + ")";
        }

        private a(a aVar, int i10, LinkedList linkedList, a aVar2) {
            this.f21965a = aVar;
            this.f21966b = i10;
            this.f21967c = linkedList;
            this.f21968d = aVar2;
        }
    }

    private void b(a aVar) {
        if (aVar != null && aVar.f21967c.isEmpty()) {
            d(aVar);
            this.f21962a.remove(aVar.f21966b);
        }
    }

    private void c(a aVar) {
        if (this.f21963b != aVar) {
            d(aVar);
            a aVar2 = this.f21963b;
            if (aVar2 == null) {
                this.f21963b = aVar;
                this.f21964c = aVar;
                return;
            }
            aVar.f21968d = aVar2;
            aVar2.f21965a = aVar;
            this.f21963b = aVar;
        }
    }

    private synchronized void d(a aVar) {
        try {
            a aVar2 = aVar.f21965a;
            a aVar3 = aVar.f21968d;
            if (aVar2 != null) {
                aVar2.f21968d = aVar3;
            }
            if (aVar3 != null) {
                aVar3.f21965a = aVar2;
            }
            aVar.f21965a = null;
            aVar.f21968d = null;
            if (aVar == this.f21963b) {
                this.f21963b = aVar3;
            }
            if (aVar == this.f21964c) {
                this.f21964c = aVar2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized Object a(int i10) {
        a aVar = (a) this.f21962a.get(i10);
        if (aVar == null) {
            return null;
        }
        Object pollFirst = aVar.f21967c.pollFirst();
        c(aVar);
        return pollFirst;
    }

    public synchronized void e(int i10, Object obj) {
        try {
            a aVar = (a) this.f21962a.get(i10);
            if (aVar == null) {
                aVar = new a((a) null, i10, new LinkedList(), (a) null);
                this.f21962a.put(i10, aVar);
            }
            aVar.f21967c.addLast(obj);
            c(aVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized Object f() {
        a aVar = this.f21964c;
        if (aVar == null) {
            return null;
        }
        Object pollLast = aVar.f21967c.pollLast();
        b(aVar);
        return pollLast;
    }
}
