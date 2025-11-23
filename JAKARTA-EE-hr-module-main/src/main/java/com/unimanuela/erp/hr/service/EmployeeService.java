package com.unimanuela.erp.hr.service;

import com.unimanuela.erp.hr.entity.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class EmployeeService {
    @PersistenceContext(unitName = "erp-hr-pu")
    private EntityManager em;

    public List<Employee> getAllEmployees() {
        return em.createQuery("SELECT e FROM Employee e ORDER BY e.lastName", Employee.class).getResultList();
    }

    @Transactional
    public void saveEmployee(Employee employee) {
        if (employee.getId() == null) {
            em.persist(employee); // Crea un nuevo empleado
        } else {
            em.merge(employee); // Actualiza un empleado existente
        }
    }

    @Transactional
    public void deleteEmployee(Long employeeId) {
        Employee employeeToDelete = em.find(Employee.class, employeeId);
        if (employeeToDelete != null) {
            em.remove(employeeToDelete);
        }
    }
}
