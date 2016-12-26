package com.pyn.rtexchagerate.http;


import rx.Observable;
import rx.Subscriber;

/**
 * 所以返回结果进行预处理，对code进行判断和解析，不同的错误返回不同的错误信息
 * created at 2016/12/26 18:51
 */
public class RxHelper {

//    /**
//     * 利用Observable.takeUntil()停止网络请求
//     *
//     * @param event
//     * @param lifecycleSubject
//     * @param <T>
//     * @return
//     */
//    @NonNull
//    public <T> Observable.Transformer<T, T> bindUntilEvent(@NonNull final ActivityLifeCycleEvent event , final PublishSubject<ActivityLifeCycleEvent> lifecycleSubject) {
//        return new Observable.Transformer<T, T>() {
//            @Override
//            public Observable<T> call(Observable<T> sourceObservable) {
//                Observable<ActivityLifeCycleEvent> compareLifecycleObservable =
//                        lifecycleSubject.takeFirst(new Func1<ActivityLifeCycleEvent, Boolean>() {
//                            @Override
//                            public Boolean call(ActivityLifeCycleEvent activityLifeCycleEvent) {
//                                return activityLifeCycleEvent.equals(event);
//                            }
//                        });
//                return sourceObservable.takeUntil(compareLifecycleObservable);
//            }
//        };
//    }
//
//
//    /**
//     * @param <T>
//     * @return
//     */
//    public static <T> Observable.Transformer<HttpResult<T>, T> handleResult(final ActivityLifeCycleEvent event,final PublishSubject<ActivityLifeCycleEvent> lifecycleSubject) {
//        return new Observable.Transformer<HttpResult<T>, T>() {
//            @Override
//            public Observable<T> call(Observable<HttpResult<T>> tObservable) {
//                Observable<ActivityLifeCycleEvent> compareLifecycleObservable =
//                        lifecycleSubject.takeFirst(new Func1<ActivityLifeCycleEvent, Boolean>() {
//                            @Override
//                            public Boolean call(ActivityLifeCycleEvent activityLifeCycleEvent) {
//                                return activityLifeCycleEvent.equals(event);
//                            }
//                        });
//                return tObservable.flatMap(new Func1<HttpResult<T>, Observable<T>>() {
//                    @Override
//                    public Observable<T> call(HttpResult<T> result) {
//                        if (result.getCount() != 0) {
//                            return createData(result.getSubjects());
//                        } else {
//                            return Observable.error(new ApiException(result.getCount()));
//                        }
//                    }
//                }) .takeUntil(compareLifecycleObservable).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread());
//            }
//        };
//    }

    /**
     * 创建成功的数据
     *
     * @param data
     * @param <T>
     * @return
     */
    private static <T> Observable<T> createData(final T data) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(data);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
