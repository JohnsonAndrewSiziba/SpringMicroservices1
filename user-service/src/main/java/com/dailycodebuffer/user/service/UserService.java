package com.dailycodebuffer.user.service;

import com.dailycodebuffer.user.VO.Department;
import com.dailycodebuffer.user.VO.ResponseTemplateVO;
import com.dailycodebuffer.user.entity.MyUser;
import com.dailycodebuffer.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public MyUser saveUser(MyUser myUser) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(myUser);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        MyUser myUser = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/departments/" + myUser.getDepartmentId(),
                Department.class
        );
        vo.setMyUser(myUser);
        vo.setDepartment(department);

        return  vo;
    }
}
