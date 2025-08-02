package com.google.firebase.platforminfo;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.Dependency;

public class LibraryVersionComponent {

    public interface VersionExtractor<T> {
        String extract(T t10);
    }

    private LibraryVersionComponent() {
    }

    public static Component<?> create(String str, String str2) {
        return Component.intoSet(c.a(str, str2), c.class);
    }

    public static Component<?> fromContext(String str, VersionExtractor<Context> versionExtractor) {
        return Component.intoSetBuilder(c.class).add(Dependency.required((Class<?>) Context.class)).factory(new d(str, versionExtractor)).build();
    }
}
