package org.hismayfly.chapterTwo;

import io.reactivex.rxjava3.core.Observable;

public class Ch2_12 {
    public static void run() {
        Observable<String> source = Observable.just("Alpha_2_11", "Beta_2_11");

        // observer 1
        source.subscribe(s -> System.out.println("Observer 1: " + s));

        // observer 2
        source.map(String::length)
                .filter(i -> i >= 5)
                .subscribe(s -> System.out.println("Observer 2: " + s));
    }
}
