package q5;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.internal.WebDialog;
import com.facebook.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class j extends DialogFragment {

    /* renamed from: c  reason: collision with root package name */
    public static final a f23346c = new a((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private Dialog f23347b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class b implements WebDialog.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f23348a;

        b(j jVar) {
            this.f23348a = jVar;
        }

        public final void a(Bundle bundle, l lVar) {
            this.f23348a.r(bundle, lVar);
        }
    }

    static final class c implements WebDialog.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f23349a;

        c(j jVar) {
            this.f23349a = jVar;
        }

        public final void a(Bundle bundle, l lVar) {
            this.f23349a.s(bundle);
        }
    }

    /* access modifiers changed from: private */
    public final void r(Bundle bundle, l lVar) {
        int i10;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            m.e(activity, "activity ?: return");
            Intent intent = activity.getIntent();
            m.e(intent, "fragmentActivity.intent");
            Intent p10 = f0.p(intent, bundle, lVar);
            if (lVar == null) {
                i10 = -1;
            } else {
                i10 = 0;
            }
            activity.setResult(i10, p10);
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    public final void s(Bundle bundle) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            m.e(activity, "activity ?: return");
            Intent intent = new Intent();
            if (bundle == null) {
                bundle = new Bundle();
            }
            intent.putExtras(bundle);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        m.f(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if ((this.f23347b instanceof WebDialog) && isResumed()) {
            Dialog dialog = this.f23347b;
            if (dialog != null) {
                ((WebDialog) dialog).s();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.WebDialog");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f23347b;
        if (dialog == null) {
            r((Bundle) null, (l) null);
            setShowsDialog(false);
            Dialog onCreateDialog = super.onCreateDialog(bundle);
            m.e(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
            return onCreateDialog;
        } else if (dialog != null) {
            return dialog;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Dialog");
        }
    }

    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage((Message) null);
        }
        super.onDestroyView();
    }

    public void onResume() {
        super.onResume();
        Dialog dialog = this.f23347b;
        if (!(dialog instanceof WebDialog)) {
            return;
        }
        if (dialog != null) {
            ((WebDialog) dialog).s();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.WebDialog");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.os.Bundle} */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q() {
        /*
            r8 = this;
            r0 = 1
            r1 = 0
            android.app.Dialog r2 = r8.f23347b
            if (r2 == 0) goto L_0x0007
            return
        L_0x0007:
            androidx.fragment.app.FragmentActivity r2 = r8.getActivity()
            if (r2 == 0) goto L_0x00b5
            java.lang.String r3 = "activity ?: return"
            kotlin.jvm.internal.m.e(r2, r3)
            android.content.Intent r3 = r2.getIntent()
            java.lang.String r4 = "intent"
            kotlin.jvm.internal.m.e(r3, r4)
            android.os.Bundle r3 = q5.f0.A(r3)
            if (r3 == 0) goto L_0x0028
            java.lang.String r4 = "is_fallback"
            boolean r4 = r3.getBoolean(r4, r1)
            goto L_0x0029
        L_0x0028:
            r4 = r1
        L_0x0029:
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.String"
            java.lang.String r6 = "FacebookDialogFragment"
            r7 = 0
            if (r4 != 0) goto L_0x006c
            if (r3 == 0) goto L_0x0039
            java.lang.String r0 = "action"
            java.lang.String r0 = r3.getString(r0)
            goto L_0x003a
        L_0x0039:
            r0 = r7
        L_0x003a:
            if (r3 == 0) goto L_0x0042
            java.lang.String r1 = "params"
            android.os.Bundle r7 = r3.getBundle(r1)
        L_0x0042:
            boolean r1 = q5.p0.Y(r0)
            if (r1 == 0) goto L_0x0051
            java.lang.String r0 = "Cannot start a WebDialog with an empty/missing 'actionName'"
            q5.p0.f0(r6, r0)
            r2.finish()
            return
        L_0x0051:
            com.facebook.internal.WebDialog$a r1 = new com.facebook.internal.WebDialog$a
            if (r0 == 0) goto L_0x0066
            r1.<init>(r2, r0, r7)
            q5.j$b r0 = new q5.j$b
            r0.<init>(r8)
            com.facebook.internal.WebDialog$a r0 = r1.h(r0)
            com.facebook.internal.WebDialog r0 = r0.a()
            goto L_0x00ac
        L_0x0066:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r5)
            throw r0
        L_0x006c:
            if (r3 == 0) goto L_0x0074
            java.lang.String r4 = "url"
            java.lang.String r7 = r3.getString(r4)
        L_0x0074:
            boolean r3 = q5.p0.Y(r7)
            if (r3 == 0) goto L_0x0083
            java.lang.String r0 = "Cannot start a fallback WebDialog with an empty/missing 'url'"
            q5.p0.f0(r6, r0)
            r2.finish()
            return
        L_0x0083:
            kotlin.jvm.internal.b0 r3 = kotlin.jvm.internal.b0.f709a
            java.lang.String r3 = com.facebook.o.g()
            java.lang.Object[] r4 = new java.lang.Object[r0]
            r4[r1] = r3
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r4, r0)
            java.lang.String r1 = "fb%s://bridge/"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            java.lang.String r1 = "java.lang.String.format(format, *args)"
            kotlin.jvm.internal.m.e(r0, r1)
            com.facebook.internal.a$a r1 = com.facebook.internal.a.P0
            if (r7 == 0) goto L_0x00af
            com.facebook.internal.a r0 = r1.a(r2, r7, r0)
            q5.j$c r1 = new q5.j$c
            r1.<init>(r8)
            r0.w(r1)
        L_0x00ac:
            r8.f23347b = r0
            return
        L_0x00af:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r5)
            throw r0
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.j.q():void");
    }

    public final void t(Dialog dialog) {
        this.f23347b = dialog;
    }
}
