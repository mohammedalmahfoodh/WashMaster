package com.kockumation.backEnd;

import com.kockumation.backEnd.utilities.MySQLJDBCUtil;
import org.glassfish.tyrus.client.ClientManager;
import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.websocket.DeploymentException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class BackEndApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(BackEndApplication.class, args);
		System.out.println("listening on port "+ 8081);
		ClientManager client = ClientManager.createClient();
		// String msg = "{ "getKslTankData": { "vessel": 1 } }";

		//	employeeDetails2.put("firstName", "Brian");
		JSONObject getShipData = new JSONObject();
		JSONObject vessel = new JSONObject();
		vessel.put( "tankId",0 );
		getShipData.put("setTankSubscriptionOn", vessel);
		String getShipString = getShipData.toString();
		/*try {
			TestWebsocketClient testWebsocketClient = new TestWebsocketClient();
			client.connectToServer(testWebsocketClient, new URI("ws://194.103.55.106:8089"));

			testWebsocketClient.sendMessage(getShipString);


		} catch (DeploymentException | URISyntaxException e) {

			throw new RuntimeException(e);

		}*/

		/*try (Connection conn = MySQLJDBCUtil.getConnection()) {

			// print out a message
			System.out.println(String.format("Connected to database %s "
					+ "successfully.", conn.getCatalog()));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}*/
	}



}
