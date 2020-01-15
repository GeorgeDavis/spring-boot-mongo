package com.mongo.services;

import com.mongo.collections.User;
import com.mongo.model.common.StatusMessages;
import com.mongo.model.delete.DeleteUserRequest;
import com.mongo.model.delete.DeleteUserResponse;
import com.mongo.repositories.UserRepository;
import com.mongo.utility.BasicCommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeleteUserServiceImpl implements DeleteUserService {

    @Autowired
    private UserRepository userRepository;

    public DeleteUserServiceImpl() {
        // empty constructor
    }

    @Override
    public ResponseEntity<DeleteUserResponse> deleteUser(DeleteUserRequest request) {

        DeleteUserResponse response = new DeleteUserResponse();
        List<StatusMessages> statusMessagesList = new ArrayList<>();
        User user = userRepository.findUserByLastName(request.getLastName());
        if(user != null){
            try{
                userRepository.delete(user);
                statusMessagesList = BasicCommonUtil.processStatusMessages("Success", "Data Updated",
                        "User was deleted successfully.");
                response.setStatusMessages(statusMessagesList);
            } catch (Exception ex){
                // log the stacktrace
            }
        } else {
            statusMessagesList = BasicCommonUtil.processStatusMessages("Failed", "Data Update Failed",
                    "User not found in system. Delete failed for this user.");
            response.setStatusMessages(statusMessagesList);
        }
        return new ResponseEntity(response, HttpStatus.OK);
    }
}