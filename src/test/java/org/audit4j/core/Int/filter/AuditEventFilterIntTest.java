package org.audit4j.core.Int.filter;

import java.util.concurrent.TimeUnit;

import org.audit4j.core.AuditManager;
import org.audit4j.core.Configuration;
import org.audit4j.core.Int.IntTestBase;
import org.audit4j.core.Mock.AuditEventFilterMock;
import org.audit4j.core.dto.AuditEvent;
import org.junit.Before;
import org.junit.Test;

public class AuditEventFilterIntTest extends IntTestBase {

    @Before
    public void before() {
        Configuration config = getDefaultConfiguration();
        config.addFilter(new AuditEventFilterMock());
        AuditManager.initWithConfiguration(config);
    }

    @Test
    public void testFilter_filter() throws InterruptedException {
        AuditManager manager = AuditManager.getInstance();
        AuditEvent event = getSampleAuditEvent();
        event.setAction("Filter");
        manager.audit(event);
        
        TimeUnit.SECONDS.sleep(2);
    }
    
    @Test
    public void testFilter_not_filter() throws InterruptedException {
        AuditManager manager = AuditManager.getInstance();
        AuditEvent event = getSampleAuditEvent();
        event.setAction("NOTFilter");
        manager.audit(event);
        
        TimeUnit.SECONDS.sleep(2);
    }
}
