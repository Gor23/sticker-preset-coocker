package com.comtrans.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import sun.net.ftp.impl.FtpClient

/**
 * Created by gor on 05.02.17.
 */
@Configuration
class MyFTPClient {

    @Bean
    FtpClient ftpClient (){

        FtpClient client = new FtpClient()
    }
}
