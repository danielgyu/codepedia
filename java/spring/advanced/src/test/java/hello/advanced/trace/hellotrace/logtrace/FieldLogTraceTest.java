package hello.advanced.trace.hellotrace.logtrace;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.FieldLogTrace;
import org.junit.jupiter.api.Test;

public class FieldLogTraceTest {

    FieldLogTrace trace = new FieldLogTrace();

    @Test
    void begin_end_levelv2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);
    }
}