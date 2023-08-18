package com.vijaycode.service;


import com.vijaycode.entity.User;
import com.vijaycode.entity.UserLoginDetail;
import com.vijaycode.exception.UserException;
import com.vijaycode.model.SuccessDO;
import com.vijaycode.model.UserDO;
import com.vijaycode.model.UserLoginDetailDO;
import com.vijaycode.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    public SuccessDO createUser(UserDO userDO) {
        User user = modelMapper.map(userDO, User.class);
        User userCreated = userRepo.save(user);
        UserDO userDOConverted = modelMapper.map(userCreated, UserDO.class);
        SuccessDO response = userDOConverted != null ? SuccessDO.builder().successMessage("User Created successfully...").build() : null;
        return response;
    }

    public List<UserDO> getUsers() {
        List<User> users = userRepo.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDO.class)).collect(Collectors.toList());
    }

    public UserDO getUser(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new UserException("User Not found..."));
        UserDO userDO = new UserDO();
        userDO.setFullName(user.getFullName());
        userDO.setUserId(user.getUserId());
        userDO.setAge(user.getAge());
        userDO.setContact(user.getContact());
        UserLoginDetailDO userLoginDetail = new UserLoginDetailDO();
        userLoginDetail.setId(user.getUserLoginDetail().getId());
        userLoginDetail.setUsername(user.getUserLoginDetail().getUsername());
        userLoginDetail.setPassword(user.getUserLoginDetail().getPassword());
        userLoginDetail.setEmail(user.getUserLoginDetail().getEmail());
        userDO.setUserLoginDetail(userLoginDetail);
        return userDO;
    }

    public SuccessDO deleteUser(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new UserException("User Not found..."));
        userRepo.delete(user);
        SuccessDO response = SuccessDO.builder().successMessage("User Deleted successfully...").build();
        return response;
    }

    public SuccessDO updateUser(Integer userId, UserDO userDO) {
        User user = userRepo.findById(userId).orElseThrow(() -> new UserException("User Not found..."));
        if (null != userDO.getFullName()) {
            user.setFullName(userDO.getFullName());
        }
        if (0 != userDO.getAge()) {
            user.setAge(userDO.getAge());
        }
        if (0l != userDO.getContact()) {
            user.setContact(userDO.getContact());
        }
        if (null != userDO.getUserLoginDetail() && null != userDO.getUserLoginDetail().getPassword()) {
            UserLoginDetail userLoginDetail = user.getUserLoginDetail();
            userLoginDetail.setPassword(userDO.getUserLoginDetail().getPassword());
            user.setUserLoginDetail(userLoginDetail);
        }
        userRepo.save(user);
        SuccessDO response = SuccessDO.builder().successMessage("User Updated successfully...").build();
        return response;
    }
}
