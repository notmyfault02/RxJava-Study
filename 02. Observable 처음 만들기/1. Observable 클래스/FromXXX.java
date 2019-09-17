package Observable;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class FromXXX {

    public static void main(String args[]) {
        FromXXX demo = new FromXXX();
        demo.arrayExample();
        demo.interableExample();
        demo.callableExample();
        demo.futureExample();
        demo.publisherExample();
    }

    //fromArray()
    private void arrayExample() {
        //Integer[] arr = {100, 200, 300};
        int[] intArray = {400, 500, 600};

        //배열에 들어 있는 데이터를 처리하는 fromArray() 함수
        //Observable<Integer> source = Observable.fromArray(arr);

        //toIntegerArray() 메서드를 적용한 예제
        Observable<Integer> source = Observable.fromArray(toIntegerArray(intArray));

        source.subscribe(data -> System.out.println(data));
    }

    // int 배열을 인식시키려면 Integer[] 로 변환해야 하며, 자바 8의 Stream API에서는 다음과 같은 방법을 제공한다.
    // toIntegerArray() 메서드 안 boxed() 메서드는 int[] 배열 각각의 요소를 Integer로 변환해 Integer[] 배열의 스트림으로 만든다.
    private static Integer[] toIntegerArray(int[] intArray) {
        return IntStream.of(intArray).boxed().toArray(Integer[]::new);
    }

    // fromIterator()
    // Iterator 인터페이스는 다음에 어떤 데이터가 있는지와 그 값을 얻어오는 것만 관여할 뿐 특정 데이터 타입에 의존하지 않는 장점이 있다.
    // Map 인터페이스는 Iterable<E> 인터페이스를 구현하지 않았으므로 from() 계열 함수에 존재하지 않는다.
    private void interableExample() {
        List<String> names = new ArrayList();
        names.add("Jerry");
        names.add("Tom");
        names.add("User");

        Observable<String> source = Observable.fromIterable(names);
        source.subscribe(System.out::println);
    }

    // fromCallable()
    // Callable 인터페이스는 동시성 API이며, 비동기 실행 후 결과를 반환하는 call() 메서드를 정의한다.

    private void callableExample() {
        // call() 함수는 인자가 없으므로 () -> {} 형태의 람다 표현식을 활용했다.
        Callable<String> callable = () -> {
            Thread.sleep(1000);
            return "Hello Callable";
        };

        Observable<String> source = Observable.fromCallable(callable);
        source.subscribe(System.out::println);
    }

    // fromFuture()
    // Future 인터페이스도 동시성 API이며, Executor 인터페이스를 구현한 클래스에 Callable 객체를 인자로 넣어 Future 객체를 반환한다.
    // get() 메서드를 호출하면 Callable 객체에서 구현한 계산 결과가 나올 때 까지 기다린다.
    private void futureExample() {
        Future<String> future = Executors.newSingleThreadExecutor().submit(() -> {
           Thread.sleep(1000);
           return "Hello Future";
        });

        Observable<String> source = Observable.fromFuture(future);
        source.subscribe(System.out::println);
    }

    // fromPublisher()
    // Publisher는 자바 9의 표준인 Flow API의 일부이다.
    // Publisher 객체는 Observable.create()와 마찬가지로 onNext()와 onComplete() 함수를 호출할 수 있다.
    private void publisherExample() {
        Publisher<String> publisher = (Subscriber<? super String> s) -> {
            s.onNext("Hello Publisher");
            s.onNext("Hello 2");
            s.onComplete();
        };

        Observable<String> source = Observable.fromPublisher(publisher);
        source.subscribe(System.out::println);
    }
}
