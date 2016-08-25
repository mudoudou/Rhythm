package com.pan.po;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util implements Serializable {

	private static final long serialVersionUID = 1L;
	private MessageDigest md5;

	public MD5Util() {
		md5 = null;
		try {
			md5 = MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		}
	}

	/**
	 * ִ��MD5У��
	 * 
	 * @param message
	 * @return
	 */
	public String makeVertify(String message) {
		md5.reset();
		return chansHex(digestAsBytes(message));
	}

	/**
	 * ִ��MD5�ļ�У��
	 * 
	 * @param filePath
	 * @return
	 */
	public String makeVertify(File file) {
		md5.reset();
		return chansHex(digestAsBytes(file));
	}

	/**
	 * ת���ļ�У���ֽ�
	 * 
	 * @param filePath
	 * @return
	 */
	protected byte[] digestAsBytes(File file) {
		byte buffer[] = new byte[1024];
		int len;

		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		try {
			while ((len = in.read(buffer, 0, 1024)) != -1) {
				md5.update(buffer, 0, len);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return md5.digest();
	}

	/**
	 * ת��У���ֽ�
	 * 
	 * @param message
	 * @return
	 */
	protected byte[] digestAsBytes(String message) {
		if (message == null || message.length() == 0) {
			return null;
		} else {
			md5.update(message.getBytes());
			return md5.digest();
		}
	}

	/**
	 * ת��ʮ�����ƣ�ִ��MD5��digest
	 * 
	 * @param bytes
	 * @return
	 */
	protected String chansHex(byte bytes[]) {
		if (bytes == null)
			return null;
		StringBuffer hex = new StringBuffer();
		String tmp = null;
		for (int i = 0; i < bytes.length; i++) {
			tmp = Integer.toHexString(bytes[i] & 0xff);
			if (1 == tmp.length())
				hex.append("0");
			hex.append(tmp);
		}
		return hex.toString();
	}

	public static void main(String[] args) {
		MD5Util md5 = new MD5Util();
		String md5digest = md5.makeVertify("aini");
		System.out.println("MD5:" + md5digest.toUpperCase());	
		
	}
}
