package org.hismayfly.chapterOne;

import io.reactivex.rxjava3.core.Observable;

public class Ch1_2 {
    public static void run() {
        Observable<String> myStrings = Observable.just("Alpha", "Beta");
        myStrings.map(s -> s.length())
                .subscribe(s -> System.out.println(s));
    }
}
