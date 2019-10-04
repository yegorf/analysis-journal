package com.example.analysis_journal.utils;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

public class RxBus {
    private final static Subject<Object, Object> _bus = new SerializedSubject<>(PublishSubject.create());

    public static void send(Object o) {
        _bus.onNext(o);
    }

    public static Observable<Object> toObserverable() {
        return _bus;
    }
}
