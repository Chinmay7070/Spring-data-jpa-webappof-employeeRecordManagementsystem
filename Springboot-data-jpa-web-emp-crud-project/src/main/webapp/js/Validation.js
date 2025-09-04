function validateForm(frm) {
	
    // clear old errors
    document.getElementById("enameErr").innerHTML = "";
    document.getElementById("jobErr").innerHTML = "";
    document.getElementById("salErr").innerHTML = "";
    document.getElementById("deptnoErr").innerHTML = "";

    let name = frm.ename.value.trim();
    let job = frm.job.value.trim();
    let sal = frm.sal.value.trim();
    let dno = frm.deptno.value.trim();

	
    let vflag = true;

    // Employee Name validation
    if (name === "") {
        document.getElementById("enameErr").innerHTML = "Employee name is mandatory.";
        vflag = false;
    } else if (name.length < 5 || name.length > 15) {
        document.getElementById("enameErr").innerHTML =
            "Employee name must have minimum of 5 chars and maximum of 15 chars.";
        vflag = false;
    }

    // Job validation
    if (job === "") {
        document.getElementById("jobErr").innerHTML = "Employee job is mandatory.";
        vflag = false;
    } else if (job.length < 4 || job.length > 10) {
        document.getElementById("jobErr").innerHTML =
            "Employee job must have minimum of 4 chars and maximum of 10 chars.";
        vflag = false;
    }

    // Salary validation
    if (sal === "") {
        document.getElementById("salErr").innerHTML = "Employee salary is mandatory.";
        vflag = false;
    } else if (isNaN(sal)) {
        document.getElementById("salErr").innerHTML = "Employee salary must be a numeric value.";
        vflag = false;
    } else if (parseInt(sal) < 10000 || parseInt(sal) > 200000) {
        document.getElementById("salErr").innerHTML =
            "Employee salary must be between 10000 and 200000.";
        vflag = false;
    }

    // Department validation
    if (dno === "" || dno === "0") {
        document.getElementById("deptnoErr").innerHTML = "Please select a department.";
        vflag = false;
    }
	frm.vflag1.value = "yes"

    return vflag;
}

// for debug
console.log("✅ Validation.js loaded");
