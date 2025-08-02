package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.HashMap;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MultiInstanceInvalidationService extends Service {
    private final IMultiInstanceInvalidationService.Stub mBinder = new b();
    final RemoteCallbackList<IMultiInstanceInvalidationCallback> mCallbackList = new a();
    final HashMap<Integer, String> mClientNames = new HashMap<>();
    int mMaxClientId = 0;

    class a extends RemoteCallbackList {
        a() {
        }

        /* renamed from: a */
        public void onCallbackDied(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, Object obj) {
            HashMap<Integer, String> hashMap = MultiInstanceInvalidationService.this.mClientNames;
            Integer num = (Integer) obj;
            num.intValue();
            hashMap.remove(num);
        }
    }

    class b extends IMultiInstanceInvalidationService.Stub {
        b() {
        }

        public void broadcastInvalidation(int i10, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                try {
                    String str = MultiInstanceInvalidationService.this.mClientNames.get(Integer.valueOf(i10));
                    if (str == null) {
                        Log.w("ROOM", "Remote invalidation client ID not registered");
                        return;
                    }
                    int beginBroadcast = MultiInstanceInvalidationService.this.mCallbackList.beginBroadcast();
                    for (int i11 = 0; i11 < beginBroadcast; i11++) {
                        Integer num = (Integer) MultiInstanceInvalidationService.this.mCallbackList.getBroadcastCookie(i11);
                        int intValue = num.intValue();
                        String str2 = MultiInstanceInvalidationService.this.mClientNames.get(num);
                        if (i10 != intValue && str.equals(str2)) {
                            try {
                                MultiInstanceInvalidationService.this.mCallbackList.getBroadcastItem(i11).onInvalidation(strArr);
                            } catch (RemoteException e10) {
                                Log.w("ROOM", "Error invoking a remote callback", e10);
                            }
                        }
                    }
                    MultiInstanceInvalidationService.this.mCallbackList.finishBroadcast();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                try {
                    MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                    int i10 = multiInstanceInvalidationService.mMaxClientId + 1;
                    multiInstanceInvalidationService.mMaxClientId = i10;
                    if (multiInstanceInvalidationService.mCallbackList.register(iMultiInstanceInvalidationCallback, Integer.valueOf(i10))) {
                        MultiInstanceInvalidationService.this.mClientNames.put(Integer.valueOf(i10), str);
                        return i10;
                    }
                    MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                    multiInstanceInvalidationService2.mMaxClientId--;
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i10) {
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                MultiInstanceInvalidationService.this.mCallbackList.unregister(iMultiInstanceInvalidationCallback);
                MultiInstanceInvalidationService.this.mClientNames.remove(Integer.valueOf(i10));
            }
        }
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}
