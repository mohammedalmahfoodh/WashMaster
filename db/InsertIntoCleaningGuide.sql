SET @greyMethod = 'No washing required - strip and drain well Refer Notes: 1 & 2';
SET @blueMethod = 'Wash tanks with COLD sea water until tank is clean Refer Notes 1, 2 & 3';
SET @redMethod = 'Wash tanks with HOT sea water until tank is clean.Refer Notes 1, 2 & 3';
SET @blackMethod = 'Product NOT to be loaded unless specific instructions have been issued by BP Head Office';
SET @p ='Tanks to be purged to below 2% Hydrocarbon by volume Non IG Vessels should be \'Gas Free\'' ;
set @m ='Tanks to be mopped or educted DRY';
set @x ='If ROB is less than 0.1%, and purging (if required) is effective cargo may be loaded directly on top without washing';
set @s ='Tanks that have been washed for the carriage of these products must have a final wash with fresh water.Tank and lines are then to be blown and drained free of water';
set @LUB ='To ensure minimum grade to grade admixture,tanks to be stripped dry, pump column and deck lines to be blown and drained.Tanks to be visually inspected to ensure min ROB';
SET @notes12 = '1. Tanks to be stripped dry such that any liquid ROB is confined to the pump well - or better.2. Pump columns, deck lines, drops etc are to be blown clear and drained free of all product and water.';
SET @notes123 = '1. Tanks to be stripped dry such that any liquid ROB is confined to the pump well - or better.2. Pump columns, deck lines, drops etc are to be blown clear and drained free of all product and water.3. Deck lines, loading drops and cross over lines must be thoroughly washed and drained.';

INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (1,1,@greyMethod,@notes12);                 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (2,1,@blackMethod);   
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES (3,1,@blackMethod);                 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (4,1,@blackMethod);                      
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES (5,1,@blackMethod);                 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (6,1,@blueMethod,@notes123);   
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (7,1,@blueMethod,@notes123);                 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (8,1,@greyMethod,@notes12);   
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (9,1,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (10,1,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (11,1,@blueMethod,@notes123); 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (12,1,@blueMethod,@notes123); 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (13,1,@blueMethod,@notes123); 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (14,1,@blueMethod,@notes123); 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (15,1,@blueMethod,@notes123); 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES (16,1,@blackMethod); 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (17,1,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (18,1,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (19,1,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (20,1,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (21,1,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (22,1,@redMethod,@notes123);
/* Row 2 Row 2  Row 2 Row 2  Row 2 Row 2  Row 2 Row 2 Row 2 Row 2  Row 2 Row 2  Row 2 Row 2  Row 2 Row 2 Row 2 Row 2  Row 2 Row 2  Row 2 Row 2  Row 2 Row 2 Row 2 Row 2  Row 2 Row 2  Row 2 Row 2  Row 2 Row 2
   Row 2 Row 2  Row 2 Row 2  Row 2 Row 2  Row 2 Row 2 Row 2 Row 2  Row 2 Row 2  Row 2 Row 2  Row 2 Row 2 Row 2 Row 2  Row 2 Row 2  Row 2 Row 2  Row 2 Row 2 Row 2 Row 2  Row 2 Row 2  Row 2 Row 2  Row 2 Row 2   Row 2  */
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (1,2,@greyMethod,@notes12); 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (2,2,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (3,2,@blackMethod); 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (4,2,@blackMethod); 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (5,2,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (6,2,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (7,2,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (8,2,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (9,2,@blueMethod,@notes123); 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (10,2,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (11,2,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (12,2,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (13,2,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (14,2,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (15,2,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (16,2,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (17,2,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (18,2,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (19,2,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (20,2,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (21,2,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (22,2,@redMethod,@notes123);   
/* Row 3 Row 3  Row 3 Row 3  Row 3 Row 3  Row 3 Row 3 Row 2  Row 3 Row 3  Row 3 Row 3  Row 3 Row 3  Row 3 Row 3
   Row 3 Row 3  Row 3 Row 3  Row 3 Row 3 Row 3  Row 3 Row 3  Row 3 Row 3  Row 3 Row 3 Row 2  Row 3 Row 3  Row 3 Row 3  Row 3 Row 3  Row 3 Row 3  */
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (1,3,@blackMethod); 
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (2,3,@blackMethod); 
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (3,3,@greyMethod,@notes12); 
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (4,3,@blackMethod); 
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (5,3,@greyMethod,@notes12);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (6,3,@greyMethod,@notes12);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (7,3,@greyMethod,@notes12);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (8,3,@greyMethod,@notes12);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (9,3,@blackMethod);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (10,3,@blueMethod,@notes123);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (11,3,@blueMethod,@notes123);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (12,3,@blueMethod,@notes123);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (13,3,@blueMethod,@notes123);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (14,3,@blueMethod,@notes123);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (15,3,@blueMethod,@notes123);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (16,3,@blackMethod);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (17,3,@blackMethod);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (18,3,@blackMethod);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (19,3,@blackMethod);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (20,3,@blackMethod);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (21,3,@blackMethod);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (22,3,@blackMethod);
/* Row 4 Row 4  Row 4 Row 4 Row 4  Row 4 Row 4 Row 4  Row 4 Row 4 Row 4  Row 4  Row 4 Row 4  Row 4 Row 4 Row 4  Row 4
   Row 4 Row 4  Row 4 Row 4 Row 4  Row 4 Row 4 Row 4  Row 4 Row 4 Row 4  Row 4  Row 4 Row 4  Row 4 Row 4 Row 4  Row 4 */ 
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (1,4,@blackMethod);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (2,4,@greyMethod,@notes12);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (3,4,@blackMethod);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (4,4,@greyMethod,@notes12);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (5,4,@greyMethod,@notes12);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (6,4,@greyMethod,@notes12);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (7,4,@greyMethod,@notes12);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (8,4,@greyMethod,@notes12);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (9,4,@blackMethod);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (10,4,@blueMethod,@notes123);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (11,4,@blueMethod,@notes123);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (12,4,@blueMethod,@notes123);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (13,4,@blueMethod,@notes123);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (14,4,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (15,4,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (16,4,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (17,4,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (18,4,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (19,4,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (20,4,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (21,4,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (22,4,@blackMethod);
/* Row 5 Row 5  Row 5 Row 5 Row 5  Row 5 Row 5  Row 5 Row 5 Row 5 Row 5 Row 5  Row 5 Row 5 Row 5  Row 5 Row 5  Row 5 Row 5 Row 5
   Row 5 Row 5  Row 5 Row 5 Row 5  Row 5 Row 5  Row 5 Row 5 Row 5 Row 5 Row 5  Row 5 Row 5 Row 5  Row 5 Row 5  Row 5 Row 5 Row 5 */ 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (1,5,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (2,5,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (3,5,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (4,5,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (5,5,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (6,5,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (7,5,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (8,5,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (9,5,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (10,5,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (11,5,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (12,5,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (13,5,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (14,5,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (15,5,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (16,5,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (17,5,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (18,5,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (19,5,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (20,5,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (21,5,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (22,5,@redMethod,@notes123);
/* Row 6 Row 6  Row 6 Row 6 Row 6  Row 6 Row 6  Row 6 Row Row 6 Row 6  Row 6 Row 6 Row 6  Row 6 Row 6  Row 6 Row 6 Row 6  Row 6 Row 6 Row 6  Row 6 Row 6  Row 6 Row Row 6 Row 6  Row 6 Row 6 Row 6  Row 6 Row 6  Row 6
   Row 6 Row 6  Row 6 Row 6 Row 6  Row 6 Row 6  Row 6 Row Row 6 Row 6  Row 6 Row 6 Row 6  Row 6 Row 6  Row 6 Row 6 Row 6  Row 6 Row 6 Row 6  Row 6 Row 6  Row 6 Row Row 6 Row 6  Row 6 Row 6 Row 6  Row 6 Row 6  Row 6 */ 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (1,6,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (2,6,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (3,6,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (4,6,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (5,6,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (6,6,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (7,6,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (8,6,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (9,6,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (10,6,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (11,6,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (12,6,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (13,6,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (14,6,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (15,6,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (16,6,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (17,6,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (18,6,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (19,6,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (20,6,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (21,6,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (22,6,@redMethod,@notes123);
/* Row 7 Row 7  Row 7 Row 7 Row 7  Row 7 Row 7  Row 7 Row Row 7 Row 7  Row 7 Row 7 Row 7 Row 7 Row 7  Row 7 Row 7 Row 7  Row 7 Row Row 7 Row 7  Row 7 Row 7 Row 7 Row 7 Row 7  Row 7
   Row 7 Row 7  Row 7 Row 7 Row 7  Row 7 Row 7  Row 7 Row Row 7 Row 7  Row 7 Row 7 Row 7 Row 7 Row 7  Row 7 Row 7 Row 7  Row 7 Row Row 7 Row 7  Row 7 Row 7 Row 7 Row 7 Row 7  Row 7 */ 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (1,7,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (2,7,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (3,7,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (4,7,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (5,7,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (6,7,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (7,7,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (8,7,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (9,7,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (10,7,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (11,7,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (12,7,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (13,7,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (14,7,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (15,7,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (16,7,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (17,7,@redMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (18,7,@redMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (19,7,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (20,7,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (21,7,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (22,7,@redMethod,@notes123,@s);
/* Row 8 Row 8  Row 8 Row 8 Row 8  Row 8 Row 8  Row 8 Row 8 Row 8  Row 8 Row 8 Row 8  Row 8 Row 8  Row 8 Row 8 Row 8  Row 8 Row 8 Row 8  Row 8 Row 8  Row 8
   Row 8 Row 8  Row 8 Row 8 Row 8  Row 8 Row 8  Row 8 Row 8 Row 8  Row 8 Row 8 Row 8  Row 8 Row 8  Row 8 Row 8 Row 8  Row 8 Row 8 Row 8  Row 8 Row 8  Row 8 */ 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (1,8,@blueMethod,@notes123,@s,@p,@m);   
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (2,8,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (3,8,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (4,8,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (5,8,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (6,8,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (7,8,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (8,8,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (9,8,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (10,8,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (11,8,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (12,8,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (13,8,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (14,8,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (15,8,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (16,8,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (17,8,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,M) VALUES (18,8,@redMethod,@notes123,@s,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (19,8,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (20,8,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (21,8,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,M) VALUES (22,8,@redMethod,@notes123,@s,@m);
/* Row 9 Row 9  Row 9 Row 9 Row 9  Row 9 Row 9  Row 9 Row 9  Row 9 Row 9 Row 9  Row 9 Row 9 Row 9 Row 9  Row 9 Row 9 Row 9  Row 9 Row 9  Row 9 Row 9  Row 9 Row 9 Row 9  Row 9 Row 9
   Row 9 Row 9  Row 9 Row 9 Row 9  Row 9 Row 9  Row 9 Row 9  Row 9 Row 9 Row 9  Row 9 Row 9 Row 9 Row 9  Row 9 Row 9 Row 9  Row 9 Row 9  Row 9 Row 9  Row 9 Row 9 Row 9  Row 9 Row 9 */ 
  INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,M) VALUES  (1,9,@blueMethod,@notes123,@p,@m); 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,M) VALUES  (2,9,@blueMethod,@notes123,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (3,9,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (4,9,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,M) VALUES  (5,9,@blueMethod,@notes123,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,M) VALUES  (6,9,@blueMethod,@notes123,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,M) VALUES  (7,9,@blueMethod,@notes123,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (8,9,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (9,9,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (10,9,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,M) VALUES  (11,9,@blueMethod,@notes123,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (12,9,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,M) VALUES  (13,9,@blueMethod,@notes123,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (14,9,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (15,9,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (16,9,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (17,9,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (18,9,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (19,9,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (20,9,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (21,9,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,M) VALUES (22,8,@redMethod,@notes123,@m);
/* Row 10 Row 10  Row 10 Row 10 Row 10  Row 10 Row 10 Row 10  Row 10 Row 10 Row 10  Row 10 Row 10 Row 10  Row 10 Row 10 Row 10  Row 10 Row 10 Row 10  Row 10 Row 10 Row 10  Row 10
   Row 10 Row 10  Row 10 Row 10 Row 10  Row 10 Row 10 Row 10  Row 10 Row 10 Row 10  Row 10 Row 10 Row 10  Row 10 Row 10 Row 10  Row 10 Row 10 Row 10  Row 10 Row 10 Row 10  Row 10 */ 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (1,10,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (2,10,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (3,10,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (4,10,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (5,10,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (6,10,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (7,10,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (8,10,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (9,10,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (10,10,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (11,10,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (12,10,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (13,10,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (14,10,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (15,10,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (16,10,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (17,10,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (18,10,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (19,10,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (20,10,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (21,10,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (22,10,@redMethod,@notes123);
/* Row 11 Row 11  Row 11 Row 11 Row 11 Row 11  Row 11 Row 11 Row 11 Row 11  Row 11 Row 11 Row 11 Row 11  Row 11 Row 11 Row 11 Row 11  Row 11 Row 11 Row 11 Row 11  Row 11 Row 11
   Row 11 Row 11  Row 11 Row 11 Row 11 Row 11  Row 11 Row 11 Row 11 Row 11  Row 11 Row 11 Row 11 Row 11  Row 11 Row 11 Row 11 Row 11  Row 11 Row 11 Row 11 Row 11  Row 11 Row 11 */ 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (1,11,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (2,11,@blueMethod,@notes123,@p);
 INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (3,11,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (4,11,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (5,11,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (6,11,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (7,11,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (8,11,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (9,11,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (10,11,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (11,11,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (12,11,@greyMethod,@notes12);  
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (13,11,@blueMethod,@notes123); 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (14,11,@greyMethod,@notes12);  
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (15,11,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (16,11,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (17,11,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (18,11,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (19,11,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (20,11,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (21,11,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (22,11,@redMethod,@notes123);
/* Row 12 Row 12  Row 12 Row 12 Row 12 Row 12  Row 12 Row 12 Row 12 Row 12  Row 12 Row 12 Row 12 Row 12  Row 12 Row 12
   Row 12 Row 12  Row 12 Row 12 Row 12 Row 12  Row 12 Row 12 Row 12 Row 12  Row 12 Row 12 Row 12 Row 12  Row 12 Row 12 */ 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (1,12,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (2,12,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (3,12,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (4,12,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (5,12,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (6,12,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (7,12,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES (8,12,@redMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (9,12,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (10,12,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (11,12,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (12,12,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (13,12,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (14,12,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (15,12,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES (16,12,@redMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (17,12,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (18,12,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (19,12,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (20,12,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (21,12,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (22,12,@redMethod,@notes123);
/* Row 13 Row 13  Row 13 Row 13  Row 13 Row 13  Row 13 Row 13 Row 13 Row 13  Row 13 Row 13  Row 13 Row 13  Row 13 Row 13
   Row 13 Row 13  Row 13 Row 13  Row 13 Row 13  Row 13 Row 13 Row 13 Row 13  Row 13 Row 13  Row 13 Row 13  Row 13 Row 13 */ 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (1,13,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (2,13,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (3,13,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (4,13,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (5,13,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (6,13,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (7,13,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES (8,13,@redMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (9,13,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (10,13,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (11,13,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (12,13,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (13,13,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (14,13,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (15,13,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES (16,13,@redMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (17,13,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (18,13,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (19,13,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (20,13,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (21,13,@redMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (22,13,@redMethod,@notes123);
/* Row 14 Row 14  Row 14 Row 14 Row 14 Row 14  Row 14 Row 14 Row 14 Row 14  Row 14 Row 14 Row 14 Row 14  Row 14 Row 14
   Row 14 Row 14  Row 14 Row 14 Row 14 Row 14  Row 14 Row 14 Row 14 Row 14  Row 14 Row 14 Row 14 Row 14  Row 14 Row 14 */ 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (1,14,@blueMethod,@notes123,@s,@p,@m);   
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (2,14,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (3,14,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (4,14,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (5,14,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (6,14,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (7,14,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,M,S) VALUES (8,14,@redMethod,@notes123,@p,@m,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (9,14,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (10,14,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,M,S) VALUES  (11,14,@blueMethod,@notes123,@p,@m,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (12,14,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,M) VALUES  (13,14,@blueMethod,@notes123,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (14,14,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (15,14,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (16,14,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (17,14,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (18,14,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (19,14,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (20,14,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (21,14,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,M,S) VALUES (22,14,@redMethod,@notes123,@m,@s);
/* Row 15 Row 15  Row 15 Row 15 Row 15 Row 15  Row 15 Row 15  Row 15 Row 15  Row 15 Row 15 Row 15 Row 15  Row 15 Row 15
   Row 15 Row 15  Row 15 Row 15 Row 15 Row 15  Row 15 Row 15  Row 15 Row 15  Row 15 Row 15 Row 15 Row 15  Row 15 Row 15 */ 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (1,15,@blueMethod,@notes123,@s,@p,@m);   
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (2,15,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (3,15,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (4,15,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (5,15,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (6,15,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (7,15,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,M,S) VALUES (8,15,@redMethod,@notes123,@p,@m,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (9,15,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (10,15,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (11,15,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (12,15,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (13,15,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (14,15,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (15,15,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (16,15,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (17,15,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (18,15,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (19,15,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (20,15,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (21,15,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (22,15,@redMethod,@notes123,@s);
/* Row 16 Row 16  Row 16 Row 16 Row 16  Row 16  Row 16 Row 16  Row 16 Row 16 Row 16  Row 16 Row 16 Row 16 Row 16  Row 16
   Row 16 Row 16  Row 16 Row 16 Row 16  Row 16  Row 16 Row 16  Row 16 Row 16 Row 16  Row 16 Row 16 Row 16 Row 16  Row 16 */ 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (1,16,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (2,16,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (3,16,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (4,16,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (5,16,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (6,16,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (7,16,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (8,16,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (9,16,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (10,16,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (11,16,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (12,16,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (13,16,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (14,16,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (15,16,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (16,16,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (17,16,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (18,16,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (19,16,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (20,16,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (21,16,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (22,16,@greyMethod,@notes12);
/* Row 17 Row 17  Row 17 Row 17 Row 17  Row 17 Row 17  Row 17 Row 17 Row 17   Row 17 Row 17  Row 17 Row 17 Row 17 
   Row 17 Row 17  Row 17 Row 17 Row 17  Row 17 Row 17  Row 17 Row 17 Row 17   Row 17 Row 17  Row 17 Row 17 Row 17 */ 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (1,17,@blueMethod,@notes123,@s,@p,@m);   
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (2,17,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (3,17,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (4,17,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (5,17,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (6,17,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P,M) VALUES  (7,17,@blueMethod,@notes123,@s,@p,@m);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,M,S) VALUES (8,17,@redMethod,@notes123,@p,@m,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (9,17,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (10,17,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (11,17,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (12,17,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (13,17,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (14,17,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (15,17,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (16,17,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,LUB) VALUES (17,17,@greyMethod,@notes12,@s,@LUB);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (18,17,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (19,17,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (20,17,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (21,17,@blackMethod);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method) VALUES  (22,17,@blackMethod);
/* Row 18 Row 18  Row 18 Row 18 Row 18  Row 18 Row 18  Row 18 Row 18 Row 18 Row 18 Row 18  Row 18 Row 18 Row 18
   Row 18 Row 18  Row 18 Row 18 Row 18  Row 18 Row 18  Row 18 Row 18 Row 18 Row 18 Row 18  Row 18 Row 18 Row 18 */ 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P) VALUES  (1,18,@blueMethod,@notes123,@s,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P) VALUES  (2,18,@blueMethod,@notes123,@s,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (3,18,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (4,18,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P) VALUES  (5,18,@blueMethod,@notes123,@s,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P) VALUES  (6,18,@blueMethod,@notes123,@s,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (7,18,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P) VALUES  (8,18,@blueMethod,@notes123,@s,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (9,18,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (10,18,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (11,18,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (12,18,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (13,18,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (14,18,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (15,18,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,S) VALUES (16,18,@redMethod,@notes123,@p,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (17,18,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (18,18,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (19,18,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (20,18,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (21,18,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (22,18,@greyMethod,@notes12,@s);
/* Row 19 Row 19  Row 19 Row 19 Row 19 Row 19  Row 19 Row 19  Row 19 Row 19  Row 19 Row 19 Row 19 Row 19  Row 19 Row 19
   Row 19 Row 19  Row 19 Row 19 Row 19 Row 19  Row 19 Row 19  Row 19 Row 19  Row 19 Row 19 Row 19 Row 19  Row 19 Row 19 */ 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P) VALUES  (1,19,@blueMethod,@notes123,@s,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P) VALUES  (2,19,@blueMethod,@notes123,@s,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (3,19,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (4,19,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P) VALUES  (5,19,@blueMethod,@notes123,@s,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P) VALUES  (6,19,@blueMethod,@notes123,@s,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES  (7,19,@blueMethod,@notes123,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S,P) VALUES  (8,19,@blueMethod,@notes123,@s,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (9,19,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (10,19,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (11,19,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (12,19,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (13,19,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (14,19,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (15,19,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,S) VALUES (16,19,@redMethod,@notes123,@p,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (17,19,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (18,19,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (19,19,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (20,19,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (21,19,@greyMethod,@notes12,@s);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,S) VALUES (22,19,@greyMethod,@notes12,@s);
/* Row 20 Row 20  Row 20  Row 20  Row 20 Row 20 Row 20  Row 20  Row 20  Row 20 Row 20 Row 20  Row 20  Row 20  Row 20
   Row 20 Row 20  Row 20  Row 20  Row 20 Row 20 Row 20  Row 20  Row 20  Row 20 Row 20 Row 20  Row 20  Row 20  Row 20 */ 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,X) VALUES  (1,20,@blueMethod,@notes123,@p,@x);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,X) VALUES  (2,20,@blueMethod,@notes123,@p,@x);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (3,20,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (4,20,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,X) VALUES  (5,20,@blueMethod,@notes123,@p,@x);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,X) VALUES  (6,20,@blueMethod,@notes123,@p,@x); 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (7,20,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (8,20,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (9,20,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (10,20,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (11,20,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (12,20,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (13,20,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (14,20,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (15,20,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,X) VALUES (16,12,@redMethod,@notes123,@p,@x);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (17,20,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (18,20,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (19,20,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (20,20,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (21,20,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (22,20,@greyMethod,@notes12);
/* Row 21 Row 21  Row 21  Row 21  Row 21 Row 21 Row 21  Row 21  Row 21  Row 21 Row 21 Row 21  Row 21  Row 21  Row 21 Row 21 Row 21  Row 21  Row 21  Row 21
   Row 21 Row 21  Row 21  Row 21  Row 21 Row 21 Row 21  Row 21  Row 21  Row 21 Row 21 Row 21  Row 21  Row 21  Row 21 Row 21 Row 21  Row 21  Row 21  Row 21 */ 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,X) VALUES  (1,21,@blueMethod,@notes123,@p,@x);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,X) VALUES  (2,21,@blueMethod,@notes123,@p,@x);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (3,21,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (4,21,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,X) VALUES  (5,21,@blueMethod,@notes123,@p,@x);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,X) VALUES  (6,21,@blueMethod,@notes123,@p,@x); 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (7,21,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (8,21,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (9,21,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (10,21,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (11,21,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (12,21,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (13,21,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (14,21,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (15,21,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,X) VALUES (16,21,@redMethod,@notes123,@p,@x);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (17,21,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (18,21,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (19,21,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (20,21,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (21,21,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (22,21,@greyMethod,@notes12);   
/* Row 22 Row 22  Row 22  Row 22  Row 22 Row 22 Row 22  Row 22  Row 22  Row 22 Row 22 Row 22  Row 22  Row 22  Row 22
   Row 22 Row 22  Row 22  Row 22  Row 22 Row 22 Row 22  Row 22  Row 22  Row 22 Row 22 Row 22  Row 22  Row 22  Row 22 */ 
  INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,X) VALUES  (1,22,@blueMethod,@notes123,@p,@x);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,X) VALUES  (2,22,@blueMethod,@notes123,@p,@x);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (3,22,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (4,22,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,X) VALUES  (5,22,@blueMethod,@notes123,@p,@x);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P,X) VALUES  (6,22,@blueMethod,@notes123,@p,@x); 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES  (7,22,@blueMethod,@notes123);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES  (8,22,@blueMethod,@notes123,@p);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (9,22,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (10,22,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (11,22,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (12,22,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (13,22,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (14,22,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (15,22,@greyMethod,@notes12);
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,P) VALUES (16,22,@redMethod,@notes123,@p); 
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (17,22,@greyMethod,@notes12);   
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (18,22,@redMethod,@notes123);   
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,X) VALUES (19,22,@redMethod,@notes123,@x);    
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,X) VALUES (20,22,@redMethod,@notes123,@x);   
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes,X) VALUES (21,22,@redMethod,@notes123,@x);   
INSERT INTO cleaning_guide (cargo_id,cargo_loaded_id,method,notes) VALUES (22,22,@greyMethod,@notes12);  

 INSERT INTO pj15_capacity_data(pj15_capacity_id,bar,nozzle_diameter_8_throughput,nozzle_diameter_9_throughput,nozzle_diameter_10_throughput,
nozzle_diameter_12_throughput,nozzle_diameter_13_throughput,nozzle_diameter_14_throughput,nozzle_diameter_16_throughput)
VALUES
   (1,6,3.5,5.5,8,12,15,18,24), (2,7,4,6,9,13,16,19.5,25.5),(3,8,4.5,7,10,14,17,20.5,27),(4,9,5,7.5,10.5,15,18.5,22,29),
     (5,10,5.5,8,11,16,20,23,31),(6,11,6,9,12,17,21,25,32.5),(7,12,6.5,10,13,18,22,26,33.5);     
           
          
 INSERT INTO pj120_capacity_data(pj120_capacity_id,bar,nozzle_diameter_25_throughput,nozzle_diameter_26_throughput,nozzle_diameter_28_throughput,
nozzle_diameter_29_throughput,nozzle_diameter_30_throughput,nozzle_diameter_31_throughput,
nozzle_diameter_325_throughput,nozzle_diameter_35_throughput)
VALUES   (8,6,51,56,63,68.5,73,78,84,95),(9,7,55,60,68,73,78.5,84,91,104),(10,8,59,64,72,78,84,90,98,114),
    (11,9,62.5,66,76,82.5,89,96,105,123),(12,10,66,72,80,87.5,94,102,112,132),(13,11,70,76,84.5,92,100,108,119,141),
    (14,12,74,80,89,97,105,114,126,149);
    
INSERT INTO pj25_capacity_data(pj25_capacity_id,bar,nozzle_diameter_8_throughput,nozzle_diameter_9_throughput,nozzle_diameter_10_throughput,
nozzle_diameter_12_throughput,nozzle_diameter_14_throughput,nozzle_diameter_16_throughput)
VALUES   (15,6,6,12,19,28,37,46),(16,7,6.5,13,20.5,29.5,39.5,49),(17,8,7,14,21.5,31.5,42,52),
    (18,9,7.5,15,23,33,44.5,55.5),(19,10,8,16,24.5,34.5,47,58.5),(20,11,8.5,17,25.5,36.5,49.5,62),(21,12,9,18,27,38,52,64);
    
    INSERT INTO pj30_capacity_data(pj30_capacity_id,bar,nozzle_diameter_12_throughput,nozzle_diameter_14_throughput,nozzle_diameter_16_throughput,
nozzle_diameter_18_throughput,nozzle_diameter_20_throughput,nozzle_diameter_22_throughput,nozzle_diameter_24_throughput,
nozzle_diameter_25_throughput,nozzle_diameter_28_throughput,nozzle_diameter_30_throughput)
VALUES   (22,6,13,19,25,30,37,42,47,50,62,72),(23,7,14,20,27,32,40,45,51,54,66,77),(24,8,15,22,28.5,34.5,42.5,48,54.5,58,70.5,83),(25,9,16,23,30,37,45,51,58,61.5,75,88),
(26,10,17,24,32,39,48,54,62,65,79.5,93),(27,11,18,26,33.5,42,51,57,65.5,69,84,99),(28,12,19,27,35,44,54,60,69,73,88,103);
    
    
    
    
    INSERT INTO tank_info(tankId,tankName,machine_char)
VALUES   (1,'WBTK1S','a'),(1,'WBTK1S','b'),(2,'WBTK2S','a'),(2,'WBTK2S','b'),(3,'WBTK3S','a'),(3,'WBTK3S','b'),(4,'WBTK4S','a'),(4,'WBTK4S','b'),
(5,'WBTK5S','a'),(5,'WBTK5S','b'),(6,'WBTK6S','a'),(6,'WBTK6S','b'),(7,'WBTK7S','a'),(7,'WBTK7S','b'),(8,'WBTK1P','a'),(8,'WBTK1P','b'), 
  (9,'WBTK2P','a'),(9,'WBTK2P','b'),(10,'WBTK3P','a'),(10,'WBTK3P','b'),(11,'WBTK4P','a'),(11,'WBTK4P','b'),(12,'WBTK5P','a'),(12,'WBTK5P','b'),
   (13,'WBTK6P','a'),(13,'WBTK6P','b'),(14,'WBTK7P','a'),(14,'WBTK7P','b');
    
   
    
    
     
   
   
   


 