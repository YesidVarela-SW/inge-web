package com.unimanuela.erp.hr.web;

import com.unimanuela.erp.hr.entity.Employee;
import com.unimanuela.erp.hr.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("employeeBean")
@ViewScoped
public class EmployeeBean implements Serializable {

    @Inject
    private EmployeeService employeeService;

    private List<Employee> employeeList;
    private Employee selectedEmployee;

    @PostConstruct
    public void init() {
        employeeList = employeeService.getAllEmployees();
        selectedEmployee = new Employee();
    }

    public void save() {
        employeeService.saveEmployee(selectedEmployee);
        init(); // Recarga la lista y reinicia el formulario
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado guardado con éxito."));
    }

    public void delete(Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        init(); // Recarga la lista
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Empleado eliminado."));
    }

    public void prepareNew() {
        selectedEmployee = new Employee();
    }

    // --- Getters y Setters ---

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(Employee selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }

}
