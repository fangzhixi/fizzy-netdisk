function post_a(pattern, token, name, value) {
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

    // param
    var paramPath = document.createElement('input');
    paramPath.type = 'hidden';
    paramPath.name = name;
    paramPath.value = value;
    form.appendChild(paramPath);

    document.body.appendChild(form);
    form.submit();
    document.body.removeChild(form);
}