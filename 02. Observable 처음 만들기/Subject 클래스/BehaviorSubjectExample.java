package Subject;

import io.reactivex.subjects.BehaviorSubject;

public class BehaviorSubjectExample {

    // BehaviorSubject 클래스는 구독을 하면 가장 최근 값 혹은 기본값을 넘겨주는 클래스이다.
    public static void main(String args[]) {
        BehaviorSubjectExample demo = new BehaviorSubjectExample();
        demo.marbleDiagram();
    }

    void marbleDiagram() {
        //AsyncSubject와 다르게 기본값을 생성한다.
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("6");
        subject.subscribe(data -> System.out.println("Subscriber #1: " + data));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(data -> System.out.println("Subscriber #2: " + data));
        subject.onNext("5");
        subject.subscribe(data -> System.out.println("Subscriber #3: " + data));
        subject.onComplete();
    }
}
