package com.example.ad.controller;

import com.example.ad.domain.Ad;
import com.example.ad.service.AdService;
import com.example.ad.util.FileUtils;
import com.example.ad.util.ResponseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.List;
/**
 * @author 林雨欣
 */

@RestController
@RequestMapping("/AdService")
public class Adcontroller {
    @Autowired
    private AdService adService;

    @Value("${web.path}")
    private String path;

    @GetMapping("/admins/ads")
    Object adminFindAdList(
                           @RequestParam(defaultValue = "1") Integer page,
                           @RequestParam(defaultValue = "10") Integer limit,
                           String adTitle,
                           String adContent
                           )
    {
        PageHelper.startPage(page,limit);
        List<Ad> adList= adService.adminFindAdList(adTitle,adContent);
        PageInfo<Ad> adPageInfo = new PageInfo<>(adList);
        List<Ad> pageList = adPageInfo.getList();
        Object retObj = ResponseUtil.ok(pageList);
        return retObj;

    }

    /**
     *
     * @param ad
     * @return ad
     */
/**
 * 删去requestbody
 */
    @PostMapping("/ads")
    Object adminCreateAad( Ad ad)
    {
        Ad detail=adService.adminCreateAad(ad);
        Object retObj = ResponseUtil.ok(detail);
        return retObj;
    }

    /**
     *
     * @param id
     * @return ad
     */
    @GetMapping("/ads/{id}")
    Object adminFindAd(@NotNull @PathVariable Integer id)
    {

        Ad detail=adService.adminFindAd(id);
        Object retObj;
        if(!detail.getId().equals(id)){
            retObj = ResponseUtil.badArgumentValue();
        }else{
            retObj = ResponseUtil.ok(detail);
        }
        return retObj;
    }

    /**
     *
     * @param id
     * @param ad
     * @return ad
     */
    @PutMapping("/ads/{id}")
    /**
     * 删掉了requestbody
     */

    Object adminUpdateAd(@PathVariable Integer id, Ad ad)
    {

        Ad detail = adService.adminUpdateAd(ad,id);
        Object retObj;
        if(detail.getId().equals(id)){
            retObj = ResponseUtil.ok(detail);
        }else {
            retObj = ResponseUtil.updatedDataFailed();
        }
        return retObj;
    }

    /**
     *
     * @param id
     * @return 无(ResponseUtil.ok()即可)
     */
    @DeleteMapping("/ads/{id}")
   Object adminDeleteAd(@PathVariable Integer id)
    {

        adService.adminDeleteAd(id);

        Object retObj;
        if(adService.adminDeleteAd(id)==1){
            retObj = ResponseUtil.ok();
        }else {
            retObj = ResponseUtil.updatedDataFailed();

        }
        return retObj;
    }

    /**
     *
     * @return List<ad>
     */
    @GetMapping("/ads")
    Object userFindAd()
    {

        List<Ad> adList= adService.userFindAd();
        Object retObj = ResponseUtil.ok(adList);
        return retObj;
    }

    @PostMapping("/pics" )
    public Object upload(@RequestParam("file") MultipartFile file){
        //1定义要上传文件 的存放路径
        String localPath="/picture";
//        String localPath = "/root/photo";
        //2获得文件名字
        String fileName=file.getOriginalFilename();
        //2上传失败提示
        String warning="";
        String newFileName = FileUtils.upload(file, localPath, fileName);
        if(newFileName != null){
            //上传成功
            warning=localPath+"/"+newFileName;
            Object retObj = ResponseUtil.ok(warning);
            return retObj;


        }else{
            warning="上传失败";
           Object retObj = ResponseUtil.updatedDataFailed();
           return retObj;
        }
    }


}
