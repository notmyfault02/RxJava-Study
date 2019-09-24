package Subject;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;

public class AsyncSubjectExample {
    // AsyncSubject 클래스는 Observable에서 발행한 마지막 데이터를 얻어올 수 있는 Subject 클래스이다.
    // 데이터 발행이 완료되기 전까지는 구독자에게 데이터를 전달하지 않다가 완료됨과 동시에 구독자에게 마지막 데이터를 발행하고 종료한다.
    public static void main(String args[]) {
        AsyncSubjectExample demo = new AsyncSubjectExample();

        demo.marbleDiagram();
        demo.asSubscriber();
        demo.afterComplete();
    }

    void marbleDiagram() {
        AsyncSubject<String> subject = AsyncSubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        subject.onNext("5");
        subject.onComplete();
    }

    // AsyncSubject 클래스가 구독자로 동작하는 예
    // Subject 클래스가 Observable을 상속하고 동시에 Observable 인터페이스를 구현하기 때문에 가능하다.
    void asSubscriber() {
        Float[] temperature = {10.1f, 13.4f, 12.5f};
        Observable<Float> source = Observable.fromArray(temperature);

        AsyncSubject<Float> subject = AsyncSubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));

        source.subscribe(subject);
    }

    // onComplete() 함수 이후에는 onNext 이벤트를 무시하는 예제
    void afterComplete() {
        AsyncSubject<Integer> subject = AsyncSubject.create();
        subject.onNext(10);
        subject.onNext(11);
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext(12);
        subject.onComplete();
        subject.onNext(13);
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        subject.subscribe(data -> System.out.println("Subscriber #3 => " + data));
    }


}