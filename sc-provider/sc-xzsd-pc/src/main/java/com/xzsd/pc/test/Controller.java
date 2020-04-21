package com.xzsd.pc.test;

import com.neusoft.core.restful.AppResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class Controller {

    @PostMapping("test")
    public AppResponse test(int version){
        String a = String.valueOf(version);


        return AppResponse.success("1", version);
    }

}
