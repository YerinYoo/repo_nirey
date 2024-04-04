package com.recorded.infra.etc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EtcController { 

	//포트폴리오 페이지 연결 컨트롤러
    @RequestMapping(value = "/pfIndex")
    public String pfIndex() throws Exception {
        return "etc/pfIndex"; 
    }
    
	//사용자 화면 > My Page > Dashboard컨트롤러
    @RequestMapping(value = "/dashboard")
    public String dashboard() throws Exception {
        return "usr/infra/v1/dashboard"; 
    }

    
}
