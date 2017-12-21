package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "room", schema = "school")
public class RoomEntity {
    private int id;
    private String information;
    private Collection<ScheduleEntity> schedulesById;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "information", nullable = true, length = -1)
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public RoomEntity(){}

    public RoomEntity(String information, Collection<ScheduleEntity> schedules){
        this.information = information;
        this.schedulesById = schedules;
    }

    public RoomEntity(int id, String information, Collection<ScheduleEntity> schedules){
        this.id = id;
        this.information = information;
        this.schedulesById = schedules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomEntity that = (RoomEntity) o;

        if (id != that.id) return false;
        if (information != null ? !information.equals(that.information) : that.information != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (information != null ? information.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roomByRoomId")
    public Collection<ScheduleEntity> getSchedulesById() {
        return schedulesById;
    }

    public void setSchedulesById(Collection<ScheduleEntity> schedulesById) {
        this.schedulesById = schedulesById;
    }
}
