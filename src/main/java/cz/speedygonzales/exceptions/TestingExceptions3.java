package cz.speedygonzales.exceptions;

class TestingException3 {
    //    void m1() { throw new MyException1(); }
    void m2() {
        throw new MyException2();
    }
}

class MyException1 extends Exception {
}

class MyException2 extends RuntimeException {
}