package com.wechat.pickles.client.mapper;

import com.wechat.pickles.client.enttiy.Swiper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * wechat mini client init data mappers
 * */
@Mapper
public interface HomeMapper{
    @Select(" select * from pickles.swiper")
    List<Swiper> selctSwiperList();
}
