package org.hismayfly.chapterTwo;

import io.reactivex.rxjava3.core.Observable;

public class Ch2_03 {
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
        Observable<Integer> lengths = source.map(String::length);
        Observable<Integer> filtered = lengths.filter(i -> i >= 10);
        filtered.subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}
