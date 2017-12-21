package entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Collection;

@Entity
@Table(name = "course", schema = "school")
public class CourseEntity {
    private int id;
    private String name;
    private Time durability;
    private Integer teacherId;
    private TeacherEntity teacherByTeacherId;
    private Collection<EducationalContractEntity> educationalContractsById;
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
    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "durability", nullable = false)
    public Time getDurability() {
        return durability;
    }

    public void setDurability(Time durability) {
        this.durability = durability;
    }

    @Basic
    @Column(name = "teacherID", nullable = true)
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public CourseEntity(){}

    public CourseEntity(String name, Time durability, Integer teacherId, Collection<EducationalContractEntity> educationalContracts, Collection<ScheduleEntity> schedule){
        this.name = name;
        this.durability = durability;
        this.teacherId = teacherId;
        this.educationalContractsById = educationalContracts;
        this.schedulesById = schedule;
    }

    public CourseEntity(int id,String name, Time durability, Integer teacherId, Collection<EducationalContractEntity> educationalContracts, Collection<ScheduleEntity> schedule){
        this.id = id;
        this.name = name;
        this.durability = durability;
        this.teacherId = teacherId;
        this.educationalContractsById = educationalContracts;
        this.schedulesById = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseEntity that = (CourseEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (durability != null ? !durability.equals(that.durability) : that.durability != null) return false;
        if (teacherId != null ? !teacherId.equals(that.teacherId) : that.teacherId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (durability != null ? durability.hashCode() : 0);
        result = 31 * result + (teacherId != null ? teacherId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "teacherID", referencedColumnName = "ID", insertable=false, updatable=false)
    public TeacherEntity getTeacherByTeacherId() {
        return teacherByTeacherId;
    }

    public void setTeacherByTeacherId(TeacherEntity teacherByTeacherId) {
        this.teacherByTeacherId = teacherByTeacherId;
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<EducationalContractEntity> getEducationalContractsById() {
        return educationalContractsById;
    }

    public void setEducationalContractsById(Collection<EducationalContractEntity> educationalContractsById) {
        this.educationalContractsById = educationalContractsById;
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<ScheduleEntity> getSchedulesById() {
        return schedulesById;
    }

    public void setSchedulesById(Collection<ScheduleEntity> schedulesById) {
        this.schedulesById = schedulesById;
    }
}
