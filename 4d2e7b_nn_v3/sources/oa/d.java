package oa;

import java.util.Locale;

public class d implements b {
    public String a() {
        String language = Locale.getDefault().getLanguage();
        language.hashCode();
        char c10 = 65535;
        switch (language.hashCode()) {
            case 3365:
                if (language.equals("in")) {
                    c10 = 0;
                    break;
                }
                break;
            case 3374:
                if (language.equals("iw")) {
                    c10 = 1;
                    break;
                }
                break;
            case 3391:
                if (language.equals("ji")) {
                    c10 = 2;
                    break;
                }
                break;
            case 3886:
                if (language.equals("zh")) {
                    c10 = 3;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return "id";
            case 1:
                return "he";
            case 2:
                return "yi";
            case 3:
                return language + "-" + Locale.getDefault().getCountry();
            default:
                return language;
        }
    }
}
