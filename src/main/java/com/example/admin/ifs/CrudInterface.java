package com.example.admin.ifs;

import com.example.admin.model.network.Header;

public interface CrudInterface<Req, Res> {

    Header<Res> create(Req request); // todo request obj

    Header<Res> read(Long id);

    Header<Res> update(Req request);

    Header delete(Long id);

}
