package com.comtrans.model

class UIPresetsModel {

    //sim 0 settings/////////
    String sim0Apn
    String sim0ApnUser
    String sim0ApnPassword

    //sim 1 settings/////////
    String sim1Apn
    String sim1ApnUser
    String sim1ApnPassword

    //server settings/////////
    String serverURL
    String serverPort

    //uzor settings/////////
    String sensorEnable0
    String sensorEnable1
    String levelMax0
    String levelMax1
    String dLevelMaxPrecent0
    String dLevelMaxPrecent1

    //device settings
    String deviceID
    MCCMNCModel sim0MCCMNC
    List<MCCMNCModel> sim1MCCMNC = []

    String crc16
}
