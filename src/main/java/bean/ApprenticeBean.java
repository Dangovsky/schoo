package bean;

import dao.ApprenticeDao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "ApprenticeBean", eager = true)
@RequestScoped
public class ApprenticeBean extends ApprenticeDao {
    private int id;
    private String name;
    private Integer contactNumber;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void Add(){
        super.Add(name, contactNumber, null);
    }

    public void Update(){
        super.Update(id, name, contactNumber, null);
    }
}
