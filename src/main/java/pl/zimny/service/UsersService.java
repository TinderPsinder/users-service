package pl.zimny.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.zimny.dao.ProfileRepository;
import pl.zimny.model.Profile;
import pl.zimny.model.ProfileDetails;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final ProfileRepository profileRepository;

    public Profile getUserProfile(Long userId){
        return profileRepository.findByUserId(userId).orElse(null);
    }

    public HttpStatus registerUser(){
        //validate user data
        // save user to the database
        profileRepository.saveAndFlush( new Profile(1111L, new ProfileDetails("This is my first profile", Collections.emptyList())));
        //send an activation link

        return HttpStatus.OK;
    }

    public HttpStatus reportUser(){
        // validate report data
        // send email to the admin?
        return HttpStatus.OK;
    }

    public HttpStatus confirmMischief(){
        // validate mischief data
        // save mischief to the database
        // validate if qualifies for a ban if yes ban the user - send to Auth service not to let him enter
        // send email to the mischievous user
        return HttpStatus.OK;
    }
}
