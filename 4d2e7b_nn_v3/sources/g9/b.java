package g9;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class b extends SSLSocketFactory {

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f12229e = {"RC4", "DES", "PSK", "_DHE_"};

    /* renamed from: a  reason: collision with root package name */
    private final SSLSocketFactory f12230a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12231b;

    /* renamed from: c  reason: collision with root package name */
    private Class f12232c;

    /* renamed from: d  reason: collision with root package name */
    private Method f12233d;

    /* renamed from: g9.b$b  reason: collision with other inner class name */
    private static class C0140b extends SSLSocket {

        /* renamed from: a  reason: collision with root package name */
        protected final SSLSocket f12234a;

        C0140b(SSLSocket sSLSocket) {
            this.f12234a = sSLSocket;
        }

        public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            this.f12234a.addHandshakeCompletedListener(handshakeCompletedListener);
        }

        public void bind(SocketAddress socketAddress) {
            this.f12234a.bind(socketAddress);
        }

        public synchronized void close() {
            this.f12234a.close();
        }

        public void connect(SocketAddress socketAddress) {
            this.f12234a.connect(socketAddress);
        }

        public boolean equals(Object obj) {
            return this.f12234a.equals(obj);
        }

        public SocketChannel getChannel() {
            return this.f12234a.getChannel();
        }

        public boolean getEnableSessionCreation() {
            return this.f12234a.getEnableSessionCreation();
        }

        public String[] getEnabledCipherSuites() {
            return this.f12234a.getEnabledCipherSuites();
        }

        public String[] getEnabledProtocols() {
            return this.f12234a.getEnabledProtocols();
        }

        public InetAddress getInetAddress() {
            return this.f12234a.getInetAddress();
        }

        public InputStream getInputStream() {
            return this.f12234a.getInputStream();
        }

        public boolean getKeepAlive() {
            return this.f12234a.getKeepAlive();
        }

        public InetAddress getLocalAddress() {
            return this.f12234a.getLocalAddress();
        }

        public int getLocalPort() {
            return this.f12234a.getLocalPort();
        }

        public SocketAddress getLocalSocketAddress() {
            return this.f12234a.getLocalSocketAddress();
        }

        public boolean getNeedClientAuth() {
            return this.f12234a.getNeedClientAuth();
        }

        public boolean getOOBInline() {
            return this.f12234a.getOOBInline();
        }

        public OutputStream getOutputStream() {
            return this.f12234a.getOutputStream();
        }

        public int getPort() {
            return this.f12234a.getPort();
        }

        public synchronized int getReceiveBufferSize() {
            return this.f12234a.getReceiveBufferSize();
        }

        public SocketAddress getRemoteSocketAddress() {
            return this.f12234a.getRemoteSocketAddress();
        }

        public boolean getReuseAddress() {
            return this.f12234a.getReuseAddress();
        }

        public synchronized int getSendBufferSize() {
            return this.f12234a.getSendBufferSize();
        }

        public SSLSession getSession() {
            return this.f12234a.getSession();
        }

        public int getSoLinger() {
            return this.f12234a.getSoLinger();
        }

        public synchronized int getSoTimeout() {
            return this.f12234a.getSoTimeout();
        }

        public String[] getSupportedCipherSuites() {
            return this.f12234a.getSupportedCipherSuites();
        }

        public String[] getSupportedProtocols() {
            return this.f12234a.getSupportedProtocols();
        }

        public boolean getTcpNoDelay() {
            return this.f12234a.getTcpNoDelay();
        }

        public int getTrafficClass() {
            return this.f12234a.getTrafficClass();
        }

        public boolean getUseClientMode() {
            return this.f12234a.getUseClientMode();
        }

        public boolean getWantClientAuth() {
            return this.f12234a.getWantClientAuth();
        }

        public boolean isBound() {
            return this.f12234a.isBound();
        }

        public boolean isClosed() {
            return this.f12234a.isClosed();
        }

        public boolean isConnected() {
            return this.f12234a.isConnected();
        }

        public boolean isInputShutdown() {
            return this.f12234a.isInputShutdown();
        }

        public boolean isOutputShutdown() {
            return this.f12234a.isOutputShutdown();
        }

        public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            this.f12234a.removeHandshakeCompletedListener(handshakeCompletedListener);
        }

        public void sendUrgentData(int i10) {
            this.f12234a.sendUrgentData(i10);
        }

        public void setEnableSessionCreation(boolean z10) {
            this.f12234a.setEnableSessionCreation(z10);
        }

        public void setEnabledCipherSuites(String[] strArr) {
            this.f12234a.setEnabledCipherSuites(strArr);
        }

        public void setEnabledProtocols(String[] strArr) {
            this.f12234a.setEnabledProtocols(strArr);
        }

        public void setKeepAlive(boolean z10) {
            this.f12234a.setKeepAlive(z10);
        }

        public void setNeedClientAuth(boolean z10) {
            this.f12234a.setNeedClientAuth(z10);
        }

        public void setOOBInline(boolean z10) {
            this.f12234a.setOOBInline(z10);
        }

        public void setPerformancePreferences(int i10, int i11, int i12) {
            this.f12234a.setPerformancePreferences(i10, i11, i12);
        }

        public synchronized void setReceiveBufferSize(int i10) {
            this.f12234a.setReceiveBufferSize(i10);
        }

        public void setReuseAddress(boolean z10) {
            this.f12234a.setReuseAddress(z10);
        }

        public synchronized void setSendBufferSize(int i10) {
            this.f12234a.setSendBufferSize(i10);
        }

        public void setSoLinger(boolean z10, int i10) {
            this.f12234a.setSoLinger(z10, i10);
        }

        public synchronized void setSoTimeout(int i10) {
            this.f12234a.setSoTimeout(i10);
        }

        public void setTcpNoDelay(boolean z10) {
            this.f12234a.setTcpNoDelay(z10);
        }

        public void setTrafficClass(int i10) {
            this.f12234a.setTrafficClass(i10);
        }

        public void setUseClientMode(boolean z10) {
            this.f12234a.setUseClientMode(z10);
        }

        public void setWantClientAuth(boolean z10) {
            this.f12234a.setWantClientAuth(z10);
        }

        public void shutdownInput() {
            this.f12234a.shutdownInput();
        }

        public void shutdownOutput() {
            this.f12234a.shutdownOutput();
        }

        public void startHandshake() {
            this.f12234a.startHandshake();
        }

        public String toString() {
            return this.f12234a.toString();
        }

        public void connect(SocketAddress socketAddress, int i10) {
            this.f12234a.connect(socketAddress, i10);
        }
    }

    private static class c extends C0140b {
        public void setEnabledProtocols(String[] strArr) {
            if (strArr != null && strArr.length == 1 && "SSLv3".equals(strArr[0])) {
                ArrayList arrayList = new ArrayList(Arrays.asList(this.f12234a.getEnabledProtocols()));
                if (arrayList.size() > 1) {
                    arrayList.remove("SSLv3");
                }
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            super.setEnabledProtocols(strArr);
        }

        private c(SSLSocket sSLSocket) {
            super(sSLSocket);
        }
    }

    public b(SSLSocketFactory sSLSocketFactory) {
        this(sSLSocketFactory, true);
    }

    private static String[] a() {
        return new String[]{"TLSv1.2"};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:8:? A[ExcHandler: NoSuchMethodException (unused java.lang.NoSuchMethodException), SYNTHETIC, Splitter:B:5:0x000b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r5 = this;
            java.lang.String r0 = "com.android.org.conscrypt.OpenSSLSocketImpl"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0009 }
            r5.f12232c = r0     // Catch:{ ClassNotFoundException -> 0x0009 }
            goto L_0x0011
        L_0x0009:
            java.lang.String r0 = "org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ NoSuchMethodException -> 0x0023, NoSuchMethodException -> 0x0023 }
            r5.f12232c = r0     // Catch:{ NoSuchMethodException -> 0x0023, NoSuchMethodException -> 0x0023 }
        L_0x0011:
            java.lang.Class r0 = r5.f12232c     // Catch:{ NoSuchMethodException -> 0x0023, NoSuchMethodException -> 0x0023 }
            java.lang.String r1 = "setHostname"
            r2 = 1
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x0023, NoSuchMethodException -> 0x0023 }
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r4 = 0
            r2[r4] = r3     // Catch:{ NoSuchMethodException -> 0x0023, NoSuchMethodException -> 0x0023 }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch:{ NoSuchMethodException -> 0x0023, NoSuchMethodException -> 0x0023 }
            r5.f12233d = r0     // Catch:{ NoSuchMethodException -> 0x0023, NoSuchMethodException -> 0x0023 }
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g9.b.b():void");
    }

    private static String[] c(String[] strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        for (String str : strArr) {
            for (String contains : f12229e) {
                if (str.contains(contains)) {
                    arrayList.remove(str);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private void d(Socket socket, String str) {
        Method method;
        if (this.f12232c.isInstance(socket) && (method = this.f12233d) != null) {
            try {
                method.invoke(socket, new Object[]{str});
            } catch (InvocationTargetException e10) {
                throw new RuntimeException(e10);
            } catch (IllegalAccessException e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    public Socket createSocket(Socket socket, String str, int i10, boolean z10) {
        Socket createSocket = this.f12230a.createSocket(socket, str, i10, z10);
        d(createSocket, str);
        return e(createSocket);
    }

    public Socket e(Socket socket) {
        if (!(socket instanceof SSLSocket)) {
            return socket;
        }
        SSLSocket sSLSocket = (SSLSocket) socket;
        sSLSocket.setEnabledProtocols(a());
        if (this.f12231b) {
            sSLSocket.setEnabledCipherSuites(c(sSLSocket.getEnabledCipherSuites()));
        }
        return new c(sSLSocket);
    }

    public String[] getDefaultCipherSuites() {
        if (this.f12231b) {
            return c(this.f12230a.getDefaultCipherSuites());
        }
        return this.f12230a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        if (this.f12231b) {
            return c(this.f12230a.getSupportedCipherSuites());
        }
        return this.f12230a.getSupportedCipherSuites();
    }

    public b(SSLSocketFactory sSLSocketFactory, boolean z10) {
        this.f12230a = sSLSocketFactory;
        this.f12231b = z10;
        b();
    }

    public Socket createSocket(String str, int i10) {
        Socket createSocket = this.f12230a.createSocket(str, i10);
        d(createSocket, str);
        return e(createSocket);
    }

    public Socket createSocket(InetAddress inetAddress, int i10) {
        return e(this.f12230a.createSocket(inetAddress, i10));
    }

    public Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) {
        return e(this.f12230a.createSocket(inetAddress, i10, inetAddress2, i11));
    }

    public Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) {
        Socket createSocket = this.f12230a.createSocket(str, i10, inetAddress, i11);
        d(createSocket, str);
        return e(createSocket);
    }

    public Socket createSocket() {
        return e(this.f12230a.createSocket());
    }
}
