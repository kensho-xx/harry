package harry.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;
import lombok.ToString;


@Entity
@ToString(includeFieldNames=true)
@Data
public class Group implements Serializable {
    static final long serialVersionUID = 80L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    //    private List<Project> projects;
}
