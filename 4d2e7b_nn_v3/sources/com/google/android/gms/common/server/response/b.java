package com.google.android.gms.common.server.response;

import java.io.BufferedReader;

final class b implements i {
    b() {
    }

    public final /* synthetic */ Object a(FastParser fastParser, BufferedReader bufferedReader) {
        return Long.valueOf(fastParser.zan(bufferedReader));
    }
}
