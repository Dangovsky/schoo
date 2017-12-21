package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EducationalContractEntityPK implements Serializable {
    private int apprenticeId;
    private int courseId;

    @Column(name = "apprenticeID", nullable = false)
    @Id
    public int getApprenticeId() {
        return apprenticeId;
    }

    public void setApprenticeId(int apprenticeId) {
        this.apprenticeId = apprenticeId;
    }

    @Column(name = "courseID", nullable = false)
    @Id
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EducationalContractEntityPK that = (EducationalContractEntityPK) o;

        if (apprenticeId != that.apprenticeId) return false;
        if (courseId != that.courseId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = apprenticeId;
        result = 31 * result + courseId;
        return result;
    }
}
