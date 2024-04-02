package com.moxi.mogublog.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.moxi.mogublog.commons.entity.User;
import com.moxi.mogublog.commons.entity.Visitor;
import com.moxi.mogublog.xo.vo.UserVO;
import com.moxi.mougblog.base.service.SuperService;

import javax.servlet.http.HttpServletRequest;

/**
 * 博主表 服务类
 *
 * @author 陌溪
 * @date 2018-09-08
 */
public interface VisitorService extends SuperService<Visitor> {
    /**
     *
    */
    Visitor insertVisitorInfo(HttpServletRequest request,String respone);


    /**
     * 新增游客信息
     * @param visitor
     * @return
     */
    public String addVisitor(Visitor visitor);

    /**
     * 更新游客信息
     * @param visitor
     * @return
     */
    public String updateVisitor(Visitor visitor);



    public IPage<Visitor> getPageList(Visitor visitor);





}
