package com.mycompany.app.model;

import lombok.*;

import java.util.Date;

@Getter @Setter // OR @DATA
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
//FIN @DATA
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int id;
    @NonNull
    private String name;
    @NonNull
    private String job;
    private int managerId;
    private Date hireDate;
    @NonNull
    private int salary;
    private int commission;
    @NonNull
    private int deptId;
}
