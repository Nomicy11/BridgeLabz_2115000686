import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

class PerformanceTest {
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Test will fail if it exceeds 2 seconds
    void testLongRunningTask() throws InterruptedException {
        Thread.sleep(3000); // Simulates a long task that runs for 3 seconds
    }
}
