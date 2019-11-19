import lombok.Data;

import java.util.List;

/**
 * @author shashi.ranjan
 */
@Data
public class MeetingInvites {
    String adminId;
    String starttime;
    String endtime;
    List<Employee> employeeList;
    String meetingRoomId;
}
