package com.example.ad.service;

import com.example.ad.domain.Ad;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author 林雨欣
 */

@Service
public interface AdService {
    /**
    * 查找广告
    * @return 广告列表
    */
    List<Ad> userFindAd();
    /**
     * 根据标题和内容查找广告
     *
     * @param adTitle adTitle
     *
     * @param adContent adContent
     *
     * @return 广告列表
     */
    List<Ad> adminFindAdList(String adTitle,String adContent);
    /**
     * 根据id查找广告
     *
     * @param id id
     *
     * @return 广告
     */
    Ad adminFindAd(Integer id);
    /**
     *更新广告
     *
     * @param ad ad
     * @param id id
     * @return
     */
    Ad adminUpdateAd(Ad ad,Integer id);
    /**
     *根据广告内容创建广告
     * @param ad  ad
     * @return ad
     */
    Ad adminCreateAad(Ad ad);
    /**
     * 删除广告
     *
     * @param id id
     *
     * @return 0/1
     */
    int adminDeleteAd(Integer id);


}
