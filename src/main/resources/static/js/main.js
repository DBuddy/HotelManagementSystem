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
        var id = "<td>" + (i + 1) + "</td>";
        var userName = "<td>" + map[i].userName + "</td>";
        var cardId = "<td>" + map[i].cardId + "</td>";
        var checkInDays = "<td>" + map[i].checkInDays + "</td>";
        var roomNumber = "<td>" + map[i].roomNumber + "</td>";
        var checkInDate = "<td>" + map[i].checkInDate + "</td>";
        var checkOutDate = "<td>" + map[i].checkOutDate + "</td>";
        var downpayment = "<td>" + map[i].downpayment + "</td>";
        selector.append("<tr>" + id + userName + cardId + checkInDays + roomNumber + checkInDate + checkOutDate + downpayment);
    }
}

function refreshRoom(data) {
    var selector = $("#list").find("#list1").find("#listbody");
    selector.html("");
    var map = data.list;
    for (var i = 0; i < map.length; i++) {
        var roomNo = "<td>" + map[i].roomNo + "</td>";
        var roomType = "<td>" + map[i].roomType + "</td>";
        var roomPrice = "<td>" + map[i].roomPrice + "</td>";
        var roomStatus = "<td>" + map[i].roomStatus + "</td>";
        var remark = "<td>" + map[i].remark + "</td>";
        var operation = "<td>" + "<button class='btn btn-info' style='height: 30px; line-height: 15px' data-toggle='modal' data-target = '#myModal'>详情</button>" + "</td>";
        selector.append("<tr>" + roomNo + roomType + roomPrice + roomStatus + remark + operation);
    }
}