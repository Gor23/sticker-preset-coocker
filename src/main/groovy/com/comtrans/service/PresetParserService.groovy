package com.comtrans.service

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
    Byte sebsorEnable0
    Byte sebsorEnable1
    Short levelMax0
    Short levelMax1
    Byte dLevelMaxPrecent0
    Byte dLevelMaxPrecent1

    //device settings
    Integer deviceID
    Integer sim0MCCMNC
    Integer[] sim1MCCMNC = new Integer[70]

    Short[] crc16

    /**
     * Load binary file
     * @param fileName
     * @return
     */
    byte[] readFile(String fileName){

        byte[] fileData

        try {
            Path path = FileSystems.getDefault().getPath(fileName)
            fileData = Files.readAllBytes(path)

            if (fileData.length != FILE_LENGTH){
                println("File length is incorrect must be ${FILE_LENGTH} but length is ${fileData.length}")
                throw new Exception("File length is incorrect must be ${FILE_LENGTH} but length is ${fileData.length}")
            }
        }catch (Exception e){

            println(e.message)
            println("Create default")
            //TODO load default
            fileData = new byte[FILE_LENGTH]
        }

        return fileData
    }






}
