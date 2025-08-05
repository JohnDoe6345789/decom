package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    private static final e f3059b = a(new Locale[0]);

    /* renamed from: a, reason: collision with root package name */
    private final g f3060a;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final Locale[] f3061a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        private static boolean b(Locale locale) {
            for (Locale locale2 : f3061a) {
                if (locale2.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        static boolean c(Locale locale, Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String strA = androidx.core.text.a.a(locale);
            if (!strA.isEmpty()) {
                return strA.equals(androidx.core.text.a.a(locale2));
            }
            String country = locale.getCountry();
            return country.isEmpty() || country.equals(locale2.getCountry());
        }
    }

    static class b {
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    private e(g gVar) {
        this.f3060a = gVar;
    }

    public static e a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? i(b.a(localeArr)) : new e(new f(localeArr));
    }

    static Locale b(String str) {
        if (str.contains("-")) {
            String[] strArrSplit = str.split("-", -1);
            if (strArrSplit.length > 2) {
                return new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
            }
            if (strArrSplit.length > 1) {
                return new Locale(strArrSplit[0], strArrSplit[1]);
            }
            if (strArrSplit.length == 1) {
                return new Locale(strArrSplit[0]);
            }
        } else {
            if (!str.contains("_")) {
                return new Locale(str);
            }
            String[] strArrSplit2 = str.split("_", -1);
            if (strArrSplit2.length > 2) {
                return new Locale(strArrSplit2[0], strArrSplit2[1], strArrSplit2[2]);
            }
            if (strArrSplit2.length > 1) {
                return new Locale(strArrSplit2[0], strArrSplit2[1]);
            }
            if (strArrSplit2.length == 1) {
                return new Locale(strArrSplit2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public static e c(String str) {
        if (str == null || str.isEmpty()) {
            return e();
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i2 = 0; i2 < length; i2++) {
            localeArr[i2] = a.a(strArrSplit[i2]);
        }
        return a(localeArr);
    }

    public static e e() {
        return f3059b;
    }

    public static e i(LocaleList localeList) {
        return new e(new n(localeList));
    }

    public Locale d(int i2) {
        return this.f3060a.get(i2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && this.f3060a.equals(((e) obj).f3060a);
    }

    public boolean f() {
        return this.f3060a.isEmpty();
    }

    public int g() {
        return this.f3060a.size();
    }

    public String h() {
        return this.f3060a.b();
    }

    public int hashCode() {
        return this.f3060a.hashCode();
    }

    public String toString() {
        return this.f3060a.toString();
    }
}
