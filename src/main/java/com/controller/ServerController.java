package com.controller;

import com.common.Result;
import com.domain.Server;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者： Mr.T
 * 描述:
 * 时间: 2023-04-16 23-45
 */
@RestController
@RequestMapping("/monitor/server")
public class ServerController {
    @GetMapping()
    public Result getInfo() throws Exception
    {
        Server server = new Server();
        server.copyTo();
        return new Result(server);
    }
}
