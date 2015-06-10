package it.tostao.jte.fromkolorobot;

@FunctionalInterface
public interface ExceptionThrower {
    void throwException() throws Throwable;
}
