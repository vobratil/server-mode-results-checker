package org.jboss.qe.as.filter.eap72x;

import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        System.out.println(env);


        for (String key : env.keySet()) {
            System.out.println(key + "=" + env.get(key));
        }
    }

}
