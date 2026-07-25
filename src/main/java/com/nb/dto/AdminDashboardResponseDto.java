package com.nb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminDashboardResponseDto {

    private long totalDoctors;

    private long totalPatients;

    private long totalQueries;

    private long pendingQueries;

    private long answeredQueries;

    private long closedQueries;

}