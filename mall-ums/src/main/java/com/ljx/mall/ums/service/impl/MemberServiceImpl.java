package com.ljx.mall.ums.service.impl;

import com.ljx.mall.ums.entity.Member;
import com.ljx.mall.ums.mapper.MemberMapper;
import com.ljx.mall.ums.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author Ljx
 * @since 2020-02-12
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

}
