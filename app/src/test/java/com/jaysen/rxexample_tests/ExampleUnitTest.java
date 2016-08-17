package com.jaysen.rxexample_tests;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testRx() {
        Observable.just(3, 1, 2, 3, 2, 5, 4, 3, 4, 5)
//                .debounce()//消除抖动,时间间隔
//                .distinct()//消除重复item
//                .elementAt(6)//只发送定位的位置的那个item
//                .filter(integer1 -> integer1 > 2)//过滤条件，结果为false的被抛弃，只发送true的item
//                .first(integer1 -> integer1 < 4)//只发送第一个，或只发送第一个遇到符合条件的item
//                .ignoreElements()//只调用onError或onComplete,不会调用onNext
//                .take(3)//刚好拿前面n个item
//                .last()//和first类似的过滤条件
                .sample(2000, TimeUnit.MILLISECONDS)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("integer: " + integer);
                    }
                });
    }
}