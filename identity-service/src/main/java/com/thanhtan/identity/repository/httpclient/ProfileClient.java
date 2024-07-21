package com.thanhtan.identity.repository.httpclient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "profile-service", url = "http://localhost:8081/profile")
public interface ProfileClient {
//    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
//    UserProfileResponse createProfile(@RequestBody ProfileCreationRequest request);
}
