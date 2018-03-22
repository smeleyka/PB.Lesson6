package ru.geekbrains.android3_6.di.modules;

import dagger.Module;
import dagger.Provides;
import ru.geekbrains.android3_6.model.api.ApiService;
import ru.geekbrains.android3_6.model.api.UserRepo;
import ru.geekbrains.android3_6.model.cache.ICache;


@Module(includes = {ApiModule.class,ICacheModule.class})
public class RepoModule
{
    @Provides
    public UserRepo userRepo(ApiService api, ICache cache)
    {
        return new UserRepo(api, cache);
    }
}
