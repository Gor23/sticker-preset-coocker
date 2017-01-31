package com.comtrans.controller

import com.comtrans.model.UIPresetsModel
import com.comtrans.service.PresetParserService
import com.fasterxml.jackson.databind.ObjectMapper
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
@Slf4j
class MainController {

    @Autowired
    PresetParserService parserService

    @Autowired
    ObjectMapper objectMapper

    @RequestMapping(value = '/preset', method = RequestMethod.GET)
    def showTable(Model model) {

        UIPresetsModel presetsModel = parserService.readModelFromFile()
        //model.addAttribute("preset", presetsModel)
        //def json = objectMapper.writeValueAsString(presetsModel)
        model.addAttribute("preset", presetsModel)
        return "table"
    }

    @RequestMapping(value = '/preset', method = RequestMethod.POST)
    def saveData(Model model,
                 @RequestParam(value = "ID") String ID,
                 @RequestParam(value = "sim0Apn") String sim0Apn,
                 @RequestParam(value = "sim0ApnUser") String sim0ApnUser,
                 @RequestParam(value = "sim0ApnPassword") String sim0ApnPassword,
                 @RequestParam(value = "sim1Apn") String sim1Apn,
                 @RequestParam(value = "sim1ApnUser") String sim1ApnUser,
                 @RequestParam(value = "sim1ApnPassword") String sim1ApnPassword,
                 @RequestParam(value = "serverURL") String serverURL,
                 @RequestParam(value = "serverPort") String serverPort,
                 @RequestParam(value = "sim0MCC") String sim0MCC,
                 @RequestParam(value = "sim0MNC") String sim0MNC,
                 @RequestParam(value = "sim1MCC0") String sim1MCC0,
                 @RequestParam(value = "sim1MNC0") String sim1MNC0,
                 @RequestParam(value = "sim1MCC1") String sim1MCC1,
                 @RequestParam(value = "sim1MNC1") String sim1MNC1,
                 @RequestParam(value = "sim1MCC2") String sim1MCC2,
                 @RequestParam(value = "sim1MNC2") String sim1MNC2,
                 @RequestParam(value = "sim1MCC3") String sim1MCC3,
                 @RequestParam(value = "sim1MNC3") String sim1MNC3,
                 @RequestParam(value = "sim1MCC4") String sim1MCC4,
                 @RequestParam(value = "sim1MNC4") String sim1MNC4,
                 @RequestParam(value = "sim1MCC4") String sim1MCC5,
                 @RequestParam(value = "sim1MNC4") String sim1MNC5,
                 @RequestParam(value = "sim1MCC6") String sim1MCC6,
                 @RequestParam(value = "sim1MNC6") String sim1MNC6,
                 @RequestParam(value = "sim1MCC7") String sim1MCC7,
                 @RequestParam(value = "sim1MNC7") String sim1MNC7,
                 @RequestParam(value = "sim1MCC8") String sim1MCC8,
                 @RequestParam(value = "sim1MNC8") String sim1MNC8,
                 @RequestParam(value = "sim1MCC9") String sim1MCC9,
                 @RequestParam(value = "sim1MNC9") String sim1MNC9,
                 @RequestParam(value = "sim1MCC10") String sim1MCC10,
                 @RequestParam(value = "sim1MNC10") String sim1MNC10,
                 @RequestParam(value = "sim1MCC11") String sim1MCC11,
                 @RequestParam(value = "sim1MNC11") String sim1MNC11,
                 @RequestParam(value = "sim1MCC12") String sim1MCC12,
                 @RequestParam(value = "sim1MNC12") String sim1MNC12,
                 @RequestParam(value = "sim1MCC13") String sim1MCC13,
                 @RequestParam(value = "sim1MNC13") String sim1MNC13,
                 @RequestParam(value = "sim1MCC14") String sim1MCC14,
                 @RequestParam(value = "sim1MNC14") String sim1MNC14,
                 @RequestParam(value = "sim1MCC15") String sim1MCC15,
                 @RequestParam(value = "sim1MNC15") String sim1MNC15,
                 @RequestParam(value = "sim1MCC16") String sim1MCC16,
                 @RequestParam(value = "sim1MNC16") String sim1MNC16,
                 @RequestParam(value = "sim1MCC17") String sim1MCC17,
                 @RequestParam(value = "sim1MNC17") String sim1MNC17,
                 @RequestParam(value = "sim1MCC18") String sim1MCC18,
                 @RequestParam(value = "sim1MNC18") String sim1MNC18,
                 @RequestParam(value = "sim1MCC19") String sim1MCC19,
                 @RequestParam(value = "sim1MNC19") String sim1MNC19,
                 @RequestParam(value = "sim1MCC20") String sim1MCC20,
                 @RequestParam(value = "sim1MNC20") String sim1MNC20,
                 @RequestParam(value = "sim1MCC21") String sim1MCC21,
                 @RequestParam(value = "sim1MNC21") String sim1MNC21,
                 @RequestParam(value = "sim1MCC22") String sim1MCC22,
                 @RequestParam(value = "sim1MNC22") String sim1MNC22,
                 @RequestParam(value = "sim1MCC23") String sim1MCC23,
                 @RequestParam(value = "sim1MNC23") String sim1MNC23,
                 @RequestParam(value = "sim1MCC24") String sim1MCC24,
                 @RequestParam(value = "sim1MNC24") String sim1MNC24,
                 @RequestParam(value = "sim1MCC25") String sim1MCC25,
                 @RequestParam(value = "sim1MNC25") String sim1MNC25,
                 @RequestParam(value = "sim1MCC26") String sim1MCC26,
                 @RequestParam(value = "sim1MNC26") String sim1MNC26,
                 @RequestParam(value = "sim1MCC27") String sim1MCC27,
                 @RequestParam(value = "sim1MNC27") String sim1MNC27,
                 @RequestParam(value = "sim1MCC28") String sim1MCC28,
                 @RequestParam(value = "sim1MNC28") String sim1MNC28,
                 @RequestParam(value = "sim1MCC29") String sim1MCC29,
                 @RequestParam(value = "sim1MNC29") String sim1MNC29,
                 @RequestParam(value = "sim1MCC30") String sim1MCC30,
                 @RequestParam(value = "sim1MNC30") String sim1MNC30,
                 @RequestParam(value = "sim1MCC31") String sim1MCC31,
                 @RequestParam(value = "sim1MNC31") String sim1MNC31,
                 @RequestParam(value = "sim1MCC32") String sim1MCC32,
                 @RequestParam(value = "sim1MNC32") String sim1MNC32,
                 @RequestParam(value = "sim1MCC33") String sim1MCC33,
                 @RequestParam(value = "sim1MNC33") String sim1MNC33,
                 @RequestParam(value = "sim1MCC34") String sim1MCC34,
                 @RequestParam(value = "sim1MNC34") String sim1MNC34,
                 @RequestParam(value = "sim1MCC35") String sim1MCC35,
                 @RequestParam(value = "sim1MNC35") String sim1MNC35,
                 @RequestParam(value = "sim1MCC36") String sim1MCC36,
                 @RequestParam(value = "sim1MNC36") String sim1MNC36,
                 @RequestParam(value = "sim1MCC37") String sim1MCC37,
                 @RequestParam(value = "sim1MNC37") String sim1MNC37,
                 @RequestParam(value = "sim1MCC38") String sim1MCC38,
                 @RequestParam(value = "sim1MNC38") String sim1MNC38,
                 @RequestParam(value = "sim1MCC39") String sim1MCC39,
                 @RequestParam(value = "sim1MNC39") String sim1MNC39,
                 @RequestParam(value = "sim1MCC40") String sim1MCC40,
                 @RequestParam(value = "sim1MNC40") String sim1MNC40,
                 @RequestParam(value = "sim1MCC41") String sim1MCC41,
                 @RequestParam(value = "sim1MNC41") String sim1MNC41,
                 @RequestParam(value = "sim1MCC42") String sim1MCC42,
                 @RequestParam(value = "sim1MNC42") String sim1MNC42,
                 @RequestParam(value = "sim1MCC43") String sim1MCC43,
                 @RequestParam(value = "sim1MNC43") String sim1MNC43,
                 @RequestParam(value = "sim1MCC44") String sim1MCC44,
                 @RequestParam(value = "sim1MNC44") String sim1MNC44,
                 @RequestParam(value = "sim1MCC45") String sim1MCC45,
                 @RequestParam(value = "sim1MNC45") String sim1MNC45,
                 @RequestParam(value = "sim1MCC46") String sim1MCC46,
                 @RequestParam(value = "sim1MNC46") String sim1MNC46,
                 @RequestParam(value = "sim1MCC47") String sim1MCC47,
                 @RequestParam(value = "sim1MNC47") String sim1MNC47,
                 @RequestParam(value = "sim1MCC48") String sim1MCC48,
                 @RequestParam(value = "sim1MNC48") String sim1MNC48,
                 @RequestParam(value = "sim1MCC49") String sim1MCC49,
                 @RequestParam(value = "sim1MNC49") String sim1MNC49,
                 @RequestParam(value = "sim1MCC50") String sim1MCC50,
                 @RequestParam(value = "sim1MNC50") String sim1MNC50,
                 @RequestParam(value = "sim1MCC51") String sim1MCC51,
                 @RequestParam(value = "sim1MNC51") String sim1MNC51,
                 @RequestParam(value = "sim1MCC52") String sim1MCC52,
                 @RequestParam(value = "sim1MNC52") String sim1MNC52,
                 @RequestParam(value = "sim1MCC53") String sim1MCC53,
                 @RequestParam(value = "sim1MNC53") String sim1MNC53,
                 @RequestParam(value = "sim1MCC54") String sim1MCC54,
                 @RequestParam(value = "sim1MNC54") String sim1MNC54,
                 @RequestParam(value = "sim1MCC55") String sim1MCC55,
                 @RequestParam(value = "sim1MNC55") String sim1MNC55,
                 @RequestParam(value = "sim1MCC56") String sim1MCC56,
                 @RequestParam(value = "sim1MNC56") String sim1MNC56,
                 @RequestParam(value = "sim1MCC57") String sim1MCC57,
                 @RequestParam(value = "sim1MNC57") String sim1MNC57,
                 @RequestParam(value = "sim1MCC58") String sim1MCC58,
                 @RequestParam(value = "sim1MNC58") String sim1MNC58,
                 @RequestParam(value = "sim1MCC59") String sim1MCC59,
                 @RequestParam(value = "sim1MNC59") String sim1MNC59,
                 @RequestParam(value = "sim1MCC60") String sim1MCC60,
                 @RequestParam(value = "sim1MNC60") String sim1MNC60,
                 @RequestParam(value = "sim1MCC61") String sim1MCC61,
                 @RequestParam(value = "sim1MNC61") String sim1MNC61,
                 @RequestParam(value = "sim1MCC62") String sim1MCC62,
                 @RequestParam(value = "sim1MNC62") String sim1MNC62,
                 @RequestParam(value = "sim1MCC63") String sim1MCC63,
                 @RequestParam(value = "sim1MNC63") String sim1MNC63,
                 @RequestParam(value = "sim1MCC64") String sim1MCC64,
                 @RequestParam(value = "sim1MNC64") String sim1MNC64,
                 @RequestParam(value = "sim1MCC65") String sim1MCC65,
                 @RequestParam(value = "sim1MNC65") String sim1MNC65,
                 @RequestParam(value = "sim1MCC66") String sim1MCC66,
                 @RequestParam(value = "sim1MNC66") String sim1MNC66,
                 @RequestParam(value = "sim1MCC67") String sim1MCC67,
                 @RequestParam(value = "sim1MNC67") String sim1MNC67,
                 @RequestParam(value = "sim1MCC68") String sim1MCC68,
                 @RequestParam(value = "sim1MNC68") String sim1MNC68,
                 @RequestParam(value = "sim1MCC69") String sim1MCC69,
                 @RequestParam(value = "sim1MNC69") String sim1MNC69,
                 @RequestParam(value = "sim1MCC70") String sim1MCC70,
                 @RequestParam(value = "sim1MNC70") String sim1MNC70
                 ) {

        //return "table"
    }
}
