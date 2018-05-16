//ajax请求函数
function request(object, method, methodURL, callback) {
    $.ajax({
        cache: true,
        type: method,
        dataType: "json",
        contentType: "application/json",
        url: methodURL,
        data: object,
        error: function (XMLHttpRequest, errorThrown) {
            console.log(XMLHttpRequest.status + "\r\n" + XMLHttpRequest.readyState);
        },
        success: callback
    });
}

function roomUpdateRequest(object, method, methodURL, callback) {
    $.ajax({
        cache: true,
        type: method,
        dataType: "json",
        contentType: "application/json",
        url: methodURL,
        data: object,
        error: function (XMLHttpRequest, errorThrown) {
            console.log(XMLHttpRequest.status + "\r\n" + XMLHttpRequest.readyState);
            success: callback;
        },

    });
}

//刷新入住记录
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

//刷新房间信息
function refreshRoom(data) {
    var selector = $("#list").find("#list1").find("#listbody");
    selector.html("");
    var map = data.list;
    var buttonsHtml = "<div class='btn-group' style='width: 79px;left: 43px;'><button class='btn btn-info' style='height: 34px; line-height: 15px;' data-toggle='modal' data-target = '#myModal' onclick='roomDetailClick(this)'>详情</button>" +
        "<button class='btn btn-info dropdown-toggle' data-toggle='dropdown'><span class='caret'></span></button><ul class='dropdown-menu'><button class='btn btn-info' style='height: 34px; line-height: 15px; width: 80px' data-toggle='modal' data-target='#updateModal' onclick='roomUpdateClick(this)'>修改</button></ul></div>";
    for (var i = 0; i < map.length; i++) {
        var roomNo = map[i].roomNo;
        var roomType = map[i].roomType;
        var roomPrice = map[i].roomPrice;
        var roomStatus = map[i].roomStatus;
        var id = map[i].id;
        if (map[i].remark != null) {
            var remark = map[i].remark;
        } else {
            var remark = "";
        }
        var operation = buttonsHtml;
        selector.append("<tr>" + "<td>"+roomNo+"</td>" + "<td>"+roomType+ "</td>" +"<td>"+ roomPrice+"</td>" +"<td>"+ roomStatus+"</td>" +"<td>"+ remark+"<input style='display:none;' value='"+id+"'/>"+ "</td>" + "<td>" + operation + "</td>");
    }
    $("#listbody").find("tr").find("td").css("line-height","34px");
}

function refreshRoomApply(data) {
    var selector = $("#list").find("#list1").find("#listbody");
    selector.html("");
    var map = data.list;
    for (var i = 0; i < map.length; i++) {
        var roomNo = map[i].roomNo;
        var roomType = map[i].roomType;
        var roomPrice = map[i].roomPrice;
        var roomStatus = map[i].roomStatus;
        var id = map[i].id;
        if (map[i].remark != null) {
            var remark = map[i].remark;
        } else {
            var remark = "";
        }
        selector.append("<tr>" + "<td>"+roomNo+"</td>" + "<td>"+roomType+ "</td>" +"<td>"+ roomPrice+"</td>" +"<td>"+ roomStatus+"</td>" +"<td>"+ remark+"<input style='display:none;' value='"+id+"'/>"+ "</td>");
    }
    $("#listbody").find("tr").find("td").css("line-height","34px");
}

//房间信息维护-点击详情按钮时
function roomDetailClick(button) {
    var id = $(button).parent().parent().prev().find("input").val();
    request(id,"GET","/room/"+id,roomDetail);
}
//房间信息维护-获取详情
function roomDetail(data) {
    var selector = $(".room-info").find(".controls");
    selector.find("#roomNo").attr("placeholder",data.roomNo);
    selector.find("#roomStatus").attr("placeholder",data.roomStatus);
    selector.find("#roomType").attr("placeholder",data.roomType);
    selector.find("#roomPrice").attr("placeholder",data.roomPrice);
    selector.find("#remark").attr("placeholder",data.remark);
    selector.find("#createUser").attr("placeholder",data.createUser);
    selector.find("#createTime").attr("placeholder",data.createTime);
}

//房间信息维护-点击修改时的房间信息
function roomDetailBeforeUpdate(data) {
    var selector = $(".room-update").find(".controls");
    selector.find("#roomNoUpdate").attr("value",data.roomNo);
    selector.find("#roomStatusUpdate").selectpicker('val', data.roomStatus);
    selector.find("#roomTypeUpdate").selectpicker('val', data.roomType);
    selector.find("#roomPriceUpdate").attr("value",data.roomPrice);
    selector.find("#remarkUpdate").attr("value",data.remark);
    selector.find("#createUserUpdate").attr("value",data.createUser);
    selector.find("#createTimeUpdate").attr("value",data.createTime);
    $("#idUpdate").attr("value",data.id);
}

//房间信息维护-点击修改按钮时
function roomUpdateClick(button) {
    var id = $(button).parent().prev().prev().parent().parent().prev().find("input").val();
    request(id,"GET","/room/"+id,roomDetailBeforeUpdate);
    return id;
}

//房间信息维护-确认修改时
function confirmUpdate(){
    var id = $("#idUpdate").val();
    var roomNo = $("#roomNoUpdate").val();
    var roomStatus = $("#roomStatusUpdate").val();
    var roomType = $("#roomTypeUpdate").val();
    var roomPrice = $("#roomPriceUpdate").val();
    var remark = $("#remarkUpdate").val();

    var o = {};
    o.id = id;
    o.roomNo = roomNo;
    o.roomStatus = roomStatus;
    o.roomType = roomType;
    o.roomPrice = roomPrice;
    o.remark = remark;
    var requestData = JSON.stringify(o);
    roomUpdateRequest(requestData,"patch","/room",refreshRoom);
    console.log("xcf111");
}