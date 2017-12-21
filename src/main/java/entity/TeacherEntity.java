package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "teacher", schema = "school")
public class TeacherEntity {
    private int id;
    private String name;
    private Integer contactNumber;
    private Collection<CourseEntity> coursesById;

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
    @Column(name = "contact_number", nullable = true)
    public Integer getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Integer contactNumber) {
        this.contactNumber = contactNumber;
    }

    public TeacherEntity(){}

    public TeacherEntity(String name, Integer contactNumber, Collection<CourseEntity> courses){
        this.name = name;
        this.contactNumber = contactNumber;
        this.coursesById = courses;
    }

    public TeacherEntity(int id, String name, Integer contactNumber, Collection<CourseEntity> courses){
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.coursesById = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherEntity that = (TeacherEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (contactNumber != null ? !contactNumber.equals(that.contactNumber) : that.contactNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (contactNumber != null ? contactNumber.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "teacherByTeacherId")
    public Collection<CourseEntity> getCoursesById() {
        return coursesById;
    }

    public void setCoursesById(Collection<CourseEntity> coursesById) {
        this.coursesById = coursesById;
    }
}
