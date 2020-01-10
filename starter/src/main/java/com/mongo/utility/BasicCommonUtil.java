package com.mongo.utility;

import com.mongo.model.common.StatusMessages;

import java.util.ArrayList;
import java.util.List;

public interface BasicCommonUtil {

    static List<StatusMessages> processStatusMessages(String code, String subCode, String message){
        StatusMessages statusMessages = new StatusMessages();
        statusMessages.setCode(code);
        statusMessages.setSubCode(subCode);
        statusMessages.setMessage(message);
        StatusMessages.Type.valueOf("INFORMATION");
        List<StatusMessages> statusMessagesList = new ArrayList<>();
        statusMessagesList.add(statusMessages);
        return statusMessagesList;
    }
}
