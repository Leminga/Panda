/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.slf4j.LoggerFactory;

/**
 *
 * @author danningersebastian
 */
public class CryptIt
{
        private static org.slf4j.Logger LOGGER = LoggerFactory
			.getLogger(CryptIt.class);
        
        public static String cleartextToHash(String cleartext)
        {
                StringBuilder sb = new StringBuilder();
                try {
                        MessageDigest md = MessageDigest.getInstance("SHA-256");
                        md.update(cleartext.getBytes());
                        byte byteData[] = md.digest();
                        for (int i = 0; i < byteData.length; i++) 
                        {
                                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
                        }
                } catch (NoSuchAlgorithmException ex) 
                {
                        LOGGER.error(ex.getMessage());
                }
                LOGGER.debug("Generated Hash: " + sb.toString());
                return sb.toString();
        }
}
