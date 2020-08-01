package com.example.mapper;

import com.example.model.Area;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AreaMapper {
    int deleteByPrimaryKey(Integer areaId);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer areaId);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);

    //这个方式我自己加的
    List<Area> selectAllArea();
}