package com.dorinbrage.easyrs.example.web.rest.service.test;

import com.dorinbrage.easyrs.example.web.dto.UserDTO;
import com.dorinbrage.easyrs.example.web.endpoints.UserEndpoint;
import com.dorinbrage.easyrs.processor.annotation.EndpointTest;
import com.dorinbrage.easyrs.processor.enums.ClientOperation;

/**
 * @author Dorin_Brage
 */
@EndpointTest(endpoint = UserEndpoint.class, entity = UserDTO.class,
    operations = {ClientOperation.GET_ALL})
public interface UserRest {

}
