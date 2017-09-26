package exception_overhead;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- regular return ---");
        measure(Main::regular);
        System.out.println("--- exit by exception ---");
        measure(Main::byException);
    }
    
    private static Long regular(Long value) {
        return value+1;
    }
    
    private static Long byException(Long value) {
        throw new ExceptionWithResult(value+1);
    }
    
    @SuppressWarnings("serial")
    private static class ExceptionWithResult extends RuntimeException {
        private long result;
        ExceptionWithResult(long result) {
            this.result = result;
        }
    }

    private static void measure(Function<Long, Long> f) {
        long elapsed = -System.currentTimeMillis();
        try {
            long result = 0;
            for (int i = 0; i < 100000; i++) {
                try {
                    result = f.apply(result);
                } catch (ExceptionWithResult e) {
                    result = e.result;
                }
            }
            System.out.println("Result: " + result);
        } finally {
            elapsed += System.currentTimeMillis();
            System.out.println(elapsed + " msec elapsed");
        }
    }
}
