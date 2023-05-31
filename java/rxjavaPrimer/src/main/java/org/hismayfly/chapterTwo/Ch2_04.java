package org.hismayfly.chapterTwo;

import io.reactivex.rxjava3.core.Observable;

public class Ch2_04 {
    public static void run() {
        Observable<String> source = Observable.create(emitter -> {
            try {
                emitter.onNext("Aplha_2_03");
                emitter.onNext("Beta_2_03");
                emitter.onNext("Gamma_2_03");
                emitter.onComplete();
            } catch (Throwable e) {
                emitter.onError(e);
            }
        });
        source.map(String::length)
                .filter(i -> i >= 10)
                .subscribe(s -> System.out.println(s));
    }
}
