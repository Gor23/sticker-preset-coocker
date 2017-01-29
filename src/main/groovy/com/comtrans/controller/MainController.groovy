package com.comtrans.controller

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@Slf4j
class MainController {

    @RequestMapping(value = '/preset', method = RequestMethod.GET)
    def showTable(Model model){
        //model.addAttribute("card", card)
        return "table"
    }
}
