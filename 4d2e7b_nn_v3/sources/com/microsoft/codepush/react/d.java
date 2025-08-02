package com.microsoft.codepush.react;

import java.net.MalformedURLException;

public class d extends RuntimeException {
    public d(String str, Throwable th) {
        super("Unable to parse contents of " + str + ", the file may be corrupted.", th);
    }

    public d(String str, MalformedURLException malformedURLException) {
        super("The package has an invalid downloadUrl: " + str, malformedURLException);
    }
}
