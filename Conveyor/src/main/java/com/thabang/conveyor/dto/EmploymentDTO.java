package com.thabang.conveyor.dto;

import java.math.BigDecimal;

public class EmploymentDTO {
    //enum
    private String employerINN;
    private BigDecimal salary;
    //enum
    private Integer workExprienceTotal;
    private Integer getWorkExprienceCurrent;

    enum employmentStatus{
        unemployed, employed
    }

    enum position{

    }
}
