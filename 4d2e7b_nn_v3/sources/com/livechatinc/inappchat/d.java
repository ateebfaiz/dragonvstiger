package com.livechatinc.inappchat;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.livechatinc.inappchat.a;
import java.util.HashMap;

public final class d extends Fragment implements c {

    /* renamed from: a  reason: collision with root package name */
    private a f10139a;

    /* renamed from: b  reason: collision with root package name */
    private g f10140b;

    public static d a(Object obj, Object obj2, String str, String str2, HashMap hashMap) {
        Bundle bundle = new Bundle();
        bundle.putString("KEY_LICENCE_NUMBER", String.valueOf(obj));
        bundle.putString("KEY_GROUP_ID", String.valueOf(obj2));
        if (str != null) {
            bundle.putString("KEY_VISITOR_NAME", str);
        }
        if (str2 != null) {
            bundle.putString("KEY_VISITOR_EMAIL", str2);
        }
        if (hashMap != null) {
            for (String str3 : hashMap.keySet()) {
                bundle.putString("#LCcustomParam_" + str3, (String) hashMap.get(str3));
            }
        }
        d dVar = new d();
        dVar.setArguments(bundle);
        return dVar;
    }

    public boolean handleUri(Uri uri) {
        return false;
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        this.f10140b.a(i10, i11, intent);
    }

    public void onChatWindowVisibilityChanged(boolean z10) {
        if (!z10) {
            getActivity().onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.C0116a aVar = new a.C0116a();
        HashMap hashMap = new HashMap();
        if (getArguments() != null) {
            for (String next : getArguments().keySet()) {
                if ("KEY_LICENCE_NUMBER".equals(next)) {
                    aVar.d(getArguments().getString("KEY_LICENCE_NUMBER"));
                } else if ("KEY_GROUP_ID".equals(next)) {
                    aVar.c(getArguments().getString("KEY_GROUP_ID"));
                } else if ("KEY_VISITOR_NAME".equals(next)) {
                    aVar.f(getArguments().getString("KEY_VISITOR_NAME"));
                } else if ("KEY_VISITOR_EMAIL".equals(next)) {
                    aVar.e(getArguments().getString("KEY_VISITOR_EMAIL"));
                } else {
                    hashMap.put(next, String.valueOf(getArguments().get(next)));
                }
            }
            aVar.b(hashMap);
        }
        this.f10139a = aVar.a();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        g gVar = (g) layoutInflater.inflate(i.f10146a, viewGroup, false);
        this.f10140b = gVar;
        gVar.f(this.f10139a);
        this.f10140b.setEventsListener(this);
        this.f10140b.initialize();
        this.f10140b.d();
        return (View) this.f10140b;
    }

    public boolean onError(b bVar, int i10, String str) {
        return false;
    }

    public void onNewMessage(p9.a aVar, boolean z10) {
    }

    public void onRequestAudioPermissions(String[] strArr, int i10) {
    }

    public void onStartFilePickerActivity(Intent intent, int i10) {
        startActivityForResult(intent, i10);
    }

    public void onWindowInitialized() {
    }
}
