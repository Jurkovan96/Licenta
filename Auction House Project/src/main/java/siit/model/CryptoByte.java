package siit.model;

import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@Component
public class CryptoByte {

//    public byte[] encrypt1(int id){
//        byte[] bytes = ByteBuffer.allocate(id).array();
//
//        byte[] enc1 = new byte[bytes.length];
//        for(int i = 0; i < enc1.length; i++){
//            enc1[i] = (byte) ((i % 2 == 0) ? enc1[i] + 1 : enc1[i] - 1);
//        }
//        return enc1;
//
//    }


    public String encrypt(byte[] data){
        byte[] enc = new byte[data.length];

        for(int i = 0; i < data.length; i++){
            enc[i] = (byte) ((i % 2 == 0) ? data[i] + 1 : data[i] - 1);
        }

        String s = new String(enc, StandardCharsets.UTF_8);

        return s;
    }

    public String decrypt(byte[] data){
        byte[] dec = new byte[data.length];

        for(int i = 0; i < data.length; i++){
            dec[i] = (byte) ((i % 2 == 0) ? data[i] - 1 : data[i] + 1);
        }

        String s = new String(dec, StandardCharsets.UTF_8);

        return s;
    }

}
