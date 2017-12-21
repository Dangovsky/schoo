package bean;

import dao.TeacherDao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "TeacherBean", eager = true)
@RequestScoped
public class TeacherBean extends TeacherDao {
    private int id;
    private String name;
    private Integer contactNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Integer contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void Add(){
        super.Add(name, contactNumber,null);
    }

    public void Update(){
        super.Update(id, name, contactNumber, null);
    }
}
