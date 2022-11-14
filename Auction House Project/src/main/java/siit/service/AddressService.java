package siit.service;

import org.springframework.stereotype.Service;
import siit.db.repository.dao.impl.AddressDAO;
import siit.exception.ValidationException;
import siit.model.Address;

@Service
public class AddressService {
    public final AddressDAO addressDao;
    public final UserService userService;

    public AddressService(AddressDAO addressDao, UserService userService) {
        this.addressDao = addressDao;
        this.userService = userService;
    }

    public Address getById(Integer id) {
        return addressDao.findById(id).orElseThrow(() -> new ValidationException("address.not.found"));
    }

//    public void updateAdress(int id, Address address) {
//        User user = userService.getUserWithAdress(id);
//        address.setId(user.getAdress().getId());
//        if (address.getCity().matches("")
//                || address.getCountry().matches("") || address.getStreetName() == "") {
//            throw new ValidationException("adress.malformed");
//        }
//        addressDao.updateAddress(address, id);
//    }
}
