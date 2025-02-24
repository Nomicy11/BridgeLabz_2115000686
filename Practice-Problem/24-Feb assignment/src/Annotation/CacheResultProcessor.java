package Annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class ExpensiveOperation {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int num) {
        if (cache.containsKey(num)) {
            System.out.println("Returning cached result for: " + num);
            return cache.get(num);
        }
        int result = num * num;
        cache.put(num, result);
        System.out.println("Computing square for: " + num);
        return result;
    }
}

public class CacheResultProcessor {
    public static void main(String[] args) throws Exception {
        ExpensiveOperation op = new ExpensiveOperation();
        Method method = op.getClass().getMethod("computeSquare", int.class);

        if (method.isAnnotationPresent(CacheResult.class)) {
            System.out.println(op.computeSquare(5)); // Compute and store
            System.out.println(op.computeSquare(5)); // Fetch from cache
        }
    }
}
