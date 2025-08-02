package i;

import com.alibaba.pdns.net.f.g;

public enum a {
    CM,
    CU,
    CT,
    Unknown;

    public static a a(String str) {
        if (str.startsWith(g.f18123p) || str.startsWith(g.f18124q) || str.startsWith("46004") || str.startsWith(g.f18125r)) {
            return CM;
        }
        if (str.startsWith(g.f18127t) || str.startsWith(g.f18128u) || str.startsWith(g.f18129v)) {
            return CU;
        }
        if (str.startsWith(g.f18130w) || str.startsWith(g.f18131x) || str.startsWith(g.f18132y)) {
            return CT;
        }
        return Unknown;
    }

    public static String c(String str) {
        return a(str).name();
    }
}
