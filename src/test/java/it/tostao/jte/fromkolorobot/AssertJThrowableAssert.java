package it.tostao.jte.fromkolorobot;

import org.assertj.core.api.Assertions.*;
import org.assertj.core.api.ThrowableAssert;

public class AssertJThrowableAssert {
    public static ThrowableAssertion assertThrown(ExceptionThrower exceptionThrower) {
        try {
            exceptionThrower.throwException();
        } catch (Throwable throwable) {
            return (ThrowableAssertion) Assertions.assertThat(throwable);
        }
        throw new ExceptionNotThrownAssertionError();
    }
}
