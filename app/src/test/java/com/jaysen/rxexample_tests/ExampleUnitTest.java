package com.jaysen.rxexample_tests;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Notification;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func2;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void testRx() {
        Observable
                /**
                 * create opterators
                 */
//                .timer(2, TimeUnit.SECONDS)
//                .empty()
//                .zip(Observable
//                .amb(getOJust(), getO1(), getO2(), getO0())//只发送最先发出item的那个序列
//                        , Observable.amb(getO2(),getO2())
//                        , new Func2<Integer, Integer, Integer>() {
//                            @Override
//                            public Integer call(Integer integer, Integer integer2) {
//                                try {
//                                    Thread.sleep(2);
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                                return integer*integer2;
//                            }
//                        }
//                )
//                .doOnNext(new Action1<Long>() {
//                    @Override
//                    public void call(Long integer) {
//                        System.out.print("doOnNext = [" + integer + "]");
//                    }
//                })
                /**
                 *        determine whether all items emitted by an Observable meet some criteria
                 */
              /*  .all(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer > 1;
                    }
                })
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        System.out.println("aBoolean = [" + aBoolean + "]");
                    }
                })*/
//                .just(3, 1, 2, 3, 2, 5, 4, 3, 4, 5)
                .defer(new Func0<Observable<Integer>>() {
                    @Override
                    public Observable<Integer> call() {
                        return getO1();
                    }
                })
                .repeat(3)
//                .map(new Func1<Integer, Integer>() {
//                    int anInt = 0;
//
//                    @Override
//                    public Integer call(Integer integer) {
//                        if (++anInt == 3) {
//                            return Integer.parseInt("0");
//                        }
//                        return integer;
//                    }
//                })
                /**
                 * Combining operators
                 */
/*              //  and,then,when//These are not part of the core RxJava implementation, but are found as and, then, and when in the rxjava-joins module.
                .combineLatest(Observable.just(1, 2, 3, 4, 10, 12), Observable.just(4, 20, 21), new Func2<Integer, Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer, Integer integer2) {
                        return integer + integer2;
                    }
                })
                .join()//left join right, leftSelector,rightSelector,resultSelector

                .merge(getO2(), getO1())
                .mergeWith(getO2())
                .startWith(getO0())
                .switchOnNext(getObOb())//onvert an Observable that emits Observables into a single Observable that emits the items emitted by the most-recently-emitted of those Observables
                .zip(Observable.just(3, 1, 2, 3, 2, 5, 4, 3, 4, 5), Observable.interval(2L, TimeUnit.SECONDS), new Func2<Integer, Long, Integer>() {
//                没有发射出来？还是订阅有问题？
                    @Override
                    public Integer call(Integer integer, Long aLong) {
                        return integer;
                    }
                })*/
                /**
                 *
                 * filer operators
                 */
/*                .debounce()//消除抖动,时间间隔
                .distinct()//消除重复item
                .elementAt(6)//只发送定位的位置的那个item
                .filter(integer1 -> integer1 > 2)//过滤条件，结果为false的被抛弃，只发送true的item
                .first(integer1 -> integer1 < 4)//只发送第一个，或只发送第一个遇到符合条件的item
                .ignoreElements()//只调用onError或onComplete,不会调用onNext
                .last()//和first类似的过滤条件
                .sample(100, TimeUnit.MILLISECONDS)
                .skip(3)//跳过前3个item
                .skipLast(3)//跳过后3个item
                .take(3)//刚好拿前面n个item
                .takeLast(3)//刚好拿后面n个item*/
                /**
                 * Error Handling Operators
                 */
//                .cache()
//                .retry()
//                .retryWhen(null)
                /**
                 * Observable Utility Operators
                 */
//                .materialize()
//                .subscribe(new Action1<Notification<Integer>>() {
//                    @Override
//                    public void call(Notification<Integer> integerNotification) {
//                        if(integerNotification.hasValue()){
//                            System.out.println("integerNotification = [" + integerNotification.getValue() + "]");
//                        }
//                    }
//                })
//                .dematerialize()
//                .delay(10L, TimeUnit.MILLISECONDS)//没有结果输出
//                .delaySubscription(10L, TimeUnit.MILLISECONDS)//没有结果输出
//                .doOnEach(new Action1<Notification<? super Integer>>() {
//                    @Override
//                    public void call(Notification<? super Integer> notification) {
//                        System.out.println("doOnEach = [" + notification.getValue() + "]");
//                    }
//                })
//                .doOnRequest(new Action1<Long>() {
//                    @Override
//                    public void call(Long aLong) {
//                        System.out.println("aLong = [" + aLong + "]");
//                    }
//                })
//                .doOnNext(new Action1<Integer>() {
//                    @Override
//                    public void call(Integer integer) {
//                        System.out.println("doOnNext = [" + integer + "]");
//                        if (integer>4){
//                            throw new IllegalStateException("integer maximun 3");
//                        }
//                    }
//                })
//                .doOnSubscribe(new Action0() {
//                    @Override
//                    public void call() {
//                        System.out.println("doOnSubscribe start action");
//                    }
//                })
//                .doOnUnsubscribe(new Action0() {
//                    @Override
//                    public void call() {
//                        System.out.println("doOnUnsubscribe action");
//                    }
//                })
//                .doOnCompleted(new Action0() {
//                    @Override
//                    public void call() {
//                        System.out.println("doOnCompleted action");
//                    }
//                })
//                .doOnError(new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        System.out.println("throwable = [" + throwable + "]");
//                    }
//                })
//                .doOnTerminate(new Action0() {
//                    @Override
//                    public void call() {
//                        System.out.println("doOnTerminate action");
//
//                    }
//                })
//                .doAfterTerminate(new Action0() {
//                    @Override
//                    public void call() {
//                        System.out.println("doAfterTerminate action");
//
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.newThread())
//                .timeInterval()
//                .timeout(1L, TimeUnit.NANOSECONDS)
//                .timestamp()
                /**
                 * using :create a disposable resource that has the same lifespan as the Observable
                 * 可以创建一个可处理的且和一个创建的observable相同生命跨度的资源
                 */
/*                .using(new Func0<Integer>() {
                    @Override
                    public Integer call() {
                        return 12345;
                    }
                }, new Func1<Integer, Observable<?>>() {
                    @Override
                    public Observable<?> call(Integer integer) {
                        return Observable.from(new String[]{"a", "b", "c"}).concatWith(Observable.from(new String[]{integer.toString()}));
                    }
                }, new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println("dispose integer = [" + integer + "]");
                    }
                }).subscribe(new Action1<Object>() {
            @Override
            public void call(Object o) {
                System.out.println("o = [" + o + "]");
            }
        })*/
                /**
                 * Conditional and Boolean Operators
                 */
//                .ambWith(Observable.just(456))
//                .skipUntil(Observable.amb(getO2(),getO1())).delay(10, TimeUnit.MILLISECONDS)
//                .takeUntil(Observable.amb(getO2(), getO1()).delay(25, TimeUnit.MILLISECONDS))
               /* .skipWhile(new Func1<Integer, Boolean>() {
                    //while true to skip items
                    @Override
                    public Boolean call(Integer integer) {

                        boolean b = integer < 4;
                        System.out.println(" boolean:"+b+" integer:"+ integer);
                        return b;
                    }
                })*/
               /* .takeWhile(new Func1<Integer, Boolean>() {
                    //take while true,false for doesn't take
                    @Override
                    public Boolean call(Integer integer) {
                        return integer<3;
                    }
                })*/
               /* .sequenceEqual(getO0(),getO1())//determine whether two Observables emit the same sequence of items
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        System.out.println("aBoolean = [" + aBoolean + "]");
                    }
                });*/
             /*   .contains(6)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        System.out.println("aBoolean = [" + aBoolean + "]");
                    }
                })*/
       /* .defaultIfEmpty(0)
        .subscribe(new Action1<Object>() {
            @Override
            public void call(Object o) {
                System.out.println("o = [" + o + "]");
            }
        })*/
                /**
                 * Mathematical and Aggregate Operators
                 Operators that operate on the entire sequence of items emitted by an Observable
                 <ul>
                 <li>Average — calculates the average of numbers emitted by an Observable and emits this average</li>
                 <li>Concat — emit the emissions from two or more Observables without interleaving them</li>
                 <li>Count — count the number of items emitted by the source Observable and emit only this value</li>
                 <li>Max — determine, and emit, the maximum-valued item emitted by an Observable</li>
                 <li>Min — determine, and emit, the minimum-valued item emitted by an Observable</li>
                 <li>Reduce — apply a function to each item emitted by an Observable, sequentially, and emit the final value</li>
                 <li>Sum — calculate the sum of numbers emitted by an Observable and emit this sum</li>
                 </ul>
                 */

                /**
                 * Connectable Observable Operators
                 Specialty Observables that have more precisely-controlled subscription dynamics

                 Connect — instruct a connectable Observable to begin emitting items to its subscribers
                 Publish — convert an ordinary Observable into a connectable Observable
                 RefCount — make a Connectable Observable behave like an ordinary Observable
                 Replay — ensure that all observers see the same sequence of emitted items, even if they subscribe after the Observable has begun emitting items
                 */
                /**
                 * subscribe timestamp
                 */
//                .subscribe(new Subscriber<Timestamped<Integer>>() {//timestamp
//                    @Override
//                    public void onCompleted() {
//                        System.out.println("onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError e = [" + e + "]");
//                    }
//
//                    @Override
//                    public void onNext(Timestamped<Integer> integerTimestamped) {
//                        System.out.println("integerTimestamped = [" + integerTimestamped + "]");
//                    }
//                })
                /**
                 * subscribe TimeInterval
                 */
//                .subscribe(new Action1<TimeInterval<Integer>>() {//TimeInterval
//                    //subscribe timeInterval
//                    @Override
//                    public void call(TimeInterval<Integer> integerTimeInterval) {
//                        System.out.println("integerTimeInterval = [" + integerTimeInterval.getIntervalInMilliseconds() + "]"+integerTimeInterval.getValue());
//                    }
//                })
                /**
                 * subscribe Integer
                 */
                .subscribe(new Subscriber<Integer>() {
                    int index = 0;

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
                        System.out.println("integer[" + index + "]: " + integer);
                        index++;
                    }
                })
        ;
    }

    private Observable<Integer> getO1() {
        return Observable.just(1, 3, 5, 7, 9);
    }

    private Observable<Integer> getOJust() {
        return Observable.just(1, 2, 3, 2, 5, 4, 3, 4, 5);
    }

    private Observer<Number> getObjObserver() {
        return new Observer<Number>() {
            @Override
            public void onCompleted() {
                System.out.println("Observer onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Observer onError" + e.toString());

            }

            @Override
            public void onNext(Number integer) {
                System.out.println("Observer onNext:" + integer);

            }
        };
    }

    private Observable<Integer> getO2() {
        return Observable.just(2, 4, 6, 8, 10);
    }

    private Observable<Integer> getO0() {
        return Observable.just(333);
    }

    public Observable<Observable<Integer>> getObOb() {

        return Observable.just(getO1(), getO2(), getO0());
    }

    @Test
    public void testDefer() {
        Observable<Integer> deferObservable = Observable.defer(new Func0<Observable<Integer>>() {
            @Override
            public Observable<Integer> call() {
                return getO1();
            }
        });
        final Observable<Integer> obs = deferObservable;
        deferObservable.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println("s1 integer = [" + integer + "]" + obs.toString());
            }
        });
        deferObservable.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println("s2 integer = [" + integer + "]" + obs.toString());
            }
        });
    }

    @Test
    public void testJust() {
        final Observable<Long> observable = Observable.timer(1, TimeUnit.SECONDS);

        observable.subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                System.out.println("s2 integer = [");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onErrors2 integer = [");
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println("onNext integer = [");
            }
        });

    }

    @Test
    public void testBuffer() {
        getO1().buffer(2).subscribe(new Action1<List<Integer>>() {
            @Override
            public void call(List<Integer> integers) {
                System.out.println("integers = [" + integers + "]");
            }
        });

    }

    @Test
    public void testObs() {
//        getO1().flatMap(new Func1<Integer, Observable<Integer>>() {
//            @Override
//            public Observable<Integer> call(Integer integer) {
//                return Observable.just(integer*integer);
//            }
//        }).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                System.out.println("integer = [" + integer + "]");
//            }
//        });
/*        Observable.just(getO1(), getO2(), getO0())
                .flatMap(new Func1<Observable<Integer>, Observable<?>>() {
                    @Override
                    public Observable<?> call(Observable<Integer> integerObservable) {
                        return integerObservable.map(new Func1<Integer, Integer>() {
                            @Override
                            public Integer call(Integer integer) {
                                return integer + 100;
                            }
                        });
                    }
                })
                .groupBy(new Func1<Object, Observable<Integer>>() {
                    @Override
                    public Observable<Integer> call(Object integer) {
                        if (integer instanceof Observable) {
                            System.out.println("integer instanceof Observable) true");
                            Observable.just((Observable<Integer>) integer);
                        } else {
                            System.out.println("iinteger instanceof Observable) false");
                        }
                        if ((Integer) integer < 200) {
                            return Observable.just((Integer) integer);
                        }
                        return Observable.just((Integer) integer);
                    }
                })
                .subscribe(new Action1<GroupedObservable<Observable<Integer>, Object>>() {
                    @Override
                    public void call(GroupedObservable<Observable<Integer>, Object> observableObjectGroupedObservable) {
                        observableObjectGroupedObservable.getKey().subscribe(new Action1<Integer>() {
                            @Override
                            public void call(Integer integer) {
                                System.out.println("integer = [" + integer + "]");
                            }
                        });
                    }
                });*/

        getO1().scan(new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer preResult, Integer nextItem) {
                return preResult * nextItem;
            }
        })
                .doOnEach(new Action1<Notification<? super Integer>>() {
                    @Override
                    public void call(Notification<? super Integer> notification) {
                        System.out.println("notification = [" + notification + "]");
                    }
                }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println("integer = [" + integer + "]");
            }
        });
    }
}