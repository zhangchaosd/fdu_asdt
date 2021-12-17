package com.zhangchao.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.zhangchao.employee.entity.Employee;
import com.zhangchao.employee.repository.EmployeeRepository;

import java.util.List;

@SpringBootApplication
public class EmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(EmployeeRepository employeeRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Employee employee = new Employee();
                employee.setUsername("admin");
                List<Employee> employeeList = employeeRepository.findEmployeeByUsername(employee.getUsername());
                if (employeeList == null || employeeList.isEmpty()) {
                    employee.setPhone("11122223333");
                    employeeRepository.save(employee);
                }
            }
        };
    }
}
