package bean;

import dao.CourseDao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Time;

@ManagedBean(name = "CourseBean", eager = true)
@RequestScoped
public class CourseBean extends CourseDao{
    private int id;
    private String name;
    private String durability;
    private Integer teacherId;

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

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public String getDurability() {

        return durability;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public void Add(){
        super.Add(name,Time.valueOf(durability),teacherId,null,null);
    }

    public void Update(){
        super.Update(id,name,Time.valueOf(durability),teacherId,null,null);
    }
}
