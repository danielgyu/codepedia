package org.hismayfly.chapterTwo;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

public class Ch2_14 {
    public static void run() {
        ConnectableObservable<String> source = Observable.just("Alpha_2_14", "Beta_2_14").publish();

        // observer 1
        source.subscribe(s -> System.out.println("Observer 1: " + s));

        // observer 2
        source.map(String::length)
                .filter(i -> i >= 5)
                .subscribe(s -> System.out.println("Observer 2: " + s));

        // fire
        source.connect();
    }
}
