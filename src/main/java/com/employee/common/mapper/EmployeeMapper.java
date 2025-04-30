package com.employee.common.mapper;

import com.employee.dao.Employee;
import com.employee.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring",
    uses = {LocalDateMapper.class})
public interface EmployeeMapper {
    EmployeeDto employeeDaoToDto(Employee employee);

    Employee employeeDtoToDao(EmployeeDto employeeDto);

    @Mapping(target = "id", ignore = true)
    void updateEmployeeFromDto(
        EmployeeDto employeeDto,
        @MappingTarget Employee employee
    );

}
