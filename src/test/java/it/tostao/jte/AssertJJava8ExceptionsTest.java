package it.tostao.jte;

import org.junit.Test;

import static it.tostao.jte.fromkolorobot.AssertJThrowableAssert.assertThrown;

/**
 * Created by Slawomir Leski <slawomir.leski@buschgroup.com> on 10.06.2015.
 */
public class AssertJJava8ExceptionsTest {

    @Test
    public void verifiesTypeAndMessage() {
        assertThrown(new DummyService()::someMethod)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Runtime exception occurred")
                .hasMessageStartingWith("Runtime")
                .hasMessageEndingWith("occurred")
                .hasMessageContaining("exception")
                .hasNoCause();
    }

    @Test
    public void verifiesCauseType() {
        assertThrown(() -> new DummyService().someOtherMethod(true))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Runtime exception occurred")
                .hasCauseExactlyInstanceOf(IllegalStateException.class)
                .hasRootCauseExactlyInstanceOf(IllegalStateException.class);
    }

    @Test
    public void verifiesCheckedExceptionThrownByConstructor() {
        assertThrown(DummyService2::new)
                .isInstanceOf(Exception.class)
                .hasMessage("Constructor exception occurred");

        assertThrown(() -> new DummyService2(true))
                .isInstanceOf(Exception.class)
                .hasMessage("Constructor exception occurred");
    }
}
