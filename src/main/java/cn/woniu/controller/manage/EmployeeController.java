package cn.woniu.controller.manage;


import cn.woniu.entity.manage.Employee;
import cn.woniu.service.manage.EmployeeService;
import cn.woniu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * (Employee)表控制层
 *
 * @author makejava
 * @since 2023-01-05 11:38:51
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    /**
     * 服务对象
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * 条件查询用户列表
     * @param employee
     * @return
     */
    @PostMapping("list")
    public ResponseResult<?> queryEmployeeList(@RequestBody Employee employee, @RequestParam int pageNum, int pageSize){
        return employeeService.queryEmployeeList(employee,pageNum,pageSize);
    }

    /**
     * 修改用户状态(含逻辑删除)
     */
    @RequestMapping("status")
    public ResponseResult<?> changeEmployeeStatusById(Integer id, Integer status){
        return employeeService.changeEmployeeStatusById(id, status);
    }
}
