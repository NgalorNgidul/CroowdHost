package com.croowd.ui.login.client;

public class Base64Utils {

	public native static String toBase64(String b64) /*-{
		return btoa(b64);
	}-*/;

}
