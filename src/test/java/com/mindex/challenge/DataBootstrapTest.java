package com.mindex.challenge;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataBootstrapTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompensationRepository compensationRepository;

    String testId;

    @Before
    public void setup() {
        testId = "16a596ae-edd3-4847-99fe-c4518e82c86f";
    }

    @Test
    public void employeeRepositoryTest() {
        Employee employee = employeeRepository.findByEmployeeId(testId);
        assertNotNull(employee);
        assertEquals("John", employee.getFirstName());
        assertEquals("Lennon", employee.getLastName());
        assertEquals("Development Manager", employee.getPosition());
        assertEquals("Engineering", employee.getDepartment());
    }

    @Test
    public void compensationRepositoryTest() {

        Compensation actual = compensationRepository.findByEmployeeEmployeeId(testId);
        assertNotNull(actual);
        assertEquals(100000, actual.getSalary());
        assertEquals(LocalDate.of(2024, 01, 31), actual.getEffectiveDate());
    }
}