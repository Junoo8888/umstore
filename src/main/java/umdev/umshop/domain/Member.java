package umdev.umshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter@Setter@ToString
public class Member {

    @Id
    @Column(name="member_id")
    private String id;

    private String name;

    @JsonIgnore
    private String password;

    @Embedded
    private Address address;

   /* @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();// null 이되지 않게*/


}
