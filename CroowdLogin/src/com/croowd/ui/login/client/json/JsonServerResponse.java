package com.croowd.ui.login.client.json;

public class JsonServerResponse {

	public static final native SimpleSessionJso getSessionJso(String responseString) /*-{
		// You should be able to use a safe parser here
		// (like the one from json.org)
		return eval('(' + responseString + ')');
	}-*/;

}
