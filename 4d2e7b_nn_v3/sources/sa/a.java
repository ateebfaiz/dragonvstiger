package sa;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import java.util.List;

public abstract class a {
    public static boolean a(Context context, Intent intent) {
        List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            return false;
        }
        return true;
    }
}
