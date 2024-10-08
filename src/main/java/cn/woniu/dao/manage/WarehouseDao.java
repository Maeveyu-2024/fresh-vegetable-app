package cn.woniu.dao.manage;


import cn.woniu.entity.manage.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.woniu.entity.manage.Warehouse;

import java.util.List;

/**
 * (Warehouse)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-05 11:39:02
 */
public interface WarehouseDao extends BaseMapper<Warehouse> {

    /**
     * 查询仓库列表
     * @param warehouse
     * @return
     */
    List<Warehouse> queryWarehouseList (Warehouse warehouse);

    /**
     * 逻辑删除仓库,修改仓库状态
     * @param id
     * @return
     */
    int updateWarehouseStatusById(String id,Integer status);

    /**
     * 查询员工列表
     * @return
     */
    List<Employee> queryEmployeeList ();




}
