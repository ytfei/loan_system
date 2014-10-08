package com.enniu.loan;

import org.springframework.core.io.Resource;

/**
 * Created by evans on 10/8/14.
 */
public aspect MyBatisDebug {
    pointcut setMapperLocations(Resource[] res): call(void setMapperLocations(Resource[])) && args(res);

    before(Resource[] res): setMapperLocations(res) {
        if (res != null) {
            for (Resource r : res) {
                System.out.println("------------> " + r.toString());
            }
        }
    }
}
