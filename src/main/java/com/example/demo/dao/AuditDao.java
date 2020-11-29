package com.example.demo.dao;

import com.example.demo.common.Result;
import com.example.demo.entities.UserRegister;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AuditDao {

    //批量审核用户(通过）
    void auditUserSuc(@Param("userRegisters") List<UserRegister> userRegisters);

    //批量审核用户(未通过）
    public boolean auditUserDef(@Param("userRegisters") List<UserRegister> userRegisters);

    int checkphnum(@Param("p_telephone") String p_telephone);

    int registUser(@Param("user") UserRegister user);

    void setbanner(@Param("id") List<Integer> id);
}
