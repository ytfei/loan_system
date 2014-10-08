package com.enniu.loan.extend.persistence;

/**
 * Created by evans on 10/8/14.
 */
public aspect LoanOrderAspect {
    public interface X {
        void x();
    }

    declare parents:com.enniu.loan.persistence.LoanOrderMapper implements X;
}
