package Subject;

import io.reactivex.subjects.PublishSubject;

public class PublishSubjectExample {
    // 구독자가 subscribe() 함수를 호출하면 값을 발행하기 시작한다.
    // 마지막 값만 발행하거나 기본값을 대신 발행하지 않고 해당 시간에 발생한 데이터를 그대로 구독자에게 전달받는다.
    public static void main(String args[]) {
        PublishSubjectExample demo = new PublishSubjectExample();
        demo.marbleDiagram();
    }

    void marbleDiagram() {
        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        subject.onNext("5");
        subject.onComplete();
    }
}
