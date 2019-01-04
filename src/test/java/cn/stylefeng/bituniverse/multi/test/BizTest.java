package cn.stylefeng.bituniverse.multi.test;

import cn.stylefeng.bituniverse.multi.service.TestService;
import cn.stylefeng.bituniverse.base.BaseJunit;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 业务测试
 *
 * @author fengshuonan
 * @date 2017-06-23 23:12
 */
public class BizTest extends BaseJunit {

    @Autowired
    private TestService testService;

    @Test
    public void test() {
        testService.testGuns();

        testService.testBiz();
    }
}
