package Observable;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class ObservableNotifications {
    public static void main(String args[]) {
        Observable<String> source = Observable.just("red", "yellow", "blue");

        //Disposable 인터페이스에는 구독을 해지하는 dispose(), 구독을 해지했는지 확인하는 isDisposed() 함수가 있다.
        Disposable d = source.subscribe(
                v -> System.out.println("onNext() : value : " + v),
                err -> System.err.println("onError() : err : " + err.getMessage()),
                () -> System.out.println("onComplete()")
        );

        System.out.println("isDisposed( ): " + d.isDisposed());
    }
}
