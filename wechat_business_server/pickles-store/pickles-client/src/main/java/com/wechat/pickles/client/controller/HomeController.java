package com.wechat.pickles.client.controller;

import com.wechat.pickles.client.enttiy.Swiper;
import com.wechat.pickles.client.mapper.HomeMapper;
import com.wechat.pickles.store.picklescommon.resp.BaseResponse;
import com.wechat.pickles.store.picklescommon.resp.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HomeController {
   Logger logger = LoggerFactory.getLogger(HomeController.class);
   @Autowired
   private HomeMapper homeMapper;

   @RequestMapping(value = "/home",method = RequestMethod.GET)
   @ResponseBody
   public BaseResponse initHome() {
      List<Swiper> swipers =  homeMapper.selctSwiperList();
      return new BaseResponse(ResponseCode.SUCCESSS.getCode(), ResponseCode.SUCCESSS.getDesc(), swipers.stream().map(Swiper::getUrl).collect(Collectors.toList()));
   }
}
