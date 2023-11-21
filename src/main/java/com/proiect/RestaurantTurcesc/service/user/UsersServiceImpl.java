package com.proiect.RestaurantTurcesc.service.user;

import com.proiect.RestaurantTurcesc.entities.User;
import com.proiect.RestaurantTurcesc.helpers.MapEntities;
import com.proiect.RestaurantTurcesc.models.user.UserRequest;
import com.proiect.RestaurantTurcesc.models.user.UserResponse;
import com.proiect.RestaurantTurcesc.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = MapEntities.mapUserRequestToUser(userRequest);
        Optional<User> userAlreadyStored = usersRepository.findUserByEmail(userRequest.getEmail());
        if (userAlreadyStored.isPresent()) {
            return null;
        }

        User newUser = this.usersRepository.save(user);
        return MapEntities.mapUserToUserResponse(newUser);
    }

    @Override
    public void deleteAll() {
        this.usersRepository.deleteAll();
    }

    @Override
    public void deleteUser(Integer id) {
        this.usersRepository.deleteById(id);
    }

    @Override
    public List<UserResponse> findAll() {
        return this.usersRepository.findAll()
                .stream()
                .map(u -> MapEntities.mapUserToUserResponse(u))
                .toList();
    }

    @Override
    public UserResponse findById(Integer id) {
        Optional<User> userFound = this.usersRepository.findById(id);
        if (userFound.isPresent()) {
            User user = userFound.get();
            return MapEntities.mapUserToUserResponse(user);
        }
        return null;
    }

    @Override
    public UserResponse updateUser(Integer id, UserRequest userRequest) {
        Optional<User> foundUser = this.usersRepository.findById(id);
        if (foundUser.isPresent()) {
            User newUser = foundUser.get();
            newUser.setEmail(userRequest.getEmail());
            newUser.setFirstName(userRequest.getFirstName());
            newUser.setLastName(userRequest.getLastName());
//            newUser.setOrders(userRequest.getOrders());
            this.usersRepository.save(newUser);
            return MapEntities.mapUserToUserResponse(newUser);
        }
        return null;
    }

    @Override
    public UserResponse updateOrders(User user) {
        User savedUser = usersRepository.save(user);
        return MapEntities.mapUserToUserResponse(savedUser);
    }
}
