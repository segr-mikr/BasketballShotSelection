package com.ftn.sbnz.model.facts;

public class QuarterEndSignal {

    private int quarter;

    public QuarterEndSignal() {
    }

    public QuarterEndSignal(int quarter) {
        this.quarter = quarter;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    @Override
    public String toString() {
        return "QuarterEndSignal{Q" + quarter + "}";
    }
}
