function request(object, method, methodURL, callback) {
    $.ajax({
        cache: true,
        type: method,
        dataType: "json",
        contentType: "application/json",
        url: methodURL,
        data: object,
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status + "\r\n" + XMLHttpRequest.readyState + "\r\n" + textStatus);
        },
        success: function (data) {
            callback(data);
        }
    });
}

function refreshLog(data) {
    var selector = $("#list").find("#list1").find("#listbody");
    selector.html("");
    var map = data.list;
    for (var i = 0; i < map.length; i++) {
        var id = "<th>" + (i + 1) + "</th>";
        var userName = "<th>" + map[i].userName + "</th>";
        var cardId = "<th>" + map[i].cardId + "</th>";
        var checkInDays = "<th>" + map[i].checkInDays + "</th>";
        var roomNumber = "<th>" + map[i].roomNumber + "</th>";
        var checkInDate = "<th>" + map[i].checkInDate + "</th>";
        var checkOutDate = "<th>" + map[i].checkOutDate + "</th>";
        var downpayment = "<th>" + map[i].downpayment + "</th>";
        selector.append("<tr>" + id + userName + cardId + checkInDays + roomNumber + checkInDate + checkOutDate + downpayment);
    }
}

function refreshRoom(data) {
    var selector = $("#roomlist").find("#list1").find("#listbody");
    selector.html("");
    for (var i = 0; i < data.length; i++) {
        var id = "<th>" + (i + 1) + "</th>";
        var number = "<th>" + data[i].number + "</th>";
        var type = "<th>" + data[i].type + "</th>";
        var price = "<th>" + data[i].price + "</th>";
        var startdate = "<th>" + data[i].startdate + "</th>";
        var enddate = "<th>" + data[i].enddate + "</th>";
        if (data[i].state == 0) {
            var state = "<th>" + "空闲" + "</th>";
            startdate = "<th>" + "" + "</th>";
            enddate = "<th>" + "" + "</th>";
        }
        else {
            var state = "<th>" + "在售" + "</th>";
        }
        selector.append("<tr>" + id + number + type + state + price + startdate + enddate)
    }
}