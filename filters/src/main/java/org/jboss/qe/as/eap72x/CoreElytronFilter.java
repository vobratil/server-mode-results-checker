package org.jboss.qe.as.filter.eap72x;

import org.jboss.qe.as.filter.AbstractEapAsTestsuite;
import org.jboss.qe.collector.FailedTest;
import org.jboss.qe.collector.FilterResult;
import org.jboss.qe.collector.filter.FilterItem;

/**
 * @author Vilem Obratil vobratil@redhat.com
 **/
public class CoreElytronFilter extends AbstractEapAsTestsuite {
    @Override
    public FilterResult filter(FailedTest failedTest) {
        return coreFilter(failedTest, FILTER_ITEMS);
    }

    static final FilterItem[] CORE_ELYTRON_FILTER_ITEMS = {

    };

    private static final FilterItem[] FILTER_ITEMS = mergeArrays(
            CoreFilter.CORE_FILTER_ITEMS,
            CORE_ELYTRON_FILTER_ITEMS);
}
