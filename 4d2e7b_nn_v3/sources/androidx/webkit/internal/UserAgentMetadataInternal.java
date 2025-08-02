package androidx.webkit.internal;

import androidx.webkit.UserAgentMetadata;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAgentMetadataInternal {
    private static final String ARCHITECTURE = "ARCHITECTURE";
    private static final String BITNESS = "BITNESS";
    private static final int BRAND_VERSION_LENGTH = 3;
    private static final String BRAND_VERSION_LIST = "BRAND_VERSION_LIST";
    private static final String FULL_VERSION = "FULL_VERSION";
    private static final String MOBILE = "MOBILE";
    private static final String MODEL = "MODEL";
    private static final String PLATFORM = "PLATFORM";
    private static final String PLATFORM_VERSION = "PLATFORM_VERSION";
    private static final String WOW64 = "WOW64";

    static Map<String, Object> convertUserAgentMetadataToMap(UserAgentMetadata userAgentMetadata) {
        HashMap hashMap = new HashMap();
        hashMap.put(BRAND_VERSION_LIST, getBrandVersionArray(userAgentMetadata.getBrandVersionList()));
        hashMap.put(FULL_VERSION, userAgentMetadata.getFullVersion());
        hashMap.put(PLATFORM, userAgentMetadata.getPlatform());
        hashMap.put(PLATFORM_VERSION, userAgentMetadata.getPlatformVersion());
        hashMap.put(ARCHITECTURE, userAgentMetadata.getArchitecture());
        hashMap.put(MODEL, userAgentMetadata.getModel());
        hashMap.put(MOBILE, Boolean.valueOf(userAgentMetadata.isMobile()));
        hashMap.put(BITNESS, Integer.valueOf(userAgentMetadata.getBitness()));
        hashMap.put(WOW64, Boolean.valueOf(userAgentMetadata.isWow64()));
        return hashMap;
    }

    private static String[][] getBrandVersionArray(List<UserAgentMetadata.BrandVersion> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size = list.size();
        int[] iArr = new int[2];
        iArr[1] = 3;
        iArr[0] = size;
        String[][] strArr = (String[][]) Array.newInstance(String.class, iArr);
        for (int i10 = 0; i10 < list.size(); i10++) {
            strArr[i10][0] = list.get(i10).getBrand();
            strArr[i10][1] = list.get(i10).getMajorVersion();
            strArr[i10][2] = list.get(i10).getFullVersion();
        }
        return strArr;
    }

    static UserAgentMetadata getUserAgentMetadataFromMap(Map<String, Object> map) {
        UserAgentMetadata.Builder builder = new UserAgentMetadata.Builder();
        Object obj = map.get(BRAND_VERSION_LIST);
        if (obj != null) {
            ArrayList arrayList = new ArrayList();
            for (String[] strArr : (String[][]) obj) {
                arrayList.add(new UserAgentMetadata.BrandVersion.Builder().setBrand(strArr[0]).setMajorVersion(strArr[1]).setFullVersion(strArr[2]).build());
            }
            builder.setBrandVersionList(arrayList);
        }
        String str = (String) map.get(FULL_VERSION);
        if (str != null) {
            builder.setFullVersion(str);
        }
        String str2 = (String) map.get(PLATFORM);
        if (str2 != null) {
            builder.setPlatform(str2);
        }
        String str3 = (String) map.get(PLATFORM_VERSION);
        if (str3 != null) {
            builder.setPlatformVersion(str3);
        }
        String str4 = (String) map.get(ARCHITECTURE);
        if (str4 != null) {
            builder.setArchitecture(str4);
        }
        String str5 = (String) map.get(MODEL);
        if (str5 != null) {
            builder.setModel(str5);
        }
        Boolean bool = (Boolean) map.get(MOBILE);
        if (bool != null) {
            builder.setMobile(bool.booleanValue());
        }
        Integer num = (Integer) map.get(BITNESS);
        if (num != null) {
            builder.setBitness(num.intValue());
        }
        Boolean bool2 = (Boolean) map.get(WOW64);
        if (bool2 != null) {
            builder.setWow64(bool2.booleanValue());
        }
        return builder.build();
    }
}
