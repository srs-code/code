import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * @author shashi.ranjan
 */
@Data
public class Meeting {
    private final String meetingId;
    private String summary;
    private String adminEmpId;
    private List<Employee> empid;
    String roomId;
    private String starttime;
    private String endtime;


    public Meeting(){
        meetingId = UUID.randomUUID().toString();
    }
}
