package chu.todo.controller;

import chu.todo.service.LoginService;
import chu.todo.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    public Boolean login(MemberVo vo) throws InterruptedException {
        //檢查 物件是否為 null or 不合法
        if (vo.getName() ==null) {
            return false;
        }
        if (vo.getPassword() == null) {
                return false;
            }
        // 進入 servive
        return loginService.login(vo);
    }

}
