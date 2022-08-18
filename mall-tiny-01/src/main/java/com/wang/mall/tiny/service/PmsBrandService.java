package com.wang.mall.tiny.service;

import com.wang.mall.tiny.mbg.model.PmsBrand;

import java.util.List;

public interface PmsBrandService {


    /**
     * 查询所有的品牌
     * @return
     */
    List<PmsBrand> listAllBrand();


    /**
     * 创建品牌
     * @param pmsBrand
     * @return
     */
    int createBrand(PmsBrand pmsBrand);


    /**
     * 更新品牌
     * @param id
     * @param pmsBrand
     * @return
     */
    int updateBrand(Long id, PmsBrand pmsBrand);

    /**
     * 删除品牌
     * @param id
     * @return
     */
    int deleteBrand(Long id);


    /**
     * 分页品牌目录
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsBrand> listBrand(Integer pageNum, Integer pageSize);

    /**
     * 通过id获取品牌的详细信息
     * @param id
     * @return
     */
    PmsBrand getBrand(Long id);
}
