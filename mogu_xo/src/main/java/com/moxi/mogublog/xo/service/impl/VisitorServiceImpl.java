package com.moxi.mogublog.xo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.moxi.mogublog.commons.entity.User;
import com.moxi.mogublog.commons.entity.Visitor;
import com.moxi.mogublog.utils.MD5Utils;
import com.moxi.mogublog.utils.ResultUtil;
import com.moxi.mogublog.xo.global.MessageConf;
import com.moxi.mogublog.xo.global.SysConf;
import com.moxi.mogublog.xo.mapper.VisitorMapper;
import com.moxi.mogublog.xo.service.VisitorService;
import com.moxi.mougblog.base.serviceImpl.SuperServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 * 博主表 服务实现类
 * </p>
 *
 * @author 陌溪
 * @since 2018-09-08
 */
@Service
public class VisitorServiceImpl extends SuperServiceImpl<VisitorMapper, Visitor> implements VisitorService {

    @Override
    public Visitor insertVisitorInfo(HttpServletRequest request, String respone) {
        Visitor visitor = new Visitor();

        visitor.setEmail("");
        visitor.setUser_name("");
        visitor.setLast_login_ip(request.getRemoteHost());
        visitor.setLogin_count(1);
        visitor.setLast_login_time(new Date());

        visitor.insert();

        return visitor;
    }


    @Override
    public String addVisitor(Visitor visitor) {
        Visitor visitor1 = new Visitor();
        // 字段拷贝【将userVO中的内容拷贝至user】
        BeanUtils.copyProperties(visitor, visitor1);
        visitor1.insert();
        return ResultUtil.successWithMessage(MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String updateVisitor(Visitor visitor) {
        return null;
    }

    @Override
    public IPage<Visitor> getPageList(Visitor visitor) {
        return null;
    }

}
