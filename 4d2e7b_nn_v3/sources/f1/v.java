package f1;

import f1.j;
import f1.k;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public abstract class v {

    /* renamed from: a  reason: collision with root package name */
    static final j.f f21495a = new a();

    /* renamed from: b  reason: collision with root package name */
    static final k.a f21496b = new b();

    /* renamed from: c  reason: collision with root package name */
    private static final DocumentBuilder f21497c;

    class a implements j.f {
        a() {
        }

        /* renamed from: b */
        public Element a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            return v.g(jVar);
        }
    }

    class b implements k.a {
        b() {
        }

        /* renamed from: b */
        public void a(k kVar, Element element) {
            v.j(element, kVar);
        }
    }

    static {
        try {
            f21497c = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static void a(Document document, Node node, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            node.appendChild(document.createCDATASection((String) it.next()));
        }
    }

    private static void b(Document document, Node node, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            node.appendChild(document.createComment((String) it.next()));
        }
    }

    private static void c(Document document, Node node, List list) {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
        }
        node.appendChild(document.createTextNode(sb2.toString()));
    }

    private static void d(Document document, Element element, Object obj) {
        if (obj instanceof HashMap) {
            for (Map.Entry entry : ((HashMap) obj).entrySet()) {
                String str = (String) entry.getKey();
                if (str.startsWith("@")) {
                    element.setAttribute(str.substring(1), entry.getValue().toString());
                } else if (!str.startsWith("#")) {
                    Element createElement = document.createElement(str);
                    element.appendChild(createElement);
                    d(document, createElement, entry.getValue());
                } else if (str.equals("#text")) {
                    if (entry.getValue() instanceof List) {
                        c(document, element, (List) entry.getValue());
                    } else {
                        element.appendChild(document.createTextNode(entry.getValue().toString()));
                    }
                } else if (str.equals("#cdata-section")) {
                    if (entry.getValue() instanceof List) {
                        a(document, element, (List) entry.getValue());
                    } else {
                        element.appendChild(document.createCDATASection(entry.getValue().toString()));
                    }
                } else if (str.equals("#comment")) {
                    if (entry.getValue() instanceof List) {
                        b(document, element, (List) entry.getValue());
                    } else {
                        element.appendChild(document.createComment(entry.getValue().toString()));
                    }
                }
            }
        } else if (obj instanceof List) {
            e(document, element, (List) obj);
        } else if (obj != null) {
            element.setTextContent(obj.toString());
        }
    }

    private static void e(Document document, Node node, List list) {
        Node parentNode = node.getParentNode();
        d(document, (Element) node, list.get(0));
        for (Object next : list.subList(1, list.size())) {
            Element createElement = document.createElement(node.getNodeName());
            parentNode.appendChild(createElement);
            d(document, createElement, next);
        }
    }

    private static synchronized Document f() {
        Document newDocument;
        synchronized (v.class) {
            try {
                newDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            } catch (ParserConfigurationException e10) {
                throw new e((Throwable) e10);
            }
        }
        return newDocument;
    }

    public static Element g(j jVar) {
        if (jVar.l() != 34) {
            return h(n.b(jVar));
        }
        try {
            return f21497c.parse(new InputSource(new StringReader(jVar.G()))).getDocumentElement();
        } catch (SAXException e10) {
            throw jVar.q("Invalid XML value", 0, e10);
        }
    }

    public static Element h(Map map) {
        Set keySet = map.keySet();
        if (keySet.size() <= 1) {
            String str = (String) keySet.iterator().next();
            Document f10 = f();
            Element createElement = f10.createElement(str);
            f10.appendChild(createElement);
            d(f10, createElement, map.get(str));
            return createElement;
        }
        throw o.b("Invalid XML. Expecting root element", true);
    }

    public static void i(Element element, k kVar) {
        Document ownerDocument = element.getOwnerDocument();
        DOMImplementationLS dOMImplementationLS = (DOMImplementationLS) ownerDocument.getImplementation();
        LSSerializer createLSSerializer = dOMImplementationLS.createLSSerializer();
        LSOutput createLSOutput = dOMImplementationLS.createLSOutput();
        createLSOutput.setEncoding("UTF-8");
        StringWriter stringWriter = new StringWriter();
        createLSOutput.setCharacterStream(stringWriter);
        createLSSerializer.write(ownerDocument, createLSOutput);
        r.a(stringWriter.toString(), kVar);
    }

    public static void j(Element element, k kVar) {
        if (element == null) {
            kVar.n();
        } else {
            i(element, kVar);
        }
    }
}
