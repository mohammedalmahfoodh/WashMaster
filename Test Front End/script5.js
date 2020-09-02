
window.onload = () => {



    let startWashButt = document.getElementById('startWash');
    let stopWashButt = document.getElementById('stopWash');
    let resumeWashButt = document.getElementById('resumeWash');

    let washInterval;


    ///************************************** */

    let progressbar = document.getElementById('progressbar');
    

    ///******************** */
    let finishTimeDom = document.getElementById('finishTime');
    let elapsedTimeDom = document.getElementById('elapsedTime');
    let remainingTimeDom = document.getElementById('remainingTime');
    let percentageDom = document.getElementById('percentage');
    let processStatusDom = document.getElementById('processStatus');   
       
    let stepDom = document.getElementById('stepNumber');
    let stepProfileNameDom = document.getElementById('stepProfileName');



    let finishTime;
    let elapsedTime;
    let remainingTime;
    let decimalOfPercentage;
    let percentage;
    let processStatus;
   
    let step;
    let stepProfileName;


    let resumeProcess = function () {
        axios.post('http://192.168.12.68:3003/api/resumeWash', {
            tcmId: 1
        }).then((res) => {
            console.log(res)
        }).catch((err) => {

        });
    }




    let stopProcess = function () {
        axios.post('http://192.168.12.68:3003/api/stopOrPauseWash', {
            tcmId: 1
        }).then((res) => {
            console.log(res)
        }).catch((err) => {

        });
    }


    let getProcess = function () {
        washInterval = setInterval(() => {
            axios.post('http://192.168.12.68:3003/api/getProcess', {
                tcmId: 1
            }).then((res) => {
                console.log(res)
                if (res.data.processStatus === 0) {
                    clearInterval(washInterval);
                }
                // data: {tcmId: 1, step_profile_name: "wash", finishTime: "00:01:00", elapsedTime: "00:00:05", percentage: "8 %", …}
                if (res.status === 200) {
                    finishTime = res.data.finishTime;
                    elapsedTime = res.data.elapsedTime;
                    remainingTime = res.data.remainingTime;
                    decimalOfPercentage = res.data.decimalOfPercentage;
                    processStatus = res.data.processStatus;
                    percentage = res.data.percentage;                  
                                        
                    step = res.data.stepNumber;
                    stepProfileName = res.data.step_profile_name;

                    //******************************************************* */
                    finishTimeDom.innerText = finishTime;
                    elapsedTimeDom.innerText = elapsedTime;
                    remainingTimeDom.innerText = remainingTime;
                    percentageDom.innerText = percentage;                   
                    stepDom.innerText = step;
                    stepProfileNameDom.innerText = stepProfileName;
                    progressbar.style.setProperty('width', decimalOfPercentage + '%');
                    progressbar.style.setProperty('aria-valuenow', decimalOfPercentage);
                    switch (processStatus) {
                        case 0:
                          processStatusDom.innerText = 'Finished';
                          progressbar.style.setProperty('color', '#07ad65');
                          processStatusDom.style.setProperty('color','#1b614e');
                          
                            break;

                        case 1:
                            processStatusDom.innerText = 'Working...';
                            progressbar.style.setProperty('color', '#eb4934');
                            processStatusDom.style.setProperty('color','#eb4934');
                            break;

                        case 2:
                            processStatusDom.innerText = 'Paused';
                            progressbar.style.setProperty('color', 'yellow');
                            processStatusDom.style.setProperty('color','yellow');
                            break;
                            case 3:
                                processStatusDom.innerText = 'Operation finished click stop';
                                progressbar.style.setProperty('color', 'orange');
                                processStatusDom.style.setProperty('color','orange');
                            //    alert("The process has been finished Jc thanks for your patient, regardly stop the operation .");
                            break;

                        default:
                            break;
                    }

                } //if(res.status === 200)
            }).catch((err) => {

            });

            /*     part += 15;
                 decimalPercentage = part / whole;
                 finishTimeDom.innerText = decimalPercentage;
                 elapsedTimeDom.innerText = decimalPercentage;
                 remainingTimeDom.innerText = decimalPercentage;
     
                 progressbar.style.setProperty('width', decimalPercentage + '%');
                 progressbar.style.setProperty('aria-valuenow', decimalPercentage);
                 console.log('Washing...........');*/

            /*    if (decimalPercentage == 550000) {
                    clearInterval(washInterval);
                    console.log('Interval stopped......')
                }*/

        }, 1700);
    }


    let startWash = function () {
        axios.post('http://192.168.12.68:3003/api/startPreWash', {
            tcmId: 1,
            general_plan_id: "2020-09-02 14:50:26",
            stepNumber: 1,
            step_profile_name: "Pre-Clean Flushing",           
            timeForOperation: 1
        }

        ).then((result) => {

            if (result.status === 200) {
                console.log(result.status);

                getProcess();
            }

        }).catch((err) => {
            console.log(err);
        });

    }



    startWashButt.addEventListener('click', startWash);
    stopWashButt.addEventListener('click', stopProcess);
    resumeWashButt.addEventListener('click', resumeProcess);







}







