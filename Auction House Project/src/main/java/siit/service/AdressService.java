package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.AdressDao;
import siit.db.UserDao;
import siit.model.Adress;

@Service
public class AdressService {

     @Autowired
     public AdressDao adressDao;

     @Autowired
     public UserDao userDao;

}
