package com.demoqa.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Employee {
     String firstName;
     String lastName;
     int age;
     String email;
     int salary;
     String department;

     //добавить три объекта в web tables  и создать лист оф employee

}
