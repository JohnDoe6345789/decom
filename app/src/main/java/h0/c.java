package H0;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import z0.C0384f;

/* loaded from: classes.dex */
abstract class c {

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f212b;

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f214d;

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f211a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f213c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f215a;

        static {
            int[] iArr = new int[b.values().length];
            f215a = iArr;
            try {
                iArr[b.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f215a[b.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f215a[b.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f215a[b.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f215a[b.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private enum b {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static {
        char[] cArr = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        f212b = cArr;
        f214d = cArr;
    }

    static D0.e a(byte[] bArr) throws C0384f {
        D0.c cVar = new D0.c(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        b bVarC = b.ASCII_ENCODE;
        do {
            b bVar = b.ASCII_ENCODE;
            if (bVarC == bVar) {
                bVarC = c(cVar, sb, sb2);
            } else {
                int i2 = a.f215a[bVarC.ordinal()];
                if (i2 == 1) {
                    e(cVar, sb);
                } else if (i2 == 2) {
                    g(cVar, sb);
                } else if (i2 == 3) {
                    b(cVar, sb);
                } else if (i2 == 4) {
                    f(cVar, sb);
                } else {
                    if (i2 != 5) {
                        throw C0384f.a();
                    }
                    d(cVar, sb, arrayList);
                }
                bVarC = bVar;
            }
            if (bVarC == b.PAD_ENCODE) {
                break;
            }
        } while (cVar.a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String string = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new D0.e(bArr, string, arrayList, null);
    }

    private static void b(D0.c cVar, StringBuilder sb) throws C0384f {
        int iD;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            h(iD, cVar.d(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i3 == 0) {
                    sb.append('\r');
                } else if (i3 == 1) {
                    sb.append('*');
                } else if (i3 == 2) {
                    sb.append('>');
                } else if (i3 == 3) {
                    sb.append(' ');
                } else if (i3 < 14) {
                    sb.append((char) (i3 + 44));
                } else {
                    if (i3 >= 40) {
                        throw C0384f.a();
                    }
                    sb.append((char) (i3 + 51));
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static b c(D0.c cVar, StringBuilder sb, StringBuilder sb2) throws C0384f {
        boolean z2 = false;
        do {
            int iD = cVar.d(8);
            if (iD == 0) {
                throw C0384f.a();
            }
            if (iD > 128) {
                if (iD != 129) {
                    if (iD > 229) {
                        switch (iD) {
                            case 230:
                                return b.C40_ENCODE;
                            case 231:
                                return b.BASE256_ENCODE;
                            case 232:
                                sb.append((char) 29);
                                break;
                            case 233:
                            case 234:
                            case 241:
                                break;
                            case 235:
                                z2 = true;
                                break;
                            case 236:
                                sb.append("[)>\u001e05\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 237:
                                sb.append("[)>\u001e06\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 238:
                                return b.ANSIX12_ENCODE;
                            case 239:
                                return b.TEXT_ENCODE;
                            case 240:
                                return b.EDIFACT_ENCODE;
                            default:
                                if (iD != 254 || cVar.a() != 0) {
                                    throw C0384f.a();
                                }
                                break;
                        }
                    } else {
                        int i2 = iD - 130;
                        if (i2 < 10) {
                            sb.append('0');
                        }
                        sb.append(i2);
                    }
                } else {
                    return b.PAD_ENCODE;
                }
            } else {
                if (z2) {
                    iD += 128;
                }
                sb.append((char) (iD - 1));
                return b.ASCII_ENCODE;
            }
        } while (cVar.a() > 0);
        return b.ASCII_ENCODE;
    }

    private static void d(D0.c cVar, StringBuilder sb, Collection collection) throws C0384f {
        int iC = cVar.c();
        int i2 = iC + 2;
        int i3 = i(cVar.d(8), iC + 1);
        if (i3 == 0) {
            i3 = cVar.a() / 8;
        } else if (i3 >= 250) {
            i3 = ((i3 - 249) * 250) + i(cVar.d(8), i2);
            i2 = iC + 3;
        }
        if (i3 < 0) {
            throw C0384f.a();
        }
        byte[] bArr = new byte[i3];
        int i4 = 0;
        while (i4 < i3) {
            if (cVar.a() < 8) {
                throw C0384f.a();
            }
            bArr[i4] = (byte) i(cVar.d(8), i2);
            i4++;
            i2++;
        }
        collection.add(bArr);
        try {
            sb.append(new String(bArr, "ISO8859_1"));
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e2)));
        }
    }

    private static void e(D0.c cVar, StringBuilder sb) throws C0384f {
        int iD;
        int[] iArr = new int[3];
        boolean z2 = false;
        int i2 = 0;
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            h(iD, cVar.d(8), iArr);
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = f212b;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z2) {
                                    sb.append((char) (c2 + 128));
                                    z2 = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i4 != 30) {
                                    throw C0384f.a();
                                }
                                z2 = true;
                            }
                            i2 = 0;
                        } else {
                            if (i2 != 3) {
                                throw C0384f.a();
                            }
                            if (z2) {
                                sb.append((char) (i4 + 224));
                                z2 = false;
                                i2 = 0;
                            } else {
                                sb.append((char) (i4 + 96));
                                i2 = 0;
                            }
                        }
                    } else if (z2) {
                        sb.append((char) (i4 + 128));
                        z2 = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr2 = f211a;
                    if (i4 >= cArr2.length) {
                        throw C0384f.a();
                    }
                    char c3 = cArr2[i4];
                    if (z2) {
                        sb.append((char) (c3 + 128));
                        z2 = false;
                    } else {
                        sb.append(c3);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void f(D0.c cVar, StringBuilder sb) {
        while (cVar.a() > 16) {
            for (int i2 = 0; i2 < 4; i2++) {
                int iD = cVar.d(6);
                if (iD == 31) {
                    int iB = 8 - cVar.b();
                    if (iB != 8) {
                        cVar.d(iB);
                        return;
                    }
                    return;
                }
                if ((iD & 32) == 0) {
                    iD |= 64;
                }
                sb.append((char) iD);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void g(D0.c cVar, StringBuilder sb) throws C0384f {
        int iD;
        int[] iArr = new int[3];
        boolean z2 = false;
        int i2 = 0;
        while (cVar.a() != 8 && (iD = cVar.d(8)) != 254) {
            h(iD, cVar.d(8), iArr);
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = f214d;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z2) {
                                    sb.append((char) (c2 + 128));
                                    z2 = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append((char) 29);
                            } else {
                                if (i4 != 30) {
                                    throw C0384f.a();
                                }
                                z2 = true;
                            }
                            i2 = 0;
                        } else {
                            if (i2 != 3) {
                                throw C0384f.a();
                            }
                            char[] cArr2 = e;
                            if (i4 >= cArr2.length) {
                                throw C0384f.a();
                            }
                            char c3 = cArr2[i4];
                            if (z2) {
                                sb.append((char) (c3 + 128));
                                z2 = false;
                                i2 = 0;
                            } else {
                                sb.append(c3);
                                i2 = 0;
                            }
                        }
                    } else if (z2) {
                        sb.append((char) (i4 + 128));
                        z2 = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr3 = f213c;
                    if (i4 >= cArr3.length) {
                        throw C0384f.a();
                    }
                    char c4 = cArr3[i4];
                    if (z2) {
                        sb.append((char) (c4 + 128));
                        z2 = false;
                    } else {
                        sb.append(c4);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void h(int i2, int i3, int[] iArr) {
        int i4 = ((i2 << 8) + i3) - 1;
        int i5 = i4 / 1600;
        iArr[0] = i5;
        int i6 = i4 - (i5 * 1600);
        int i7 = i6 / 40;
        iArr[1] = i7;
        iArr[2] = i6 - (i7 * 40);
    }

    private static int i(int i2, int i3) {
        int i4 = i2 - (((i3 * 149) % 255) + 1);
        return i4 >= 0 ? i4 : i4 + 256;
    }
}
