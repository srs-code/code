import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shashi.ranjan
 */
public class MeetingRoom {
//    Assumption metting can be booked only for a hour
    String roomId;
    List<String> startimeList = new ArrayList<>();

    public boolean isAvailabe(String startime , String endtime){

        for(String start: startimeList){
            if(start == startime)
                return false;
        }
        return true;
    }
}
