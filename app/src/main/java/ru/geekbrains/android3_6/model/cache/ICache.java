package ru.geekbrains.android3_6.model.cache;

import java.util.List;

import io.reactivex.Observable;
import ru.geekbrains.android3_6.model.entity.User;
import ru.geekbrains.android3_6.model.entity.UserRepository;

public interface ICache
{
    void putUser(User user);

    Observable<User> getUser(String username);

    void putUserRepositories(User user, List<UserRepository> repositories);

    Observable<List<UserRepository>> getUserRepositories(User user);

}
