package bean;

import dao.RoomDao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "RoomBean", eager = true)
@RequestScoped
public class RoomBean extends RoomDao {
    private int id;
    private String information;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void Add(){
        super.Add(information, null);
    }

    public void Update(){
        super.Update(id, information, null);
    }
}
