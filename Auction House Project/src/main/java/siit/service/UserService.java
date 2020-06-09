package siit.service;

import siit.db.AdressDao;
import siit.db.BidDao;
import siit.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.UserDao;
import siit.model.Adress;
import siit.model.CryptoByte;
import siit.model.User;

import javax.jws.soap.SOAPBinding;
import javax.naming.AuthenticationException;
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

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public User getUserByEmail(String email) {
        User user = userDao.getUserByEmail(email);
        return user;

    }

    public User getUserByName(String name) {
        User user = userDao.getUserByName(name);
        return user;

    }

    public User getUserByPassword(String password) {
        User user = userDao.getUserByPassword(password);
        return user;

    }

    public User getUserById(int id) {
        User user = userDao.getUserById(id);
        return user;
    }

    public void upDateUser(int id, User user) {
        if (!user.getPhone_number().matches("\\+\\d+")) {
            throw new ValidationException("phoneNumber.malformed");
        }
        userDao.updateUser(id, user);
    }


    public boolean checkUserObj(String name, String password) {
        int index = 0;
        String pass = cryptoByte.encrypt(password.getBytes());
        List<User> userList = userDao.getUsers();
        for (User user : userList) {
            if (user.getName().equals(name) &&
                    user.getPassword().equals(pass)) {
                index++;
            }
        }
        //User user1 = userDao.getUserByPassword(password);
        if (index == 1) {
            return true;
        } else {
            throw new ValidationException("autentification.error");
        }
    }


    public User getUserWithAdress(int id) {
        User user = userDao.getUserById(id);
        user.setAdress(adressDao.getAdressByUserId(id));
        return user;
    }

   //Nu stiu ce pula mea are...
    public void addNewUserService(String name, String passw, String em, String ph) {
//        if (!name.matches("^[a-z0-9_-]{3,15}$")) {
//            throw new ValidationException("userName.malformed"); }
//            if(!passw.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")){
//                throw new ValidationException("password.malformed");}
        if (!em.matches("^(.+)@(.+)$")) {
            throw new ValidationException("email.malformed");
        }
        userDao.addNewUser(name, passw, em, ph);
    }


    public boolean checkExistingEmailForRegister(String email) {
        int index = 0;
        List<User> userList = userDao.getUsers();
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                index++;
            }
        }
        if (index == 0) {
            return true;
        } else {
            throw new ValidationException("email.existing");
        }
    }

    public boolean checkExistingEmailForPasswordChange(String email) {
        int index = 0;
        List<User> userList = userDao.getUsers();
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                index++;
            }
        }
        if (index == 1) {
            return true;
        } else {
            throw new ValidationException("email.existing");
        }
    }

    public void resetPassword(String email, String password) {
        userDao.resetPassword(email, cryptoByte.encrypt(password.getBytes()));
    }

    public boolean checkExistingUserName(String username) {
        int index = 0;
        List<User> userList = userDao.getUsers();
        for (User user : userList) {
            if (user.getName().equals(username)) {
                index++;
            }
        }
        if (index == 0) {
            return true;
        } else {
            throw new ValidationException("user.existing");
        }
    }

    public void updateAdress(int id, Adress adress) {
        User user = getUserWithAdress(id);
        adress.setAdress_id(user.getAdress().getAdress_id());
        if (adress.getCity().matches("")
        || adress.getCountry().matches("") || adress.getStreet() == "") {
            throw new ValidationException("adress.malformed");
        }
        userDao.upadateAdress(adress);
    }

    public void addAdressDefault(int user_id){
        userDao.addDefaultAdressForUserId(user_id);
    }
}

