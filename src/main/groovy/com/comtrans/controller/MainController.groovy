package com.comtrans.controller

import com.comtrans.model.UIPresetsModel
import com.comtrans.service.PresetParserService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@Slf4j
class MainController {

    @Autowired
    PresetParserService parserService

    @RequestMapping(value = '/preset', method = RequestMethod.GET)
    def showTable(Model model){

        UIPresetsModel presetsModel = parserService.readModelFromFile()
        //model.addAttribute("preset", presetsModel)
        model.addAttribute("preset", "ggg")
        return "table"
    }
}
