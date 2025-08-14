package com.demoqa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Title {
     MR("Mr"),
     MRS("Mrs");

    final String title;
}
