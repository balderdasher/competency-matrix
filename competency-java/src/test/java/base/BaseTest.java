package base;

/**
 * Junit单元测试基类
 *
 * @author huxiong
 * @date 2016/06/24 11:42
 */
public class BaseTest {

    /**
     * 断言为True
     *
     * @param expression
     */
    protected void assertTrue(boolean expression) {
        assert expression;
    }

    /**
     * 断言为False
     *
     * @param expression
     */
    protected void assertFalse(boolean expression) {
        assert !expression;
    }
}
