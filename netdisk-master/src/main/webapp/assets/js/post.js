function post_a(pattern, token, name_1, value_1, name_2, value_2) {
    var form = document.createElement('form');
    form.style = "display:none;";
    form.method = 'post';
    form.action = pattern;
    form.target = '_self';

    // token
    var tokenPath = document.createElement('input');
    tokenPath.type = 'hidden';
    tokenPath.name = 'token';
    tokenPath.value = token;
    form.appendChild(tokenPath);

    // param1
    if (name_1 != null && name_1 != ''){
        var paramPath_1 = document.createElement('input');
        paramPath_1.type = 'hidden';
        paramPath_1.name = name_1;
        paramPath_1.value = value_1;
        form.appendChild(paramPath_1);
    }

    // param2
    if (name_2 != null && name_2 != '') {
        var paramPath_2 = document.createElement('input');
        paramPath_2.type = 'hidden';
        paramPath_2.name = name_2;
        paramPath_2.value = value_2;
        form.appendChild(paramPath_2);
    }

    document.body.appendChild(form);
    form.submit();
    document.body.removeChild(form);
}