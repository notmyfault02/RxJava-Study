package Single;

import io.reactivex.Observable;
import io.reactivex.Single;

public class FromObservable {
    public static void main(String args[]) {
        FromObservable demo = new FromObservable();
        demo.changeSingle();
        demo.singleWithSingle();
        demo.singleWithFirst();
        demo.singleWithEmpty();
        demo.singleWithTake();
    }

    // 기존 Observable에서 Single 객체로 변환하기.
    // 첫 번째 값을 발행하면 onSuccess 이벤트를 호출한 후 종료한다.
    private void changeSingle() {
        Observable<String> source = Observable.just("Single");
        Single.fromObservable(source)
                .subscribe(System.out::println);
    }

    // single() 함수를 호출해 Single 객체 생성하기
    // single() 함수는 default value를 인자로 갖는다.
    // Observable에서 값이 발행되지 않을 때도 인자로 넣은 기본값을 대신 발행한다.
    private void singleWithSingle() {
        Observable.just("Hello Single")
                .single("default item")
                .subscribe(System.out::println);
    }

    // first() 함수를 호출해 Single 객체 생성하기
    // first() 함수를 호출하면 Observable이 Single 객체로 변환된다.
    // 첫 번째 데이터 발행 후 onSuccess 이벤트가 발생한다.
    private void singleWithFirst() {
        String[] colors = {"Red", "Blue", "Green"};
        Observable.fromArray(colors)
                .first("default item")
                .subscribe(System.out::println);
    }

    // empty() 함수를 호출해 Single 객체 생성하기
    // Observable에서 값이 발행 되지 않을 때도 기본값을 가진다.
    private void singleWithEmpty() {
        Observable.empty()
                .single("default item")
                .subscribe(System.out::println);
    }

    // take() 함수를 호출해 Single 객체 생성하기
    //
    private void singleWithTake() {
        Observable.just(new Order("ORD-1"), new Order("ORD-2"))
                .take(1)
                .single(new Order("default item"))
                .subscribe(System.out::println);
    }
}
