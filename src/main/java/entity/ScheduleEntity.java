package entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "schedule", schema = "school")
@IdClass(ScheduleEntityPK.class)
public class ScheduleEntity {
    private int courseId;
    private int roomId;
    private Time startTime;
    private CourseEntity courseByCourseId;
    private RoomEntity roomByRoomId;

    @Id
    @Column(name = "courseID", nullable = false)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Id
    @Column(name = "roomID", nullable = false)
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Id
    @Column(name = "start_time", nullable = false)
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public ScheduleEntity(){}

    public ScheduleEntity(int courseId, int roomId, Time startTime){
        this.courseId = courseId;
        this.roomId = roomId;
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScheduleEntity that = (ScheduleEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "courseID", referencedColumnName = "ID", nullable = false, insertable=false, updatable=false)
    public CourseEntity getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(CourseEntity courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }

    @ManyToOne
    @JoinColumn(name = "roomID", referencedColumnName = "ID", nullable = false, insertable=false, updatable=false)
    public RoomEntity getRoomByRoomId() {
        return roomByRoomId;
    }

    public void setRoomByRoomId(RoomEntity roomByRoomId) {
        this.roomByRoomId = roomByRoomId;
    }
}
