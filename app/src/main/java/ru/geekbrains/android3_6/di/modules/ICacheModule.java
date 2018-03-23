package ru.geekbrains.android3_6.di.modules;


import com.activeandroid.query.Select;

import dagger.Module;
import dagger.Provides;
import ru.geekbrains.android3_6.model.cache.AACache;
import ru.geekbrains.android3_6.model.cache.ICache;
import ru.geekbrains.android3_6.model.entity.activeandroid.AAUser;

@Module
public class ICacheModule
{


    @Provides
    public AAUser provaideAAUser(){
        AAUser aaUser = new Select()
                .from(AAUser.class)
                .where("login = ?", username)
                .executeSingle();

        return  aaUser;
    }



    @Provides
    public ICache cache(){
        return new AACache();
    }
}
