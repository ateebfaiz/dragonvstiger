package com.facebook.soloader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class z {
    private static boolean a(String str) {
        Matcher matcher = Pattern.compile("\\P{ASCII}+").matcher(str);
        if (!matcher.find()) {
            return false;
        }
        String group = matcher.group();
        m.g("SoLoader", "Library name is corrupted, contains non-ASCII characters " + group);
        return true;
    }

    public static y b(String str, UnsatisfiedLinkError unsatisfiedLinkError) {
        y yVar;
        if (unsatisfiedLinkError.getMessage() != null && unsatisfiedLinkError.getMessage().contains("ELF")) {
            m.a("SoLoader", "Corrupted lib file detected");
            yVar = new v(str, unsatisfiedLinkError.toString());
        } else if (a(str)) {
            m.a("SoLoader", "Corrupted lib name detected");
            yVar = new w(str, "corrupted lib name: " + unsatisfiedLinkError.toString());
        } else {
            yVar = new y(str, unsatisfiedLinkError.toString());
        }
        yVar.initCause(unsatisfiedLinkError);
        return yVar;
    }
}
