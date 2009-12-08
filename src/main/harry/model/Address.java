package harry.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;


@Entity
@ToString(includeFieldNames=true)
@Data
public class Address implements Serializable {
    static final long serialVersionUID = 76L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String country;
    private String city;
    private String street;
    private String number;
    private String postalCode;
}
