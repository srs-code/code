import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author shashi.ranjan
 */
public class MeetingContoller {

    @Autowired
    MeetingService meetingService;
    @Autowired
    EmployeeService employeeService;


    @PutMapping( "/createMeeting" )
    public @ResponseBody String  createMeeting(@RequestBody MeetingInvites meetingInvites) {
        if (employeeService.isValidEmp(meetingInvites.adminId)) {
            meetingService.createMeeting(meetingInvites);

        } else
            return "not a valid employee";


        return "meeting sucessfully created";
    }



    @GetMapping( "/listMeeting" )
    public @ResponseBody String listMeetingForEmployee(String empId) {
        return meetingService.ListMeetingByEmp(empId).toString();
    }



    @PutMapping( "/addEmployee" )
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

}
