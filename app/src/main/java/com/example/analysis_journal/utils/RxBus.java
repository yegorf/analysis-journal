package com.example.analysis_journal.utils;

import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

public class RxBus {
    private final static Subject<String, String> bus = new SerializedSubject<>(PublishSubject.create());

    public static void send(String tag) {
        bus.onNext(tag);
    }

    public static void subscribe(String tag, Runnable event) {
        bus.subscribe(o -> {
            if (o.equals(tag)) {
                event.run();
            }
        });
    }
}
