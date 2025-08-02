package com.livechatinc.inappchat;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.pdns.DNSResolver;
import java.util.HashMap;
import java.util.HashSet;

public final class ChatWindowActivity extends FragmentActivity {

    /* renamed from: a  reason: collision with root package name */
    private static final HashSet f10091a;

    static {
        HashSet hashSet = new HashSet();
        f10091a = hashSet;
        hashSet.add("KEY_LICENCE_NUMBER");
        hashSet.add("KEY_GROUP_ID");
        hashSet.add("KEY_VISITOR_NAME");
        hashSet.add("KEY_VISITOR_EMAIL");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        super.onCreate(bundle);
        getWindow().requestFeature(1);
        LinearLayout linearLayout = new LinearLayout(this);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(DNSResolver.GOBACK_LOCAL);
        linearLayout.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        setContentView((View) linearLayout);
        HashMap hashMap = new HashMap();
        Bundle extras = getIntent().getExtras();
        String str4 = null;
        if (extras != null) {
            String valueOf = String.valueOf(extras.get("KEY_LICENCE_NUMBER"));
            str2 = String.valueOf(extras.get("KEY_GROUP_ID"));
            if (extras.containsKey("KEY_VISITOR_NAME")) {
                str = String.valueOf(extras.get("KEY_VISITOR_NAME"));
            } else {
                str = null;
            }
            if (extras.containsKey("KEY_VISITOR_EMAIL")) {
                str4 = String.valueOf(extras.get("KEY_VISITOR_EMAIL"));
            }
            for (String next : extras.keySet()) {
                if (!f10091a.contains(next)) {
                    hashMap.put(next, String.valueOf(extras.get(next)));
                }
            }
            str3 = str4;
            str4 = valueOf;
        } else {
            str3 = null;
            str2 = null;
            str = null;
        }
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(DNSResolver.GOBACK_LOCAL, d.a(str4, str2, str, str3, hashMap));
        beginTransaction.commit();
    }
}
