package com.mongo.starter;

import com.mongo.controllers.GetUsersController;
import com.mongo.model.common.StatusMessages;
import com.mongo.model.set.SetUserRequest;
import com.mongo.model.set.SetUserResponse;
import com.mongo.model.delete.DeleteUserRequest;
import com.mongo.model.delete.DeleteUserResponse;
import com.mongo.model.entity.UserResponse;
import com.mongo.model.get.GetUsersRequest;
import com.mongo.model.get.GetUsersResponse;
import com.mongo.services.DeleteUserService;
import com.mongo.services.GetUsersService;
import com.mongo.services.SetUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetUsersControllerTest {
    
    @Mock
    GetUsersService getUsersService;
    @Mock
    SetUserService setUserService;
    @Mock
    DeleteUserService deleteUserService;

    GetUsersController controller;

    @Before
    public void setUp(){
        controller = new GetUsersController(getUsersService, setUserService, deleteUserService);
    }

    @Test
    public void successDeleteUserTest(){
        when(deleteUserService.deleteUser(any(DeleteUserRequest.class))).thenReturn(new ResponseEntity(new DeleteUserResponse(), HttpStatus.OK));
        ResponseEntity responseEntity = controller.deleteUser(getDeleteRequest());
        DeleteUserResponse response = successDeleteUserResponse();
        assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
        assertEquals(1, response.getStatusMessages().size());
        assertEquals("Success",response.getStatusMessages().get(0).getCode());

    }

    @Test
    public void userNotFoundForDeleteTest(){
        when(deleteUserService.deleteUser(any(DeleteUserRequest.class))).thenReturn(new ResponseEntity(getUserNotFoundResponse(), HttpStatus.OK));
        ResponseEntity responseEntity = controller.deleteUser(getDeleteRequest());
        DeleteUserResponse response = getUserNotFoundResponse();
        assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
        assertEquals(1, response.getStatusMessages().size());
        assertEquals("Failed",response.getStatusMessages().get(0).getCode());
    }

    @Test
    public void setNewUserTest(){
        when(setUserService.saveUser(any(SetUserRequest.class))).thenReturn(new ResponseEntity(new SetUserResponse(), HttpStatus.OK));
        ResponseEntity responseEntity = controller.setUser(getCreateUserRequest());
        assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
    }

    // TODO: Test for user already existing
    // TODO: determine how mongo recognizes unique identifiers
//    @Test
//    public void userAlreadyExistTest(){
//        when()
//    }

    @Test
    public void getListOfUsersTest(){
        when(getUsersService.getUsers(any(GetUsersRequest.class))).thenReturn(new ResponseEntity(getUsersResponse(), HttpStatus.OK));
        ResponseEntity responseEntity = controller.getUsers(getUsersRequest());
        GetUsersResponse response = getUsersResponse();
        assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
        assertEquals(1, response.getGameNameUsersList().size());
    }


    private DeleteUserRequest getDeleteRequest(){
        DeleteUserRequest request = new DeleteUserRequest();
        request.setFirstName("George");
        request.setLastName("Washington");
        request.setStreetAddress("1600 Pennsylvania Ave.");
        request.setCity("Washington");
        request.setState("District of Columbia");
        return request;
    }

    private DeleteUserResponse getUserNotFoundResponse(){
        DeleteUserResponse response = new DeleteUserResponse();
        List<StatusMessages> statusMessagesList = new ArrayList();
        StatusMessages statusMessages = new StatusMessages();
        statusMessages.setCode("Failed");
        statusMessages.setSubCode("Data Update Failed");
        statusMessages.setMessage("Test Failed");
        statusMessagesList.add(statusMessages);
        response.setStatusMessages(statusMessagesList);
        return response;

    }

    private DeleteUserResponse successDeleteUserResponse(){
        DeleteUserResponse response = new DeleteUserResponse();
        List<StatusMessages> statusMessagesList = new ArrayList();
        StatusMessages statusMessages = new StatusMessages();
        statusMessages.setCode("Success");
        statusMessages.setSubCode("Data Updated");
        statusMessages.setMessage("User was deleted successfully.");
        statusMessagesList.add(statusMessages);
        response.setStatusMessages(statusMessagesList);
        return response;

    }

    private SetUserRequest getCreateUserRequest(){
        SetUserRequest request = new SetUserRequest();
        request.setFirstName("George");
        request.setLastName("Washington");
        request.setStreetAddress("1600 Pennsylvania Ave.");
        request.setCity("Washington");
        request.setState("District of Columbia");
        return request;
    }

    private GetUsersRequest getUsersRequest(){
        GetUsersRequest request = new GetUsersRequest();
        request.setGameName("Madden");
        return request;
    }

    private GetUsersResponse getUsersResponse(){
        GetUsersResponse response = new GetUsersResponse();
        UserResponse userResponse = new UserResponse();
        List<UserResponse> userResponseList = new ArrayList<>();
        userResponse.setFirstName("George");
        userResponse.setLastName("Washington");
        userResponse.setStreetAddress("1600 Pennsylvania Ave.");
        userResponse.setCity("Washington");
        userResponse.setState("District of Columbia");
        userResponseList.add(userResponse);
        response.setGameNameUsersList(userResponseList);
        return response;
    }
}
