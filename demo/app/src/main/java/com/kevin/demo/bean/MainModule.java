package com.kevin.demo.bean;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    UserBean provUserBean(){
        return  new UserBean();
    }
}
