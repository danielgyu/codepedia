package com.hismayfly.orderexecution.transport;

import com.hismayfly.orderexecution.application.RegisterShoeService;
import com.hismayfly.orderexecution.domain.dto.RegisterShoeDTO;
import com.hismayfly.orderexecution.domain.dto.RegisterShoeRespDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ShoeController {

    final Logger logger = LoggerFactory.getLogger(ShoeController.class);

    @Autowired
    private RegisterShoeService registerShoeService;

    @PostMapping("/shoe")
    public RegisterShoeRespDTO registerShoe(@RequestBody RegisterShoeDTO dto) {
        logger.info("[REQ] dto" + dto.toString());
        RegisterShoeRespDTO resp = registerShoeService.execute(dto);
        if (resp.isSuccess()) {
            return resp;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, resp.failedReason());
    }
}
