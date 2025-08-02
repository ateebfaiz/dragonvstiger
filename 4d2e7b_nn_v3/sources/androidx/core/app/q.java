package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

abstract class q {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f14869a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f14870b = new Object();

    private static RemoteInput a(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("allowedDataTypes");
        HashSet hashSet = new HashSet();
        if (stringArrayList != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        return new RemoteInput(bundle.getString("resultKey"), bundle.getCharSequence(Constants.ScionAnalytics.PARAM_LABEL), bundle.getCharSequenceArray("choices"), bundle.getBoolean("allowFreeFormInput"), 0, bundle.getBundle("extras"), hashSet);
    }

    private static RemoteInput[] b(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[bundleArr.length];
        for (int i10 = 0; i10 < bundleArr.length; i10++) {
            remoteInputArr[i10] = a(bundleArr[i10]);
        }
        return remoteInputArr;
    }

    static NotificationCompat.Action c(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("extras");
        boolean z10 = false;
        if (bundle2 != null) {
            z10 = bundle2.getBoolean("android.support.allowGeneratedReplies", false);
        }
        return new NotificationCompat.Action(bundle.getInt("icon"), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable("actionIntent"), bundle.getBundle("extras"), b(d(bundle, "remoteInputs")), b(d(bundle, "dataOnlyRemoteInputs")), z10, bundle.getInt("semanticAction"), bundle.getBoolean("showsUserInterface"), false, false);
    }

    private static Bundle[] d(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Bundle[]) || parcelableArray == null) {
            return (Bundle[]) parcelableArray;
        }
        Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
        bundle.putParcelableArray(str, bundleArr);
        return bundleArr;
    }

    static Bundle e(NotificationCompat.Action action) {
        int i10;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat iconCompat = action.getIconCompat();
        if (iconCompat != null) {
            i10 = iconCompat.getResId();
        } else {
            i10 = 0;
        }
        bundle2.putInt("icon", i10);
        bundle2.putCharSequence("title", action.getTitle());
        bundle2.putParcelable("actionIntent", action.getActionIntent());
        if (action.getExtras() != null) {
            bundle = new Bundle(action.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", g(action.getRemoteInputs()));
        bundle2.putBoolean("showsUserInterface", action.getShowsUserInterface());
        bundle2.putInt("semanticAction", action.getSemanticAction());
        return bundle2;
    }

    private static Bundle f(RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", remoteInput.getResultKey());
        bundle.putCharSequence(Constants.ScionAnalytics.PARAM_LABEL, remoteInput.getLabel());
        bundle.putCharSequenceArray("choices", remoteInput.getChoices());
        bundle.putBoolean("allowFreeFormInput", remoteInput.getAllowFreeFormInput());
        bundle.putBundle("extras", remoteInput.getExtras());
        Set<String> allowedDataTypes = remoteInput.getAllowedDataTypes();
        if (allowedDataTypes != null && !allowedDataTypes.isEmpty()) {
            ArrayList arrayList = new ArrayList(allowedDataTypes.size());
            for (String add : allowedDataTypes) {
                arrayList.add(add);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static Bundle[] g(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i10 = 0; i10 < remoteInputArr.length; i10++) {
            bundleArr[i10] = f(remoteInputArr[i10]);
        }
        return bundleArr;
    }
}
