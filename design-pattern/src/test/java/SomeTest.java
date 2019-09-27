import org.junit.Test;

/**
 * @author CodePorter
 * @date 2018-01-25
 */
public class SomeTest {
    @Test
    public void test() {
        for (int x = 1; x < 10000; x++) {
            if (x + x * x - Integer.valueOf(x + "" + x) / x == Integer.valueOf("7" + x)) {
                System.out.println(x);
            }
        }
    }
}
