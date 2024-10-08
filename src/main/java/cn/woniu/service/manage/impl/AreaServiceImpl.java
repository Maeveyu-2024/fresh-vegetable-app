package cn.woniu.service.manage.impl;

import cn.woniu.dao.manage.AreaDao;
import cn.woniu.entity.manage.Area;
import cn.woniu.redis.RedisRepository;
import cn.woniu.service.manage.AreaService;

import cn.woniu.utils.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;


/**
 * (Area)表服务实现类
 *
 * @author makejava
 * @since 2023-01-05 11:38:48
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired(required = false)
    private AreaDao areaDao;



    @Override
    public ResponseResult<?> queryAreaList(String name, Integer pageNo, Integer pageSize) {

            PageHelper.startPage(pageNo,pageSize);
            List<Area> areas = areaDao.queryAreaList(name);
            PageInfo<Area>  areasInfo = new PageInfo<>(areas);
            return new ResponseResult<>(200,"查询区域",areasInfo);
    }

    @Override
    public ResponseResult<?> addArea(Area area) {
        List<Area> areas = areaDao.queryAllAreaList();
        List<Area> collect = areas.stream().filter(a -> a.getName().equals(area.getName()))
                .collect(Collectors.toList());
        if (collect.size()>0){
            return new ResponseResult<>(201,"该区域已添加");
        }else{
            String areaValue = StringUtils.join(area.getAreaValues(), ' ');
            area.setAreaValue(areaValue);
            areaDao.addArea(area);
            return new ResponseResult<>(200,"添加区域成功");
        }

    }

    @Override
    public ResponseResult<?> updateArea(Area area) {
        areaDao.updateArea(area);
        return new ResponseResult<>(200,"编辑区域");
    }

    @Override
    public ResponseResult<?> delArea(Long id) {
        areaDao.delArea(id);
        return new ResponseResult<>(200,"删除区域");
    }

    @Override
    public ResponseResult<?> stopStatus(Long id) {
        areaDao.stopStatus(id);
        return new ResponseResult<>(200,"停用区域状态");
    }

    @Override
    public ResponseResult<?> batchDelArea(List<Integer> ids) {
        areaDao.batchDelArea(ids);
        return new ResponseResult<>(200,"批量删除区域");
    }

    @Override
    public ResponseResult<?> queryAllAreaList() {
        List<Area> areas = areaDao.queryAllAreaList();
        return new ResponseResult<>(200,"查询区域",areas);
    }

    @Override
    public ResponseResult<?> queryOtherAreaById(Long id) {
        Integer areaId = areaDao.queryOtherAreaById(id);
        if (areaId>0){
            return new ResponseResult<>(201,"存在客户");
        }else{
            return new ResponseResult<>(202,"不存在客户");
        }
    }

    @Override
    public ResponseResult<?> openStatus(Long id) {
        areaDao.openStatus(id);
        return new ResponseResult<>(200,"启用区域状态");
    }
}

