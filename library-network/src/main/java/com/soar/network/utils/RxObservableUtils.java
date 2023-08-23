package com.soar.network.utils;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * NAME：YONG_
 * Created at: 2019/9/2 16
 * Describe:
 */
public class RxObservableUtils {
    /**
     * 订阅
     */
    public static <T> void toSubscribe(Observable<T> o, Observer<T> s) {
        o.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    /**
     * 订阅
     * 生命周期取消订阅
     */
    public static <T> void toSubscribe(Observable<T> o, Observer<T> s,LifecycleProvider<ActivityEvent> lifecycle) {
        o.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(lifecycle.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(s);
    }
}
