CREATE TABLE IF NOT EXISTS previous_cargo (
    cargo_id INT NOT NULL AUTO_INCREMENT,
    cargo_previous_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (cargo_id)
);


CREATE TABLE IF NOT EXISTS pj15_capacity_data (
    pj15_capacity_id int NOT NULL ,
    bar int NOT NULL,
    nozzle_diameter_8_throughput float NOT NULL,
    nozzle_diameter_9_throughput float NOT NULL,
    nozzle_diameter_10_throughput float NOT NULL,
    nozzle_diameter_12_throughput float NOT NULL,
    nozzle_diameter_13_throughput float NOT NULL,
    nozzle_diameter_14_throughput float NOT NULL,
    nozzle_diameter_16_throughput float NOT NULL,    
    PRIMARY KEY (pj15_capacity_id)    
);
CREATE TABLE IF NOT EXISTS pj120_capacity_data (
    pj120_capacity_id int NOT NULL ,
    bar int NOT NULL,
    nozzle_diameter_25_throughput float NOT NULL,
    nozzle_diameter_26_throughput float NOT NULL,
    nozzle_diameter_28_throughput float NOT NULL,
    nozzle_diameter_29_throughput float NOT NULL,
    nozzle_diameter_30_throughput float NOT NULL,
    nozzle_diameter_31_throughput float NOT NULL,
    nozzle_diameter_325_throughput float NOT NULL,
    nozzle_diameter_35_throughput float NOT NULL,
    PRIMARY KEY (pj120_capacity_id)    
);
CREATE TABLE IF NOT EXISTS pj25_capacity_data (
    pj25_capacity_id int NOT NULL ,
    bar int NOT NULL,
    nozzle_diameter_8_throughput float NOT NULL,
    nozzle_diameter_9_throughput float NOT NULL,
    nozzle_diameter_10_throughput float NOT NULL,
    nozzle_diameter_12_throughput float NOT NULL,
    nozzle_diameter_14_throughput float NOT NULL,
    nozzle_diameter_16_throughput float NOT NULL,    
    PRIMARY KEY (pj25_capacity_id)    
);
CREATE TABLE IF NOT EXISTS pj30_capacity_data (
    pj30_capacity_id int NOT NULL ,
    bar int NOT NULL,
    nozzle_diameter_12_throughput float NOT NULL,
    nozzle_diameter_14_throughput float NOT NULL,
    nozzle_diameter_16_throughput float NOT NULL,
    nozzle_diameter_18_throughput float NOT NULL,
    nozzle_diameter_20_throughput float NOT NULL,
    nozzle_diameter_22_throughput float NOT NULL,
    nozzle_diameter_24_throughput float NOT NULL,
    nozzle_diameter_25_throughput float NOT NULL,
    nozzle_diameter_28_throughput float NOT NULL,
    nozzle_diameter_30_throughput float NOT NULL,
    PRIMARY KEY (pj30_capacity_id)    
);

CREATE TABLE IF NOT EXISTS cargo_to_be_loaded (
    cargo_loaded_id INT NOT NULL AUTO_INCREMENT,
    cargo_load_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (cargo_loaded_id)
);
INSERT INTO previous_cargo(cargo_previous_name)
VALUES
    ('Naphtha / Clean Condensates / LDF'),
    ('Avgas'),
    ('MTBE'),
    ('Ethanol/Methanol'),
    ('Leaded Motor Spirit'),
    ('Unleaded Motor Spirit'),
    ('Sulphur Free Motor Spirit'),
    ('Solvents'),
    ('Jet / Aviation Kerosenes'),
    ('Kerosenes (undyed)'),
    ('Kerosenes (dyed)'),
    ('Gas Oil (undyed)'),
    ('Gas Oil (dyed)'),
    ('Ultra Low Sulphur Diesel/Gas Oil'),
    ('Sulphur Free Diesel'),
    ('Crude Oils / Dirty Condensates'),
    ('Lube Oils'),
     ('Wax Distillate / Vacuum Gas Oil'),
    ('Atmosphric Residue'),
    ('Heavy / Medium Fuel Oil'),
    ('Low Sulphur Fuel Oil (LSFO / LSWR)'),
     ('Light Fuel Oil (LFO)');
     
     INSERT INTO cargo_to_be_loaded(cargo_load_name)
VALUES
    ('Naphtha / Clean Condensates / LDF'),
    ('Avgas'),
    ('MTBE'),
    ('Ethanol/Methanol'),
    ('Leaded Motor Spirit'),
    ('Unleaded Motor Spirit'),
    ('Sulphur Free Motor Spirit'),
    ('Solvents'),
    ('Jet / Aviation Kerosenes'),
    ('Kerosenes (undyed)'),
    ('Kerosenes (dyed)'),
    ('Un-dyed Gas Oil'),
    ('Dyed Gas Oil'),
    ('Ultra Low Sulphur Diesel/Gas Oil'),
    ('Sulphur Free Diesel'),
    ('Crude Oils / Dirty Condensates'),
    ('Lube Oils'),
     ('Wax Distillate / Vacuum Gas Oil'),
    ('Atmosphric Residue'),
    ('Heavy / Medium Fuel Oil'),
    ('Low Sulphur Fuel Oil (LSFO / LSWR)'),
     ('Light Fuel Oil (LFO)');

CREATE TABLE IF NOT EXISTS cleaning_guide (
    cleaning_guide_id INT NOT NULL AUTO_INCREMENT,
    cargo_id INT,
    cargo_loaded_id INT,
    method VARCHAR(100) DEFAULT NULL,
    P VARCHAR(100) DEFAULT NULL,
    M VARCHAR(100) DEFAULT NULL,
    X VARCHAR(200) DEFAULT NULL,
    S VARCHAR(250) DEFAULT NULL,
    LUB VARCHAR(250) DEFAULT NULL,
    notes VARCHAR(500) DEFAULT NULL,
    PRIMARY KEY (cleaning_guide_id),
    FOREIGN KEY (cargo_id)
        REFERENCES previous_cargo (cargo_id)
        ON DELETE CASCADE,
    FOREIGN KEY (cargo_loaded_id)
        REFERENCES cargo_to_be_loaded (cargo_loaded_id)
        ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS pj120_capacity_data (
    capacity_id INT NOT NULL AUTO_INCREMENT,
    bar INT NOT NULL,
    nozzle_diameter_25_throughput FLOAT NOT NULL,
    nozzle_diameter_26_throughput FLOAT NOT NULL,
    nozzle_diameter_28_throughput FLOAT NOT NULL,
    nozzle_diameter_29_throughput FLOAT NOT NULL,
    nozzle_diameter_30_throughput FLOAT NOT NULL,
    nozzle_diameter_31_throughput FLOAT NOT NULL,
    nozzle_diameter_325_throughput FLOAT NOT NULL,
    nozzle_diameter_35_throughput FLOAT NOT NULL,
    PRIMARY KEY (capacity_id)
);

CREATE TABLE IF NOT EXISTS general_plan (
    general_plan_id VARCHAR(30) NOT NULL,    
    genInfoDate VARCHAR(25)DEFAULT NULL,
    genInfoTime VARCHAR(25) DEFAULT NULL,
    nextLoadPort VARCHAR(25) DEFAULT NULL,
    positionOfTankCleaning VARCHAR(25)DEFAULT NULL,
    manualLocation VARCHAR(50)DEFAULT NULL,
    sequenceOfWashing VARCHAR(500) DEFAULT NULL,      
    userName VARCHAR(25)DEFAULT NULL ,  
    vesselName VARCHAR(25)DEFAULT NULL ,
    voyageId VARCHAR(25)DEFAULT NULL ,
     machineName VARCHAR(30) default NULL,
     nozzle_diameter VARCHAR(30) default NULL,
   
    PRIMARY KEY (general_plan_id)    
);
CREATE TABLE IF NOT EXISTS tank_info (
    tcmId int not null AUTO_INCREMENT ,
    
    tankId int DEFAULT 0 ,        
    tankName VARCHAR(25)DEFAULT NULL,   
    machine_char VARCHAR(5) default NULL,
    PRIMARY KEY (tcmId)
);
CREATE TABLE IF NOT EXISTS tank_plans (
    tankPlanId VARCHAR(50) NOT NULL,  
    tankId int DEFAULT 0,
    tcmId int default NULL,
    general_plan_id VARCHAR(30) default NULL,    
    cleaningMethod VARCHAR(25) DEFAULT NULL,
    stepsCtr int DEFAULT NULL,  
    tcmIda int DEFAULT 0,  
    tcmIdb int DEFAULT 0,  
    nextCargo VARCHAR(50) DEFAULT NULL, 
    previousCargo VARCHAR(50) DEFAULT NULL,  
    tankCoating VARCHAR(25) DEFAULT NULL,
    tankAtmosphere VARCHAR(25) DEFAULT NULL,    
    numberOfMachines int default 0,
    oxygenLevel Double DEFAULT NULL,  
    hc Double DEFAULT NULL,
    tankComments VARCHAR(250)DEFAULT NULL ,   
    PRIMARY KEY (tankPlanId),
    FOREIGN KEY (general_plan_id)
        REFERENCES general_plan (general_plan_id)
        ON DELETE CASCADE,
     FOREIGN KEY (tcmId)
        REFERENCES tank_info (tcmId)
        ON DELETE CASCADE
        
);

CREATE TABLE IF NOT EXISTS steps (
    stepId BIGINT NOT NULL AUTO_INCREMENT, 
    stepNumber int DEFAULT NULL,
    tankId int DEFAULT NULL,
    tankPlanId VARCHAR(50) default NULL,
    general_plan_id VARCHAR(30) default NULL,
    stepProfile int DEFAULT NULL,
    step_profile_name VARCHAR(30) DEFAULT NULL,
    timeForOperation int DEFAULT NULL,   
    washType int DEFAULT NULL,
    lWsValue int DEFAULT NULL,
    uWsValue int DEFAULT NULL,     
    washingMedia VARCHAR(50) DEFAULT NULL,
    cleaning_time_in_minutes int DEFAULT NULL , 
    washing_Media_Amount double default 0.0,
    speed int DEFAULT 0,
    pitch double DEFAULT 0,
    rpm double DEFAULT 0,
    bar double DEFAULT 0,
    PRIMARY KEY (stepId),
    FOREIGN KEY (general_plan_id)
        REFERENCES general_plan (general_plan_id)
        ON DELETE CASCADE,
    FOREIGN KEY (tankPlanId)
     REFERENCES tank_plans (tankPlanId)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS wash_modes (
    washType int NOT NULL,    
    wash_mode_name VARCHAR(50),
    cleaning_machine_name VARCHAR(30)DEFAULT null,
    pitch float DEFAULT NULL,
    speed int DEFAULT NULL,
    lower_wash_sector float DEFAULT null,
    upper_wash_sector float DEFAULT null,
    wash_sector int DEFAULT NULL ,
    full_cycle boolean DEFAULT true ,
    cleaning_time_in_Minutes int DEFAULT 0,
    PRIMARY KEY (washType)    
);
CREATE TABLE IF NOT EXISTS sessions (
    session_id VARCHAR(100) NOT NULL,
    session_start_date VARCHAR(100),
    session_end_date VARCHAR(100),
    tcmId float ,
    tankId float ,
    PRIMARY KEY (session_id)
);

CREATE TABLE IF NOT EXISTS reports (
    report_id VARCHAR(100) NOT NULL,  
    session_id VARCHAR(100) NOT NULL,
    washType int ,       
    stepId int,
    cleaning_time varchar(100) DEFAULT NULL,
    report_start_date VARCHAR(100),
    report_end_date VARCHAR(100),          
    cycle INT DEFAULT NULL,
    rpm INT default null,
    PRIMARY KEY (report_id),    
    FOREIGN KEY (session_id)
        REFERENCES sessions (session_id) ON DELETE CASCADE,
        FOREIGN KEY (washType)
        REFERENCES wash_modes (washType)    ON DELETE CASCADE
);
INSERT INTO wash_modes(washType,wash_mode_name,cleaning_machine_name,pitch,speed,lower_wash_sector,upper_wash_sector,wash_sector,full_cycle,cleaning_time_in_Minutes)
VALUES
    (1,'Manual wash',null,0,0,0,0,0,0,0),
    (2,'Average cleaning 1','POLAR JET® PJ 30',1.5,2,0,135,135,1,0),
    (3,'Average cleaning 2','POLAR JET® PJ 30',1.5,2,0,180,180,1,0),
    (4,'Light cleaning 1','POLAR JET® PJ 30',1.5,2,0,135,135,0,0),
    (5,'Light cleaning 2','POLAR JET® PJ 30',1.5,2,0,180,180,0,0),
    (6,'Bottom cleaning','POLAR JET® PJ 30',1.5,2,0,45,45,1,0),
    (7,'Heavy cleaning','POLAR JET® PJ 30',7,1,0,0,0,1,0),
    (8,'Pre-wash','POLAR JET® PJ 30',3,2,0,180,180,1,0),
    (9,'Bottom-wash','POLAR JET® PJ 120',3,1,0,40,40,1,0),
    (10,'Middle-wash','POLAR JET® PJ 120',3,1,0,120,120,1,0),
    (11,'Full-wash','POLAR JET® PJ 120',3,1,0,180,180,1,0); 

    

    




