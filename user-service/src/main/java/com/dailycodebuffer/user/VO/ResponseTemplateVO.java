package com.dailycodebuffer.user.VO;

import com.dailycodebuffer.user.entity.MyUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private MyUser myUser;
    private Department department;
}
