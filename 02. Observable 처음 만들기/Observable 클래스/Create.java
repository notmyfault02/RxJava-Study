package Observable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Consumer;

public class Create {
    public static void main(String args[]) {
        Observable<Integer> sourse = Observable.create(
                (ObservableEmitter<Integer> emitter) -> {
                    emitter.onNext(100);
                    emitter.onNext(200);
                    emitter.onNext(300);
                    emitter.onComplete();
                });
        //sourse.subscribe(System.out::println);

        //subscribe()의 인자로 System.out::println이라는 메서드 레퍼런스를 넣고 람다식으로 표현
        sourse.subscribe(data -> System.out.println("Result : " + data));

        //위의 코드를 익명 객체로 변경했을 때
        sourse.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer data) throws Exception {
                System.out.println("Result2 : " + data);
            }
        });
    }
}
