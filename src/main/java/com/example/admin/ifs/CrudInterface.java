package com.example.admin.ifs;

import com.example.admin.model.network.Header;

public interface CrudInterface {

    Header create(); // todo request obj

    Header read(Long id);

    Header update(Long id);

    Header delete(Long id);

}
