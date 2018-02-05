function createXHR() {
    if (window.XMLHttpRequest)    //  Objet standard
    {
        xhr = new XMLHttpRequest();     //  Firefox, Safari, ...
    }
    else if (window.ActiveXObject)      //  Internet Explorer
    {
        xhr = new ActiveXObject("Msxml2.XMLHTTP");
    }
    return xhr;
}

function getParameterValues()
{
	return '';
}

function executerRequeteXML(url, querystring, okFunction, errorFunction)
{
    var xhr = createXHR();
    xhr.onreadystatechange = function()
    {
        if (xhr.readyState == 4)
        {
            if (xhr.status == 200 || xhr.status == 204)
            {
                okFunction(xhr.responseXML);
            }
            else
            {
                errorFunction(xhr.status);
            }
        }
    };
    
    
    xhr.open("GET", url + "?" + querystring, true);
    xhr.send(null);
}

function executerRequete(url, querystring, okFunction, errorFunction)
{
    var xhr = createXHR();
    xhr.onreadystatechange = function()
    {
        if (xhr.readyState == 4)
        {
            if (xhr.status == 200 || xhr.status == 204)
            {
                okFunction(xhr.responseText);
            }
            else
            {
                errorFunction(xhr.status);
            }
        }
    };

    xhr.open("GET", url + "?" + querystring, true);
    xhr.send(null);
}