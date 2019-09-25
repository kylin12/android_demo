package com.kevin.demo.component;
import com.kevin.demo.bean.MainModule;
import com.kevin.demo.business.home.HomeNewFragment;

import dagger.Component;

@Component(modules={MainModule.class})
public interface UserBeanComPonent {
    void inject(HomeNewFragment homeNewFragment);
}
