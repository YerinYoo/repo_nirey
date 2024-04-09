function checkNull(objName, pattern, message) {
    var obj = document.getElementById(objName);
    var objValue = document.getElementById(objName).value.trim();
    var objFeedback = document.getElementById(objName + "Feedback");

    if (objValue == "" || objValue == null) {
        checkLogicExpression(obj, objFeedback, pattern, message);
        return false;
    } else {
        obj.classList.remove('is-invalid');
        return true;
    }
}

function checkNullWithoutFocus(value, message) {
    if (value == "" || value == null) {
        alert(message);
        return false;
    } else {
        return true;
    }
}

function checkOnlyKoreanEnglishNumber(objName, pattern, nullAllowedNy, message) {
    var regExp = /^[ㄱ-ㅎ가-힣A-Za-z0-9]+$/;
    return checkLogic(objName, pattern, nullAllowedNy, message, regExp);
}

function checkOnlyEnglishNumber(objName, pattern, nullAllowedNy, message) {
    var regExp = /^[A-Za-z0-9]+$/;
    return checkLogic(objName, pattern, nullAllowedNy, message, regExp);
}

function checkOnlyEnglish(objName, pattern, nullAllowedNy, message) {
    var regExp = /^[A-Za-z]+$/;
    return checkLogic(objName, pattern, nullAllowedNy, message, regExp);
}

function checkOnlyKoreanNumber(objName, pattern, nullAllowedNy, message) {
    var regExp = /^[ㄱ-ㅎ가-힣0-9]+$/;
    return checkLogic(objName, pattern, nullAllowedNy, message, regExp);
}

function checkOnlyKorean(objName, pattern, nullAllowedNy, message) {
    var regExp = /^[ㄱ-ㅎ가-힣]+$/;
    return checkLogic(objName, pattern, nullAllowedNy, message, regExp);
}

function checkOnlyNumber(objName, pattern, nullAllowedNy, minMaxCheckNy, min, max, message) {
    var obj = document.getElementById(objName);
    var objValue = document.getElementById(objName).value.trim();
    var objFeedback = document.getElementById(objName + "Feedback");
    var regExp = /^[0-9]+$/;

    if (minMaxCheckNy == 1) {
        if (objValue >= min && objValue <= max) {
            return checkLogic(objName, pattern, nullAllowedNy, message, regExp);
        } else {
            checkLogicExpression(obj, objFeedback, pattern, message);
            return false;
        }
    } else {
        return checkLogic(objName, pattern, nullAllowedNy, message, regExp);
    }
}

function checkSelectNull(objName, pattern, message) {
    var obj = document.getElementById(objName);
    var objValue = document.getElementById(objName).value;
    var objFeedback = document.getElementById(objName + "Feedback");

    if (objValue != "" && objValue != null) {
        obj.classList.remove('is-invalid');
        return true;
    } else {
        checkLogicExpression(obj, objFeedback, pattern, message)
        return false;
    }
}

function checkRadio(objName, pattern, nullAllowedNy, message, regExp) {
    var obj = document.getElementById(objName);
    var objFeedback = document.getElementById(objName + "Feedback");

    if (document.querySelector("input[name='gender']:checked") != null) {
        if (document.querySelector("input[name='gender']:checked") != null) {
            obj.classList.remove('is-invalid');
            return true;
        } else {
            checkLogicExpression(obj, objFeedback, pattern, message);
            return false;
        }
    }
}

function checkId(objName, pattern, nullAllowedNy, message) {
    var regExp = /^[A-Za-z0-9,_-]{4,20}$/;
    return checkLogic(objName, pattern, nullAllowedNy, message, regExp);
}

function checkPassword(objName, pattern, nullAllowedNy, message) {
    var regExp = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*]).{8,20}$/;
    return checkLogic(objName, pattern, nullAllowedNy, message, regExp);
}

function checkPasswordAndRe(password, passwordRe, message) {
    var objPassword = document.getElementById(objName);
    var objPasswordRe = document.getElementById(objName + "Re");
    var objPasswordValue = objPassword.value.trim();
    var objPasswordReValue = objPasswordRe.value.trim();
    var objFeedback = document.getElementById(objName + "ReFeedback");

    if (objPasswordValue == objPasswordReValue) {
        objPasswordRe.classList.remove('is-invalid');
        return true;
    } else {
        checkLogicExpression(objPasswordRe, objFeedback, pattern, message);
        return false;
    }
}

function checkDob(year, month, day, message) {
    if (Number(year) > 0 && Number(month) > 0 && Number(day) > 0) {
        objPasswordRe.classList.remove('is-invalid');
        return true;
    } else {
        checkLogicExpression(objPasswordRe, objFeedback, pattern, message);
        return false;
    }
}

function checkEmail(objName, pattern, nullAllowedNy, message) {
    var regExp = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    return checkLogic(objName, pattern, nullAllowedNy, message, regExp);
}

function checkMobile(objName, pattern, nullAllowedNy, message) {
    var regExp = /^\d{3}-\d{3,4}-\d{4}$/;
    return checkLogic(objName, pattern, nullAllowedNy, message, regExp);
}
