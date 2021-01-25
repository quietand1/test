package dao;

import bean.Employee;

/**
 * @author quiet
 * @create 2021-01-14  10:06
 */
public interface MybatisEmployee {

    public Employee getEmpById(Integer id);

    public void addEmp(Employee employee);

    public void updateEmp(Employee employee);
}
