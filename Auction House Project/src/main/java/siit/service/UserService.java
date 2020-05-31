package siit.service;

import siit.db.AdressDao;
import siit.db.BidDao;
import siit.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.UserDao;
import siit.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BidDao bidsDao;

    @Autowired
    private AdressDao adressDao;

    public List<User> getUsers(){
        return userDao.getUsers();
    }

    public User getUserByEmail(String email){
        User user = userDao.getUserByEmail(email);
        return user;

    }

    public User getUserByName(String name){
        User user = userDao.getUserByName(name);
        return user;

    }

    public User getUserByPassword(String password){
        User user = userDao.getUserByPassword(password);
        return user;

    }

    public User getUserById(int id){
        User user = userDao.getUserById(id);
        return user;
    }

  public void upDateUser(User user){
        userDao.updateUser(user);
  }




    public boolean checkUser(String name, String password){
        if( name.equals(userDao.getUserByName(name).getName()) &&
                password.equals(userDao.getUserByPassword(password).getPassword()))
            return true;
        else return false;}

      public User getUserWithAdress(int id){
        User user = userDao.getUserById(id);
        user.setAdress(adressDao.getAdressByUserId(id));
        return user;
      }


     public void addNewUserService(String name, String passw, String em, String ph){
        if(!checkUser(name, passw)){
        userDao.addNewUser(name, passw, em, ph);}
        else
            throw new ValidationException("existing.user");
    }



}

