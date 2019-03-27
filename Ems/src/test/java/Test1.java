import org.apache.log4j.Logger;
import org.junit.Test;
import wo.common.util.WoUtil;

public class Test1 {
    private static Logger logger = Logger.getLogger(Test1.class);

    @Test
    public void test1() {
        System.out.println(WoUtil.getMD5("20120003", "123456"));
    }
}
