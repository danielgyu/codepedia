package org.hismayfly.chapterTwo;

import io.reactivex.rxjava3.core.Observable;

public class Ch2_11 {
    public static void run() {
        Observable<String> source = Observable.just("Alpha_2_11", "Beta_2_11");

        source.subscribe(s -> System.out.println("Observer 1: " + s));
        source.subscribe(s -> System.out.println("Observer 2: " + s));
    }
}
