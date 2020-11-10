package com.wcc.alelo.api.Client.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.wcc.alelo.api.Client.Entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client,Integer> {
}
