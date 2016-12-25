package com.mslabs.xmpp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jivesoftware.smack.XMPPException;

import com.mslabs.xmpp.server.CcsClient;
import com.mslabs.xmpp.util.Util;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet");
		
		String message = "";
		String action = request.getParameter("action");
		
		if(action == null) {
			return;
		}
		
		if(action.equals("startServer")) {
			CcsClient ccsClient = CcsClient.prepareClient(Util.FCM_SENDER_ID, Util.FCM_SERVER_KEY, true);

			try {
				ccsClient.connect();
				message = "Server started successfully...!!!";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(action.equals("stopServer")) {
			CcsClient ccsClient = CcsClient.getInstance();
			ccsClient.disconnect();
			message = "Server stopped successfully...!!!";
		}else {
			message = "Invalid action...!!!";
		}
			
		PrintWriter out = response.getWriter();
		out.print(message);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
