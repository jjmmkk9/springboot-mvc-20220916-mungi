package com.boot.mvc20220916mungi.repository;

import com.boot.mvc20220916mungi.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/*
@repository =  @Component
=> 이 클래스를 IOC에 등록해라 - 똑같은 인터페이스 implements하는 클래스가 두개이므로 이름도 "a"라고 지어서 등록해라
 */
@Repository("a")
public class UserRepositoryImpl implements UserRepository{

    private final List<User> userData;


    //UserRepositoryImpl가 생성 될때 user가 5개 만들어진다.
    public UserRepositoryImpl(){
        userData = new ArrayList<User>();

        for(int i = 0; i < 5; i++) {
            int index = i + 1;
            User user = User.builder()
                    .user_code(index)
                    .user_id("mungi" + index)
                    .user_password("1234")
                    .user_name("조문" + index)
                    .user_email("q" + index + "@gmail.com")
                    .build();
            userData.add(user); //조문1~조문5까지 list에 차곡차곡
        }
    }


    public int save(User user) {//1을 리턴하고 userData에 새로운 유저를 새로운 코드로 등록
        try {
            int maxCode = 0;
            for (User u : userData) {
                if (u.getUser_code() > maxCode) {
                    maxCode = u.getUser_code();
                }
            }
            maxCode++;          
            user.setUser_code(maxCode); //여기서 maxCode는 6이 되면서 방금 받은 user객체의 User_code가 6이 됨

            userData.add(user);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public User findUserByUserId(String userId) {
        User user = null;

        for(User userObj : userData){
            if(userObj.getUser_id().equals(userId)){
                user = userObj;
            }
        }
        return user;
    }

    @Override
    public User findUserByUserCode(int userCode) {
        User user = null;

        for(User userObj : userData){
            if(userObj.getUser_code() == userCode){
                user = userObj;
            }
        }
        return user;
    }


    @Override
    public int modify(User user) {
        return 0;
    }

    @Override
    public int remove(int userCode) {
        return 0;
    }
}
