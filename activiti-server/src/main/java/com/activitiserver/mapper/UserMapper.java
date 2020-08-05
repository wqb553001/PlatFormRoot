package com.activitiserver.mapper;import com.activitiserver.entity.UserEntity;import org.apache.ibatis.annotations.*;import org.springframework.stereotype.Repository;import java.util.List;@Mapper@Repositorypublic interface UserMapper {    @Insert("insert into user(username,password,enabled) values(#{username},#{password},#{enabled})")    int insert(UserEntity user);    @Delete("delete delete from UserEntity where id = #{id}")    int deleteByPrimaryKey(int id);    @Update("update UserEntity set username = #{username}, password = #{password}, enabled = #{enabled} where id = #{id}")    int updateByPrimaryKey(int id);    @Select("select id,username,password,enabled from UserEntity where id = #{id}")    UserEntity selectByPrimaryKey(int id);    @Select("select id,username,password,enabled from UserEntity where username = #{username}")    List<UserEntity> selectByUserName(String username);    @Select("select id,username,password,enabled from UserEntity")    List<UserEntity> selectAllUser(int id);}