package chu.todo.repo;

import chu.todo.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepo extends JpaRepository<MemberEntity, Integer> {

    // select * from member where id =? and password =?
    Optional<MemberEntity> findByIdAndPassword(Integer id, String password);

    // select * from member where name =? and password =?
    Optional<MemberEntity> findByNameAndPassword(String name, String password);

    // select * from member where name like %?%
    List<MemberEntity> findByNameContaining(String name);

    void deleteByName(String name); //不知道什麼意思
}
