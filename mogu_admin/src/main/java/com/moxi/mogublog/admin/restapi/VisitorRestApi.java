package com.moxi.mogublog.admin.restapi;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.moxi.mogublog.admin.annotion.AuthorityVerify.AuthorityVerify;
import com.moxi.mogublog.admin.annotion.OperationLogger.OperationLogger;
import com.moxi.mogublog.commons.entity.Visitor;
import com.moxi.mogublog.utils.ResultUtil;
import com.moxi.mogublog.xo.mapper.VisitorMapper;
import com.moxi.mogublog.xo.service.VisitorService;
import com.moxi.mogublog.xo.vo.UserVO;
import com.moxi.mougblog.base.exception.ThrowableUtils;
import com.moxi.mougblog.base.validator.group.Insert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 游客表 RestApi
 * 
 * 增删改查
 * 批量增删改查
 *
 * @author 陌溪
 * @date 2018-09-08
 */
@RestController
@RequestMapping("/visitor")
@Api(value = "游客相关接口", tags = {"游客相关接口"})
@Slf4j
public class VisitorRestApi {
    @Autowired
    private VisitorService visitorService;

    /**
     * 何时需要进行（对db进行）增删改查？
     * 1.增：游客登录时，需要记录游客信息
     * 2.---删：除游客登录信息-->非必须
     * 3.改：更新游客信息，如登录次数，主键Ip？
     * 4.查：游客列表查询游客信息
     * @param visitor
     * @param result
     * @return
     */
    @OperationLogger(value = "新增游客")
    @ApiOperation(value = "新增游客", notes = "新增游客", response = String.class)
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody Visitor visitor, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return visitorService.addVisitor(visitor);
    }



    @OperationLogger(value = "获取游客列表")
    @ApiOperation(value = "获取游客列表", notes = "获取游客列表", response = String.class)
    @PostMapping("/getlist")
    public String getList(@Validated({Insert.class}) @RequestBody Visitor visitor, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        IPage iPage =  visitorService.getPageList(visitor);
        return ResultUtil.successWithData(iPage);
    }


























}

