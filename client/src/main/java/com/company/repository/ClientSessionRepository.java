package com.company.repository;

import com.company.api.Session;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ClientSessionRepository {
    private Session session;
}
