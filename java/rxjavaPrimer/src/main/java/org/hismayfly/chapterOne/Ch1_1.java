package org.hismayfly.chapterOne;

import io.reactivex.rxjava3.core.Observable;

public class Ch1_1 {
    public static void run() {
        Observable<String> myStrings = Observable.just("Alpha", "Beta", "Gamma");

        myStrings.subscribe(s -> System.out.println(s));
    }
}
