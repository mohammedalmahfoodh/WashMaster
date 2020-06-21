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


		try (Connection conn = MySQLJDBCUtil.getConnection()) {

			System.out.println(String.format("Connected to database %s "
					+ "successfully.", conn.getCatalog()));

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}



}
