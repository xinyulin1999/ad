package com.example.ad.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
/**
 * @author 林雨欣
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Ad {
    private Integer id;
    /**
     * 该广告的链接
     */
    private String link;
    /**
     * 该广告的名称
     */
    private String name;
    /**
     * 该广告的内容
     */
    private String content;
    /**
     * 该广告显示时的图片
     */
    private String picUrl;
    /**
     * 该广告是否是默认广告
     * 0: 不是   1：是
     */
    private Boolean beDefault;
    /**
     * 该广告是否启用
     */
    private Boolean beEnable;
    /**
     * 该广告上线的时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    /**
     * 该广告下线的时间
     */
   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;
    private Boolean beDeleted;

}
