package com.thanhtan.identity.service;

import com.thanhtan.identity.dto.request.CreateSystemUserRequest;
import com.thanhtan.identity.dto.request.UpdateSystemUserRequest;
import com.thanhtan.identity.dto.request.UpdateUserRequest;
import com.thanhtan.identity.dto.request.UserRequest;
import com.thanhtan.identity.dto.response.UserResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IUserService {
    UserResponse createUser(UserRequest request);

    UserResponse getMyInfo();

    UserResponse updateUserProfile(UpdateUserRequest request, MultipartFile file);

    UserResponse createSystemUser(CreateSystemUserRequest request, MultipartFile file);

    UserResponse updateSystemUser(UpdateSystemUserRequest request, MultipartFile file, Long userId);

    UserResponse updateUserProfileById(UpdateUserRequest request, MultipartFile file, Long userId);

    List<UserResponse> getUsers();

    List<UserResponse> getAllCustomer();

    UserResponse getCustomerById(Long userId);

    UserResponse getSystemUsersById(Long userId);

    List<UserResponse> getAllAdmin();

    void deleteUserssByIds(Long[] ids);

}
