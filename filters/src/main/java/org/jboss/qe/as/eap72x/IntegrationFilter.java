package org.jboss.qe.as.filter.eap72x;

import org.jboss.qe.as.filter.AbstractEapAsTestsuite;
import org.jboss.qe.collector.Colour;
import org.jboss.qe.collector.FailedTest;
import org.jboss.qe.collector.FilterResult;
import org.jboss.qe.collector.filter.FilterItem;

import static org.jboss.qe.as.filter.AsTsCategory.CANNOT_REPRODUCE;
import static org.jboss.qe.as.filter.AsTsCategory.ENVIRONMENT;
import static org.jboss.qe.as.filter.AsTsCategory.WS;

/**
 * @author Petr Kremensky pkremens@redhat.com
 */
public class IntegrationFilter extends AbstractEapAsTestsuite {
    @Override
    public FilterResult filter(FailedTest failedTest) {
        return coreFilter(failedTest, INTEG_FILTER_ITEMS);
    }

    static final FilterItem[] INTEG_FILTER_ITEMS = {
            // https://issues.jboss.org/browse/WFLY-10336 MustUnderstand headers: [{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd}Security] are not understood.
            new FilterItem(Colour.YELLOW).addUrl(INTEG).addUrl(IBM)
                    .addTest("org.jboss.as.test.integration.ws.wsse..*")
                    .setErrorText(JIRA + "WFLY-10336 - MustUnderstand headers: [{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd}Security] are not understood.")
                    .setCategory(WS),

            // https://issues.jboss.org/browse/WFLY-10529 ParseAndMarshalModelsTestCase fails on the latest IBM8 with Failed to register MBean with MBeanServer
            new FilterItem(Colour.YELLOW).addUrl(INTEG).addUrl(IBM)
                    .addTest("org.jboss.as.test.manualmode.parse.ParseAndMarshalModelsTestCase#.*")
                    .setErrorText(JIRA + "WFLY-10529 - ParseAndMarshalModelsTestCase fails on the latest IBM8"),

            // https://issues.jboss.org/browse/WFLY-10530 Domain test failures on IBM8 - IllegalStateException: The LogManager was not properly installed
            new FilterItem(Colour.YELLOW).addUrl(INTEG).addUrl(IBM)
                    .addTest("org.jboss.as.test.integration.domain.suites.DeploymentOverlayTestCase#testDeploymentOverlayInDomainMode")
                    .addTest("org.jboss.as.test.integration.domain.suites.ReadEnvironmentVariablesTestCase#testReadEnvironmentVariablesForServers")
                    .setErrorText(JIRA + "WFLY-10530 - Domain test failures on IBM8"),

            // https://issues.jboss.org/browse/WFLY-5507
            // https://github.com/ctomc/ansible-playbooks/blob/4703b8c2109c054d2e0dd7c0275e0329e6b9903d/teamcity-agent/roles/setup-rng/tasks/main.yml
            new FilterItem(Colour.PURPLE).addUrl(INTEG)
                    .addTest("org.jboss.as.test.integration.ws.wsse.signencrypt.EJBSignEncryptMultipleClientsTestCase#encryptedAndSignedRequestFromJohn")
                    .addTest("org.jboss.as.test.integration.ws.wsse.signencrypt.EJBSignEncryptMultipleClientsTestCase#encryptedAndSignedRequestFromAlice")
                    .setErrorText("Occurs intermittently mostly on 32b oracle, unable to reproduce locally though.")
                    .setCategory(CANNOT_REPRODUCE),

            // org.jboss.as.test.clustering.cluster.web.remote.HotRodPersistenceWebFailoverTestCase#test
            new FilterItem(Colour.PURPLE).addUrl(INTEG)
                    .addTest("org.jboss.as.test.clustering.cluster.web.remote.HotRodPersistenceWebFailoverTestCase#test")
                    .setErrorText("This looks more like a collision with some other cluster running elsewhere - revisit!")
                    .setCategory(ENVIRONMENT),
    };
}
