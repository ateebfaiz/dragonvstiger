package androidx.activity;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentDialog f13827a;

    public /* synthetic */ m(ComponentDialog componentDialog) {
        this.f13827a = componentDialog;
    }

    public final void run() {
        ComponentDialog.onBackPressedDispatcher$lambda$1(this.f13827a);
    }
}
