package bean;

import dao.ScheduleDao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Time;

@ManagedBean(name = "ScheduleBean", eager = true)
@RequestScoped
public class ScheduleBean extends ScheduleDao {
    private int courseId;
    private int roomId;
    private String startTime;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String  getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void Add(){
        super.Add(courseId,roomId,Time.valueOf(startTime));
    }
}
