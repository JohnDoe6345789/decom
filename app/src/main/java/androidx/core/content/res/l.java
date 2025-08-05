package androidx.core.content.res;

/* loaded from: classes.dex */
final class l {

    /* renamed from: k, reason: collision with root package name */
    static final l f2990k = k(b.f2957c, (float) ((b.h(50.0f) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: a, reason: collision with root package name */
    private final float f2991a;

    /* renamed from: b, reason: collision with root package name */
    private final float f2992b;

    /* renamed from: c, reason: collision with root package name */
    private final float f2993c;

    /* renamed from: d, reason: collision with root package name */
    private final float f2994d;
    private final float e;

    /* renamed from: f, reason: collision with root package name */
    private final float f2995f;

    /* renamed from: g, reason: collision with root package name */
    private final float[] f2996g;

    /* renamed from: h, reason: collision with root package name */
    private final float f2997h;

    /* renamed from: i, reason: collision with root package name */
    private final float f2998i;

    /* renamed from: j, reason: collision with root package name */
    private final float f2999j;

    private l(float f2, float f3, float f4, float f5, float f6, float f7, float[] fArr, float f8, float f9, float f10) {
        this.f2995f = f2;
        this.f2991a = f3;
        this.f2992b = f4;
        this.f2993c = f5;
        this.f2994d = f6;
        this.e = f7;
        this.f2996g = fArr;
        this.f2997h = f8;
        this.f2998i = f9;
        this.f2999j = f10;
    }

    static l k(float[] fArr, float f2, float f3, float f4, boolean z2) {
        float[][] fArr2 = b.f2955a;
        float f5 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f6 = fArr3[0] * f5;
        float f7 = fArr[1];
        float f8 = f6 + (fArr3[1] * f7);
        float f9 = fArr[2];
        float f10 = f8 + (fArr3[2] * f9);
        float[] fArr4 = fArr2[1];
        float f11 = (fArr4[0] * f5) + (fArr4[1] * f7) + (fArr4[2] * f9);
        float[] fArr5 = fArr2[2];
        float f12 = (f5 * fArr5[0]) + (f7 * fArr5[1]) + (f9 * fArr5[2]);
        float f13 = (f4 / 10.0f) + 0.8f;
        float fD = ((double) f13) >= 0.9d ? b.d(0.59f, 0.69f, (f13 - 0.9f) * 10.0f) : b.d(0.525f, 0.59f, (f13 - 0.8f) * 10.0f);
        float fExp = z2 ? 1.0f : (1.0f - (((float) Math.exp(((-f2) - 42.0f) / 92.0f)) * 0.2777778f)) * f13;
        double d2 = fExp;
        if (d2 > 1.0d) {
            fExp = 1.0f;
        } else if (d2 < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f10) * fExp) + 1.0f) - fExp, (((100.0f / f11) * fExp) + 1.0f) - fExp, (((100.0f / f12) * fExp) + 1.0f) - fExp};
        float f14 = 1.0f / ((5.0f * f2) + 1.0f);
        float f15 = f14 * f14 * f14 * f14;
        float f16 = 1.0f - f15;
        float fCbrt = (f15 * f2) + (0.1f * f16 * f16 * ((float) Math.cbrt(f2 * 5.0d)));
        float fH = b.h(f3) / fArr[1];
        double d3 = fH;
        float fSqrt = ((float) Math.sqrt(d3)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d3, 0.2d));
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * fCbrt) * f10) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * fCbrt) * f11) / 100.0d, 0.42d), (float) Math.pow(((fArr6[2] * fCbrt) * f12) / 100.0d, 0.42d)};
        float f17 = fArr7[0];
        float f18 = (f17 * 400.0f) / (f17 + 27.13f);
        float f19 = fArr7[1];
        float f20 = (f19 * 400.0f) / (f19 + 27.13f);
        float f21 = fArr7[2];
        float[] fArr8 = {f18, f20, (400.0f * f21) / (f21 + 27.13f)};
        return new l(fH, ((fArr8[0] * 2.0f) + fArr8[1] + (fArr8[2] * 0.05f)) * fPow, fPow, fPow, fD, f13, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    float a() {
        return this.f2991a;
    }

    float b() {
        return this.f2994d;
    }

    float c() {
        return this.f2997h;
    }

    float d() {
        return this.f2998i;
    }

    float e() {
        return this.f2995f;
    }

    float f() {
        return this.f2992b;
    }

    float g() {
        return this.e;
    }

    float h() {
        return this.f2993c;
    }

    float[] i() {
        return this.f2996g;
    }

    float j() {
        return this.f2999j;
    }
}
