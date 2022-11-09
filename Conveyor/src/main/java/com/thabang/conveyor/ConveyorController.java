package com.thabang.conveyor;



import com.thabang.conveyor.dto.LoanApplicationRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/conveyor/offers")
public class ConveyorController {

    @Autowired
    private ConveyorService conveyorService;



    @PostMapping
    public List<LoanApplicationRequestDTO> loanOffer()
    {

        return conveyorService.getUserInfo();
    }
}
