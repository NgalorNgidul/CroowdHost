package com.croowd.ui.login.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class SimpleSessionJso extends JavaScriptObject {
	protected SimpleSessionJso() {
	}

	public final native String getName() /*-{
		return this.name;
	}-*/;

	public final native String getFirstModule() /*-{
		return this.firstModule;
	}-*/;

	public final native String getRedirect() /*-{
		return this.redirect;
	}-*/;

	public final native String getBaseRedirect() /*-{
		return this.baseRedirect;
	}-*/;

}
