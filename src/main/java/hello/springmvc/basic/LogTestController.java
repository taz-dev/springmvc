package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController
//@Controller는 반환 값이 String이면 뷰 이름으로 인식된다. 그래서 뷰를 찾고 뷰가 랜더링 된다.
//@RestController는 반환 값으로 뷰를 찾는 것이 아니라, HTTP 메시지 바디에 바로 입력한다. 따라서 실행 결과로 ok 메세지를 받을 수 있다.
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass()); //@Slf4j

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        //System.out.println("name = " + name);

        //로그 레벨 설정(application.yml)을 변경
        //LEVEL : TRACE > DEBUG > INFO > WARN > ERROR
        //개발 서버는 DEBUG 출력, 운영 서버는 INFO 출력
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
