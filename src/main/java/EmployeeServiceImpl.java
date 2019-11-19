import java.util.HashMap;
import java.util.Map;

/**
 * @author shashi.ranjan
 */
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, Employee> empData = new HashMap<String, Employee>();

    public void addEmployee(Employee employee) {
        empData.put(employee.getEmpId(), employee);

    }

    public boolean isValidEmp(String empId) {
        if(empData.get(empId) != null)
            return true;
        else return false;
    }
}
