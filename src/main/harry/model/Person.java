package harry.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.CascadeType;

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * Person class gives basic data 
 */
@Entity
@ToString(includeFieldNames = true)
@Data
public class Person implements Serializable {
    static final long serialVersionUID = 75L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private Address address;
    private String telephone;
    private String email;
    private Date birthday;
    private String pesel;
    private String nip;
    private String accountNumber;
    private String cvFilepath;

    @OneToMany(cascade=CascadeType.MERGE)                                                  
    @JoinTable(
        name="contractor_groups",                                
        joinColumns= { @JoinColumn(name="contractor_fk") },
        inverseJoinColumns = @JoinColumn(name="group_fk")
    )
    @OrderBy("id")
    private List<Group> groups;
}
