package com.example.ad.service.adserviceimpl;

import com.example.ad.domain.Ad;
import com.example.ad.mapper.AdMapper;
import com.example.ad.service.AdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author 林雨欣
 */


@Service
public class AdServiceImpl implements AdService {
    @Resource
    private AdMapper adMapper;
    @Override
    public List<Ad>  userFindAd()
    {
        return adMapper.userFindAd();
    }

    @Override
    public List<Ad> adminFindAdList( String adTitle, String adContent)
    {
        return adMapper.adminFindAdList(adTitle,adContent);
    }
    @Override
    public Ad adminFindAd(Integer id)
    {
        return adMapper.adminFindAd(id);
    }
    @Override
    public Ad adminCreateAad(Ad ad)
    {
        adMapper.adminCreateAad(ad);
        return adMapper.adminFindAd(ad.getId());
    }

    @Override
    public Ad adminUpdateAd(Ad ad,Integer id)
    {
        if(adMapper.adminFindAd(id)==null)
        {
            ad.setId(-1);
            return ad;
        }
        else
        {
            ad.setId(id);
            adMapper.adminUpdateAd(ad);
            return adMapper.adminFindAd(id);
        }

    }
 @Override
    public int adminDeleteAd(Integer id)
 {
     if(adMapper.adminFindAd(id)==null){
         return 0;
     }else{
         adMapper.adminDeleteAd(id);
         return 1;
     }
 }


}
