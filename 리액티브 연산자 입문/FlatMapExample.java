package Operator;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class FlatMapExample {

    String[] balls = {"1", "3", "5"};

    public static void main(String args[]) {
        FlatMapExample demo = new FlatMapExample();
        demo.marbleDiagram();
        demo.flatMapLambda();
    }

    void marbleDiagram() {
        Function<String, Observable<String>> getDoubleDiamonds =
                ball -> Observable.just(ball + "<>", ball + "<>");

        Observable<String> source = Observable.fromArray(balls)
                .flatMap(getDoubleDiamonds);
        source.subscribe(System.out::println);
    }

    void flatMapLambda() {
        Observable<String> source = Observable.fromArray(balls)
                .flatMap(ball -> Observable.just(ball + "<>", ball + "<>"));
        source.subscribe(System.out::println);
    }
}
