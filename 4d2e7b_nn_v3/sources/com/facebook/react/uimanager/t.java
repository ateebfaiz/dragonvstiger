package com.facebook.react.uimanager;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.events.n;
import com.facebook.react.uimanager.events.o;
import com.facebook.react.uimanager.f1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p5.a;

public class t {

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f3915j = {0, 0};

    /* renamed from: a  reason: collision with root package name */
    private Map f3916a;

    /* renamed from: b  reason: collision with root package name */
    private Map f3917b;

    /* renamed from: c  reason: collision with root package name */
    private Map f3918c;

    /* renamed from: d  reason: collision with root package name */
    private Set f3919d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    private int f3920e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f3921f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f3922g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f3923h = 0;

    /* renamed from: i  reason: collision with root package name */
    private final ViewGroup f3924i;

    public t(ViewGroup viewGroup) {
        this.f3924i = viewGroup;
        this.f3918c = new HashMap();
    }

    private MotionEvent a(View view, MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int[] iArr = new int[2];
        this.f3924i.getLocationOnScreen(iArr);
        obtain.setLocation(motionEvent.getRawX() - ((float) iArr[0]), motionEvent.getRawY() - ((float) iArr[1]));
        return obtain;
    }

    private n.b b(int i10, MotionEvent motionEvent) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        for (int i11 = 0; i11 < motionEvent.getPointerCount(); i11++) {
            float[] fArr = new float[2];
            float[] fArr2 = {motionEvent.getX(i11), motionEvent.getY(i11)};
            List b10 = f1.b(fArr2[0], fArr2[1], this.f3924i, fArr);
            int pointerId = motionEvent.getPointerId(i11);
            hashMap.put(Integer.valueOf(pointerId), fArr);
            hashMap2.put(Integer.valueOf(pointerId), b10);
            hashMap3.put(Integer.valueOf(pointerId), fArr2);
            hashMap4.put(Integer.valueOf(pointerId), e(fArr2));
        }
        return new n.b(this.f3921f, i10, this.f3923h, k1.f(this.f3924i), hashMap, hashMap2, hashMap3, hashMap4, this.f3919d);
    }

    private void c(View view, n.b bVar, MotionEvent motionEvent, e eVar) {
        boolean z10;
        if (this.f3920e == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.b(z10, "Expected to not have already sent a cancel for this gesture");
        List list = (List) bVar.d().get(Integer.valueOf(bVar.b()));
        if (!list.isEmpty() && view != null) {
            if (m(list, o.b.CANCEL, o.b.CANCEL_CAPTURE)) {
                int b10 = ((f1.b) list.get(0)).b();
                int[] h10 = h(view);
                ((e) a.c(eVar)).c(n.i("topPointerCancel", b10, n(bVar, (float) h10[0], (float) h10[1]), motionEvent));
            }
            l();
            this.f3921f = -1;
        }
    }

    private static void d(String str, n.b bVar, MotionEvent motionEvent, List list, e eVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            eVar.c(n.i(str, ((f1.b) it.next()).b(), bVar, motionEvent));
        }
    }

    private float[] e(float[] fArr) {
        ViewGroup viewGroup = this.f3924i;
        int[] iArr = f3915j;
        viewGroup.getLocationOnScreen(iArr);
        return new float[]{fArr[0] + ((float) iArr[0]), fArr[1] + ((float) iArr[1])};
    }

    private static List f(List list, o.b bVar, o.b bVar2, boolean z10) {
        ArrayList arrayList = new ArrayList(list);
        if (z10) {
            return arrayList;
        }
        boolean z11 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            View a10 = ((f1.b) list.get(size)).a();
            if (!z11 && !o.h(a10, bVar2) && !o.h(a10, bVar)) {
                arrayList.remove(size);
            } else if (!z11 && o.h(a10, bVar2)) {
                z11 = true;
            }
        }
        return arrayList;
    }

    private static List g(List list, List list2) {
        if (list.isEmpty()) {
            return new ArrayList();
        }
        if (list2.isEmpty()) {
            return new ArrayList();
        }
        HashSet hashSet = new HashSet(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            f1.b bVar = (f1.b) it.next();
            if (hashSet.contains(bVar)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    private int[] h(View view) {
        Rect rect = new Rect(0, 0, 1, 1);
        this.f3924i.offsetDescendantRectToMyCoords(view, rect);
        return new int[]{rect.top, rect.left};
    }

    private short i() {
        return (short) (65535 & this.f3922g);
    }

    private void j(int i10, n.b bVar, MotionEvent motionEvent, e eVar) {
        List list;
        List list2;
        int b10 = bVar.b();
        if (i10 != -1) {
            list = (List) bVar.d().get(Integer.valueOf(b10));
        } else {
            list = new ArrayList();
        }
        Map map = this.f3916a;
        if (map == null || !map.containsKey(Integer.valueOf(b10))) {
            list2 = new ArrayList();
        } else {
            list2 = (List) this.f3916a.get(Integer.valueOf(b10));
        }
        int i11 = 0;
        boolean z10 = false;
        boolean z11 = false;
        while (i11 < Math.min(list.size(), list2.size()) && ((f1.b) list.get((list.size() - 1) - i11)).equals(list2.get((list2.size() - 1) - i11))) {
            View a10 = ((f1.b) list.get((list.size() - 1) - i11)).a();
            if (!z10 && o.h(a10, o.b.ENTER_CAPTURE)) {
                z10 = true;
            }
            if (!z11 && o.h(a10, o.b.LEAVE_CAPTURE)) {
                z11 = true;
            }
            i11++;
        }
        if (i11 < Math.max(list.size(), list2.size())) {
            l();
            if (list2.size() > 0) {
                int b11 = ((f1.b) list2.get(0)).b();
                if (m(list2, o.b.OUT, o.b.OUT_CAPTURE)) {
                    eVar.c(n.i("topPointerOut", b11, bVar, motionEvent));
                }
                List f10 = f(list2.subList(0, list2.size() - i11), o.b.LEAVE, o.b.LEAVE_CAPTURE, z11);
                if (f10.size() > 0) {
                    d("topPointerLeave", bVar, motionEvent, f10, eVar);
                }
            }
            if (m(list, o.b.OVER, o.b.OVER_CAPTURE)) {
                eVar.c(n.i("topPointerOver", i10, bVar, motionEvent));
            }
            List f11 = f(list.subList(0, list.size() - i11), o.b.ENTER, o.b.ENTER_CAPTURE, z10);
            if (f11.size() > 0) {
                Collections.reverse(f11);
                d("topPointerEnter", bVar, motionEvent, f11, eVar);
            }
        }
        HashMap hashMap = new HashMap(bVar.d());
        if (i10 == -1) {
            hashMap.remove(Integer.valueOf(b10));
        }
        this.f3916a = hashMap;
    }

    private void l() {
        this.f3922g = (this.f3922g + 1) % Integer.MAX_VALUE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m(java.util.List r2, com.facebook.react.uimanager.events.o.b r3, com.facebook.react.uimanager.events.o.b r4) {
        /*
            java.util.Iterator r2 = r2.iterator()
        L_0x0004:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0026
            java.lang.Object r0 = r2.next()
            com.facebook.react.uimanager.f1$b r0 = (com.facebook.react.uimanager.f1.b) r0
            android.view.View r1 = r0.a()
            boolean r1 = com.facebook.react.uimanager.events.o.h(r1, r3)
            if (r1 != 0) goto L_0x0024
            android.view.View r0 = r0.a()
            boolean r0 = com.facebook.react.uimanager.events.o.h(r0, r4)
            if (r0 == 0) goto L_0x0004
        L_0x0024:
            r2 = 1
            return r2
        L_0x0026:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.t.m(java.util.List, com.facebook.react.uimanager.events.o$b, com.facebook.react.uimanager.events.o$b):boolean");
    }

    private n.b n(n.b bVar, float f10, float f11) {
        HashMap hashMap = new HashMap(bVar.h());
        HashMap hashMap2 = new HashMap(bVar.c());
        HashMap hashMap3 = new HashMap(bVar.j());
        float[] fArr = {f10, f11};
        for (Map.Entry value : hashMap.entrySet()) {
            value.setValue(fArr);
        }
        float[] fArr2 = {0.0f, 0.0f};
        for (Map.Entry value2 : hashMap2.entrySet()) {
            value2.setValue(fArr2);
        }
        float[] e10 = e(fArr);
        for (Map.Entry value3 : hashMap3.entrySet()) {
            value3.setValue(e10);
        }
        return new n.b(bVar.i(), bVar.b(), bVar.g(), bVar.k(), hashMap, new HashMap(bVar.d()), hashMap2, hashMap3, new HashSet(bVar.f()));
    }

    private void q(int i10, n.b bVar, MotionEvent motionEvent, e eVar) {
        List list = (List) bVar.d().get(Integer.valueOf(bVar.b()));
        l();
        if (!this.f3919d.contains(Integer.valueOf(bVar.b()))) {
            if (m(list, o.b.OVER, o.b.OVER_CAPTURE)) {
                eVar.c(n.i("topPointerOver", i10, bVar, motionEvent));
            }
            List f10 = f(list, o.b.ENTER, o.b.ENTER_CAPTURE, false);
            Collections.reverse(f10);
            d("topPointerEnter", bVar, motionEvent, f10, eVar);
        }
        if (m(list, o.b.CLICK, o.b.CLICK_CAPTURE)) {
            this.f3918c.put(Integer.valueOf(bVar.b()), new ArrayList(list));
        }
        if (m(list, o.b.DOWN, o.b.DOWN_CAPTURE)) {
            eVar.c(n.i("topPointerDown", i10, bVar, motionEvent));
        }
    }

    private void r(int i10, n.b bVar, MotionEvent motionEvent, e eVar) {
        if (m((List) bVar.d().get(Integer.valueOf(bVar.b())), o.b.MOVE, o.b.MOVE_CAPTURE)) {
            eVar.c(n.j("topPointerMove", i10, bVar, motionEvent, i()));
        }
    }

    private void s(int i10, n.b bVar, MotionEvent motionEvent, e eVar) {
        int b10 = bVar.b();
        List list = (List) bVar.d().get(Integer.valueOf(b10));
        if (m(list, o.b.UP, o.b.UP_CAPTURE)) {
            eVar.c(n.i("topPointerUp", i10, bVar, motionEvent));
        }
        if (!this.f3919d.contains(Integer.valueOf(b10))) {
            if (m(list, o.b.OUT, o.b.OUT_CAPTURE)) {
                eVar.c(n.i("topPointerOut", i10, bVar, motionEvent));
            }
            d("topPointerLeave", bVar, motionEvent, f(list, o.b.LEAVE, o.b.LEAVE_CAPTURE, false), eVar);
        }
        List list2 = (List) this.f3918c.remove(Integer.valueOf(b10));
        if (list2 != null && m(list, o.b.CLICK, o.b.CLICK_CAPTURE)) {
            List g10 = g(list2, list);
            if (!g10.isEmpty()) {
                eVar.c(n.i("topClick", ((f1.b) g10.get(0)).b(), bVar, motionEvent));
            }
        }
        if (motionEvent.getActionMasked() == 1) {
            this.f3921f = -1;
        }
        this.f3919d.remove(Integer.valueOf(b10));
    }

    private static boolean t(float[] fArr, float[] fArr2) {
        if (Math.abs(fArr2[0] - fArr[0]) > 0.1f || Math.abs(fArr2[1] - fArr[1]) > 0.1f) {
            return true;
        }
        return false;
    }

    public void k(MotionEvent motionEvent, e eVar, boolean z10) {
        boolean z11;
        int i10;
        View view;
        List list;
        if (this.f3920e == -1) {
            int actionMasked = motionEvent.getActionMasked();
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (actionMasked == 0) {
                this.f3921f = motionEvent.getPointerId(0);
            } else if (actionMasked == 7) {
                this.f3919d.add(Integer.valueOf(pointerId));
            }
            n.b b10 = b(pointerId, motionEvent);
            if (!z10 || motionEvent.getActionMasked() != 10) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                Map map = this.f3916a;
                if (map != null) {
                    list = (List) map.get(Integer.valueOf(b10.b()));
                } else {
                    list = null;
                }
                if (list != null && !list.isEmpty()) {
                    f1.b bVar = (f1.b) list.get(list.size() - 1);
                    i10 = bVar.b();
                    view = bVar.a();
                    b10.d().put(Integer.valueOf(pointerId), new ArrayList());
                } else {
                    return;
                }
            } else {
                List list2 = (List) b10.d().get(Integer.valueOf(pointerId));
                if (list2 != null && !list2.isEmpty()) {
                    f1.b bVar2 = (f1.b) list2.get(0);
                    i10 = bVar2.b();
                    view = bVar2.a();
                } else {
                    return;
                }
            }
            j(i10, b10, motionEvent, eVar);
            switch (actionMasked) {
                case 0:
                case 5:
                    q(i10, b10, motionEvent, eVar);
                    break;
                case 1:
                case 6:
                    l();
                    s(i10, b10, motionEvent, eVar);
                    break;
                case 2:
                    r(i10, b10, motionEvent, eVar);
                    break;
                case 3:
                    c(view, b10, motionEvent, eVar);
                    j(-1, b10, motionEvent, eVar);
                    break;
                case 7:
                    float[] fArr = (float[]) b10.c().get(Integer.valueOf(pointerId));
                    Map map2 = this.f3917b;
                    if (t(fArr, (map2 == null || !map2.containsKey(Integer.valueOf(pointerId))) ? new float[]{0.0f, 0.0f} : (float[]) this.f3917b.get(Integer.valueOf(pointerId)))) {
                        r(i10, b10, motionEvent, eVar);
                        break;
                    } else {
                        return;
                    }
                    break;
                case 9:
                    return;
                case 10:
                    if (z11) {
                        r(i10, b10, motionEvent, eVar);
                        break;
                    }
                    break;
                default:
                    z2.a.G("ReactNative", "Motion Event was ignored. Action=" + actionMasked + " Target=" + i10);
                    return;
            }
            this.f3917b = new HashMap(b10.c());
            this.f3923h = motionEvent.getButtonState();
            this.f3919d.retainAll(this.f3917b.keySet());
        }
    }

    public void o() {
        this.f3920e = -1;
    }

    public void p(View view, MotionEvent motionEvent, e eVar) {
        if (this.f3920e == -1 && view != null) {
            MotionEvent a10 = a(view, motionEvent);
            a10.setAction(3);
            k(a10, eVar, false);
            this.f3920e = view.getId();
        }
    }
}
