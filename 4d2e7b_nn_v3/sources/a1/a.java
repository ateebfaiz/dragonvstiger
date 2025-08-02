package a1;

import android.content.Intent;

public class a extends u {

    /* renamed from: c  reason: collision with root package name */
    private Intent f13577c;

    public a(k kVar) {
        super(kVar);
    }

    public String getMessage() {
        if (this.f13577c != null) {
            return "User needs to (re)enter credentials.";
        }
        return super.getMessage();
    }
}
