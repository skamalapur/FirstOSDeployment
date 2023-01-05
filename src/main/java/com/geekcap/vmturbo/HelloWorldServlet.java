package com.geekcap.vmturbo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.TelemetryConfiguration;

public class HelloWorldServlet extends HttpServlet {

	static final TelemetryClient telemetryClient = new TelemetryClient();

	String instrumentationKey = "366e9224-8e23-47bc-9721-e9f13688996d";

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

		TelemetryConfiguration.getActive().setInstrumentationKey(instrumentationKey);

		telemetryClient.trackTrace("HelloWorldServlet initializing  ");
		extracted(res, "service");

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		telemetryClient.trackTrace("HelloWorldServlet initializing  ");
		extracted(res, "Do Get");
	}

	@SuppressWarnings("deprecation")
	private void extracted(HttpServletResponse res, String message) throws IOException {

		PrintWriter out = null;
		try {

			System.out.println("This.message ++++++++++++++++++   " + message);
			int k = 100 / 0;
			System.out.println("This.endmessage #######  " + message);
			out = res.getWriter();
			out.println("Hello, World! 123 " + message);
			telemetryClient.trackEvent(getServletName());
			telemetryClient.trackTrace("HelloWorldServlet Called " + message);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("  HelloWorldServlet Error $$$$$$$$$$$$$$$ " + e.getMessage());
			e.printStackTrace();
			telemetryClient.trackException(e);
			throw e;
		} finally {
			out.close();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		telemetryClient.trackTrace("HelloWorldServlet initializing  ");
		extracted(res, "dopost");

	}
}
