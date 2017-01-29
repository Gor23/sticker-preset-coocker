package com.comtrans.service

import com.comtrans.model.MCCMNCModel
import com.comtrans.model.UIPresetsModel
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path

@Service
@Slf4j
class PresetParserService {

    @PostConstruct
    void test(){

        readFile("F:\\preset.bin")
        UIPresetsModel model = toUIPresetModel()
        println("finish")
    }

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
    Short sensorEnable0
    Short sensorEnable1
    Integer levelMax0
    Integer levelMax1
    Short dLevelMaxPrecent0
    Short dLevelMaxPrecent1

    //device settings
    Long deviceID
    Integer sim0MCC
    Integer sim0MNC
    Integer[] sim1MCC = new Integer[70]
    Integer[] sim1MNC = new Integer[70]

    Integer crc16

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
        sensorEnable0 = presetsBinary[j++]&0xFF
        sensorEnable1 = presetsBinary[j++]&0xFF

        levelMax0 = (presetsBinary[j++]&0xFF)<<8
        levelMax0 |= presetsBinary[j++]&0xFF
        levelMax1 = (presetsBinary[j++]&0xFF)<<8
        levelMax1 |= presetsBinary[j++]&0xFF

        dLevelMaxPrecent0 = presetsBinary[j++]&0xFF
        dLevelMaxPrecent1 = presetsBinary[j++]&0xFF

        deviceID = (presetsBinary[j++]&0xFF)<<24
        deviceID |= (presetsBinary[j++]&0xFF)<<16
        deviceID |= (presetsBinary[j++]&0xFF)<<8
        deviceID |= presetsBinary[j++]&0xFF

        sim0MCC = (presetsBinary[j++]&0xFF)<<8
        sim0MCC |= presetsBinary[j++]&0xFF
        sim0MNC = (presetsBinary[j++]&0xFF)<<8
        sim0MNC |= presetsBinary[j++]&0xFF

        for(int i; i<sim1MCC.length; i++){
            sim1MCC[i] = (presetsBinary[j++]&0xFF)<<8
            sim1MCC[i] |= presetsBinary[j++]&0xFF
            sim1MNC[i] = (presetsBinary[j++]&0xFF)<<8
            sim1MNC[i] |= presetsBinary[j++]&0xFF
        }

        crc16 = (presetsBinary[j++]&0xFF)<<8
        crc16 |= presetsBinary[j]&0xFF
    }

    /**
     * deserialize file to ui preset model (strings)
     * @return
     */
    UIPresetsModel toUIPresetModel(){

        toPresetModel()
        UIPresetsModel uiPresetsModel = new UIPresetsModel(
                sim0Apn: new String(sim0Apn).trim(),
                sim0ApnUser: new String(sim0ApnUser).trim(),
                sim0ApnPassword: new String(sim0ApnPassword).trim(),
                sim1Apn: new String(sim1Apn).trim(),
                sim1ApnUser: new String(sim1ApnUser).trim(),
                sim1ApnPassword: new String(sim1ApnPassword).trim(),
                serverURL: new String(serverURL).trim(),
                serverPort: new String(serverPort).trim(),
                sensorEnable0: sensorEnable0.toString(),
                sensorEnable1: sensorEnable1.toString(),
                levelMax0: levelMax0.toString(),
                levelMax1: levelMax1.toString(),
                dLevelMaxPrecent0: dLevelMaxPrecent0.toString(),
                dLevelMaxPrecent1: dLevelMaxPrecent1.toString(),
                deviceID: deviceID.toString(),
                sim0MCCMNC: new MCCMNCModel(MCC: sim0MCC.toString(), MNC: sim0MNC.toString()),
                crc16: crc16.toString()
        )

        for(int i; i<70; i++){
            uiPresetsModel.sim1MCCMNC.add(new MCCMNCModel(MCC: sim1MCC[i].toString(), MNC: sim1MNC[i].toString()))
        }

        return uiPresetsModel
    }


}



