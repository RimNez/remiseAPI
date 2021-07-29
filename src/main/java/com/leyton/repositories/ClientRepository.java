package com.leyton.repositories;

import com.leyton.models.Client;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ClientRepository extends ElasticsearchRepository<Client,String> {

}
