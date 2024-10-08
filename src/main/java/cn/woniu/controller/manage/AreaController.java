package cn.woniu.controller.manage;


import cn.woniu.entity.manage.Area;
import cn.woniu.service.manage.AreaService;
import cn.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * (Area)表控制层
 *
 * @author makejava
 * @since 2023-01-05 11:38:48
 */
@RestController
@RequestMapping("/area")
public class AreaController {
    /**
     * 服务对象
     */
    @Autowired
    private AreaService areaService;

    /**
     *查询地区表
     */
    @RequestMapping("/queryArea")
    ResponseResult<?> queryAreaList(String name, Integer pageNo, Integer pageSize){
        return areaService.queryAreaList(name,pageNo,pageSize);
    }
    /**
     *添加地区
     */
    @PostMapping("/add")
    ResponseResult<?> addArea(@RequestBody Area area) {
        return areaService.addArea(area);
    }
    /**
     *编辑地区表
     */
    @PostMapping("/update")
    ResponseResult<?> updateArea(@RequestBody Area area){
        return areaService.updateArea(area);
    }
    /**
     *逻辑删除地区表
     */
    @RequestMapping("/delete")
    ResponseResult<?> delArea(Long id){
        return areaService.delArea(id);
    }
    /**
     *停用地区
     */
    @RequestMapping("/stopArea")
    ResponseResult<?> stopStatus(Long id){
        return areaService.stopStatus(id);
    }
    /**
     *启用地区
     */
    @RequestMapping("/open")
    ResponseResult<?> openStatus(Long id){
        return areaService.openStatus(id);
    }
    /**
     *批量删除地区
     */
    @PostMapping("/delArea")
    ResponseResult<?> batchDelArea(@RequestBody Area area){
        List<Integer> ids = area.getIds();
        return areaService.batchDelArea(ids);
    }
    /**
     *查询全部地区
     */
    @RequestMapping("/list")
    ResponseResult<?> queryAllAreaList(){
        return areaService.queryAllAreaList();
    }
    /**
     *判断该地区是否存在客户
     */
    @RequestMapping("/custom")
    ResponseResult<?> queryOtherAreaById(Long id){
        return areaService.queryOtherAreaById(id);
    }
}
