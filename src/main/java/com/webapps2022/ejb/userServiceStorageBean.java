
package com.webapps2022.ejb;


import com.webapps2022.entity.UserEntity;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *
 * @author Laptop
 */
 @Stateless
 public class userServiceStorageBean implements userService {

 @PersistenceContext 
 EntityManager em;

    public userServiceStorageBean() {
    }

@Override
public  List<UserEntity> getUserList(){
List <UserEntity> Users = em.createNamedQuery("findAllUsers").setParameter("role", "user").getResultList();
 return Users;
}
    
    //@Transactional(readOnly = true)
    @Override
public UserEntity authenticate(String email, String password) {
    List <UserEntity> usersList = em.createNamedQuery("findUser",  UserEntity.class).setParameter("email", email).setParameter("password", password).getResultList();
if (usersList.isEmpty()){return null;}
    UserEntity firstUserFromList = usersList.get(0);
    return firstUserFromList;
}
    
    @Override
    public void insertUsers(String email, String fname,String lname, String password, String currency, double balance, String role) {
        UserEntity Newuser = new UserEntity(email, fname, lname,  password, currency, 1000.00, "user");
        //commentList.add(cmnt);
        em.persist(Newuser);
        System.out.println("Inserted the following comment in the store:");
        System.out.println("Email: " + email);
        System.out.println("fname: " + fname);
        System.out.println("lname: " + lname);
        System.out.println("Password: " + password);
    }

@Override
 public void updateUser(UserEntity user, double amount){

UserEntity retrievedUser = em.merge(user);
retrievedUser.setBalance(amount);

}


@Override
 public void updateUserRole(UserEntity user, String role){

UserEntity retrievedUser = em.merge(user);
retrievedUser.setRole(role);

}

@Override
public UserEntity getUser(String email){
 List <UserEntity> user = em.createNamedQuery("findUserEntity").setParameter("email", email).getResultList();
if (user.isEmpty()){return null;}
return user.get(0);
}

    @PostConstruct
    public void postConstruct() {
        System.out.println("UsersStore: PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("UsersStore: PreDestroy");
    }

}