package Subject;

import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectExample {
    // 차가운 Observable 처럼 동작한다.
    // 구독자가 새로 생기면 항상 데이터의 처음부터 끝까지 발행하는 것을 보장하다.
    // 모든 데이터를 저장해두는 과정 중 메모리 누수가 발생할 가능성을 염두에 두고 사용해야 한다.
    public static void main(String args[]) {
        ReplaySubjectExample demo = new ReplaySubjectExample();
        demo.marbleDiagram();
    }

    void marbleDiagram() {
        ReplaySubject subject = ReplaySubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext("1");
        subject.onNext("3");
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        subject.onNext("5");
        subject.onComplete();
    }
}
