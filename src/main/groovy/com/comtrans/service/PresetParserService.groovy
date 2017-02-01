package com.comtrans.service

import com.comtrans.model.MCCMNCModel
import com.comtrans.model.UIPresetsModel
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service

import javax.annotation.PostConstruct
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path

@Scope("prototype")
@Service
@Slf4j
class PresetParserService {

//    @PostConstruct
//    void test() {
//
//        readFile("/home/igor/Dropbox/preset.bin")
//        UIPresetsModel model = toUIPresetModel()
//        fromUiPresetModelToByteArray(model)
//        writeFile("/home/igor/Dropbox/preset2.bin")
//        println("finish")
//    }


    @Value('${preset.path:/daemon/server/presets/}')
    String pathToPresetsFolder

    final static Integer FILE_LENGTH = 441
    final static Integer APN_STRING_LENGTH = 31
    final static Integer APN_USER_STRING_LENGTH = 11
    final static Integer APN_PASSWORD_STRING_LENGTH = 11
    final static Integer SERVER_URL_STRING_LENGTH = 31
    final static Integer SERVER_PORT_STRING_LENGTH = 6
    final static Integer ID_START_POSITION = 151

    private byte[] presetsBinary = new byte[FILE_LENGTH]

    //sim 0 settings/////////
    byte[] sim0Apn = new byte[APN_STRING_LENGTH]
    byte[] sim0ApnUser = new byte[APN_USER_STRING_LENGTH]
    byte[] sim0ApnPassword = new byte[APN_PASSWORD_STRING_LENGTH]

    //sim 1 settings/////////
    byte[] sim1Apn = new byte[APN_STRING_LENGTH]
    byte[] sim1ApnUser = new byte[APN_USER_STRING_LENGTH]
    byte[] sim1ApnPassword = new byte[APN_PASSWORD_STRING_LENGTH]

    //server settings/////////
    byte[] serverURL = new byte[SERVER_URL_STRING_LENGTH]
    byte[] serverPort = new byte[SERVER_PORT_STRING_LENGTH]

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
     * Прочитать файл с натройками и выдать модель
     * @param ID
     * @return
     */
    UIPresetsModel readModelFromFile(String ID) {

        readFile(pathToPresetsFolder + ID)
        return toUIPresetModel()
    }

    /**
     * Прочитать файл с дефолтными натройками и выдать модель, ID в файл вбивается тот который бал введён
     * @param ID
     * @return
     */
    UIPresetsModel readDefaultPresets(String ID) {

        Long defDevID = 0
        Integer position = ID_START_POSITION

        readFile(pathToPresetsFolder + "preset")
        defDevID = ID.toLong()
        presetsBinary[position++] = 0
        presetsBinary[position++] = 0
        presetsBinary[position++] = 0
        presetsBinary[position] = 0

        position = ID_START_POSITION
        presetsBinary[position++] = (byte) (defDevID >> 24) & 0xFF
        presetsBinary[position++] |= (byte) (defDevID >> 16) & 0xFF
        presetsBinary[position++] |= (byte) (defDevID >> 8) & 0xFF
        presetsBinary[position] |= (byte) defDevID & 0xFF

        return toUIPresetModel()
    }

    /**
     * Load binary file
     * @param fileName
     * @return
     */
    void readFile(String fileName) {

        byte[] fileData
        Path path = FileSystems.getDefault().getPath(fileName)
        fileData = Files.readAllBytes(path)

        if (fileData.length != FILE_LENGTH) {
            println("File length is incorrect must be ${FILE_LENGTH} but length is ${fileData.length}")
            throw new Exception("File length is incorrect must be ${FILE_LENGTH} but length is ${fileData.length}")
        }
        Arrays.fill(presetsBinary, (byte) 0)
        presetsBinary = fileData
    }

    /**
     * deserealize file to model
     */
    void toPresetModel() {

        Integer j = 0

        for (int i; i < sim0Apn.length; i++) {
            sim0Apn[i] = presetsBinary[j++]
        }
        for (int i; i < sim0ApnUser.length; i++) {
            sim0ApnUser[i] = presetsBinary[j++]
        }
        for (int i; i < sim0ApnPassword.length; i++) {
            sim0ApnPassword[i] = presetsBinary[j++]
        }
        for (int i; i < sim1Apn.length; i++) {
            sim1Apn[i] = presetsBinary[j++]
        }
        for (int i; i < sim1ApnUser.length; i++) {
            sim1ApnUser[i] = presetsBinary[j++]
        }
        for (int i; i < sim1ApnPassword.length; i++) {
            sim1ApnPassword[i] = presetsBinary[j++]
        }
        for (int i; i < serverURL.length; i++) {
            serverURL[i] = presetsBinary[j++]
        }
        for (int i; i < serverPort.length; i++) {
            serverPort[i] = presetsBinary[j++]
        }
        sensorEnable0 = (short) (presetsBinary[j++] & 0xFF)
        sensorEnable1 = (short) (presetsBinary[j++] & 0xFF)

        levelMax0 = (presetsBinary[j++] & 0xFF) << 8
        levelMax0 |= presetsBinary[j++] & 0xFF
        levelMax1 = (presetsBinary[j++] & 0xFF) << 8
        levelMax1 |= presetsBinary[j++] & 0xFF

        dLevelMaxPrecent0 = (short) (presetsBinary[j++] & 0xFF)
        dLevelMaxPrecent1 = (short) (presetsBinary[j++] & 0xFF)

        deviceID = (presetsBinary[j++] & 0xFF) << 24
        deviceID |= (presetsBinary[j++] & 0xFF) << 16
        deviceID |= (presetsBinary[j++] & 0xFF) << 8
        deviceID |= presetsBinary[j++] & 0xFF

        sim0MCC = (presetsBinary[j++] & 0xFF) << 8
        sim0MCC |= presetsBinary[j++] & 0xFF
        sim0MNC = (presetsBinary[j++] & 0xFF) << 8
        sim0MNC |= presetsBinary[j++] & 0xFF

        for (int i; i < sim1MCC.length; i++) {
            sim1MCC[i] = (presetsBinary[j++] & 0xFF) << 8
            sim1MCC[i] |= presetsBinary[j++] & 0xFF
            sim1MNC[i] = (presetsBinary[j++] & 0xFF) << 8
            sim1MNC[i] |= presetsBinary[j++] & 0xFF
        }

        crc16 = (presetsBinary[j++] & 0xFF) << 8
        crc16 |= presetsBinary[j] & 0xFF
    }

    /**
     * deserialize file to ui preset model (strings)
     * @return
     */
    UIPresetsModel toUIPresetModel() {

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

        for (int i; i < 70; i++) {
            uiPresetsModel.sim1MCCMNC.add(new MCCMNCModel(MCC: sim1MCC[i].toString(), MNC: sim1MNC[i].toString()))
        }

        return uiPresetsModel
    }

    /**
     * convert data arrays to common data array
     */
    void fromPresetByteModelToByteArray() {

        Integer j = 0

        Arrays.fill(presetsBinary, (byte) 0)

        for (int i; i < sim0Apn.length; i++) {
            presetsBinary[j++] = sim0Apn[i]
        }
        for (int i; i < sim0ApnUser.length; i++) {
            presetsBinary[j++] = sim0ApnUser[i]
        }
        for (int i; i < sim0ApnPassword.length; i++) {
            presetsBinary[j++] = sim0ApnPassword[i]
        }
        for (int i; i < sim1Apn.length; i++) {
            presetsBinary[j++] = sim1Apn[i]
        }
        for (int i; i < sim1ApnUser.length; i++) {
            presetsBinary[j++] = sim1ApnUser[i]
        }
        for (int i; i < sim1ApnPassword.length; i++) {
            presetsBinary[j++] = sim1ApnPassword[i]
        }
        for (int i; i < serverURL.length; i++) {
            presetsBinary[j++] = serverURL[i]
        }
        for (int i; i < serverPort.length; i++) {
            presetsBinary[j++] = serverPort[i]
        }
        presetsBinary[j++] = (byte) (sensorEnable0 & 0xFF)
        presetsBinary[j++] = (byte) (sensorEnable0 & 0xFF)

        presetsBinary[j++] = (byte) ((levelMax0 >> 8) & 0xFF)
        presetsBinary[j++] |= (byte) (levelMax0 & 0xFF)
        presetsBinary[j++] = (byte) ((levelMax1 >> 8) & 0xFF)
        presetsBinary[j++] |= (byte) (levelMax1 & 0xFF)

        presetsBinary[j++] = (byte) (dLevelMaxPrecent0 & 0xFF)
        presetsBinary[j++] = (byte) (dLevelMaxPrecent1 & 0xFF)

        presetsBinary[j++] = (byte) (deviceID >> 24) & 0xFF
        presetsBinary[j++] |= (byte) (deviceID >> 16) & 0xFF
        presetsBinary[j++] |= (byte) (deviceID >> 8) & 0xFF
        presetsBinary[j++] |= (byte) deviceID & 0xFF


        presetsBinary[j++] = (byte) (sim0MCC >> 8) & 0xFF
        presetsBinary[j++] |= (byte) sim0MCC & 0xFF
        presetsBinary[j++] = (byte) (sim0MNC >> 8) & 0xFF
        presetsBinary[j++] |= (byte) sim0MNC & 0xFF


        for (int i; i < sim1MCC.length; i++) {
            presetsBinary[j++] = (byte) (sim1MCC[i] >> 8) & 0xFF
            presetsBinary[j++] |= (byte) sim1MCC[i] & 0xFF
            presetsBinary[j++] = (byte) (sim1MNC[i] >> 8) & 0xFF
            presetsBinary[j++] |= (byte) sim1MNC[i] & 0xFF
        }

        crc16 = crc16Init()
        for (int i = 0; i < FILE_LENGTH; i++) {
            crc16 = crc16Update((short) crc16, presetsBinary[i])
        }
        presetsBinary[j++] = (byte) (crc16 >> 8) & 0xFF
        presetsBinary[j] |= (byte) crc16 & 0xFF
    }

    /**
     * Clean all model arrays
     */
    void cleanAllModelArrays() {

        Arrays.fill(sim0Apn, (byte) 0)
        Arrays.fill(sim0ApnUser, (byte) 0)
        Arrays.fill(sim0ApnPassword, (byte) 0)
        Arrays.fill(sim1Apn, (byte) 0)
        Arrays.fill(sim1ApnUser, (byte) 0)
        Arrays.fill(sim1ApnPassword, (byte) 0)
        Arrays.fill(serverURL, (byte) 0)
        Arrays.fill(serverPort, (byte) 0)
        Arrays.fill(sim1MCC, (int) 0)
        Arrays.fill(sim1MNC, (int) 0)
    }

    void fromUiPresetModelToByteArray(UIPresetsModel model) {

        cleanAllModelArrays()

        try {
            byteArrayCopy(model.sim0Apn.getBytes(), sim0Apn)
            byteArrayCopy(model.sim0ApnUser.getBytes(), sim0ApnUser)
            byteArrayCopy(model.sim0ApnPassword.getBytes(), sim0ApnPassword)

            byteArrayCopy(model.sim1Apn.getBytes(), sim1Apn)
            byteArrayCopy(model.sim1ApnUser.getBytes(), sim1ApnUser)
            byteArrayCopy(model.sim1ApnPassword.getBytes(), sim1ApnPassword)

            byteArrayCopy(model.serverURL.getBytes(), serverURL)
            byteArrayCopy(model.serverPort.getBytes(), serverPort)

            sensorEnable0 = (short) model.sensorEnable0.toInteger()
            sensorEnable1 = (short) model.sensorEnable1.toInteger()

            levelMax0 = model.levelMax0.toInteger()
            levelMax1 = model.levelMax1.toInteger()

            dLevelMaxPrecent0 = (short) model.dLevelMaxPrecent0.toInteger()
            dLevelMaxPrecent1 = (short) model.dLevelMaxPrecent1.toInteger()

            deviceID = model.deviceID.toLong()
            sim0MCC = model.sim0MCCMNC.MCC.toInteger()
            sim0MNC = model.sim0MCCMNC.MNC.toInteger()

            for (int i; i < model.sim1MCCMNC.size(); i++) {

                sim1MCC[i] = model.sim1MCCMNC.MCC[i].toInteger()
                sim1MNC[i] = model.sim1MCCMNC.MNC[i].toInteger()
            }

            fromPresetByteModelToByteArray()

        } catch (Exception e) {

            println("Incorrect data")
            println(e.message)
        }
    }

    /**
     * Save binary file
     * @param fileName
     * @return
     */
    void writeFile(String fileName) {

        try {
            Path path = FileSystems.getDefault().getPath(pathToPresetsFolder + fileName)
            Files.write(path, presetsBinary)

        } catch (Exception e) {

            println(e.message)
            println("Can't save file")
        }
    }

    void byteArrayCopy(byte[] src, byte[] dst) {

        for (int i; i < src.length; i++) {
            dst[i] = src[i]
        }
    }

    Short crc16Init() {
        return (0xFFFF)
    }

    Short crc16Update(Short crc16, byte dat) {
        int i
        crc16 ^= dat
        for (i = 0; i < 8; ++i) {
            if (crc16 & 0x0001)
                crc16 = (crc16 >> 1) ^ 0xA001
            else
                crc16 >>= 1
        }
        return crc16
    }


}



