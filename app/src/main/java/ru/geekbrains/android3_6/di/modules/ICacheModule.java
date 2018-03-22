package ru.geekbrains.android3_6.di.modules;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.geekbrains.android3_6.model.api.ApiService;
import ru.geekbrains.android3_6.model.cache.AACache;
import ru.geekbrains.android3_6.model.cache.ICache;
import ru.geekbrains.android3_6.model.entity.User;
import ru.geekbrains.android3_6.model.entity.UserRepository;
import ru.geekbrains.android3_6.model.entity.activeandroid.AAUser;
import ru.geekbrains.android3_6.model.entity.activeandroid.AAUserRepository;


@Module
public class ICacheModule
{




    @Provides
    public ICache cache(){
        return new AACache();
    }

}
