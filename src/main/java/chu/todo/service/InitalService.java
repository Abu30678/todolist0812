package chu.todo.service;

import chu.todo.entity.MemberEntity;
import chu.todo.repo.MemberRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Slf4j
public class InitalService {

    @Autowired
    private MemberRepo memberRepo;

    @EventListener(ApplicationReadyEvent.class)  // 19~22用來 ?
    public void doForDbInitialData() {
        initMemberData();  //這個方法負責檢查，並初始化 會員資料庫;如果資料庫中 沒有任何會員資料，則新增 預設的會員。
//         ....
    }

    public void initMemberData() {
        List<MemberEntity> min = memberRepo.findByNameContaining("");
        log.info("count:" + min.size());

        if(memberRepo.count() ==0) {  //如果為 0（即資料庫中沒有會員資料），則執行接下來的初始化動作。
            MemberEntity member01 = new MemberEntity();
            member01.setName("Chu");
            member01.setId(01);
            member01.setPassword("sasa");
            member01.setEmail("chu@");
            memberRepo.save(member01);
        }
    }
}
