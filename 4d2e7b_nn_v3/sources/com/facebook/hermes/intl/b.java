package com.facebook.hermes.intl;

import androidx.core.text.util.LocalePreferences;
import com.adjust.sdk.Constants;
import com.alibaba.pdns.model.DomainUhfReportModel;
import java.text.AttributedCharacterIterator;

public interface b {

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19769a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f19770b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f19771c;

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ int[] f19772d;

        /* renamed from: e  reason: collision with root package name */
        static final /* synthetic */ int[] f19773e;

        /* renamed from: f  reason: collision with root package name */
        static final /* synthetic */ int[] f19774f;

        /* renamed from: g  reason: collision with root package name */
        static final /* synthetic */ int[] f19775g;

        /* renamed from: h  reason: collision with root package name */
        static final /* synthetic */ int[] f19776h;

        /* renamed from: i  reason: collision with root package name */
        static final /* synthetic */ int[] f19777i;

        /* renamed from: j  reason: collision with root package name */
        static final /* synthetic */ int[] f19778j;

        /* renamed from: k  reason: collision with root package name */
        static final /* synthetic */ int[] f19779k;

        /* renamed from: l  reason: collision with root package name */
        static final /* synthetic */ int[] f19780l;

        /* renamed from: m  reason: collision with root package name */
        static final /* synthetic */ int[] f19781m;

        /* JADX WARNING: Can't wrap try/catch for region: R(107:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|45|46|(2:47|48)|49|51|52|53|54|(2:55|56)|57|59|60|61|62|(2:63|64)|65|67|68|69|70|(2:71|72)|73|75|76|77|78|(2:79|80)|81|83|84|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|(2:101|102)|103|105|106|107|108|109|110|(2:111|112)|113|115|116|117|118|119|120|(2:121|122)|123|125|126|127|128|129|130|131|132|(2:133|134)|135|137|138|(3:139|140|142)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(109:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|45|46|47|48|49|51|52|53|54|(2:55|56)|57|59|60|61|62|(2:63|64)|65|67|68|69|70|(2:71|72)|73|75|76|77|78|(2:79|80)|81|83|84|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|105|106|107|108|109|110|(2:111|112)|113|115|116|117|118|119|120|(2:121|122)|123|125|126|127|128|129|130|131|132|(2:133|134)|135|137|138|(3:139|140|142)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(110:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|45|46|47|48|49|51|52|53|54|(2:55|56)|57|59|60|61|62|(2:63|64)|65|67|68|69|70|(2:71|72)|73|75|76|77|78|(2:79|80)|81|83|84|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|105|106|107|108|109|110|(2:111|112)|113|115|116|117|118|119|120|(2:121|122)|123|125|126|127|128|129|130|131|132|(2:133|134)|135|137|138|(3:139|140|142)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(111:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|45|46|47|48|49|51|52|53|54|(2:55|56)|57|59|60|61|62|(2:63|64)|65|67|68|69|70|(2:71|72)|73|75|76|77|78|(2:79|80)|81|83|84|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|105|106|107|108|109|110|(2:111|112)|113|115|116|117|118|119|120|(2:121|122)|123|125|126|127|128|129|130|131|132|(2:133|134)|135|137|138|(3:139|140|142)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(116:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|45|46|47|48|49|51|52|53|54|(2:55|56)|57|59|60|61|62|(2:63|64)|65|67|68|69|70|71|72|73|75|76|77|78|(2:79|80)|81|83|84|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|105|106|107|108|109|110|111|112|113|115|116|117|118|119|120|(2:121|122)|123|125|126|127|128|129|130|131|132|(2:133|134)|135|137|138|139|140|142) */
        /* JADX WARNING: Can't wrap try/catch for region: R(118:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|45|46|47|48|49|51|52|53|54|55|56|57|59|60|61|62|(2:63|64)|65|67|68|69|70|71|72|73|75|76|77|78|(2:79|80)|81|83|84|85|86|87|88|89|90|91|92|(2:93|94)|95|97|98|99|100|101|102|103|105|106|107|108|109|110|111|112|113|115|116|117|118|119|120|(2:121|122)|123|125|126|127|128|129|130|131|132|(2:133|134)|135|137|138|139|140|142) */
        /* JADX WARNING: Can't wrap try/catch for region: R(121:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|45|46|47|48|49|51|52|53|54|55|56|57|59|60|61|62|(2:63|64)|65|67|68|69|70|71|72|73|75|76|77|78|(2:79|80)|81|83|84|85|86|87|88|89|90|91|92|93|94|95|97|98|99|100|101|102|103|105|106|107|108|109|110|111|112|113|115|116|117|118|119|120|121|122|123|125|126|127|128|129|130|131|132|(2:133|134)|135|137|138|139|140|142) */
        /* JADX WARNING: Can't wrap try/catch for region: R(123:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|45|46|47|48|49|51|52|53|54|55|56|57|59|60|61|62|(2:63|64)|65|67|68|69|70|71|72|73|75|76|77|78|79|80|81|83|84|85|86|87|88|89|90|91|92|93|94|95|97|98|99|100|101|102|103|105|106|107|108|109|110|111|112|113|115|116|117|118|119|120|121|122|123|125|126|127|128|129|130|131|132|133|134|135|137|138|139|140|142) */
        /* JADX WARNING: Can't wrap try/catch for region: R(124:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|45|46|47|48|49|51|52|53|54|55|56|57|59|60|61|62|(2:63|64)|65|67|68|69|70|71|72|73|75|76|77|78|79|80|81|83|84|85|86|87|88|89|90|91|92|93|94|95|97|98|99|100|101|102|103|105|106|107|108|109|110|111|112|113|115|116|117|118|119|120|121|122|123|125|126|127|128|129|130|131|132|133|134|135|137|138|139|140|142) */
        /* JADX WARNING: Can't wrap try/catch for region: R(125:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|45|46|47|48|49|51|52|53|54|55|56|57|59|60|61|62|63|64|65|67|68|69|70|71|72|73|75|76|77|78|79|80|81|83|84|85|86|87|88|89|90|91|92|93|94|95|97|98|99|100|101|102|103|105|106|107|108|109|110|111|112|113|115|116|117|118|119|120|121|122|123|125|126|127|128|129|130|131|132|133|134|135|137|138|139|140|142) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:101:0x01b8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:107:0x01d3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:109:0x01dd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:111:0x01e7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:117:0x0202 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:119:0x020c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:121:0x0216 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:127:0x0231 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:129:0x023b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:131:0x0245 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:133:0x024f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:139:0x026a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0063 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0088 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00a6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00bb */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00d7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00e1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0106 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0121 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x012b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x0146 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:79:0x0150 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x016b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x0175 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x017f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x0189 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x0193 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:99:0x01ae */
        static {
            /*
                com.facebook.hermes.intl.b$k[] r0 = com.facebook.hermes.intl.b.k.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19781m = r0
                r1 = 1
                com.facebook.hermes.intl.b$k r2 = com.facebook.hermes.intl.b.k.FULL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f19781m     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.hermes.intl.b$k r3 = com.facebook.hermes.intl.b.k.LONG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f19781m     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.hermes.intl.b$k r4 = com.facebook.hermes.intl.b.k.MEDIUM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f19781m     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.hermes.intl.b$k r5 = com.facebook.hermes.intl.b.k.SHORT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f19781m     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.hermes.intl.b$k r6 = com.facebook.hermes.intl.b.k.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                com.facebook.hermes.intl.b$b[] r5 = com.facebook.hermes.intl.b.C0249b.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f19780l = r5
                com.facebook.hermes.intl.b$b r6 = com.facebook.hermes.intl.b.C0249b.FULL     // Catch:{ NoSuchFieldError -> 0x004f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r5 = f19780l     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.facebook.hermes.intl.b$b r6 = com.facebook.hermes.intl.b.C0249b.LONG     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r5 = f19780l     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.facebook.hermes.intl.b$b r6 = com.facebook.hermes.intl.b.C0249b.MEDIUM     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r5[r6] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r5 = f19780l     // Catch:{ NoSuchFieldError -> 0x006d }
                com.facebook.hermes.intl.b$b r6 = com.facebook.hermes.intl.b.C0249b.SHORT     // Catch:{ NoSuchFieldError -> 0x006d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r5[r6] = r3     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r5 = f19780l     // Catch:{ NoSuchFieldError -> 0x0077 }
                com.facebook.hermes.intl.b$b r6 = com.facebook.hermes.intl.b.C0249b.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0077 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0077 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0077 }
            L_0x0077:
                com.facebook.hermes.intl.b$l[] r5 = com.facebook.hermes.intl.b.l.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f19779k = r5
                com.facebook.hermes.intl.b$l r6 = com.facebook.hermes.intl.b.l.LONG     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                int[] r5 = f19779k     // Catch:{ NoSuchFieldError -> 0x0092 }
                com.facebook.hermes.intl.b$l r6 = com.facebook.hermes.intl.b.l.LONGOFFSET     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                int[] r5 = f19779k     // Catch:{ NoSuchFieldError -> 0x009c }
                com.facebook.hermes.intl.b$l r6 = com.facebook.hermes.intl.b.l.LONGGENERIC     // Catch:{ NoSuchFieldError -> 0x009c }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r5[r6] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r5 = f19779k     // Catch:{ NoSuchFieldError -> 0x00a6 }
                com.facebook.hermes.intl.b$l r6 = com.facebook.hermes.intl.b.l.SHORT     // Catch:{ NoSuchFieldError -> 0x00a6 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a6 }
                r5[r6] = r3     // Catch:{ NoSuchFieldError -> 0x00a6 }
            L_0x00a6:
                int[] r5 = f19779k     // Catch:{ NoSuchFieldError -> 0x00b0 }
                com.facebook.hermes.intl.b$l r6 = com.facebook.hermes.intl.b.l.SHORTOFFSET     // Catch:{ NoSuchFieldError -> 0x00b0 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b0 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x00b0 }
            L_0x00b0:
                r5 = 6
                int[] r6 = f19779k     // Catch:{ NoSuchFieldError -> 0x00bb }
                com.facebook.hermes.intl.b$l r7 = com.facebook.hermes.intl.b.l.SHORTGENERIC     // Catch:{ NoSuchFieldError -> 0x00bb }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bb }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x00bb }
            L_0x00bb:
                int[] r6 = f19779k     // Catch:{ NoSuchFieldError -> 0x00c6 }
                com.facebook.hermes.intl.b$l r7 = com.facebook.hermes.intl.b.l.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x00c6 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c6 }
                r8 = 7
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00c6 }
            L_0x00c6:
                com.facebook.hermes.intl.b$j[] r6 = com.facebook.hermes.intl.b.j.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                f19778j = r6
                com.facebook.hermes.intl.b$j r7 = com.facebook.hermes.intl.b.j.NUMERIC     // Catch:{ NoSuchFieldError -> 0x00d7 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d7 }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x00d7 }
            L_0x00d7:
                int[] r6 = f19778j     // Catch:{ NoSuchFieldError -> 0x00e1 }
                com.facebook.hermes.intl.b$j r7 = com.facebook.hermes.intl.b.j.DIGIT2     // Catch:{ NoSuchFieldError -> 0x00e1 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e1 }
                r6[r7] = r0     // Catch:{ NoSuchFieldError -> 0x00e1 }
            L_0x00e1:
                int[] r6 = f19778j     // Catch:{ NoSuchFieldError -> 0x00eb }
                com.facebook.hermes.intl.b$j r7 = com.facebook.hermes.intl.b.j.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x00eb }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00eb }
                r6[r7] = r2     // Catch:{ NoSuchFieldError -> 0x00eb }
            L_0x00eb:
                com.facebook.hermes.intl.b$h[] r6 = com.facebook.hermes.intl.b.h.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                f19777i = r6
                com.facebook.hermes.intl.b$h r7 = com.facebook.hermes.intl.b.h.NUMERIC     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r6 = f19777i     // Catch:{ NoSuchFieldError -> 0x0106 }
                com.facebook.hermes.intl.b$h r7 = com.facebook.hermes.intl.b.h.DIGIT2     // Catch:{ NoSuchFieldError -> 0x0106 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0106 }
                r6[r7] = r0     // Catch:{ NoSuchFieldError -> 0x0106 }
            L_0x0106:
                int[] r6 = f19777i     // Catch:{ NoSuchFieldError -> 0x0110 }
                com.facebook.hermes.intl.b$h r7 = com.facebook.hermes.intl.b.h.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0110 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0110 }
                r6[r7] = r2     // Catch:{ NoSuchFieldError -> 0x0110 }
            L_0x0110:
                com.facebook.hermes.intl.b$f[] r6 = com.facebook.hermes.intl.b.f.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                f19776h = r6
                com.facebook.hermes.intl.b$f r7 = com.facebook.hermes.intl.b.f.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0121 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0121 }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x0121 }
            L_0x0121:
                int[] r6 = f19776h     // Catch:{ NoSuchFieldError -> 0x012b }
                com.facebook.hermes.intl.b$f r7 = com.facebook.hermes.intl.b.f.DIGIT2     // Catch:{ NoSuchFieldError -> 0x012b }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x012b }
                r6[r7] = r0     // Catch:{ NoSuchFieldError -> 0x012b }
            L_0x012b:
                int[] r6 = f19776h     // Catch:{ NoSuchFieldError -> 0x0135 }
                com.facebook.hermes.intl.b$f r7 = com.facebook.hermes.intl.b.f.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0135 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0135 }
                r6[r7] = r2     // Catch:{ NoSuchFieldError -> 0x0135 }
            L_0x0135:
                com.facebook.hermes.intl.b$c[] r6 = com.facebook.hermes.intl.b.c.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                f19775g = r6
                com.facebook.hermes.intl.b$c r7 = com.facebook.hermes.intl.b.c.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0146 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0146 }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x0146 }
            L_0x0146:
                int[] r6 = f19775g     // Catch:{ NoSuchFieldError -> 0x0150 }
                com.facebook.hermes.intl.b$c r7 = com.facebook.hermes.intl.b.c.DIGIT2     // Catch:{ NoSuchFieldError -> 0x0150 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0150 }
                r6[r7] = r0     // Catch:{ NoSuchFieldError -> 0x0150 }
            L_0x0150:
                int[] r6 = f19775g     // Catch:{ NoSuchFieldError -> 0x015a }
                com.facebook.hermes.intl.b$c r7 = com.facebook.hermes.intl.b.c.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x015a }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x015a }
                r6[r7] = r2     // Catch:{ NoSuchFieldError -> 0x015a }
            L_0x015a:
                com.facebook.hermes.intl.b$i[] r6 = com.facebook.hermes.intl.b.i.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                f19774f = r6
                com.facebook.hermes.intl.b$i r7 = com.facebook.hermes.intl.b.i.NUMERIC     // Catch:{ NoSuchFieldError -> 0x016b }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x016b }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x016b }
            L_0x016b:
                int[] r6 = f19774f     // Catch:{ NoSuchFieldError -> 0x0175 }
                com.facebook.hermes.intl.b$i r7 = com.facebook.hermes.intl.b.i.DIGIT2     // Catch:{ NoSuchFieldError -> 0x0175 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0175 }
                r6[r7] = r0     // Catch:{ NoSuchFieldError -> 0x0175 }
            L_0x0175:
                int[] r6 = f19774f     // Catch:{ NoSuchFieldError -> 0x017f }
                com.facebook.hermes.intl.b$i r7 = com.facebook.hermes.intl.b.i.LONG     // Catch:{ NoSuchFieldError -> 0x017f }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x017f }
                r6[r7] = r2     // Catch:{ NoSuchFieldError -> 0x017f }
            L_0x017f:
                int[] r6 = f19774f     // Catch:{ NoSuchFieldError -> 0x0189 }
                com.facebook.hermes.intl.b$i r7 = com.facebook.hermes.intl.b.i.SHORT     // Catch:{ NoSuchFieldError -> 0x0189 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0189 }
                r6[r7] = r3     // Catch:{ NoSuchFieldError -> 0x0189 }
            L_0x0189:
                int[] r6 = f19774f     // Catch:{ NoSuchFieldError -> 0x0193 }
                com.facebook.hermes.intl.b$i r7 = com.facebook.hermes.intl.b.i.NARROW     // Catch:{ NoSuchFieldError -> 0x0193 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0193 }
                r6[r7] = r4     // Catch:{ NoSuchFieldError -> 0x0193 }
            L_0x0193:
                int[] r6 = f19774f     // Catch:{ NoSuchFieldError -> 0x019d }
                com.facebook.hermes.intl.b$i r7 = com.facebook.hermes.intl.b.i.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x019d }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x019d }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x019d }
            L_0x019d:
                com.facebook.hermes.intl.b$n[] r5 = com.facebook.hermes.intl.b.n.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f19773e = r5
                com.facebook.hermes.intl.b$n r6 = com.facebook.hermes.intl.b.n.NUMERIC     // Catch:{ NoSuchFieldError -> 0x01ae }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x01ae }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x01ae }
            L_0x01ae:
                int[] r5 = f19773e     // Catch:{ NoSuchFieldError -> 0x01b8 }
                com.facebook.hermes.intl.b$n r6 = com.facebook.hermes.intl.b.n.DIGIT2     // Catch:{ NoSuchFieldError -> 0x01b8 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x01b8 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x01b8 }
            L_0x01b8:
                int[] r5 = f19773e     // Catch:{ NoSuchFieldError -> 0x01c2 }
                com.facebook.hermes.intl.b$n r6 = com.facebook.hermes.intl.b.n.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x01c2 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x01c2 }
                r5[r6] = r2     // Catch:{ NoSuchFieldError -> 0x01c2 }
            L_0x01c2:
                com.facebook.hermes.intl.b$d[] r5 = com.facebook.hermes.intl.b.d.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f19772d = r5
                com.facebook.hermes.intl.b$d r6 = com.facebook.hermes.intl.b.d.LONG     // Catch:{ NoSuchFieldError -> 0x01d3 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x01d3 }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x01d3 }
            L_0x01d3:
                int[] r5 = f19772d     // Catch:{ NoSuchFieldError -> 0x01dd }
                com.facebook.hermes.intl.b$d r6 = com.facebook.hermes.intl.b.d.SHORT     // Catch:{ NoSuchFieldError -> 0x01dd }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x01dd }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x01dd }
            L_0x01dd:
                int[] r5 = f19772d     // Catch:{ NoSuchFieldError -> 0x01e7 }
                com.facebook.hermes.intl.b$d r6 = com.facebook.hermes.intl.b.d.NARROW     // Catch:{ NoSuchFieldError -> 0x01e7 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x01e7 }
                r5[r6] = r2     // Catch:{ NoSuchFieldError -> 0x01e7 }
            L_0x01e7:
                int[] r5 = f19772d     // Catch:{ NoSuchFieldError -> 0x01f1 }
                com.facebook.hermes.intl.b$d r6 = com.facebook.hermes.intl.b.d.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x01f1 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x01f1 }
                r5[r6] = r3     // Catch:{ NoSuchFieldError -> 0x01f1 }
            L_0x01f1:
                com.facebook.hermes.intl.b$m[] r5 = com.facebook.hermes.intl.b.m.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f19771c = r5
                com.facebook.hermes.intl.b$m r6 = com.facebook.hermes.intl.b.m.LONG     // Catch:{ NoSuchFieldError -> 0x0202 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0202 }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0202 }
            L_0x0202:
                int[] r5 = f19771c     // Catch:{ NoSuchFieldError -> 0x020c }
                com.facebook.hermes.intl.b$m r6 = com.facebook.hermes.intl.b.m.SHORT     // Catch:{ NoSuchFieldError -> 0x020c }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x020c }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x020c }
            L_0x020c:
                int[] r5 = f19771c     // Catch:{ NoSuchFieldError -> 0x0216 }
                com.facebook.hermes.intl.b$m r6 = com.facebook.hermes.intl.b.m.NARROW     // Catch:{ NoSuchFieldError -> 0x0216 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0216 }
                r5[r6] = r2     // Catch:{ NoSuchFieldError -> 0x0216 }
            L_0x0216:
                int[] r5 = f19771c     // Catch:{ NoSuchFieldError -> 0x0220 }
                com.facebook.hermes.intl.b$m r6 = com.facebook.hermes.intl.b.m.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0220 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0220 }
                r5[r6] = r3     // Catch:{ NoSuchFieldError -> 0x0220 }
            L_0x0220:
                com.facebook.hermes.intl.b$g[] r5 = com.facebook.hermes.intl.b.g.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f19770b = r5
                com.facebook.hermes.intl.b$g r6 = com.facebook.hermes.intl.b.g.H11     // Catch:{ NoSuchFieldError -> 0x0231 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0231 }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0231 }
            L_0x0231:
                int[] r5 = f19770b     // Catch:{ NoSuchFieldError -> 0x023b }
                com.facebook.hermes.intl.b$g r6 = com.facebook.hermes.intl.b.g.H12     // Catch:{ NoSuchFieldError -> 0x023b }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x023b }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x023b }
            L_0x023b:
                int[] r5 = f19770b     // Catch:{ NoSuchFieldError -> 0x0245 }
                com.facebook.hermes.intl.b$g r6 = com.facebook.hermes.intl.b.g.H23     // Catch:{ NoSuchFieldError -> 0x0245 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0245 }
                r5[r6] = r2     // Catch:{ NoSuchFieldError -> 0x0245 }
            L_0x0245:
                int[] r2 = f19770b     // Catch:{ NoSuchFieldError -> 0x024f }
                com.facebook.hermes.intl.b$g r5 = com.facebook.hermes.intl.b.g.H24     // Catch:{ NoSuchFieldError -> 0x024f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x024f }
                r2[r5] = r3     // Catch:{ NoSuchFieldError -> 0x024f }
            L_0x024f:
                int[] r2 = f19770b     // Catch:{ NoSuchFieldError -> 0x0259 }
                com.facebook.hermes.intl.b$g r3 = com.facebook.hermes.intl.b.g.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0259 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0259 }
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0259 }
            L_0x0259:
                com.facebook.hermes.intl.b$e[] r2 = com.facebook.hermes.intl.b.e.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f19769a = r2
                com.facebook.hermes.intl.b$e r3 = com.facebook.hermes.intl.b.e.BESTFIT     // Catch:{ NoSuchFieldError -> 0x026a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x026a }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x026a }
            L_0x026a:
                int[] r1 = f19769a     // Catch:{ NoSuchFieldError -> 0x0274 }
                com.facebook.hermes.intl.b$e r2 = com.facebook.hermes.intl.b.e.BASIC     // Catch:{ NoSuchFieldError -> 0x0274 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0274 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0274 }
            L_0x0274:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.intl.b.a.<clinit>():void");
        }
    }

    /* renamed from: com.facebook.hermes.intl.b$b  reason: collision with other inner class name */
    public enum C0249b {
        FULL,
        LONG,
        MEDIUM,
        SHORT,
        UNDEFINED;

        public String toString() {
            int i10 = a.f19780l[ordinal()];
            if (i10 == 1) {
                return "full";
            }
            if (i10 == 2) {
                return Constants.LONG;
            }
            if (i10 == 3) {
                return "medium";
            }
            if (i10 == 4) {
                return "short";
            }
            if (i10 == 5) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum c {
        NUMERIC,
        DIGIT2,
        UNDEFINED;

        public String b() {
            int i10 = a.f19775g[ordinal()];
            if (i10 == 1) {
                return DomainUhfReportModel.ENCRYPTDATA;
            }
            if (i10 == 2) {
                return "dd";
            }
            if (i10 == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String toString() {
            int i10 = a.f19775g[ordinal()];
            if (i10 == 1) {
                return "numeric";
            }
            if (i10 == 2) {
                return "2-digit";
            }
            if (i10 == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum d {
        LONG,
        SHORT,
        NARROW,
        UNDEFINED;

        public String b() {
            int i10 = a.f19772d[ordinal()];
            if (i10 == 1) {
                return "GGGG";
            }
            if (i10 == 2) {
                return "GGG";
            }
            if (i10 == 3) {
                return "G5";
            }
            if (i10 == 4) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String toString() {
            int i10 = a.f19772d[ordinal()];
            if (i10 == 1) {
                return Constants.LONG;
            }
            if (i10 == 2) {
                return "short";
            }
            if (i10 == 3) {
                return "narrow";
            }
            if (i10 == 4) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum e {
        BESTFIT,
        BASIC;

        public String toString() {
            int i10 = a.f19769a[ordinal()];
            if (i10 == 1) {
                return "best fit";
            }
            if (i10 == 2) {
                return "basic";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum f {
        NUMERIC,
        DIGIT2,
        UNDEFINED;

        public String b() {
            int i10 = a.f19776h[ordinal()];
            if (i10 == 1) {
                return "h";
            }
            if (i10 == 2) {
                return "hh";
            }
            if (i10 == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String c() {
            int i10 = a.f19776h[ordinal()];
            if (i10 == 1) {
                return "k";
            }
            if (i10 == 2) {
                return "kk";
            }
            if (i10 == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String toString() {
            int i10 = a.f19776h[ordinal()];
            if (i10 == 1) {
                return "numeric";
            }
            if (i10 == 2) {
                return "2-digit";
            }
            if (i10 == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum g {
        H11,
        H12,
        H23,
        H24,
        UNDEFINED;

        public String toString() {
            int i10 = a.f19770b[ordinal()];
            if (i10 == 1) {
                return LocalePreferences.HourCycle.H11;
            }
            if (i10 == 2) {
                return LocalePreferences.HourCycle.H12;
            }
            if (i10 == 3) {
                return LocalePreferences.HourCycle.H23;
            }
            if (i10 == 4) {
                return LocalePreferences.HourCycle.H24;
            }
            if (i10 == 5) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum h {
        NUMERIC,
        DIGIT2,
        UNDEFINED;

        public String b() {
            int i10 = a.f19777i[ordinal()];
            if (i10 == 1) {
                return "m";
            }
            if (i10 == 2) {
                return "mm";
            }
            if (i10 == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String toString() {
            int i10 = a.f19777i[ordinal()];
            if (i10 == 1) {
                return "numeric";
            }
            if (i10 == 2) {
                return "2-digit";
            }
            if (i10 == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum i {
        NUMERIC,
        DIGIT2,
        LONG,
        SHORT,
        NARROW,
        UNDEFINED;

        public String b() {
            switch (a.f19774f[ordinal()]) {
                case 1:
                    return "M";
                case 2:
                    return "MM";
                case 3:
                    return "MMMM";
                case 4:
                    return "MMM";
                case 5:
                    return "MMMMM";
                case 6:
                    return "";
                default:
                    throw new IllegalArgumentException();
            }
        }

        public String toString() {
            switch (a.f19774f[ordinal()]) {
                case 1:
                    return "numeric";
                case 2:
                    return "2-digit";
                case 3:
                    return Constants.LONG;
                case 4:
                    return "short";
                case 5:
                    return "narrow";
                case 6:
                    return "";
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    public enum j {
        NUMERIC,
        DIGIT2,
        UNDEFINED;

        public String b() {
            int i10 = a.f19778j[ordinal()];
            if (i10 == 1) {
                return DomainUhfReportModel.SCENE;
            }
            if (i10 == 2) {
                return "ss";
            }
            if (i10 == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String toString() {
            int i10 = a.f19778j[ordinal()];
            if (i10 == 1) {
                return "numeric";
            }
            if (i10 == 2) {
                return "2-digit";
            }
            if (i10 == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum k {
        FULL,
        LONG,
        MEDIUM,
        SHORT,
        UNDEFINED;

        public String toString() {
            int i10 = a.f19781m[ordinal()];
            if (i10 == 1) {
                return "full";
            }
            if (i10 == 2) {
                return Constants.LONG;
            }
            if (i10 == 3) {
                return "medium";
            }
            if (i10 == 4) {
                return "short";
            }
            if (i10 == 5) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum l {
        LONG,
        LONGOFFSET,
        LONGGENERIC,
        SHORT,
        SHORTOFFSET,
        SHORTGENERIC,
        UNDEFINED;

        public String b() {
            switch (a.f19779k[ordinal()]) {
                case 1:
                    return "zzzz";
                case 2:
                    return "OOOO";
                case 3:
                    return "vvvv";
                case 4:
                    return "z";
                case 5:
                    return "O";
                case 6:
                    return DomainUhfReportModel.ENCRYPTYPE;
                case 7:
                    return "";
                default:
                    throw new IllegalArgumentException();
            }
        }

        public String toString() {
            switch (a.f19779k[ordinal()]) {
                case 1:
                    return Constants.LONG;
                case 2:
                    return "longOffset";
                case 3:
                    return "longGeneric";
                case 4:
                    return "short";
                case 5:
                    return "shortOffset";
                case 6:
                    return "shortGeneric";
                case 7:
                    return "";
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    public enum m {
        LONG,
        SHORT,
        NARROW,
        UNDEFINED;

        public String b() {
            int i10 = a.f19771c[ordinal()];
            if (i10 == 1) {
                return "EEEE";
            }
            if (i10 == 2) {
                return "EEE";
            }
            if (i10 == 3) {
                return "EEEEE";
            }
            if (i10 == 4) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String toString() {
            int i10 = a.f19771c[ordinal()];
            if (i10 == 1) {
                return Constants.LONG;
            }
            if (i10 == 2) {
                return "short";
            }
            if (i10 == 3) {
                return "narrow";
            }
            if (i10 == 4) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum n {
        NUMERIC,
        DIGIT2,
        UNDEFINED;

        public String b() {
            int i10 = a.f19773e[ordinal()];
            if (i10 == 1) {
                return "yyyy";
            }
            if (i10 == 2) {
                return "yy";
            }
            if (i10 == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String toString() {
            int i10 = a.f19773e[ordinal()];
            if (i10 == 1) {
                return "numeric";
            }
            if (i10 == 2) {
                return "2-digit";
            }
            if (i10 == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    AttributedCharacterIterator a(double d10);

    String b(double d10);

    String c(o4.b bVar);

    String d(o4.b bVar);

    void e(o4.b bVar, String str, String str2, e eVar, m mVar, d dVar, n nVar, i iVar, c cVar, f fVar, h hVar, j jVar, l lVar, g gVar, Object obj, C0249b bVar2, k kVar, Object obj2);

    String f(AttributedCharacterIterator.Attribute attribute, String str);

    g g(o4.b bVar);

    String h(o4.b bVar);
}
