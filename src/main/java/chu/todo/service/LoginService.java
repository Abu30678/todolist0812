package chu.todo.service;

import chu.todo.dao.MemberDao;
import chu.todo.vo.MemberVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginService {

    @Autowired
    private MemberDao memberDao;  //@Service

    public boolean login(MemberVo memberFromUI) throws InterruptedException {
        log.info("Login service called: {}", memberFromUI);

        boolean loginSuccess = true;
        try {
            MemberVo memberFromDB = memberDao.queryUser(memberFromUI.getName(), memberFromUI.getPassword());  // memberDao.queryUser() @Service
            log.debug("memberFromDB: {}", memberFromDB);
            log.debug("memberFromUI name:{} password:{}", memberFromUI.getName(), memberFromUI.getPassword());
            log.debug("memberFromDB name:{} password:{}", memberFromDB.getName(), memberFromDB.getPassword());
            if (!memberFromUI.getName().equals(memberFromDB.getName())) {
                loginSuccess = false;
            }
            if (!memberFromUI.getName().equals(memberFromDB.getName())) {
                loginSuccess = false;
            }
        } catch (Exception e) {
            log.error("Login failed: {}", e.getMessage());
            loginSuccess = false;
            throw e;
        }

        log.info("Login result: {}", loginSuccess);
        return loginSuccess;
    }

    public boolean login(String id, String password) {return false;}
}
