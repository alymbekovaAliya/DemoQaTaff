package com.demoqa.enums;

import lombok.Getter;

@Getter
public enum Category {
    WOMEN("Women"),
    MEN("Men"),
    KIDS("Kids");

    String category;

    Category(String category) {
        this.category = category;
    }
}
