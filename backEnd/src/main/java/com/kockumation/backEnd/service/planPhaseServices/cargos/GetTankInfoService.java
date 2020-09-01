package com.kockumation.backEnd.service.planPhaseServices.cargos;

import com.kockumation.backEnd.service.planPhaseServices.cargos.model.cargo.CargoToBeLoaded;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.tankInfo.GetTankInfo;
import com.kockumation.backEnd.utilities.MySQLJDBCUtil;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class GetTankInfoService {
    private ExecutorService executor;

    public GetTankInfoService() {
        executor = Executors.newSingleThreadExecutor();
    }

    //Get cargo_to_be_loaded ******** Get cargo_to_be_loaded ********************
    public Future<List<GetTankInfo>> getTankInfo() {
        List<GetTankInfo> getTankInfoList = new ArrayList<>();
        try (Connection conn = MySQLJDBCUtil.getConnection()) {
            String sql = "select * from tank_info ";


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                GetTankInfo getTankInfo = new GetTankInfo();
                getTankInfo.setTankId(rs.getInt("tankId"));
                getTankInfo.setTcmId(rs.getInt("tcmId"));
                getTankInfo.setTankName(rs.getString("tankName"));
                getTankInfo.setMachine_char(rs.getString("machine_char"));
                getTankInfo.setMachineName(rs.getString("machineName"));
                getTankInfo.setNozzle_diameter(rs.getString("nozzle_diameter"));
                getTankInfoList.add(getTankInfo);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return (Future<List<GetTankInfo>>) getTankInfoList;
        }

        return executor.submit(() -> {

            return getTankInfoList;
        });
    }//Get Get cargo_to_be_loaded ******** Get Get cargo_to_be_loaded ********************
}
