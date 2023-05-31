package org.hismayfly.chapterTwo;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Ch2_07 {
    public static void run() {
        Observable<String> source = Observable.just("Alpha_2_07", "Beta_2_07");

        Observer<Integer> myObserver = new Observer<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {}

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println("integer = " + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Done");
            }
        };

        source.map(String::length)
                .filter(i -> i >= 5)
                .subscribe(myObserver);
    }
}
