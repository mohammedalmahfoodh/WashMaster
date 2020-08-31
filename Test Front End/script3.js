
window.onload = () => {



    let startWashButt = document.getElementById('startWash');
    let stopWashButt = document.getElementById('stopWash');
    let resumeWashButt = document.getElementById('resumeWash');

    let washInterval;


    ///************************************** */

    let progressbar = document.getElementById('progressbar');
    let part = 1;
    let whole = 100;


    ///******************** */
    let finishTimeDom = document.getElementById('finishTime');
    let elapsedTimeDom = document.getElementById('elapsedTime');
    let remainingTimeDom = document.getElementById('remainingTime');
    let percentageDom = document.getElementById('percentage');
    let processStatusDom = document.getElementById('processStatus');
    let currentNozzleAngleDom = document.getElementById('currentNozzleAngle');

    let finishTime;
    let elapsedTime;
    let remainingTime;
    let decimalOfPercentage;
    let percentage;
    let processStatus;
    let currentNozzleAngle;


    let resumeProcess = function () {
        axios.post('http://192.168.12.68:3003/api/resumeWash', {
            tcmId: 3
        }).then((res) => {
            console.log(res)
        }).catch((err) => {

        });
    }




    let stopProcess = function () {
        axios.post('http://192.168.12.68:3003/api/stopOrPauseWash', {
            tcmId: 3
        }).then((res) => {
            console.log(res)
        }).catch((err) => {

        });
    }


    let getProcess = function () {
        washInterval = setInterval(() => {
            axios.post('http://192.168.12.68:3003/api/getProcess', {
                tcmId: 3
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
                    currentNozzleAngle = res.data.stringCurrentNozzleAngle;
                    //******************************************************* */
                    finishTimeDom.innerText = finishTime;
                    elapsedTimeDom.innerText = elapsedTime;
                    remainingTimeDom.innerText = remainingTime;
                    percentageDom.innerText = percentage;
                    currentNozzleAngleDom.innerText = currentNozzleAngle ;
                    progressbar.style.setProperty('width', decimalOfPercentage + '%');
                    progressbar.style.setProperty('aria-valuenow', decimalOfPercentage);
                    switch (processStatus) {
                        case 0:
                          processStatusDom.innerText = 'Finished';
                          progressbar.style.setProperty('color', '#07ad65');
                          processStatusDom.style.setProperty('color','#43ba63');
                          
                            break;

                        case 1:
                            processStatusDom.innerText = 'Working';
                            progressbar.style.setProperty('color', '#eb4934');
                            processStatusDom.style.setProperty('color','#611309');
                            break;

                        case 2:
                            processStatusDom.innerText = 'Paused';
                            progressbar.style.setProperty('color', 'yellow');
                            processStatusDom.style.setProperty('color','yellow');
                            break;
                            case 3:
                                alert("The process has been finished Jc thanks for your patient, regardly stop the operation .");
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
        axios.post('http://192.168.12.68:3003/api/startWash', {
            tcmId: 3,
            general_plan_id: "2020-08-28 08:49:37",
            stepProfile: 4,
            step_profile_name: "wash",
            rpm: 2,
            bar: 2,
            speed: 2,
            pitch: 2,
            lWsValue: 0,
            uWsValue: 30,
            cleaning_time_in_minutes: 6
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







