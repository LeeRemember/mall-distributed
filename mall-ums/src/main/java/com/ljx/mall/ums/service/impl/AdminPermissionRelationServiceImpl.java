package com.ljx.mall.ums.service.impl;

import com.ljx.mall.ums.entity.AdminPermissionRelation;
import com.ljx.mall.ums.mapper.AdminPermissionRelationMapper;
import com.ljx.mall.ums.service.IAdminPermissionRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 服务实现类
 * </p>
 *
 * @author Ljx
 * @since 2020-02-12
 */
@Service
public class AdminPermissionRelationServiceImpl extends ServiceImpl<AdminPermissionRelationMapper, AdminPermissionRelation> implements IAdminPermissionRelationService {

}
