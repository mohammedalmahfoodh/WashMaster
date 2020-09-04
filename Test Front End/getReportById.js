window.onload = () => {



    let getReportButt = document.getElementById('getReport');
    let tableBody = document.getElementById('reportBody');
    let reportIdInput = document.getElementById('reportIdInput');
     let group = document.getElementsByClassName('form-group row');


    let displayTable = function (data) {
          let va = 8
        let tableBodyContent = ` 
        <tr>
          <th scope="row">${data.report_id} </th>
          <th>${data.report_start_date} </th>
          <th> ${data.report_end_date} </th>
          <th>${data.general_plan_id} </th>
          <th>${data.session_id} </th>
          <th>${data.tankId} </th>
          <th>${data.tcmId} </th>
          <th>${data.profileNumber} </th>
          <th>${data.machineName} </th>
          <th>${data.nozzle_diameter} </th>
          <th>${data.uWsValue} </th>
          <th>${data.lWsValue} </th>
          <th>${data.cycle} </th>
          <th>${data.pitch} </th>
          <th>${data.rpm} </th>
          <th>${data.speed} </th>
          <th>${data.washing_Media_Amount} </th>

        </tr>        
      ` 
      
      tableBody.innerHTML = tableBodyContent;
      

    }



    let getReport = function () {
        
        let report_id = reportIdInput.value;
        console.log(reportIdInput.value)
        axios.post('http://192.168.12.68:3003/api/getReportById', {
           
            report_id:report_id
        }

        ).then((result) => {

            if (result.status === 200) {
                console.log(result.data);
                reportIdInput.style.border = "none"
                displayTable(result.data);
            }else{
                console.log("Not Valid Report Id..")
               
               
            }

        }).catch((err) => {
            console.log(err);
            
            reportIdInput.style.backgroundColor = "red"
            reportIdInput.value = "Wrong report id please type valid report id."
            reportIdInput.style.color = "white"
            reportIdInput.style.border = "thin solid red"
            setTimeout(() => {
                reportIdInput.style.backgroundColor = "white";
                reportIdInput.value =""
                reportIdInput.style.color = "black";
                reportIdInput.setAttribute("placeholder") = "Type valid report ID.. Like    2020-09-04 07:04:30 ";
                
            }, 5000);
        });

    }





    getReportButt.addEventListener('click', getReport);



} // Window load