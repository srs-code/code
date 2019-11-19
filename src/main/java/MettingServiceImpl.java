import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shashi.ranjan
 */
public class MettingServiceImpl implements MeetingService {

    Map<String, Meeting> meetingData = new HashMap<>();
    Map<String, List<Meeting>> empMeetingData = new HashMap<>();
    Map<String, List<String>> meetingRooms = new HashMap<>();

    public void createMeeting(MeetingInvites meetingInvites) {

        Meeting meeting = new Meeting();
        meeting.setAdminEmpId(meetingInvites.adminId);
        meeting.setStarttime(meetingInvites.starttime);
        meeting.setEndtime(meetingInvites.endtime);
        if (isMettingRoomAvilable(meetingInvites.meetingRoomId, meetingInvites.starttime, meetingInvites.endtime)) {
            meeting.setRoomId(meetingInvites.meetingRoomId);
        } else {
            if (assignDefaultRoomAvilable(meetingInvites.starttime, meetingInvites.endtime) != null) {
                meeting.setRoomId(assignDefaultRoomAvilable(meetingInvites.starttime, meetingInvites.endtime));
            } else {
//                         throw an exception
            }


        }

        meeting.setEmpid(meetingInvites.employeeList);
        sentNotification(meeting);
        meetingData.put(meeting.getMeetingId(), meeting);
        for (Employee employee : meetingInvites.employeeList) {
            if (empMeetingData.get(employee.getEmpId()) == null) {
                empMeetingData.put(employee.getEmpId(), Arrays.asList(meeting));
            } else {
                List<Meeting> list = empMeetingData.get(employee.getEmpId());
                list.add(meeting);
                empMeetingData.put(employee.getEmpId(), list);
            }
        }
    }

    public List<Meeting> ListMeetingByEmp(String empid) {
        return empMeetingData.get(empid);
    }

    private boolean isMettingRoomAvilable(String roomId, String starttime, String endtime) {
        // check availbality of rooms
        if (meetingRooms.get(roomId) == null) {
            meetingRooms.put(roomId, Arrays.asList(starttime));
            return true;
        } else {
            List<String> startimeList = meetingRooms.get(roomId);
            for (String start : startimeList) {
                if (start == starttime)
                    return false;
            }
            return true;

        }
    }

    public Integer getRoomCount() {
        return meetingRooms.size();
    }


    private String assignDefaultRoomAvilable(String starttime, String endtime) {
        // check availbality of rooms
        return "id";
    }

    public void sentNotification(Meeting meeting) {

    }
}
