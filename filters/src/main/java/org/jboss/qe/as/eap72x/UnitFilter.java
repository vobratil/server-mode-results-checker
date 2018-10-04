package org.jboss.qe.as.filter.eap72x;

import org.jboss.qe.as.filter.AbstractEapAsTestsuite;
import org.jboss.qe.collector.FailedTest;
import org.jboss.qe.collector.FilterResult;
import org.jboss.qe.collector.filter.FilterItem;

/**
 * @author Petr Kremensky pkremens@redhat.com
 */
public class UnitFilter extends AbstractEapAsTestsuite {
    @Override
    public FilterResult filter(FailedTest failedTest) {
        return coreFilter(failedTest, UNIT_FILTER_ITEMS);
    }

    static final FilterItem[] UNIT_FILTER_ITEMS = {

    };
}
