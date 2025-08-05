package H0;

import z0.C0384f;

/* loaded from: classes.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final D0.b f206a;

    /* renamed from: b, reason: collision with root package name */
    private final D0.b f207b;

    /* renamed from: c, reason: collision with root package name */
    private final e f208c;

    a(D0.b bVar) throws C0384f {
        int iG = bVar.g();
        if (iG < 8 || iG > 144 || (iG & 1) != 0) {
            throw C0384f.a();
        }
        this.f208c = j(bVar);
        D0.b bVarA = a(bVar);
        this.f206a = bVarA;
        this.f207b = new D0.b(bVarA.j(), bVarA.g());
    }

    private D0.b a(D0.b bVar) {
        int iF = this.f208c.f();
        int iE = this.f208c.e();
        if (bVar.g() != iF) {
            throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
        }
        int iC = this.f208c.c();
        int iB = this.f208c.b();
        int i2 = iF / iC;
        int i3 = iE / iB;
        D0.b bVar2 = new D0.b(i3 * iB, i2 * iC);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 * iC;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = i6 * iB;
                for (int i8 = 0; i8 < iC; i8++) {
                    int i9 = ((iC + 2) * i4) + 1 + i8;
                    int i10 = i5 + i8;
                    for (int i11 = 0; i11 < iB; i11++) {
                        if (bVar.d(((iB + 2) * i6) + 1 + i11, i9)) {
                            bVar2.l(i7 + i11, i10);
                        }
                    }
                }
            }
        }
        return bVar2;
    }

    private int d(int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = (h(i4, 0, i2, i3) ? 1 : 0) << 1;
        if (h(i4, 1, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(i4, 2, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (h(0, i3 - 2, i2, i3)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i3 - 1;
        if (h(0, i9, i2, i3)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (h(1, i9, i2, i3)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (h(2, i9, i2, i3)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        return h(3, i9, i2, i3) ? i12 | 1 : i12;
    }

    private int e(int i2, int i3) {
        int i4 = (h(i2 + (-3), 0, i2, i3) ? 1 : 0) << 1;
        if (h(i2 - 2, 0, i2, i3)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(i2 - 1, 0, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(0, i3 - 4, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (h(0, i3 - 3, i2, i3)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (h(0, i3 - 2, i2, i3)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        int i10 = i3 - 1;
        if (h(0, i10, i2, i3)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        return h(1, i10, i2, i3) ? i11 | 1 : i11;
    }

    private int f(int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = (h(i4, 0, i2, i3) ? 1 : 0) << 1;
        int i6 = i3 - 1;
        if (h(i4, i6, i2, i3)) {
            i5 |= 1;
        }
        int i7 = i5 << 1;
        int i8 = i3 - 3;
        if (h(0, i8, i2, i3)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i3 - 2;
        if (h(0, i10, i2, i3)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (h(0, i6, i2, i3)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (h(1, i8, i2, i3)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(1, i10, i2, i3)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        return h(1, i6, i2, i3) ? i14 | 1 : i14;
    }

    private int g(int i2, int i3) {
        int i4 = (h(i2 + (-3), 0, i2, i3) ? 1 : 0) << 1;
        if (h(i2 - 2, 0, i2, i3)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(i2 - 1, 0, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(0, i3 - 2, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i3 - 1;
        if (h(0, i8, i2, i3)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (h(1, i8, i2, i3)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (h(2, i8, i2, i3)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return h(3, i8, i2, i3) ? i11 | 1 : i11;
    }

    private boolean h(int i2, int i3, int i4, int i5) {
        if (i2 < 0) {
            i2 += i4;
            i3 += 4 - ((i4 + 4) & 7);
        }
        if (i3 < 0) {
            i3 += i5;
            i2 += 4 - ((i5 + 4) & 7);
        }
        this.f207b.l(i3, i2);
        return this.f206a.d(i3, i2);
    }

    private int i(int i2, int i3, int i4, int i5) {
        int i6 = i2 - 2;
        int i7 = i3 - 2;
        int i8 = (h(i6, i7, i4, i5) ? 1 : 0) << 1;
        int i9 = i3 - 1;
        if (h(i6, i9, i4, i5)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        int i11 = i2 - 1;
        if (h(i11, i7, i4, i5)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        if (h(i11, i9, i4, i5)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(i11, i3, i4, i5)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(i2, i7, i4, i5)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (h(i2, i9, i4, i5)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        return h(i2, i3, i4, i5) ? i16 | 1 : i16;
    }

    private static e j(D0.b bVar) {
        return e.h(bVar.g(), bVar.j());
    }

    e b() {
        return this.f208c;
    }

    byte[] c() throws C0384f {
        byte[] bArr = new byte[this.f208c.g()];
        int iG = this.f206a.g();
        int iJ = this.f206a.j();
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i4 = 4;
        while (true) {
            if (i4 == iG && i2 == 0 && !z2) {
                bArr[i3] = (byte) d(iG, iJ);
                i4 -= 2;
                i2 += 2;
                i3++;
                z2 = true;
            } else {
                int i5 = iG - 2;
                if (i4 == i5 && i2 == 0 && (iJ & 3) != 0 && !z3) {
                    bArr[i3] = (byte) e(iG, iJ);
                    i4 -= 2;
                    i2 += 2;
                    i3++;
                    z3 = true;
                } else if (i4 == iG + 4 && i2 == 2 && (iJ & 7) == 0 && !z4) {
                    bArr[i3] = (byte) f(iG, iJ);
                    i4 -= 2;
                    i2 += 2;
                    i3++;
                    z4 = true;
                } else if (i4 == i5 && i2 == 0 && (iJ & 7) == 4 && !z5) {
                    bArr[i3] = (byte) g(iG, iJ);
                    i4 -= 2;
                    i2 += 2;
                    i3++;
                    z5 = true;
                } else {
                    while (true) {
                        if (i4 < iG && i2 >= 0 && !this.f207b.d(i2, i4)) {
                            bArr[i3] = (byte) i(i4, i2, iG, iJ);
                            i3++;
                        }
                        int i6 = i4 - 2;
                        int i7 = i2 + 2;
                        if (i6 < 0 || i7 >= iJ) {
                            break;
                        }
                        i4 = i6;
                        i2 = i7;
                    }
                    int i8 = i4 - 1;
                    int i9 = i2 + 5;
                    while (true) {
                        if (i8 >= 0 && i9 < iJ && !this.f207b.d(i9, i8)) {
                            bArr[i3] = (byte) i(i8, i9, iG, iJ);
                            i3++;
                        }
                        int i10 = i8 + 2;
                        int i11 = i9 - 2;
                        if (i10 >= iG || i11 < 0) {
                            break;
                        }
                        i8 = i10;
                        i9 = i11;
                    }
                    i4 = i8 + 5;
                    i2 = i9 - 1;
                }
            }
            if (i4 >= iG && i2 >= iJ) {
                break;
            }
        }
        if (i3 == this.f208c.g()) {
            return bArr;
        }
        throw C0384f.a();
    }
}
