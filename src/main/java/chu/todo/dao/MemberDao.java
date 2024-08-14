package chu.todo.dao;

import chu.todo.entity.MemberEntity;
import chu.todo.repo.MemberRepo;
import chu.todo.vo.MemberVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.logging.ErrorManager;

@Repository
@Slf4j
public class MemberDao {

    @Autowired
    private MemberRepo memberRepo;

    //MVC
    // Model -> DAO 與資料庫互動層
    public MemberVo queryUser(String name, String password) {
        MemberVo vo = new MemberVo();
        MemberEntity member;
        try {
            // try catch 主要是針對 連線問題 與 資料庫查詢問題
            // JDBC 與資料庫互動
            // select * from member where id = 'id' and password = 'password'
            Optional<MemberEntity>memberOpt = memberRepo.findByNameAndPassword(name ,password);

            if (memberOpt.isPresent()) {  // isPresent() 判斷 Optional裡面 是否有值
                member = memberOpt.get(); //通常會搭配.get() 取出值
            } else {
                member = new MemberEntity();
            }
        } catch (Exception e) {  // Try Catch
            log.error(e.getMessage());  //@Slf4j
            member = new MemberEntity();
        }
        BeanUtils.copyProperties(member, vo);
        return vo;
    }

}
