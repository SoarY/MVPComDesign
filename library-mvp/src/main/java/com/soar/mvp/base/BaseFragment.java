package com.soar.mvp.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.navi2.component.support.NaviFragment;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment<T extends BasePresenter> extends NaviFragment {

    public String TAG = this.getClass().getSimpleName();

    public Activity context;
    public Unbinder unbinder;
    public T presenter;
    private View mRootView;

    public abstract int getContentViewId();

    protected abstract T bindPresenter();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mRootView = inflater.inflate(getContentViewId(), container, false);
        init();
        return mRootView;
    }

    private void init() {
        context = getActivity();
        unbinder = ButterKnife.bind(this, mRootView);
        presenter = bindPresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if (presenter != null)
            presenter.onDestroy();
    }

}
