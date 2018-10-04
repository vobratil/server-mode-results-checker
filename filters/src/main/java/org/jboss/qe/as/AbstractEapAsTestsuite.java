package org.jboss.qe.as.filter;

import org.jboss.qe.collector.Colour;
import org.jboss.qe.collector.filter.AbstractFilter;
import org.jboss.qe.collector.filter.Category;
import org.jboss.qe.collector.filter.FilterItem;

import java.util.Map;
import java.util.stream.Stream;

public abstract class AbstractEapAsTestsuite extends AbstractFilter {
    protected static final String JIRA = "https://issues.jboss.org/browse/";
    protected static final String INTEG = ".*integration.*";
    protected static final String CORE = ".*core.*";
    protected static final String SECMAN = ".*secman.*";
    protected static final String ELYTRON = ".*elytron.*";
    protected static final String MIXED_DOMAIN = ".*mixed_domain.*";
    protected static final String IBM = ".*ibm-java.*";
    protected static final String IPV6 = ".*-ipv6.*";
    protected static final String WINDOWS = ".*windows.*";
    protected static final String HP_UX = ".*hpux.*";
    protected static final String W2K16 = ".*w2k16.*";
    protected static final String JDK9 = ".*jdk1.9.*";
    protected static final String JDK10 = ".*oracle-java-10.*";

    @Override
    public void onFinish() {
        if (Category.statistics.size() > 0) {
            System.out.println(dyeText("########    CATEGORIES STATISTICS    ########", Colour.CYAN_BOLD));

            Category.statistics.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(it -> {
                        String text = String.format("%s - %s", dyeText(it.getKey(), Colour.BLUE), it.getValue());
                        System.out.println(text);
                    });

            System.out.println();
        }
    }

    protected static FilterItem[] mergeArrays(FilterItem[]... values) {
        return Stream.of(values).flatMap(Stream::of).toArray(FilterItem[]::new);
    }

}
