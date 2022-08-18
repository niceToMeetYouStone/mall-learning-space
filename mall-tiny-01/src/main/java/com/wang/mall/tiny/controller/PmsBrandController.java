package com.wang.mall.tiny.controller;


import com.wang.mall.tiny.common.api.CommonPage;
import com.wang.mall.tiny.common.api.CommonResult;
import com.wang.mall.tiny.mbg.model.PmsBrand;
import com.wang.mall.tiny.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *品牌管理
 */
@Api(tags = "PmsBrandController",description = "商品品牌管理")
@Controller
@RequestMapping("/brand")
public class PmsBrandController {


    @Autowired
    private PmsBrandService pmsBrandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);
    @ApiOperation("获取所有的商品列表")
    @PostMapping("listAll")
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(pmsBrandService.listAllBrand());
    }


    @ApiOperation("添加品牌")
    @PostMapping("create")
    @ResponseBody
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = pmsBrandService.createBrand(pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("create PsmBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id的品牌信息")
    @PostMapping("/update/{id}")
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrand, BindingResult bindingResult) {
        CommonResult commonResult;
        int count = pmsBrandService.updateBrand(id, pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("updateBrand success{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("删除指定的id的品牌信息")
    @GetMapping("/delete/{id}")
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id){
        int count = pmsBrandService.deleteBrand(id);
        if(count == 1){
            LOGGER.debug("deleteBrand success:id={}",id);
            return CommonResult.success(null);
        }else{
            LOGGER.debug("deleteBrand failed:id={}",id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("分页查询品牌的列表")
    @GetMapping("/list")
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum",defaultValue = "1") Integer  pageNum,
                                                        @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize){
        List<PmsBrand> branList = pmsBrandService.listBrand(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(branList));
    }

    @ApiOperation("获取指定id品牌的详情")
    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id){
        return CommonResult.success(pmsBrandService.getBrand(id));
    }
}
