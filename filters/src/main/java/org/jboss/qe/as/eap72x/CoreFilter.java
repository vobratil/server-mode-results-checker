package org.jboss.qe.as.filter.eap72x;

import org.jboss.qe.as.filter.AbstractEapAsTestsuite;
import org.jboss.qe.collector.Colour;
import org.jboss.qe.collector.FailedTest;
import org.jboss.qe.collector.FilterResult;
import org.jboss.qe.collector.filter.FilterItem;

/**
 * @author Petr Kremensky pkremens@redhat.com
 */
public class CoreFilter extends AbstractEapAsTestsuite {
    @Override
    public FilterResult filter(FailedTest failedTest) {
        return coreFilter(failedTest, CORE_FILTER_ITEMS);
    }

    static final FilterItem[] CORE_FILTER_ITEMS = {
            // https://issues.jboss.org/browse/WFCORE-4081 SocketHandlerTestCase.testTlsSocket fails on IBM JDK
            new FilterItem(Colour.YELLOW).addUrl(CORE).addUrl(IBM)
                    .addTest("org.jboss.as.test.integration.logging.handlers.SocketHandlerTestCase#testTlsSocket")
                    .setErrorText(JIRA + "WFCORE-4081 SocketHandlerTestCase.testTlsSocket fails on IBM JDK"),

            // https://issues.jboss.org/browse/WFCORE-2086 Intermittent failure in OperationCancellationTestCase
            new FilterItem(Colour.YELLOW).addUrl(CORE)
                    .addTest("org.jboss.as.test.integration.domain.suites.OperationCancellationTestCase#.*")
                    .setErrorText(JIRA + "WFCORE-2086 - Intermittent failure in OperationCancellationTestCase"),

            // https://issues.jboss.org/browse/WFCORE-3869 [jdk10] DeletionCollisionTest#testFileLockByRemoveContent failure
            new FilterItem(Colour.YELLOW).addUrl(CORE).addUrl(JDK10)
                    .addTest("org.jboss.as.repository.DeletionCollisionTest#testFileLockByRemoveContent")
                    .setErrorText(JIRA + "WFCORE-3869 - [jdk10] DeletionCollisionTest#testFileLockByRemoveContent failure"),

            // https://issues.jboss.org/browse/WFCORE-3874 [jdk10] FileSystemDeploymentServiceUnitTestCase#testNoUndeployment failure
            new FilterItem(Colour.YELLOW).addUrl(CORE).addUrl(JDK10)
                    .addTest("org.jboss.as.server.deployment.scanner.FileSystemDeploymentServiceUnitTestCase#testNoUndeployment")
                    .setErrorText(JIRA + "WFCORE-3874 - [jdk10] FileSystemDeploymentServiceUnitTestCase#testNoUndeployment failure"),

            // https://issues.jboss.org/browse/WFCORE-3875 [jdk10] PatchModuleInvalidationWithRenamingFailureTestCase#test failure
            new FilterItem(Colour.YELLOW).addUrl(CORE).addUrl(JDK10)
                    .addTest("org.jboss.as.patching.tests.PatchModuleInvalidationWithRenamingFailureTestCase#test")
                    .setErrorText(JIRA + "WFCORE-3875 - [jdk10] PatchModuleInvalidationWithRenamingFailureTestCase#test failure"),

            // Test case issue, to be fixed
            new FilterItem(Colour.PURPLE).addUrl(CORE)
                    .addTest("org.jboss.as.test.manualmode.auditlog.AuditLogBootingSyslogTest#testSyslog")
                    .setErrorText("Test case issue, to be fixed"),

            // https://issues.jboss.org/browse/WFCORE-2086 Intermittent failure in OperationCancellationTestCase
            new FilterItem(Colour.YELLOW).addUrl(CORE)
                    .addTest("org.jboss.as.test.manualmode.deployment.InterdependentDeploymentTestCase#test")
                    .setErrorText(JIRA + "WFCORE-4074 - InterdependentDeploymentTestCase fail intermittently"),

    };
}