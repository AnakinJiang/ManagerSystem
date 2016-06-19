/*校验*/
function checkid(ssn) {
    if(ssn.length!=12) {
        document.getElementById("idErr").innerHTML="<font color='red'>请输入12位的学号！</font>"
        return false;
    }
    document.getElementById("idErr").innerHTML="";
    return true;
}

function checkpw(ssn) {
    if(ssn=="" || ssn==null) {
        document.getElementById("pwErr").innerHTML="<font color='red'>密码不能为空！</font>";
        return false;
    }
    document.getElementById("pwErr").innerHTML="";
    return true;
}
function checkrpw(ssn) {
    if(ssn!=document.getElementById("pw").value.toString()) {
        document.getElementById("rpwErr").innerHTML="<font color='red'>两次密码不一致！</font>";
        return false;
    }
    document.getElementById("rpwErr").innerHTML="";
    return true;
}
function checkun(ssn) {
    if(ssn==null || ssn=="") {
        document.getElementById("unErr").innerHTML="<font color='red'>请输入用户名！</font>";
        return false;
    }
    document.getElementById("unErr").innerHTML="";
    return true;
}
function checkidn(ssn) {
    if(ssn==null || ssn=="") {
        document.getElementById("idnErr").innerHTML="<font color='red'>请输入您的身份证号码！</font>";
        return false;
    }
    else if(ssn.length!=18) {
        document.getElementById("idnErr").innerHTML="<font color='red'>请输入有效的身份证号码！</font>";
        return false;
    }
    else {
    	//TO　DO
    }
    document.getElementById("idnErr").innerHTML="";
    return true;
}
function checkna(ssn) {
    if(ssn==null || ssn=="") {
        document.getElementById("naErr").innerHTML="<font color='red'>请输入您的真实姓名！</font>";
        return false;
    }
    document.getElementById("naErr").innerHTML="";
    return true;
}
function checkph(ssn) {
    if(ssn==null || ssn=="") {
        document.getElementById("phErr").innerHTML="<font color='red'>请输入您的手机号码！</font>";
        return false;
    }
    document.getElementById("phErr").innerHTML="";
    return true;
}
function checkad(ssn) {
    if(ssn==null || ssn=="") {
        document.getElementById("adErr").innerHTML="<font color='red'>请输入您的寝室住址！</font>";
        return false;
    }
    document.getElementById("adErr").innerHTML="";
    return true;
}