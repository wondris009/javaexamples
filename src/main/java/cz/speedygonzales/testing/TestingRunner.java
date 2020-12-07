package cz.speedygonzales.testing;

class TestRunner {
    static public int succeeded;
    static public int failed;

    public TestRunner() {
    }

    public TestRunner(int s, int f) {
        succeeded=s; failed=f;
    }

    public String toString() {
        return succeeded + " " + failed;
    }
}

class TestStatistics {
    public static void main(String[] args) {
        new TestRunner(1, 99);
        TestRunner.succeeded = 99;
        System.out.print(new TestRunner());
    }
}