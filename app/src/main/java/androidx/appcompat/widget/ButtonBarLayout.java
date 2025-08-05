package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bumptech.glide.request.target.Target;
import defpackage.e;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2135a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f2136b;

    /* renamed from: c, reason: collision with root package name */
    private int f2137c;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2137c = -1;
        int[] iArr = e.m.f5999N0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        androidx.core.view.M.d0(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        this.f2135a = typedArrayObtainStyledAttributes.getBoolean(e.m.f6001O0, true);
        typedArrayObtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f2135a);
        }
    }

    private int a(int i2) {
        int childCount = getChildCount();
        while (i2 < childCount) {
            if (getChildAt(i2).getVisibility() == 0) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private boolean b() {
        return this.f2136b;
    }

    private void setStacked(boolean z2) {
        if (this.f2136b != z2) {
            if (!z2 || this.f2135a) {
                this.f2136b = z2;
                setOrientation(z2 ? 1 : 0);
                setGravity(z2 ? 8388613 : 80);
                View viewFindViewById = findViewById(e.i.f5940x);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(z2 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int iMakeMeasureSpec;
        boolean z2;
        int size = View.MeasureSpec.getSize(i2);
        int paddingBottom = 0;
        if (this.f2135a) {
            if (size > this.f2137c && b()) {
                setStacked(false);
            }
            this.f2137c = size;
        }
        if (b() || View.MeasureSpec.getMode(i2) != 1073741824) {
            iMakeMeasureSpec = i2;
            z2 = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Target.SIZE_ORIGINAL);
            z2 = true;
        }
        super.onMeasure(iMakeMeasureSpec, i3);
        if (this.f2135a && !b() && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z2 = true;
        }
        if (z2) {
            super.onMeasure(i2, i3);
        }
        int iA = a(0);
        if (iA >= 0) {
            View childAt = getChildAt(iA);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (b()) {
                int iA2 = a(iA + 1);
                if (iA2 >= 0) {
                    paddingTop += getChildAt(iA2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                paddingBottom = paddingTop;
            } else {
                paddingBottom = paddingTop + getPaddingBottom();
            }
        }
        if (androidx.core.view.M.z(this) != paddingBottom) {
            setMinimumHeight(paddingBottom);
            if (i3 == 0) {
                super.onMeasure(i2, i3);
            }
        }
    }

    public void setAllowStacking(boolean z2) {
        if (this.f2135a != z2) {
            this.f2135a = z2;
            if (!z2 && b()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
