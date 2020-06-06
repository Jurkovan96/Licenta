package siit.service;

import siit.db.AdressDao;
import siit.db.BidDao;
import siit.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.UserDao;
import siit.model.CryptoByte;
import siit.model.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BidDao bidsDao;

    @Autowired
    private AdressDao adressDao;

    @Autowired
    private CryptoByte cryptoByte;

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
        String pass = cryptoByte.encrypt(password.getBytes());
        if( name.equals(userDao.getUserByName(name).getName()) &&
                pass.equals(userDao.getUserByPassword(pass).getPassword()))
            return true;
        else return false;}


      public User getUserWithAdress(int id){
        User user = userDao.getUserById(id);
        user.setAdress(adressDao.getAdressByUserId(id));
        return user;
      }


     public void addNewUserService(String name, String passw, String em, String ph){
        userDao.addNewUser(name, passw, em, ph);
    }


    public boolean checkUserByEmail(String em) {
//        User user = userDao.getUserByEmail(em);
//        if(user == null){
//            return false;
//        }
//        else
            return true;
    }


}

