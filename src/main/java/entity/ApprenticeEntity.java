package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "apprentice", schema = "school")
public class ApprenticeEntity {
    private int id;
    private String name;
    private Integer contactNumber;
    private Collection<EducationalContractEntity> educationalContractsById;

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

    public ApprenticeEntity(){}

    public ApprenticeEntity(String name, Integer contactNumber, Collection<EducationalContractEntity> educationalContracts){
        this.name = name;
        this.contactNumber = contactNumber;
        this.educationalContractsById = educationalContracts;
    }

    public ApprenticeEntity(int id, String name, Integer contactNumber, Collection<EducationalContractEntity> educationalContracts){
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.educationalContractsById = educationalContracts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApprenticeEntity that = (ApprenticeEntity) o;

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

    @OneToMany(mappedBy = "apprenticeByApprenticeId")
    public Collection<EducationalContractEntity> getEducationalContractsById() {
        return educationalContractsById;
    }

    public void setEducationalContractsById(Collection<EducationalContractEntity> educationalContractsById) {
        this.educationalContractsById = educationalContractsById;
    }
}
