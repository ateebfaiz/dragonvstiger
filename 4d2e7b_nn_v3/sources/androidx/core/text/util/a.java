package androidx.core.text.util;

import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final C0191a[] f15122a;

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f15123b = Pattern.compile("[^,*•\t                　\n\u000b\f\r  ]+(?=[,*•\t                　\n\u000b\f\r  ]|$)", 2);

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f15124c = Pattern.compile("(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)(?:-(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?))*(?=[,\"'\t                　\n\u000b\f\r  ]|$)", 2);

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f15125d = Pattern.compile("(?:(ak|alaska)|(al|alabama)|(ar|arkansas)|(as|american[\t                　]+samoa)|(az|arizona)|(ca|california)|(co|colorado)|(ct|connecticut)|(dc|district[\t                　]+of[\t                　]+columbia)|(de|delaware)|(fl|florida)|(fm|federated[\t                　]+states[\t                　]+of[\t                　]+micronesia)|(ga|georgia)|(gu|guam)|(hi|hawaii)|(ia|iowa)|(id|idaho)|(il|illinois)|(in|indiana)|(ks|kansas)|(ky|kentucky)|(la|louisiana)|(ma|massachusetts)|(md|maryland)|(me|maine)|(mh|marshall[\t                　]+islands)|(mi|michigan)|(mn|minnesota)|(mo|missouri)|(mp|northern[\t                　]+mariana[\t                　]+islands)|(ms|mississippi)|(mt|montana)|(nc|north[\t                　]+carolina)|(nd|north[\t                　]+dakota)|(ne|nebraska)|(nh|new[\t                　]+hampshire)|(nj|new[\t                　]+jersey)|(nm|new[\t                　]+mexico)|(nv|nevada)|(ny|new[\t                　]+york)|(oh|ohio)|(ok|oklahoma)|(or|oregon)|(pa|pennsylvania)|(pr|puerto[\t                　]+rico)|(pw|palau)|(ri|rhode[\t                　]+island)|(sc|south[\t                　]+carolina)|(sd|south[\t                　]+dakota)|(tn|tennessee)|(tx|texas)|(ut|utah)|(va|virginia)|(vi|virgin[\t                　]+islands)|(vt|vermont)|(wa|washington)|(wi|wisconsin)|(wv|west[\t                　]+virginia)|(wy|wyoming))(?=[,*•\t                　\n\u000b\f\r  ]|$)", 2);

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f15126e = Pattern.compile("(?:alley|annex|arcade|ave[.]?|avenue|alameda|bayou|beach|bend|bluffs?|bottom|boulevard|branch|bridge|brooks?|burgs?|bypass|broadway|camino|camp|canyon|cape|causeway|centers?|circles?|cliffs?|club|common|corners?|course|courts?|coves?|creek|crescent|crest|crossing|crossroad|curve|circulo|dale|dam|divide|drives?|estates?|expressway|extensions?|falls?|ferry|fields?|flats?|fords?|forest|forges?|forks?|fort|freeway|gardens?|gateway|glens?|greens?|groves?|harbors?|haven|heights|highway|hills?|hollow|inlet|islands?|isle|junctions?|keys?|knolls?|lakes?|land|landing|lane|lights?|loaf|locks?|lodge|loop|mall|manors?|meadows?|mews|mills?|mission|motorway|mount|mountains?|neck|orchard|oval|overpass|parks?|parkways?|pass|passage|path|pike|pines?|plains?|plaza|points?|ports?|prairie|privada|radial|ramp|ranch|rapids?|rd[.]?|rest|ridges?|river|roads?|route|row|rue|run|shoals?|shores?|skyway|springs?|spurs?|squares?|station|stravenue|stream|st[.]?|streets?|summit|speedway|terrace|throughway|trace|track|trafficway|trail|tunnel|turnpike|underpass|unions?|valleys?|viaduct|views?|villages?|ville|vista|walks?|wall|ways?|wells?|xing|xrd)(?=[,*•\t                　\n\u000b\f\r  ]|$)", 2);

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f15127f = Pattern.compile("([0-9]+)(st|nd|rd|th)", 2);

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f15128g = Pattern.compile("(?:[0-9]{5}(?:-[0-9]{4})?)(?=[,*•\t                　\n\u000b\f\r  ]|$)", 2);

    /* renamed from: androidx.core.text.util.a$a  reason: collision with other inner class name */
    private static class C0191a {

        /* renamed from: a  reason: collision with root package name */
        int f15129a;

        /* renamed from: b  reason: collision with root package name */
        int f15130b;

        /* renamed from: c  reason: collision with root package name */
        int f15131c;

        /* renamed from: d  reason: collision with root package name */
        int f15132d;

        C0191a(int i10, int i11, int i12, int i13) {
            this.f15129a = i10;
            this.f15130b = i11;
            this.f15131c = i12;
            this.f15132d = i13;
        }

        /* access modifiers changed from: package-private */
        public boolean a(String str) {
            int parseInt = Integer.parseInt(str.substring(0, 2));
            if ((this.f15129a <= parseInt && parseInt <= this.f15130b) || parseInt == this.f15131c || parseInt == this.f15132d) {
                return true;
            }
            return false;
        }
    }

    static {
        C0191a aVar = new C0191a(99, 99, -1, -1);
        C0191a aVar2 = new C0191a(35, 36, -1, -1);
        C0191a aVar3 = new C0191a(71, 72, -1, -1);
        C0191a aVar4 = new C0191a(96, 96, -1, -1);
        C0191a aVar5 = new C0191a(85, 86, -1, -1);
        C0191a aVar6 = new C0191a(90, 96, -1, -1);
        C0191a aVar7 = new C0191a(80, 81, -1, -1);
        C0191a aVar8 = new C0191a(6, 6, -1, -1);
        C0191a aVar9 = new C0191a(20, 20, -1, -1);
        C0191a aVar10 = new C0191a(19, 19, -1, -1);
        C0191a aVar11 = new C0191a(32, 34, -1, -1);
        C0191a aVar12 = new C0191a(96, 96, -1, -1);
        C0191a aVar13 = new C0191a(30, 31, -1, -1);
        C0191a aVar14 = new C0191a(96, 96, -1, -1);
        C0191a aVar15 = new C0191a(96, 96, -1, -1);
        C0191a aVar16 = new C0191a(50, 52, -1, -1);
        C0191a aVar17 = new C0191a(83, 83, -1, -1);
        C0191a aVar18 = aVar16;
        C0191a aVar19 = new C0191a(60, 62, -1, -1);
        C0191a aVar20 = new C0191a(46, 47, -1, -1);
        C0191a aVar21 = aVar12;
        C0191a aVar22 = new C0191a(66, 67, 73, -1);
        C0191a aVar23 = new C0191a(40, 42, -1, -1);
        C0191a aVar24 = new C0191a(70, 71, -1, -1);
        C0191a aVar25 = new C0191a(1, 2, -1, -1);
        C0191a aVar26 = new C0191a(20, 21, -1, -1);
        C0191a aVar27 = new C0191a(3, 4, -1, -1);
        C0191a aVar28 = new C0191a(96, 96, -1, -1);
        C0191a aVar29 = aVar27;
        C0191a aVar30 = new C0191a(48, 49, -1, -1);
        C0191a aVar31 = new C0191a(55, 56, -1, -1);
        C0191a aVar32 = new C0191a(63, 65, -1, -1);
        C0191a aVar33 = new C0191a(96, 96, -1, -1);
        C0191a aVar34 = aVar32;
        C0191a aVar35 = new C0191a(38, 39, -1, -1);
        C0191a aVar36 = new C0191a(55, 56, -1, -1);
        C0191a aVar37 = new C0191a(27, 28, -1, -1);
        C0191a aVar38 = new C0191a(58, 58, -1, -1);
        C0191a aVar39 = new C0191a(68, 69, -1, -1);
        C0191a aVar40 = new C0191a(3, 4, -1, -1);
        C0191a aVar41 = new C0191a(7, 8, -1, -1);
        C0191a aVar42 = aVar22;
        C0191a aVar43 = new C0191a(87, 88, 86, -1);
        C0191a aVar44 = new C0191a(88, 89, 96, -1);
        C0191a aVar45 = new C0191a(10, 14, 0, 6);
        C0191a aVar46 = new C0191a(43, 45, -1, -1);
        C0191a aVar47 = new C0191a(73, 74, -1, -1);
        C0191a aVar48 = new C0191a(97, 97, -1, -1);
        C0191a aVar49 = new C0191a(6, 6, 0, 9);
        C0191a aVar50 = new C0191a(96, 96, -1, -1);
        C0191a aVar51 = new C0191a(2, 2, -1, -1);
        C0191a aVar52 = new C0191a(29, 29, -1, -1);
        C0191a aVar53 = new C0191a(57, 57, -1, -1);
        C0191a aVar54 = aVar49;
        C0191a aVar55 = new C0191a(37, 38, -1, -1);
        C0191a aVar56 = aVar45;
        C0191a aVar57 = new C0191a(75, 79, 87, 88);
        C0191a aVar58 = new C0191a(84, 84, -1, -1);
        C0191a aVar59 = aVar57;
        C0191a aVar60 = new C0191a(22, 24, 20, -1);
        C0191a aVar61 = new C0191a(6, 9, -1, -1);
        C0191a aVar62 = aVar61;
        f15122a = new C0191a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar21, aVar13, aVar14, aVar15, aVar18, aVar17, aVar19, aVar20, aVar42, aVar23, aVar24, aVar25, aVar26, aVar29, aVar28, aVar30, aVar31, aVar34, aVar33, aVar35, aVar36, aVar37, aVar38, aVar39, aVar40, aVar41, aVar43, aVar44, aVar56, aVar46, aVar47, aVar48, new C0191a(15, 19, -1, -1), aVar54, aVar50, aVar51, aVar52, aVar53, aVar55, aVar59, aVar58, aVar60, aVar62, new C0191a(5, 5, -1, -1), new C0191a(98, 99, -1, -1), new C0191a(53, 54, -1, -1), new C0191a(24, 26, -1, -1), new C0191a(82, 83, -1, -1)};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
        return -r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.lang.String r13, java.util.regex.MatchResult r14) {
        /*
            int r14 = r14.end()
            java.util.regex.Pattern r0 = f15123b
            java.util.regex.Matcher r0 = r0.matcher(r13)
            r1 = -1
            r2 = 1
            r3 = 0
            java.lang.String r4 = ""
            r9 = r1
            r10 = r9
            r5 = r2
            r6 = r5
            r7 = r6
            r8 = r3
        L_0x0015:
            int r11 = r13.length()
            if (r14 >= r11) goto L_0x00d5
            boolean r11 = r0.find(r14)
            if (r11 != 0) goto L_0x0027
            int r13 = r13.length()
        L_0x0025:
            int r13 = -r13
            return r13
        L_0x0027:
            int r11 = r0.end()
            int r12 = r0.start()
            int r11 = r11 - r12
            r12 = 25
            if (r11 <= r12) goto L_0x0039
            int r13 = r0.end()
            goto L_0x0025
        L_0x0039:
            int r11 = r0.start()
            if (r14 >= r11) goto L_0x0051
            int r11 = r14 + 1
            char r14 = r13.charAt(r14)
            java.lang.String r12 = "\n\u000b\f\r  "
            int r14 = r12.indexOf(r14)
            if (r14 == r1) goto L_0x004f
            int r5 = r5 + 1
        L_0x004f:
            r14 = r11
            goto L_0x0039
        L_0x0051:
            r11 = 5
            if (r5 <= r11) goto L_0x0056
            goto L_0x00d5
        L_0x0056:
            int r6 = r6 + r2
            r12 = 14
            if (r6 <= r12) goto L_0x005d
            goto L_0x00d5
        L_0x005d:
            java.util.regex.MatchResult r12 = f(r13, r14)
            if (r12 == 0) goto L_0x006d
            if (r7 == 0) goto L_0x0069
            if (r5 <= r2) goto L_0x0069
            int r13 = -r14
            return r13
        L_0x0069:
            if (r9 != r1) goto L_0x00cb
            r9 = r14
            goto L_0x00cb
        L_0x006d:
            java.lang.String r7 = r0.group(r3)
            boolean r7 = d(r7)
            if (r7 == 0) goto L_0x007a
            r8 = r2
        L_0x0078:
            r7 = r3
            goto L_0x00cb
        L_0x007a:
            if (r6 != r11) goto L_0x0083
            if (r8 != 0) goto L_0x0083
            int r14 = r0.end()
            goto L_0x00d5
        L_0x0083:
            if (r8 == 0) goto L_0x0078
            r7 = 4
            if (r6 <= r7) goto L_0x0078
            java.util.regex.MatchResult r14 = g(r13, r14)
            if (r14 == 0) goto L_0x0078
            java.lang.String r7 = "et"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x00a7
            java.lang.String r4 = r14.group(r3)
            java.lang.String r7 = "al"
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x00a7
            int r14 = r14.end()
            goto L_0x00d5
        L_0x00a7:
            java.util.regex.Pattern r4 = f15123b
            java.util.regex.Matcher r4 = r4.matcher(r13)
            int r7 = r14.end()
            boolean r7 = r4.find(r7)
            if (r7 == 0) goto L_0x00c6
            java.lang.String r7 = r4.group(r3)
            boolean r14 = e(r7, r14)
            if (r14 == 0) goto L_0x0078
            int r13 = r4.end()
            return r13
        L_0x00c6:
            int r10 = r14.end()
            goto L_0x0078
        L_0x00cb:
            java.lang.String r4 = r0.group(r3)
            int r14 = r0.end()
            goto L_0x0015
        L_0x00d5:
            if (r10 <= 0) goto L_0x00d8
            return r10
        L_0x00d8:
            if (r9 <= 0) goto L_0x00db
            goto L_0x00dc
        L_0x00db:
            r9 = r14
        L_0x00dc:
            int r13 = -r9
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.util.a.a(java.lang.String, java.util.regex.MatchResult):int");
    }

    private static boolean b(String str) {
        int i10 = 0;
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (Character.isDigit(str.charAt(i11))) {
                i10++;
            }
        }
        if (i10 > 5) {
            return false;
        }
        Matcher matcher = f15127f.matcher(str);
        if (!matcher.find()) {
            return true;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        if (parseInt == 0) {
            return false;
        }
        String lowerCase = matcher.group(2).toLowerCase(Locale.getDefault());
        int i12 = parseInt % 10;
        String str2 = "th";
        if (i12 == 1) {
            if (parseInt % 100 != 11) {
                str2 = "st";
            }
            return lowerCase.equals(str2);
        } else if (i12 == 2) {
            if (parseInt % 100 != 12) {
                str2 = "nd";
            }
            return lowerCase.equals(str2);
        } else if (i12 != 3) {
            return lowerCase.equals(str2);
        } else {
            if (parseInt % 100 != 13) {
                str2 = "rd";
            }
            return lowerCase.equals(str2);
        }
    }

    static String c(String str) {
        Matcher matcher = f15124c.matcher(str);
        int i10 = 0;
        while (matcher.find(i10)) {
            if (b(matcher.group(0))) {
                int start = matcher.start();
                int a10 = a(str, matcher);
                if (a10 > 0) {
                    return str.substring(start, a10);
                }
                i10 = -a10;
            } else {
                i10 = matcher.end();
            }
        }
        return null;
    }

    public static boolean d(String str) {
        return f15126e.matcher(str).matches();
    }

    private static boolean e(String str, MatchResult matchResult) {
        if (matchResult == null) {
            return false;
        }
        int groupCount = matchResult.groupCount();
        while (true) {
            if (groupCount <= 0) {
                break;
            }
            int i10 = groupCount - 1;
            if (matchResult.group(groupCount) != null) {
                groupCount = i10;
                break;
            }
            groupCount = i10;
        }
        if (!f15128g.matcher(str).matches() || !f15122a[groupCount].a(str)) {
            return false;
        }
        return true;
    }

    public static MatchResult f(String str, int i10) {
        if (i10 > 0 && ":,\"'\t                　\n\u000b\f\r  ".indexOf(str.charAt(i10 - 1)) == -1) {
            return null;
        }
        Matcher region = f15124c.matcher(str).region(i10, str.length());
        if (region.lookingAt()) {
            MatchResult matchResult = region.toMatchResult();
            if (b(matchResult.group(0))) {
                return matchResult;
            }
        }
        return null;
    }

    public static MatchResult g(String str, int i10) {
        if (i10 > 0 && ",*•\t                　\n\u000b\f\r  ".indexOf(str.charAt(i10 - 1)) == -1) {
            return null;
        }
        Matcher region = f15125d.matcher(str).region(i10, str.length());
        if (region.lookingAt()) {
            return region.toMatchResult();
        }
        return null;
    }
}
