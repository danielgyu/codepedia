package hello.advanced.trace.hellotrace.template;

import hello.advanced.trace.hellotrace.template.code.AbstractTemplate;
import hello.advanced.trace.hellotrace.template.code.SubClassLogic1;
import hello.advanced.trace.hellotrace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long starTime = System.currentTimeMillis();
        log.info("Business logic 1 execution");
        long endTime = System.currentTimeMillis();
        long result = endTime - starTime;
        log.info("result={}", result);
    }

    private void logic2() {
        long starTime = System.currentTimeMillis();
        log.info("Business logic 1 execution");
        long endTime = System.currentTimeMillis();
        long result = endTime - starTime;
        log.info("result={}", result);
    }

    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();
        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

    @Test
    void templateMethodV2() {
        AbstractTemplate template = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("inner abstract class");
            }
        };
        template.execute();
    }
}
