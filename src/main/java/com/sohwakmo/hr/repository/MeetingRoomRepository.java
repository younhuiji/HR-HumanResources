package com.sohwakmo.hr.repository;

import com.sohwakmo.hr.domain.MeetingRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Integer> {
    List<MeetingRoom> findAll();

    List<MeetingRoom> findByAttendeeOrEmployeeNo(String attendee, String employeeNo);

    List<MeetingRoom> findByEmployeeNoOrderByMeetingRoomNoDesc(String employeeNo);

    List<MeetingRoom> findByOrderByMeetingRoomNoDesc();

    List<MeetingRoom> findByReserveDateOrderByRoomNameAscStartTimeAsc(String date);
    List<MeetingRoom> findByEmployeeNoAndReserveDateContaining(String employeeNo, String formatedNow);
}
