package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId,Integer.MAX_VALUE);
        calendar =new ArrayList<>();
        // The inboxCapacity is equal to the maximum value an integer can store.
    }

    public void addMeeting(Meeting meeting){
        calendar.add(meeting);
        //add the meeting to calendar
    }

    public int findMaxMeetings(){
        List<Meeting> tmp = calendar;
        Collections.sort(tmp,(a,b)->(a.getStartTime().compareTo(b.getStartTime())>0?1:-1));
        LocalTime t = tmp.get(0).getEndTime();
        int count=1;
        for(int i=1;i<tmp.size();i++){
            if(tmp.get(i).getStartTime().compareTo(t)>0){
              count++;
               t=tmp.get(i).getEndTime();
              System.out.println(count);
            }
        }
//        for(int i=0;i< tmp.size();i++){
////            System.out.println(tmp.get(i).getStartTime() +" "+tmp.get(i).getEndTime());
////        }
        return count;
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

    }
}
