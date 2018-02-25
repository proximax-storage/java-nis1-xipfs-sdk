package io.nem.utils;

public class Hex2StringUtils {

	private static String hexEncodeChar = "0123456789abcdef";
	
	/**
	 * Hex to String
	 * @param hex
	 * @return
	 */
	public static String hex2String(String hex) {
		try {
			char[] hexs = hex.toCharArray();
			byte[] bytes = new byte[hex.length() / 2];
			int n;
			for (int i = 0; i < bytes.length; i++){
				n = hexEncodeChar.indexOf(hexs[2 * i]) * 16;
				n += hexEncodeChar.indexOf(hexs[2 * i + 1]);
				bytes[i] = (byte) (n & 0xff);
			}
			return new String(bytes);
		} catch (Exception ex) {
			return null;
		}
	}
	
	/**
	 * String to Hex
	 * @param string
	 * @return
	 */
	public static String string2Hex(String string) {   
		char[] chars = hexEncodeChar.toCharArray();
		StringBuilder sb = new StringBuilder("");
		byte[] bs = string.getBytes();
		int bit;
		for (int i = 0; i < bs.length; i++) {
			bit = (bs[i] & 0x0f0) >> 4;
			sb.append(chars[bit]);
			bit = bs[i] & 0x0f;
			sb.append(chars[bit]);
		}
		return sb.toString().trim();
	} 
}
