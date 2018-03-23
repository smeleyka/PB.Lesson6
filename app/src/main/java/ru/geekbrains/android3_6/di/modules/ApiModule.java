package ru.geekbrains.android3_6.di.modules;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.geekbrains.android3_6.model.api.ApiService;


@Module
public class ApiModule
{
    @Provides
    @Named("GsonLCWU")
    public Gson gsonLcwu()
    {
        return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }

    @Provides
    @Named("Gson")
    public Gson gson()
    {
        return new GsonBuilder().create();
    }

    @Provides
    public GsonConverterFactory converterFactory(@Named("GsonLCWU") Gson gson)
    {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    public CallAdapter.Factory callAdapterFactory()
    {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    public Retrofit retrofit(CallAdapter.Factory callAdapterFactory, GsonConverterFactory converterFactory)
    {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addCallAdapterFactory(callAdapterFactory)
                .addConverterFactory(converterFactory)
                .build();
    }

    @Singleton
    @Provides
    public ApiService api(Retrofit retrofit)
    {
        return retrofit.create(ApiService.class);
    }

}
