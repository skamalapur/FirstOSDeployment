package com.geekcap.vmturbo;

import com.microsoft.applicationinsights.TelemetryClient;

public class TestTelementry {
	static final TelemetryClient telemetryClient = new TelemetryClient();

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			telemetryClient.trackEvent("Shrini Test");
			telemetryClient.trackTrace("Called " + "Shrini Test 123");
			int k = 1/0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 telemetryClient.trackException(e);
		}
	}

}
