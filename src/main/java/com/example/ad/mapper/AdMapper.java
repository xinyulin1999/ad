package com.example.ad.mapper;

import com.example.ad.domain.Ad;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;
/**
 * @author 林雨欣
 */

@Mapper
public interface AdMapper {
   /**
    * 广告列表
    *
    * @return 广告列表
    */
   List<Ad> userFindAd();
   /**
    * 根据广告标题和内容查找广告
    * @param  adTitle 广告标题
    *
    * @param  adContent 广告内容
    *
    * @return 广告列表
    */
   List<Ad> adminFindAdList(@Param("adTitle") String adTitle,@Param("adContent") String adContent);
   /**
    * 根据id查找广告
    *
    * @param id id
    *
    * @return 广告
    */
   Ad adminFindAd(Integer id);
   /**
    *根据广告内容创建广告
    * @param ad  ad
    */
   void adminCreateAad(Ad ad);
   /**
    *更新广告
    *
    * @param ad ad
   */
   void adminUpdateAd(Ad ad);
   /**
    * 删除广告
    *
    * @param id id
    */
   void adminDeleteAd(@Param(value = "id") Integer id);



}
