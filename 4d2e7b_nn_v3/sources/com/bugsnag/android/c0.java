package com.bugsnag.android;

import java.util.Collection;

abstract class c0 {
    static boolean a(Collection collection) {
        if (collection == null) {
            return true;
        }
        for (Object obj : collection) {
            if (obj == null) {
                return true;
            }
        }
        return false;
    }
}
