package bean;

import dao.ApprenticeDao;
import dao.CourseDao;
import dao.EducationalContractDao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Date;

@ManagedBean(name = "EducationContractBean", eager = true)
@RequestScoped
public class EducationContractBean extends EducationalContractDao{
    private int apprenticeId;
    private int courseId;
    private String condusionDate;
    private int price;
    private String paymentInformation;
    private String apprrenticeName;
    private String courseName;

    public int getApprenticeId() {
        return apprenticeId;
    }

    public void setApprenticeId(int apprenticeId) {
        this.apprenticeId = apprenticeId;
        ApprenticeDao ad = new ApprenticeDao();
        apprrenticeName = ad.getById(apprenticeId).get(0).getName();
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
        CourseDao cd = new CourseDao();
        courseName = cd.getById(courseId).get(0).getName();
    }

    public String getCondusionDate() {
        return condusionDate;
    }

    public void setCondusionDate(String condusionDate) {
        this.condusionDate = condusionDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation(String paymentInformation) {
        this.paymentInformation = paymentInformation;
    }

    public String getApprrenticeName() {
        return apprrenticeName;
    }

    public void setApprrenticeName(String apprrenticeName) {
        this.apprrenticeName = apprrenticeName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void Add(){
        super.Add(apprenticeId,courseId,Date.valueOf(condusionDate),price,paymentInformation);
    }

    public void Update(){
        super.Update(apprenticeId,courseId,Date.valueOf(condusionDate),price,paymentInformation);
    }
}
