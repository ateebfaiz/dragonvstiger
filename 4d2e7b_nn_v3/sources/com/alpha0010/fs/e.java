package com.alpha0010.fs;

import android.content.Context;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public abstract class e {
    public static final DocumentFile a(String str, Context context) {
        DocumentFile documentFile;
        m.f(str, "<this>");
        m.f(context, "context");
        if (b(str)) {
            try {
                Uri parse = Uri.parse(str);
                m.c(parse);
                if (c(parse)) {
                    documentFile = DocumentFile.fromTreeUri(context, parse);
                } else {
                    documentFile = DocumentFile.fromSingleUri(context, parse);
                }
                if (documentFile != null) {
                    return documentFile;
                }
            } catch (Throwable unused) {
            }
        }
        DocumentFile fromFile = DocumentFile.fromFile(d(str));
        m.e(fromFile, "fromFile(...)");
        return fromFile;
    }

    public static final boolean b(String str) {
        m.f(str, "<this>");
        return j.F(str, "content://", false, 2, (Object) null);
    }

    public static final boolean c(Uri uri) {
        m.f(uri, "<this>");
        List<String> pathSegments = uri.getPathSegments();
        m.e(pathSegments, "getPathSegments(...)");
        return m.b(r.Z(pathSegments), "tree");
    }

    public static final File d(String str) {
        m.f(str, "path");
        if (!j.K(str, "://", false, 2, (Object) null)) {
            return new File(str);
        }
        try {
            String path = Uri.parse(str).getPath();
            m.c(path);
            return new File(path);
        } catch (Throwable unused) {
            return new File(str);
        }
    }

    public static final Pair e(String str) {
        String Q0;
        m.f(str, "path");
        Uri parse = Uri.parse(str);
        String lastPathSegment = parse.getLastPathSegment();
        if (lastPathSegment == null || (Q0 = j.Q0(lastPathSegment, '/')) == null) {
            throw new Exception("Failed to parse '" + str + "'.");
        }
        int Z = j.Z(Q0, '/', 0, false, 6, (Object) null);
        if (Z >= 1) {
            String substring = Q0.substring(0, Z);
            m.e(substring, "substring(...)");
            String substring2 = Q0.substring(Z + 1, Q0.length());
            m.e(substring2, "substring(...)");
            Uri.Builder path = parse.buildUpon().path("");
            List<String> pathSegments = parse.getPathSegments();
            m.e(pathSegments, "getPathSegments(...)");
            for (String appendPath : r.T(pathSegments, 1)) {
                path.appendPath(appendPath);
            }
            path.appendPath(substring);
            return new Pair(path.build(), Uri.decode(substring2));
        }
        throw new Exception("Failed to parse '" + str + "'.");
    }
}
