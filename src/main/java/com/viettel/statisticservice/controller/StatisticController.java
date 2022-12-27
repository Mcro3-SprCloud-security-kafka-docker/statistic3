package com.viettel.statisticservice.controller;

import com.viettel.statisticservice.service.StatisticService;
import com.viettel.statisticservice.service.dto.StatisticDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "")
@Tag(name = "Api entry for statistics", description = "Containing all api entries for statistics operation")
public class StatisticController {
    @Autowired
    private StatisticService statisticService;

    //    @PreAuthorize(value = "hasRole('ADMIN')  && isAuthenticated()")
    @GetMapping(value = "/statistics")
    @Operation(description = "Get all statistic", responses = {@ApiResponse(responseCode = "200", description = "Get statistics successfully")})
    public ResponseEntity<List<StatisticDTO>> getAllStatistics() {
        List<StatisticDTO> result = statisticService.getAllStatistic();
        return ResponseEntity.ok().body(result);
    }

    // i can pass bearer token to here to check role, if i dont pass, i cannot get role
//    @PreAuthorize(value = "(#oauth2.hasScope('statistic') && hasRole('ADMIN')) && isAuthenticated()")
//    @PreAuthorize(value = "(#oauth2.hasScope('statistic') || hasRole('ADMIN')) && isAuthenticated()")
    @PostMapping(value = "/statistic")
    @Operation(description = "Save statistic", responses = {@ApiResponse(responseCode = "200", description = "Save statistics successfully")})
    public ResponseEntity<Long> addStatistic(@RequestBody StatisticDTO statisticDTO) throws Exception {
        return ResponseEntity.ok().body(statisticService.addStatistic(statisticDTO));
    }

    @GetMapping(value = "/me")
    public Principal getPrincipals(Principal principal) {
        return principal;
    }
}
