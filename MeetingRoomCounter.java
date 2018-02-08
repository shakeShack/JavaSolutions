/*Given a list of meeting times, checks if any of them overlaps.
The follow-up question is to return the minimum number of rooms
required to accommodate all the meetings
Example times: (1, 4), (3, 6), (8, 9), (2, 6)

Refer: http://blog.gainlo.co/index.php/2016/07/12/meeting-room-scheduling-problem/*/
import java.util.*;

public class MeetingRoomCounter {
  public static void main (String[] args){
    List<Schedule> meetings = new ArrayList<>();
    meetings.add(new Schedule(1,4));
    meetings.add(new Schedule(3,6));
    meetings.add(new Schedule(8,9));
    meetings.add(new Schedule(2,6));

    System.out.println(roomsRequired(meetings));
  }

  static int roomsRequired(List<Schedule> meetings){
    if (meetings == null || meetings.isEmpty()) return 0;

    //populate the map with each hour added to counter for all meetings encountered.
    Map<Integer, Integer> timeToCountMap = new HashMap<>();
    for(Schedule schedule : meetings){
      int i = schedule.start;
      while(i <= schedule.end){
        Integer count = timeToCountMap.get(i);
        if(count == null){
          timeToCountMap.put(i, 1);
        } else {
          timeToCountMap.put(i, count+1);
        }
        i++;
      }
    }

    int max = 0;
    for(int count : timeToCountMap.values()){
      max = max > count ? max : count;
    }

    return max;
  }
}

class Schedule {
  int start;
  int end;

  Schedule(int start, int end){
    this.start = start;
    this.end = end;
  }
}
