package com.bluedon.modules.classes.service.impl;

import com.bluedon.modules.classes.entity.Classes;
import com.bluedon.modules.classes.dao.ClassesDao;
import com.bluedon.modules.classes.service.ClassesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hhong
 * @since 2019-12-13
 */
@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesDao, Classes> implements ClassesService {

}
