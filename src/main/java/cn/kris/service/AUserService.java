package cn.kris.service;

import cn.kris.entity.AUser;
import cn.kris.mapper.AUserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AUserService extends ServiceImpl<AUserMapper,AUser> {
}
