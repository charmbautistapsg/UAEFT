package com.psglobal.uaeftmt103.constants;

public enum BLock5Constants {

    CHK("CHK"), TNG("TNG"), PDE("PDE"), PDM("PDM");

    private final String value;

    BLock5Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
