/*
 * Copyright 2014 Janith Bandara, This source is a part of Audit4j - 
 * An open-source audit platform for Enterprise java platform.
 * http://mechanizedspace.com/audit4j
 * http://audit4j.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.audit4j.core;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.audit4j.core.handler.ConsoleAuditHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class SecurityUtil.
 *
 * @author <a href="mailto:janith3000@gmail.com">Janith Bandara</a>
 */
public class EncryptionUtil {

	/** The log. */
	private static final Logger LOG = LoggerFactory.getLogger(ConsoleAuditHandler.class);

	/** The Constant ALGORYITHM. */
	private static final String ALGORYITHM = "AES/CBC/PKCS5Padding";
	
	/** The instance. */
	private static EncryptionUtil instance;
	
	/** The crypt key. */
	private static Key cryptKey;

	/**
	 * Instantiates a new encrypt util.
	 */
	private EncryptionUtil(){}
	
	/**
	 * Encrypt.
	 *
	 * @param raw the raw
	 * @return the string
	 * @throws Exception the exception
	 */
	public String encrypt(String raw) throws Exception {
		Cipher c = getCipher(Cipher.ENCRYPT_MODE);

		byte[] encryptedVal = c.doFinal(raw.getBytes(CoreConstants.ENCODE_UTF8));
		return new String(Base64Coder.encode(encryptedVal));
	}

	/**
	 * Decrypt.
	 *
	 * @param encrypted the encrypted
	 * @return the string
	 * @throws Exception the exception
	 */
	public String decrypt(String encrypted) throws Exception {

		byte[] decodedValue = Base64Coder.decode(encrypted.toCharArray());

		Cipher c = getCipher(Cipher.DECRYPT_MODE);
		byte[] decValue = c.doFinal(decodedValue);

		return new String(decValue);
	}

	/**
	 * Gets the cipher.
	 *
	 * @param mode the mode
	 * @return the cipher
	 * @throws Exception the exception
	 */
	private Cipher getCipher(int mode) throws Exception {
		Cipher c = Cipher.getInstance(ALGORYITHM);

		byte[] iv = CoreConstants.IV.getBytes(CoreConstants.ENCODE_UTF8);

		c.init(mode, cryptKey, new IvParameterSpec(iv));
		return c;
	}

	/**
	 * Generate key.
	 *
	 * @param key the key
	 * @param salt the salt
	 * @return the key
	 * @throws NoSuchAlgorithmException the no such algorithm exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 * @throws InvalidKeySpecException the invalid key spec exception
	 */
	private static void generateKeyIfNotAvailable(String key, String salt) throws NoSuchAlgorithmException,
			UnsupportedEncodingException, InvalidKeySpecException {
		if (null == cryptKey) {
			LOG.debug("Generating Key...");
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			char[] password = key.toCharArray();
			byte[] saltBytes = salt.getBytes(CoreConstants.ENCODE_UTF8);

			KeySpec spec = new PBEKeySpec(password, saltBytes, 65536, 128);
			SecretKey tmp = factory.generateSecret(spec);
			byte[] encoded = tmp.getEncoded();
			cryptKey =  new SecretKeySpec(encoded, "AES");
		}
	}
	
    /**
     * Gets the Encryptor.
     *
     * @param key the key
     * @param salt the salt
     * @return the Encryptor
     */
    public static EncryptionUtil getInstance(String key, String salt) {
        if (instance == null) {
            synchronized (EncryptionUtil.class) {
                if (instance == null) {
                    instance = new EncryptionUtil();
                    try {
						generateKeyIfNotAvailable(key, salt);
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvalidKeySpecException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
        }
        return instance;
    }
}
