package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "educational_contract", schema = "school")
@IdClass(EducationalContractEntityPK.class)
public class EducationalContractEntity {
    private int apprenticeId;
    private int courseId;
    private Date condusionDate;
    private int price;
    private String paymentInformation;
    private ApprenticeEntity apprenticeByApprenticeId;
    private CourseEntity courseByCourseId;

    @Id
    @Column(name = "apprenticeID", nullable = false)
    public int getApprenticeId() {
        return apprenticeId;
    }

    public void setApprenticeId(int apprenticeId) {
        this.apprenticeId = apprenticeId;
    }

    @Id
    @Column(name = "courseID", nullable = false)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "condusion_date", nullable = false)
    public Date getCondusionDate() {
        return condusionDate;
    }

    public void setCondusionDate(Date condusionDate) {
        this.condusionDate = condusionDate;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "payment_information", nullable = false, length = 20)
    public String getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation(String paymentInformation) {
        this.paymentInformation = paymentInformation;
    }

    public EducationalContractEntity(){}

    public EducationalContractEntity(int apprenticeId, int courseId, Date condusionDate, int price, String paymentInformation){
        this.apprenticeId = apprenticeId;
        this.courseId = courseId;
        this.condusionDate = condusionDate;
        this.price = price;
        this.paymentInformation = paymentInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EducationalContractEntity that = (EducationalContractEntity) o;

        if (apprenticeId != that.apprenticeId) return false;
        if (courseId != that.courseId) return false;
        if (price != that.price) return false;
        if (condusionDate != null ? !condusionDate.equals(that.condusionDate) : that.condusionDate != null)
            return false;
        if (paymentInformation != null ? !paymentInformation.equals(that.paymentInformation) : that.paymentInformation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = apprenticeId;
        result = 31 * result + courseId;
        result = 31 * result + (condusionDate != null ? condusionDate.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (paymentInformation != null ? paymentInformation.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "apprenticeID", referencedColumnName = "ID", nullable = false, insertable=false, updatable=false)
    public ApprenticeEntity getApprenticeByApprenticeId() {
        return apprenticeByApprenticeId;
    }

    public void setApprenticeByApprenticeId(ApprenticeEntity apprenticeByApprenticeId) {
        this.apprenticeByApprenticeId = apprenticeByApprenticeId;
    }

    @ManyToOne
    @JoinColumn(name = "courseID", referencedColumnName = "ID", nullable = false, insertable=false, updatable=false)
    public CourseEntity getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(CourseEntity courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }
}
