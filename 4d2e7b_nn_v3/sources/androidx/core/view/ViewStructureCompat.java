package androidx.core.view;

import android.view.ViewStructure;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class ViewStructureCompat {
    private final Object mWrappedObj;

    private static class a {
        @DoNotInline
        static void a(ViewStructure viewStructure, String str) {
            viewStructure.setClassName(str);
        }

        @DoNotInline
        static void b(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setContentDescription(charSequence);
        }

        @DoNotInline
        static void c(ViewStructure viewStructure, int i10, int i11, int i12, int i13, int i14, int i15) {
            viewStructure.setDimens(i10, i11, i12, i13, i14, i15);
        }

        @DoNotInline
        static void d(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setText(charSequence);
        }
    }

    private ViewStructureCompat(@NonNull ViewStructure viewStructure) {
        this.mWrappedObj = viewStructure;
    }

    @RequiresApi(23)
    @NonNull
    public static ViewStructureCompat toViewStructureCompat(@NonNull ViewStructure viewStructure) {
        return new ViewStructureCompat(viewStructure);
    }

    public void setClassName(@NonNull String str) {
        a.a((ViewStructure) this.mWrappedObj, str);
    }

    public void setContentDescription(@NonNull CharSequence charSequence) {
        a.b((ViewStructure) this.mWrappedObj, charSequence);
    }

    public void setDimens(int i10, int i11, int i12, int i13, int i14, int i15) {
        a.c((ViewStructure) this.mWrappedObj, i10, i11, i12, i13, i14, i15);
    }

    public void setText(@NonNull CharSequence charSequence) {
        a.d((ViewStructure) this.mWrappedObj, charSequence);
    }

    @RequiresApi(23)
    @NonNull
    public ViewStructure toViewStructure() {
        return (ViewStructure) this.mWrappedObj;
    }
}
