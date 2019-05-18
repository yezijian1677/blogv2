function addKind() {
    var kind = document.getElementById("category-name");
    var value = kind.value;
    $.post("/admin/addKind", {kind: value}, function (result) {
        if (result.success){
            alert("添加成功");
            window.location.reload();
        } else {
            alert(result.msg);
        }
    })
}

function delKind(id){
    if(window.confirm("此操作不可逆，是否确认？")){
        $.post("/admin/delKind", {id: id}, function (result) {
            if (result.success){
                alert("删除成功");
                window.location.reload();
            } else {
                alert(result.msg);
            }
        })
    }
}

$(
    function () {
        var kindInfo = document.getElementById("kindInfo");
        var targetUrl = "/admin/getKinds";
        $.get(targetUrl,function (result) {
            var kinds = result.data;
            for (i = 0; i < kinds.length; i++) {
                if (result.data[i]){
                    var tr = document.createElement("tr");
                    var kind = result.data[i];
                    tr.innerHTML=" <td>"+kind.id+"</td>\n" +
                        "                                <td>"+kind.name+"</td>\n" +
                        "                                <td>125</td>\n" +
                        "                                <td><a onclick='delKind("+kind.id+")'>删除</a></td>";
                    kindInfo.appendChild(tr);
                }
            }
        })
    }
);