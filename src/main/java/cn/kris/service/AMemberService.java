package cn.kris.service;

import cn.kris.entity.AMember;
import cn.kris.mapper.AMemberMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AMemberService extends ServiceImpl<AMemberMapper, AMember> {

}
