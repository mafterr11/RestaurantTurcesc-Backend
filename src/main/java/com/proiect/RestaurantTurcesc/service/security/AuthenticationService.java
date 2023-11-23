package com.proiect.RestaurantTurcesc.service.security;

import com.proiect.RestaurantTurcesc.models.security.AuthenticationResponse;
import com.proiect.RestaurantTurcesc.models.security.LoginRequest;
import com.proiect.RestaurantTurcesc.models.security.RegisterRequest;

public interface AuthenticationService{

    AuthenticationResponse login(LoginRequest loginRequest);

    AuthenticationResponse register(RegisterRequest registerRequest);
}

