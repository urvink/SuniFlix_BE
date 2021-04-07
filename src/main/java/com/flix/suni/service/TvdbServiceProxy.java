package com.flix.suni.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "tvdb-service")
public interface TvdbServiceProxy extends TvdbService {

}
