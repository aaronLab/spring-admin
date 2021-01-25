package com.example.admin.controller;

import com.example.admin.model.SearchParam;
import com.example.admin.model.network.Header;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GetController {

    @GetMapping(value = "/getMethod")
    public String getRequest() {
        return "getRequest";
    }

    @GetMapping(value = "/getParameter")
    public String getParameter(
            @RequestParam String id,
            @RequestParam(value = "password") String pwd
    ) {
        System.out.println("id: " + id);
        System.out.println("pw: " + pwd);
        return id + pwd;
    }

    @GetMapping(value = "/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader() {
        return Header.builder().resultCode("OK").description("OK").build();
    }

}
