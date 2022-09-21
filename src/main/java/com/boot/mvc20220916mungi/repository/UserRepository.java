package com.boot.mvc20220916mungi.repository;

import com.boot.mvc20220916mungi.domain.User;

public interface UserRepository {
    /**
     * @param user
     * @return
     * int 1 오류나면 0
     */
    public int save(User user); //Create user객체를 받아올 것 ->
    public User findUserByUserId(String userId); //user객체 반환하는
    public User findUserByUserCode(int userCode);
    public int modify(User user);
    public int remove(int userCode);


}
