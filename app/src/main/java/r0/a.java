package R0;

import z0.C0382d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f720a = b.f721f;

    private int[] b(c cVar) throws C0382d {
        int iD = cVar.d();
        int[] iArr = new int[iD];
        int i2 = 0;
        for (int i3 = 1; i3 < this.f720a.e() && i2 < iD; i3++) {
            if (cVar.b(i3) == 0) {
                iArr[i2] = this.f720a.g(i3);
                i2++;
            }
        }
        if (i2 == iD) {
            return iArr;
        }
        throw C0382d.a();
    }

    private int[] c(c cVar, c cVar2, int[] iArr) {
        int iD = cVar2.d();
        int[] iArr2 = new int[iD];
        for (int i2 = 1; i2 <= iD; i2++) {
            iArr2[iD - i2] = this.f720a.i(i2, cVar2.c(i2));
        }
        c cVar3 = new c(this.f720a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            int iG = this.f720a.g(iArr[i3]);
            iArr3[i3] = this.f720a.i(this.f720a.j(0, cVar.b(iG)), this.f720a.g(cVar3.b(iG)));
        }
        return iArr3;
    }

    private c[] d(c cVar, c cVar2, int i2) throws C0382d {
        if (cVar.d() < cVar2.d()) {
            cVar2 = cVar;
            cVar = cVar2;
        }
        c cVarF = this.f720a.f();
        c cVarD = this.f720a.d();
        while (true) {
            c cVar3 = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
            c cVar4 = cVarD;
            c cVar5 = cVarF;
            cVarF = cVar4;
            if (cVar.d() < i2 / 2) {
                int iC = cVarF.c(0);
                if (iC == 0) {
                    throw C0382d.a();
                }
                int iG = this.f720a.g(iC);
                return new c[]{cVarF.f(iG), cVar.f(iG)};
            }
            if (cVar.e()) {
                throw C0382d.a();
            }
            c cVarF2 = this.f720a.f();
            int iG2 = this.f720a.g(cVar.c(cVar.d()));
            while (cVar2.d() >= cVar.d() && !cVar2.e()) {
                int iD = cVar2.d() - cVar.d();
                int i3 = this.f720a.i(cVar2.c(cVar2.d()), iG2);
                cVarF2 = cVarF2.a(this.f720a.b(iD, i3));
                cVar2 = cVar2.j(cVar.h(iD, i3));
            }
            cVarD = cVarF2.g(cVarF).j(cVar5).i();
        }
    }

    public int a(int[] iArr, int i2, int[] iArr2) throws C0382d {
        c cVar = new c(this.f720a, iArr);
        int[] iArr3 = new int[i2];
        boolean z2 = false;
        for (int i3 = i2; i3 > 0; i3--) {
            int iB = cVar.b(this.f720a.c(i3));
            iArr3[i2 - i3] = iB;
            if (iB != 0) {
                z2 = true;
            }
        }
        if (!z2) {
            return 0;
        }
        c cVarD = this.f720a.d();
        if (iArr2 != null) {
            for (int i4 : iArr2) {
                int iC = this.f720a.c((iArr.length - 1) - i4);
                b bVar = this.f720a;
                cVarD = cVarD.g(new c(bVar, new int[]{bVar.j(0, iC), 1}));
            }
        }
        c[] cVarArrD = d(this.f720a.b(i2, 1), new c(this.f720a, iArr3), i2);
        c cVar2 = cVarArrD[0];
        c cVar3 = cVarArrD[1];
        int[] iArrB = b(cVar2);
        int[] iArrC = c(cVar3, cVar2, iArrB);
        for (int i5 = 0; i5 < iArrB.length; i5++) {
            int length = (iArr.length - 1) - this.f720a.h(iArrB[i5]);
            if (length < 0) {
                throw C0382d.a();
            }
            iArr[length] = this.f720a.j(iArr[length], iArrC[i5]);
        }
        return iArrB.length;
    }
}
