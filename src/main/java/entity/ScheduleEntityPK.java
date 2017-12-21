package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Time;

public class ScheduleEntityPK implements Serializable {
    private int courseId;
    private int roomId;
    private Time startTime;

    @Column(name = "courseID", nullable = false)
    @Id
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Column(name = "roomID", nullable = false)
    @Id
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Column(name = "start_time", nullable = false)
    @Id
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScheduleEntityPK that = (ScheduleEntityPK) o;

        if (courseId != that.courseId) return false;
        if (roomId != that.roomId) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId;
        result = 31 * result + roomId;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        return result;
    }
}
