package cn.woniu.service.manage;


import cn.woniu.entity.manage.Warehouse;
import cn.woniu.utils.ResponseResult;

/**
 * (Warehouse)表服务接口
 *
 * @author makejava
 * @since 2023-01-05 11:39:02
 */
public interface WarehouseService {

    /**
     * 查询仓库列表
     * @param warehouse
     * @return
     */
    ResponseResult<?> queryWarehouseList(Warehouse warehouse);

    /**
     * 新增仓库
     * @param warehouse
     * @return
     */
    ResponseResult<?> addWarehouse(Warehouse warehouse);

    /**
     * 修改仓库
     * @param warehouse
     * @return
     */
    ResponseResult<?> updateWarehouse(Warehouse warehouse);


}

