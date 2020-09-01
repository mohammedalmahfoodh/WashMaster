package com.kockumation.backEnd.service.planPhaseServices.cargos;

import com.kockumation.backEnd.service.planPhaseServices.cargos.model.cargo.CargoToBeLoaded;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.cargo.CargosIds;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.cargo.CargosModel;
import com.kockumation.backEnd.service.planPhaseServices.cargos.model.cargo.CleaningGuideInstructions;
import com.kockumation.backEnd.utilities.MySQLJDBCUtil;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class CargosService {
    private ExecutorService executor
            = Executors.newSingleThreadExecutor();








    //Get previous cargos ******** Get previous cargos ********************
    public Future<List<CargosModel>> getPreviousCargos() {
        List<CargosModel> cargosModelList = new ArrayList<>();
        try (Connection conn = MySQLJDBCUtil.getConnection()) {

            String sql = "SELECT * FROM previous_cargo";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CargosModel cargosModel = new CargosModel();
                cargosModel.setCargo_id(rs.getInt("cargo_id"));
                cargosModel.setCargo_previous_name(rs.getString("cargo_previous_name"));
                cargosModelList.add(cargosModel);
                System.out.println(cargosModel);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return executor.submit(() -> {

            return cargosModelList;
        });
    }//Get previous cargos ******** Get previous cargos ********************

    //Get cargo_to_be_loaded ******** Get cargo_to_be_loaded ********************
    public Future<List<CargoToBeLoaded>> cargoToBeLoaded() {
        List<CargoToBeLoaded> cargo_to_be_loaded = new ArrayList<>();
        try (Connection conn = MySQLJDBCUtil.getConnection()) {

            String sql = "SELECT * FROM cargo_to_be_loaded";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CargoToBeLoaded cargosModel = new CargoToBeLoaded();
                cargosModel.setCargo_loaded_id(rs.getInt("cargo_loaded_id"));
                cargosModel.setCargo_load_name(rs.getString("cargo_load_name"));
                cargo_to_be_loaded.add(cargosModel);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return executor.submit(() -> {

            return cargo_to_be_loaded;
        });
    }//Get Get cargo_to_be_loaded ******** Get Get cargo_to_be_loaded ********************

    //Get Cleaning instructions ******** Get Cleaning instructions ********************
    public Future<List<CleaningGuideInstructions>> GetCleaningInstructions(CargosIds cargosIds) {
        List<CleaningGuideInstructions> cleaningGuideInstructions = new ArrayList<>();
        int cargo_id = cargosIds.getCargo_id();
        int cargo_loaded_id = cargosIds.getCargo_loaded_id();

        try (Connection conn = MySQLJDBCUtil.getConnection()) {

            String sql = String.format("SELECT cg.cleaning_guide_id,cg.cargo_id,cg.cargo_loaded_id," +
                    "cl.cargo_load_name,p.cargo_previous_name,cg.LUB,cg.M,cg.method,cg.notes,cg.P,cg.M,cg.X,cg.S\n  FROM wash_master.cleaning_guide cg\n" +
                    "  inner join previous_cargo p \n  using(cargo_id)\n  inner join cargo_to_be_loaded cl\n  using(cargo_loaded_id)\n " +
                    " where (cargo_id = %d and cargo_loaded_id = %d) ;", cargo_id, cargo_loaded_id) ;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CleaningGuideInstructions cleaningGuideInstr = new CleaningGuideInstructions();
                cleaningGuideInstr.setCleaning_guide_id(rs.getInt("cleaning_guide_id"));
                cleaningGuideInstr.setCargo_id(rs.getInt("cargo_id"));
                cleaningGuideInstr.setCargo_loaded_id(rs.getInt("cargo_loaded_id"));
                cleaningGuideInstr.setMethod(rs.getString("method"));
                cleaningGuideInstr.setP(rs.getString("P"));
                cleaningGuideInstr.setM(rs.getString("M"));
                cleaningGuideInstr.setX(rs.getString("X"));
                cleaningGuideInstr.setS(rs.getString("S"));
                cleaningGuideInstr.setLUB(rs.getString("LUB"));
                cleaningGuideInstr.setNotes(rs.getString("notes"));

                cleaningGuideInstructions.add(cleaningGuideInstr);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return executor.submit(() -> {

            return cleaningGuideInstructions;
        });
    }//Get Cleaning instructions ******** Get Cleaning instructions ********************














    /* boolean b1 = Pattern.matches("^\\d+$", data);
        boolean b2 = Pattern.matches("[0-9a-zA-Z([+-]?\\d*\\.+\\d*)]*", data);
        boolean b3 = Pattern.matches("^([+-]?\\d*\\.+\\d*)$", data);
        if(b1) {
            System.out.println("It is integer.");
        } else if(b2) {
            System.out.println("It is String. ");
        } else if(b3) {
            System.out.println("It is Float. ");
        }*/

}
