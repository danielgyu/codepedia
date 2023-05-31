package org.hismayfly.chapterTwo;

import io.reactivex.rxjava3.core.Observable;

public class Ch2_01 {
    public static void run() {
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("Alpha");
            emitter.onNext("Beta");
            emitter.onNext("Gamma");
            emitter.onComplete();
        });

        source.subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}
