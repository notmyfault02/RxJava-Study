package Single;

import io.reactivex.Single;

public class Just {
    public static void main(String args[]) {
        Just demo = new Just();
        demo.exampleJust();
    }

    private void exampleJust() {
        Single<String> source = Single.just("Hello");
        source.subscribe(System.out::println);
    }
}
