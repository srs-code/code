import java.util.List;

/**
 * @author shashi.ranjan
 */
public interface MeetingService {

    public void createMeeting(MeetingInvites meetingInvites);

    public List<Meeting> ListMeetingByEmp(String empid);

    public Integer getRoomCount();



}
