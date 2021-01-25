package com.example.admin.controller.api;

import com.example.admin.ifs.CrudInterface;
import com.example.admin.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserApiController implements CrudInterface {

    @Override
    @PostMapping("")
    public Header create() {
        return null;
    }

    @Override
    @GetMapping("{id}")
    public Header read(@PathVariable Long id) {
        return null;
    }

    @Override
    @PutMapping("{id}")
    public Header update(@PathVariable Long id) {
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return null;
    }

}
