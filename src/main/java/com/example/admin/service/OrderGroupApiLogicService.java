package com.example.admin.service;

import com.example.admin.ifs.CrudInterface;
import com.example.admin.model.network.Header;
import com.example.admin.model.network.request.OrderGroupApiRequest;
import com.example.admin.model.network.response.OrderGroupApiResponse;
import com.example.admin.repository.OrderGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderGroupApiLogicService implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

    private final OrderGroupRepository orderGroupRepository;

    @Override
    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {
        return null;
    }

    @Override
    public Header<OrderGroupApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }
}
