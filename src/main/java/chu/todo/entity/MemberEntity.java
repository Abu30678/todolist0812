package chu.todo.entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Table(name = "MEMBER")
@Entity
@ToString
// extends GenericEntity 用來幹嘛 ?
public class MemberEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //使用資料庫自動增加策略
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
}
