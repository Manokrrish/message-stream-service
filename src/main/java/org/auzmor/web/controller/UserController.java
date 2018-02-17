package org.auzmor.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.auzmor.web.proto.UserProto;
import org.auzmor.web.proto.UserProto.User.Builder;
import org.auzmor.web.service.QueueService;
import org.auzmor.web.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	private Log log = LogFactory.getLog(UserController.class.getName());
	
	@Autowired
	QueueService queueService;
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST, consumes={"application/*"})
    public void addUser(@RequestBody User user) {
		log.info("Adding User:"+user.getId());
        Builder userBuild = UserProto.User.newBuilder();
        userBuild.setId(user.getId());
        userBuild.setFname(user.getfName());
        userBuild.setLname(user.getlName());
        queueService.pushUserToQueue(userBuild.build());
    }

}
