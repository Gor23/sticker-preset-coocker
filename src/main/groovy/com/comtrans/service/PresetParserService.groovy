package com.comtrans.service

import com.comtrans.model.UIPresetsModel
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path

@Service
@Slf4j
class PresetParserService {

    final static Integer FILE_LENGTH = 441
    private Byte[] presetsBinary = new Byte[FILE_LENGTH]

    //String path = "C:\\Users\\IGOR\\git\\f103c\\tabloMaster\\Debug\\tabloMaster.bin"

    short pageSize = 128
    byte[] outArray = new byte[pageSize]

    //sim 0 settings/////////
    Byte[] sim0Apn = new Byte[31]
    Byte[] sim0ApnUser = new Byte[11]
    Byte[] sim0ApnPassword = new Byte[11]

    //sim 1 settings/////////
    Byte[] sim1Apn = new Byte[31]
    Byte[] sim1ApnUser = new Byte[11]
    Byte[] sim1ApnPassword = new Byte[11]

    //server settings/////////
    Byte[] serverURL = new Byte[31]
    Byte[] serverPort = new Byte[6]

    //uzor settings/////////
    Byte sensorEnable0
    Byte sensorEnable1
    Short levelMax0
    Short levelMax1
    Byte dLevelMaxPrecent0
    Byte dLevelMaxPrecent1

    //device settings
    Integer deviceID
    Integer sim0MCCMNC
    Integer[] sim1MCCMNC = new Integer[70]

    Short crc16

    /**
     * Load binary file
     * @param fileName
     * @return
     */
    void readFile(String fileName) {

        byte[] fileData

        try {
            Path path = FileSystems.getDefault().getPath(fileName)
            fileData = Files.readAllBytes(path)

            if (fileData.length != FILE_LENGTH) {
                println("File length is incorrect must be ${FILE_LENGTH} but length is ${fileData.length}")
                throw new Exception("File length is incorrect must be ${FILE_LENGTH} but length is ${fileData.length}")
            }
        } catch (Exception e) {

            println(e.message)
            println("Create default")
            //TODO load default
            fileData = new byte[FILE_LENGTH]
        }

        Arrays.fill(presetsBinary, (byte) 0);
        presetsBinary = fileData
    }

    /**
     * deserealize file to model
     */
    void toPresetModel() {

        Integer j = 0

        for(int i; i<sim0Apn.length; i++){
            sim0Apn[i] = presetsBinary[j++]
        }
        for(int i; i<sim0ApnUser.length; i++){
            sim0ApnUser[i] = presetsBinary[j++]
        }
        for(int i; i<sim0ApnPassword.length; i++){
            sim0ApnPassword[i] = presetsBinary[j++]
        }
        for(int i; i<sim1Apn.length; i++){
            sim1Apn[i] = presetsBinary[j++]
        }
        for(int i; i<sim1ApnUser.length; i++){
            sim1ApnUser[i] = presetsBinary[j++]
        }
        for(int i; i<sim1ApnPassword.length; i++){
            sim1ApnPassword[i] = presetsBinary[j++]
        }
        for(int i; i<serverURL.length; i++){
            serverURL[i] = presetsBinary[j++]
        }
        for(int i; i<serverPort.length; i++){
            serverPort[i] = presetsBinary[j++]
        }
        sensorEnable0 = presetsBinary[j++]
        sensorEnable1 = presetsBinary[j++]

        levelMax0 = presetsBinary[j++]>>8
        levelMax0 |= presetsBinary[j++]
        levelMax1 = presetsBinary[j++]>>8
        levelMax1 |= presetsBinary[j++]

        dLevelMaxPrecent0 = presetsBinary[j++]
        dLevelMaxPrecent1 = presetsBinary[j++]

        deviceID = presetsBinary[j++]>>24
        deviceID |= presetsBinary[j++]>>16
        deviceID |= presetsBinary[j++]>>8
        deviceID |= presetsBinary[j++]

        sim0MCCMNC = presetsBinary[j++]>>24
        sim0MCCMNC |= presetsBinary[j++]>>16
        sim0MCCMNC |= presetsBinary[j++]>>8
        sim0MCCMNC |= presetsBinary[j++]

        for(int i; i<sim1MCCMNC.length; i++){
            sim1MCCMNC[i] = presetsBinary[j++]>>24
            sim1MCCMNC[i] |= presetsBinary[j++]>>16
            sim1MCCMNC[i] |= presetsBinary[j++]>>8
            sim1MCCMNC[i] |= presetsBinary[j++]
        }

        crc16 = presetsBinary[j++]>>8
        crc16 |= presetsBinary[j]
    }

    /**
     * deserialize file to ui preset model (strings)
     * @return
     */
    UIPresetsModel toUIPresetModel(){

        toPresetModel()
        UIPresetsModel uiPresetsModel = new UIPresetsModel(
                sim0Apn: sim0Apn.toString(),
                sim0ApnUser: sim0ApnUser.toString(),
                sim0ApnPassword: sim0ApnPassword.toString(),
                sim1Apn: sim0Apn.toString(),
                sim1ApnUser: sim0ApnUser.toString(),
                sim1ApnPassword: sim0ApnPassword.toString(),
                serverURL: serverURL.toString(),
                serverPort: serverPort.toString(),
                sensorEnable0: sensorEnable0.toString(),
                sensorEnable1: sensorEnable1.toString(),
                levelMax0: levelMax0.toString(),
                levelMax1: levelMax1.toString(),
                dLevelMaxPrecent0: dLevelMaxPrecent0.toString(),
                dLevelMaxPrecent1: dLevelMaxPrecent1.toString(),
                deviceID: deviceID.toString(),
                sim0MCCMNC: sim0MCCMNC.toString(),
        )

        for(int i; i<70; i++){
            uiPresetsModel.sim1MCCMNC.add(sim1MCCMNC[i].toString())
        }

        return uiPresetsModel
    }


}



