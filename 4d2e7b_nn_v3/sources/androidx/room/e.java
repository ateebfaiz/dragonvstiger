package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;

class e implements SupportSQLiteOpenHelper.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final String f16475a;

    /* renamed from: b  reason: collision with root package name */
    private final File f16476b;

    /* renamed from: c  reason: collision with root package name */
    private final SupportSQLiteOpenHelper.Factory f16477c;

    e(String str, File file, SupportSQLiteOpenHelper.Factory factory) {
        this.f16475a = str;
        this.f16476b = file;
        this.f16477c = factory;
    }

    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return new d(configuration.context, this.f16475a, this.f16476b, configuration.callback.version, this.f16477c.create(configuration));
    }
}
