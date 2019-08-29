package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> selectAll();
    Employee getEmployee(@Param("id") int id);
    void addEmployee(@Param("employee") Employee employee);
    void insertEmployee(@Param("employee") Employee employee);
    void deleteEmployee(@Param("id") int id);
}
