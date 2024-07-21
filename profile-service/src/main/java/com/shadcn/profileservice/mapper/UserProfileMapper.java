package com.shadcn.profileservice.mapper;

import com.shadcn.profileservice.dto.request.ProfileCreationRequest;
import com.shadcn.profileservice.dto.response.UserProfileReponse;
import com.shadcn.profileservice.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileReponse toUserProfileReponse(UserProfile entity);
}
