package com.ftn.sbnz.model.enums;

public enum ShotZone {
    RESTRICTED_AREA(0.67),
    PAINT_NON_RA(0.41),
    MID_RANGE(0.39),
    LEFT_CORNER_3(0.58),
    RIGHT_CORNER_3(0.57),
    LEFT_WING_3(0.36),
    RIGHT_WING_3(0.35),
    TOP_OF_KEY_3(0.35);

    private final double historicalEfgPct;

    ShotZone(double historicalEfgPct) {
        this.historicalEfgPct = historicalEfgPct;
    }

    public double getHistoricalEfgPct() {
        return historicalEfgPct;
    }

    public boolean isThreePointer() {
        return this == LEFT_CORNER_3 || this == RIGHT_CORNER_3
                || this == LEFT_WING_3 || this == RIGHT_WING_3
                || this == TOP_OF_KEY_3;
    }

    public boolean isPaintArea() {
        return this == RESTRICTED_AREA || this == PAINT_NON_RA;
    }
}
