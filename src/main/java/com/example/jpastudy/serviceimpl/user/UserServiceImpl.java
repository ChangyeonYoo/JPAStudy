package com.example.jpastudy.serviceimpl.user;

import com.example.jpastudy.domain.user.User;
import com.example.jpastudy.entity.user.UserEntity;
import com.example.jpastudy.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void createUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setAge(user.getAge());

        em.persist(userEntity);

        userEntity.setAge(23);
    }
}
