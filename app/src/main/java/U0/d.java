package U0;

import D0.l;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import z0.C0384f;

/* loaded from: classes.dex */
abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f913a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f914a;

        static {
            int[] iArr = new int[h.values().length];
            f914a = iArr;
            try {
                iArr[h.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f914a[h.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f914a[h.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f914a[h.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f914a[h.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f914a[h.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f914a[h.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f914a[h.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f914a[h.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f914a[h.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static D0.e a(byte[] bArr, j jVar, f fVar, Map map) throws C0384f {
        h hVar;
        D0.c cVar = new D0.c(bArr);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int i2 = -1;
        int iD = -1;
        boolean z2 = false;
        D0.d dVarA = null;
        do {
            try {
                h hVarA = cVar.a() < 4 ? h.TERMINATOR : h.a(cVar.d(4));
                int[] iArr = a.f914a;
                switch (iArr[hVarA.ordinal()]) {
                    case 5:
                        hVar = hVarA;
                        break;
                    case 6:
                    case 7:
                        hVar = hVarA;
                        z2 = true;
                        break;
                    case 8:
                        hVar = hVarA;
                        if (cVar.a() < 16) {
                            throw C0384f.a();
                        }
                        int iD2 = cVar.d(8);
                        iD = cVar.d(8);
                        i2 = iD2;
                        break;
                    case 9:
                        hVar = hVarA;
                        dVarA = D0.d.a(g(cVar));
                        if (dVarA == null) {
                            throw C0384f.a();
                        }
                        break;
                    case 10:
                        hVar = hVarA;
                        int iD3 = cVar.d(4);
                        int iD4 = cVar.d(hVar.b(jVar));
                        if (iD3 == 1) {
                            d(cVar, sb, iD4);
                        }
                        break;
                    default:
                        int iD5 = cVar.d(hVarA.b(jVar));
                        int i3 = iArr[hVarA.ordinal()];
                        if (i3 == 1) {
                            hVar = hVarA;
                            f(cVar, sb, iD5);
                        } else if (i3 == 2) {
                            hVar = hVarA;
                            b(cVar, sb, iD5, z2);
                        } else if (i3 == 3) {
                            hVar = hVarA;
                            c(cVar, sb, iD5, dVarA, arrayList, map);
                        } else {
                            if (i3 != 4) {
                                throw C0384f.a();
                            }
                            e(cVar, sb, iD5);
                            hVar = hVarA;
                        }
                        break;
                }
            } catch (IllegalArgumentException unused) {
                throw C0384f.a();
            }
        } while (hVar != h.TERMINATOR);
        return new D0.e(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, fVar == null ? null : fVar.toString(), i2, iD);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(D0.c r3, java.lang.StringBuilder r4, int r5, boolean r6) throws z0.C0384f {
        /*
            int r0 = r4.length()
        L4:
            r1 = 1
            if (r5 <= r1) goto L2d
            int r1 = r3.a()
            r2 = 11
            if (r1 < r2) goto L28
            int r1 = r3.d(r2)
            int r2 = r1 / 45
            char r2 = h(r2)
            r4.append(r2)
            int r1 = r1 % 45
            char r1 = h(r1)
            r4.append(r1)
            int r5 = r5 + (-2)
            goto L4
        L28:
            z0.f r3 = z0.C0384f.a()
            throw r3
        L2d:
            if (r5 != r1) goto L47
            int r5 = r3.a()
            r2 = 6
            if (r5 < r2) goto L42
            int r3 = r3.d(r2)
            char r3 = h(r3)
            r4.append(r3)
            goto L47
        L42:
            z0.f r3 = z0.C0384f.a()
            throw r3
        L47:
            if (r6 == 0) goto L72
        L49:
            int r3 = r4.length()
            if (r0 >= r3) goto L72
            char r3 = r4.charAt(r0)
            r5 = 37
            if (r3 != r5) goto L6f
            int r3 = r4.length()
            int r3 = r3 - r1
            if (r0 >= r3) goto L6a
            int r3 = r0 + 1
            char r6 = r4.charAt(r3)
            if (r6 != r5) goto L6a
            r4.deleteCharAt(r3)
            goto L6f
        L6a:
            r3 = 29
            r4.setCharAt(r0, r3)
        L6f:
            int r0 = r0 + 1
            goto L49
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: U0.d.b(D0.c, java.lang.StringBuilder, int, boolean):void");
    }

    private static void c(D0.c cVar, StringBuilder sb, int i2, D0.d dVar, Collection collection, Map map) throws C0384f {
        if ((i2 << 3) > cVar.a()) {
            throw C0384f.a();
        }
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) cVar.d(8);
        }
        try {
            sb.append(new String(bArr, dVar == null ? l.a(bArr, map) : dVar.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw C0384f.a();
        }
    }

    private static void d(D0.c cVar, StringBuilder sb, int i2) throws C0384f {
        if (i2 * 13 > cVar.a()) {
            throw C0384f.a();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int iD = cVar.d(13);
            int i4 = (iD % 96) | ((iD / 96) << 8);
            int i5 = i4 + (i4 < 959 ? 41377 : 42657);
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException unused) {
            throw C0384f.a();
        }
    }

    private static void e(D0.c cVar, StringBuilder sb, int i2) throws C0384f {
        if (i2 * 13 > cVar.a()) {
            throw C0384f.a();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int iD = cVar.d(13);
            int i4 = (iD % 192) | ((iD / 192) << 8);
            int i5 = i4 + (i4 < 7936 ? 33088 : 49472);
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException unused) {
            throw C0384f.a();
        }
    }

    private static void f(D0.c cVar, StringBuilder sb, int i2) throws C0384f {
        while (i2 >= 3) {
            if (cVar.a() < 10) {
                throw C0384f.a();
            }
            int iD = cVar.d(10);
            if (iD >= 1000) {
                throw C0384f.a();
            }
            sb.append(h(iD / 100));
            sb.append(h((iD / 10) % 10));
            sb.append(h(iD % 10));
            i2 -= 3;
        }
        if (i2 == 2) {
            if (cVar.a() < 7) {
                throw C0384f.a();
            }
            int iD2 = cVar.d(7);
            if (iD2 >= 100) {
                throw C0384f.a();
            }
            sb.append(h(iD2 / 10));
            sb.append(h(iD2 % 10));
            return;
        }
        if (i2 == 1) {
            if (cVar.a() < 4) {
                throw C0384f.a();
            }
            int iD3 = cVar.d(4);
            if (iD3 >= 10) {
                throw C0384f.a();
            }
            sb.append(h(iD3));
        }
    }

    private static int g(D0.c cVar) throws C0384f {
        int iD = cVar.d(8);
        if ((iD & 128) == 0) {
            return iD & 127;
        }
        if ((iD & 192) == 128) {
            return cVar.d(8) | ((iD & 63) << 8);
        }
        if ((iD & 224) == 192) {
            return cVar.d(16) | ((iD & 31) << 16);
        }
        throw C0384f.a();
    }

    private static char h(int i2) throws C0384f {
        char[] cArr = f913a;
        if (i2 < cArr.length) {
            return cArr[i2];
        }
        throw C0384f.a();
    }
}
