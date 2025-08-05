package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import i.InterfaceC0269e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class h implements InterfaceC0269e, j, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    private Rect f2024a;

    h() {
    }

    protected static int o(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        View view = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < count; i5++) {
            int itemViewType = listAdapter.getItemViewType(i5);
            if (itemViewType != i4) {
                view = null;
                i4 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i5, view, viewGroup);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i2) {
                return i2;
            }
            if (measuredWidth > i3) {
                i3 = measuredWidth;
            }
        }
        return i3;
    }

    protected static boolean x(e eVar) {
        int size = eVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = eVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    protected static d y(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (d) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (d) listAdapter;
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(Context context, e eVar) {
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean g(e eVar, g gVar) {
        return false;
    }

    public abstract void l(e eVar);

    protected boolean m() {
        return true;
    }

    public Rect n() {
        return this.f2024a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        y(listAdapter).f1964a.N((MenuItem) listAdapter.getItem(i2), this, m() ? 0 : 4);
    }

    public abstract void p(View view);

    public void q(Rect rect) {
        this.f2024a = rect;
    }

    public abstract void r(boolean z2);

    public abstract void s(int i2);

    public abstract void t(int i2);

    public abstract void u(PopupWindow.OnDismissListener onDismissListener);

    public abstract void v(boolean z2);

    public abstract void w(int i2);
}
