@ECHO OFF
"C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe" --protocol=tcp --host=localhost --user=root --password=tyfon --port=3306 --default-character-set=utf8 --comments   < "%CD%\Create DataBaseWM.sql"
"C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe" --protocol=tcp --host=localhost --user=root --password=tyfon --port=3306 --default-character-set=utf8 --comments --database=wash_master  < "%CD%\Create TablesCargos.sql"
"C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe" --protocol=tcp --host=localhost --user=root --password=tyfon --port=3306 --default-character-set=utf8 --comments --database=wash_master  < "%CD%\InsertIntoCleaningGuide.sql"



echo.
echo.
ECHO Database Wash Master has been initialized...
echo.
echo.
echo.
echo.
echo.
echo.
echo.
echo.
echo.
echo.
echo.
echo.
echo.
echo.
echo.
echo.

PAUSE