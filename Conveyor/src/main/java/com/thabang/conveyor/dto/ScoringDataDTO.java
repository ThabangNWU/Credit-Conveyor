package com.thabang.conveyor.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ScoringDataDTO {
    private BigDecimal amount;
    private Integer term;
    private String firstName;
    private String lastName;
    private String middleName;
    //enum
    private LocalDate birthDate;
    private String passportSeries;
    private String passportNumber;
    private LocalDate passportIssueDate;
    private String passportIssueBranch;
    //enum
    private Integer dependentAmount;
    //class
    private String account;
    private Boolean isInsuranceEnabled;
    private Boolean isSalaryClient;
}
