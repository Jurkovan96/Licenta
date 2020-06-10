package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.AdressDao;
import siit.db.UserDao;
import siit.exceptions.ValidationException;
import siit.model.Adress;
import siit.model.User;

@Service
public class AdressService {

     @Autowired
     public AdressDao adressDao;

     @Autowired
     public UserDao userDao;

     @Autowired
     public UserService userService;

    public Adress getAdressForUserId(int id) {
    Adress adress = adressDao.getAdressByUserId(id);
    return adress;
    }

    public void updateAdress(int id, Adress adress) {
        User user = userService.getUserWithAdress(id);
        adress.setAdress_id(user.getAdress().getAdress_id());
        if (adress.getCity().matches("")
                || adress.getCountry().matches("") || adress.getStreet() == "") {
            throw new ValidationException("adress.malformed");
        }
        adressDao.upDateAdress(adress, id);
    }
}
