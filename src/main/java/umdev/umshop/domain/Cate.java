package umdev.umshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Cate {

    @Id @GeneratedValue
    @Column(name = "cate_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "cate", cascade = CascadeType.ALL)
    private List<CateItem> cateItems = new ArrayList<>();

}
