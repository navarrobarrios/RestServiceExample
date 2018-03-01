package mx.restserviceexample.restserviceexample.controllers;

import mx.restserviceexample.restserviceexample.beans.ErrorCodesAplication;
import mx.restserviceexample.restserviceexample.beans.ErrorResponse;
import mx.restserviceexample.restserviceexample.beans.GeneralResponse;
import mx.restserviceexample.restserviceexample.beans.User;
import mx.restserviceexample.restserviceexample.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    //region Variables
    @Autowired
    private IUserService userService;
    //endregion

    //region Mapping
    @GetMapping("users/getUser/{username}")
    @ResponseBody
    public ResponseEntity<GeneralResponse> getUser(@PathVariable("username") String username) {
        GeneralResponse userResponse = new GeneralResponse();
        User user_by_id = userService.getUserByUsername(username);
        if(user_by_id != null){
            userResponse.setSuccess(true);
            userResponse.setResult(user_by_id);
            return new ResponseEntity<GeneralResponse>(userResponse, HttpStatus.OK);
        }else{
            userResponse.setSuccess(false);
            userResponse.setResult(new ErrorResponse(ErrorCodesAplication.ERROR_001));
            return new ResponseEntity<GeneralResponse>(userResponse, HttpStatus.OK);
        }
    }
    @GetMapping("users/getUsers")
    @ResponseBody
    public ResponseEntity<GeneralResponse> getUsers() {
        GeneralResponse usersResponse = new GeneralResponse();
        List<User> users = userService.getAllUsers();
        usersResponse.setSuccess(true);
        usersResponse.setResult(users);
        return new ResponseEntity<GeneralResponse>(usersResponse, HttpStatus.OK);
    }
    //endregion
}
