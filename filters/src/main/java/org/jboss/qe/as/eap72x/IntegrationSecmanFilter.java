package org.jboss.qe.as.filter.eap72x;

import org.jboss.qe.as.filter.AbstractEapAsTestsuite;
import org.jboss.qe.collector.FailedTest;
import org.jboss.qe.collector.FilterResult;
import org.jboss.qe.collector.filter.FilterItem;

/**
 * @author Petr Kremensky pkremens@redhat.com
 */
public class IntegrationSecmanFilter extends AbstractEapAsTestsuite {
    @Override
    public FilterResult filter(FailedTest failedTest) {
        return coreFilter(failedTest, FILTER_ITEMS);
    }

    static final FilterItem[] INTEG_SECMAN_FILTER_ITEMS = {

    };

    private static final FilterItem[] FILTER_ITEMS = mergeArrays(
            IntegrationFilter.INTEG_FILTER_ITEMS,
            INTEG_SECMAN_FILTER_ITEMS);
}
