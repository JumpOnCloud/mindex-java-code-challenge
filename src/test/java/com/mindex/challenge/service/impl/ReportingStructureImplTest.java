package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructureImplTest {

    @Autowired
    ReportingStructureService reportingStructureService;

    @Autowired
    EmployeeService employeeService;

    @BeforeEach
    void setup() {
        assertNotNull(reportingStructureService);
        assertNotNull(employeeService);
    }

    // TODO: mock and inject mocks?

    @DisplayName("Given getReportingStructure()")
    class GivenGetReportingStructure {

        @Nested
        @DisplayName("When provided a String employeeId and the employee has no reports")
        class WhenProvidedAStringEmployeeIdAndTheEmployeeHasNoReports {

            Employee employee = new Employee();

            @BeforeEach
            void setup() {
                employee.setEmployeeId("id");
                doReturn(employee).when(employeeService).read(anyString());
            }

            @Test
            @DisplayName("Then return a ReportingStructure with numberOfReports set to 0")
            void thenReturnAReportingStructureWithNumberOfReportsSetTo0() {

                String input = "id";

                ReportingStructure expected = new ReportingStructure();
                expected.setEmployee(employee);
                expected.setNumberOfReports(0);

                ReportingStructure actual = reportingStructureService.getReportingStructure(input);
                assertEquals(expected, actual);
            }
        }
    }
}