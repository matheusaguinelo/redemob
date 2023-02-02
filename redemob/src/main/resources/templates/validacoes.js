document.getElementById("cpf").addEventListener("input", function(event) {
    var value = this.value.replace(/\D/g, "");

    this.value = value.slice(0, 3) + "." + value.slice(3, 6) + "." + value.slice(6, 9) + "-" + value.slice(9, 11);
});

function validateCPF(cpf) {
    cpf = cpf.replace(/\D/g, '');

    if (cpf.length !== 11) {
        return false;
    }

    if (/^(.)\1+$/.test(cpf)) {
        return false;
    }

    var digits = cpf.split('');
    var sum = 0;
    var weight = 10;
    for (var i = 0; i < 9; i++) {
        sum += digits[i] * weight;
        weight--;
    }
    var firstDigit = (sum * 10) % 11;
    if (firstDigit === 10 || firstDigit === 11) {
        firstDigit = 0;
    }

    sum = 0;
    weight = 11;
    for (var j = 0; j < 10; j++) {
        sum += digits[j] * weight;
        weight--;
    }
    var secondDigit = (sum * 10) % 11;
    if (secondDigit === 10 || secondDigit === 11) {
        secondDigit = 0;
    }

    if (firstDigit !== +digits[9] || secondDigit !== +digits[10]) {
        return false;
    }

    return true;
}

var form = document.querySelector('form');
var cpfInput = document.querySelector('input[name="cpf"]');
var errorMessage = document.querySelector('#error-message');

form.addEventListener('submit', function (event) {
    event.preventDefault();

    var cpf = cpfInput.value;
    if (validateCPF(cpf)) {
        errorMessage.textContent = '';
        this.action = "/book/form/save";
        this.method = "POST";
    } else {
        errorMessage.textContent = 'CPF inválido';
    }
})

document.querySelector("form").addEventListener("submit", function(event) {
    var dtNasc = document.getElementById("dt_nasc");

    if (isValidDtNasc(dtNasc.value)) {
        return true;
    } else {
        event.preventDefault();
        alert("A data de nascimento deve ter mais de 18 anos.");
    }
});

function isValidDtNasc(dtNasc) {
    var hoje = new Date();
    var dtNasc = new Date(dtNasc);
    var idade = hoje.getFullYear() - dtNasc.getFullYear();
    return idade >= 18;
}


function checkPasswordLength() {
    var password = document.getElementById("password").value;
    var errorMessage = document.getElementById("errorMessage");
    if (password.length < 8 || password.length > 20) {
        errorMessage.style.display = "block";
    } else {
        errorMessage.style.display = "none";
    }
}