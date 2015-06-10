package it.tostao.jte;

/**
 * Created by Slawomir Leski <slawomir.leski@buschgroup.com> on 10.06.2015.
 */
public class DummyService {

    public void someMethod() {
        throw new RuntimeException("Runtime exception occurred");
    }

    public void someOtherMethod(boolean b) {
        throw new RuntimeException("Runtime exception occurred",
                new IllegalStateException("Illegal state"));
    }
}
