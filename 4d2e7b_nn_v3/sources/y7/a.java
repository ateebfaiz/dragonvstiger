package y7;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import com.facebook.FacebookActivity;
import com.facebook.FacebookRequestError;
import com.facebook.j;
import com.facebook.l;
import com.facebook.o;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.List;
import q5.d;
import q5.i;
import q5.u;

public class a extends i {

    /* renamed from: h  reason: collision with root package name */
    private static final int f13328h = d.c.DeviceShare.a();

    /* renamed from: y7.a$a  reason: collision with other inner class name */
    class C0160a implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f13329a;

        C0160a(j jVar) {
            this.f13329a = jVar;
        }

        public boolean a(int i10, Intent intent) {
            if (intent.hasExtra(Constants.IPC_BUNDLE_KEY_SEND_ERROR)) {
                this.f13329a.a(((FacebookRequestError) intent.getParcelableExtra(Constants.IPC_BUNDLE_KEY_SEND_ERROR)).e());
                return true;
            }
            this.f13329a.onSuccess(new b());
            return true;
        }
    }

    public static class b {
    }

    public a(Activity activity) {
        super(activity, f13328h);
    }

    /* access modifiers changed from: protected */
    public q5.a e() {
        return null;
    }

    /* access modifiers changed from: protected */
    public List g() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void k(d dVar, j jVar) {
        dVar.c(h(), new C0160a(jVar));
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean c(ShareContent shareContent, Object obj) {
        if ((shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareOpenGraphContent)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public void n(ShareContent shareContent, Object obj) {
        if (shareContent == null) {
            throw new l("Must provide non-null content to share");
        } else if ((shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareOpenGraphContent)) {
            Intent intent = new Intent();
            intent.setClass(o.f(), FacebookActivity.class);
            intent.setAction("DeviceShareDialogFragment");
            intent.putExtra(FirebaseAnalytics.Param.CONTENT, shareContent);
            o(intent, h());
        } else {
            throw new l(getClass().getSimpleName() + " only supports ShareLinkContent or ShareOpenGraphContent");
        }
    }

    public a(Fragment fragment) {
        super(new u(fragment), f13328h);
    }

    public a(androidx.fragment.app.Fragment fragment) {
        super(new u(fragment), f13328h);
    }
}
