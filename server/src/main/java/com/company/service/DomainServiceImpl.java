package com.company.service;

import com.company.api.DomainRepository;
import com.company.api.DomainService;
import com.company.model.Domain;

public class DomainServiceImpl implements DomainService {
    private DomainRepository domainRepository;

    public DomainServiceImpl(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    @Override
    public Domain getDomain() {
        return domainRepository.getDomain();
    }
}