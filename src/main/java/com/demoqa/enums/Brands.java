package com.demoqa.enums;

import lombok.Getter;

@Getter
public enum Brands {
    POLO("Polo"),
    HM("H&M"),
    MADAME("Madame"),
    MAST_HARBOUR("Mast & Harbour"),
    BABY_HUG("Babyhug"),
    ALLEN_SOLLY("Allen Solly Junior"),
    KOOKIE_KIDS("Kookie Kids"),
    BIBA("Biba");

    String name;

    Brands(String name) {
        this.name = name;
    }
}
