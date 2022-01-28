package hello.advanced.trace.hellotrace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute() {
        long starTime = System.currentTimeMillis();
        call();
        long endTime = System.currentTimeMillis();
        long result = endTime - starTime;
        log.info("result={}", result);
    }

    protected abstract void call();
}
