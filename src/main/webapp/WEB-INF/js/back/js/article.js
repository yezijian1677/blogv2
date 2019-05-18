$(
    function () {
        var articleInfo = document.getElementById("articleInfo");
        var targetUrl = "/admin/article";
        $.post(targetUrl, function (result) {
            for (i = 0; i< 10; i++){
                if (result.data.article[i]){
                    var article = result.data.article[i];
                    var tr = document.createElement("tr");
                    var j = i + 1;
                    var time = new Date(article.ctime).toLocaleString();

                    tr.innerHTML = " <td>"+j+"</td>\n" +
                        "                            <td class=\"article-title\">"+article.title+"</td>\n" +
                        "                            <td>"+article.kinds+"</td>\n" +
                        "                            <td class=\"hidden-sm\">"+article.tags+"</td>\n" +
                        "                            <td class=\"hidden-sm\">"+article.click+"</td>\n" +
                        "                            <td>"+time+"</td>\n" +
                        "                            <td><a href=\"update-article.html\">修改</a> <a onclick='del(" + article.id + "," + j + ")'>删除</a></td>";
                    articleInfo.appendChild(tr);
                }
            }

            // 文章信息的分页
            var ul = document.getElementById("paging_1");
            ul.className = "pagination pagenav";
            var pages = result.data.page.pages;
            var current = result.data.page.current;
            var last = current - 1;
            var next = current + 1;
            if (last < 1) {
                last = 1
            }
            if (next > pages) {
                next = pages
            }
            var li_first = document.createElement("li");
            li_first.id = "li_first";
            li_first.innerHTML = "<a href='#'onclick='getArticles(" + last + ")'>&laquo;</a>";
            ul.appendChild(li_first);
            document.getElementById("li_first").className = "disabled";
            for (i = 0; i < pages; i++) {
                var j = i + 1;
                var li = document.createElement("li");
                li.id = "li_" + j;
                li.innerHTML = "<a href='#'onclick='getArticles(" + j + ")'>" + j + "</a>";
                ul.appendChild(li);
            }
            document.getElementById("li_" + current).className = "active";
            var li_last = document.createElement("li");
            li_last.innerHTML = "<a href='#'onclick='getArticles(" + next + ")'>&raquo;</a>";
            ul.appendChild(li_last);
        });
    }
);

//游戏信息分页的函数
function getArticles(pagenum) {
    var articleInfo = document.getElementById("articleInfo");
    articleInfo.innerHTML = "";
    var targetUrl = "/admin/article";
    $.post(targetUrl, {page: pagenum}, function (result) {
        for (i = 0; i < 10; i++) {
            if (result.data.article[i]) {
                var article = result.data.article[i];
                var tr = document.createElement("tr");
                var j = i + 1;
                var time = new Date(article.ctime).toLocaleString();

                tr.innerHTML = " <td>" + j + "</td>\n" +
                    "                            <td class=\"article-title\">" + article.title + "</td>\n" +
                    "                            <td>" + article.kinds + "</td>\n" +
                    "                            <td class=\"hidden-sm\">" + article.tags + "</td>\n" +
                    "                            <td class=\"hidden-sm\">" + article.click + "</td>\n" +
                    "                            <td>" + time + "</td>\n" +
                    "                            <td><a href=\"update-article.html\">修改</a> <a onclick='del(" + article.id + "," + j + ")'>删除</a></td>";
                articleInfo.appendChild(tr);
            }
        }

        // 文章信息的分页
        var ul = document.getElementById("paging_1");
        ul.className = "pagination pagenav";
        ul.innerHTML = "";
        var pages = result.data.page.pages;
        var current = result.data.page.current;
        var last = current - 1;
        var next = current + 1;
        if (last < 1) {
            last = 1
        }
        if (next > pages) {
            next = pages
        }
        var li_first = document.createElement("li");
        li_first.id = "li_first";
        li_first.innerHTML = "<a href='#'onclick='getArticles(" + last + ")'>&laquo;</a>";
        ul.appendChild(li_first);
        document.getElementById("li_first").className = "disabled";
        for (i = 0; i < pages; i++) {
            var j = i + 1;
            var li = document.createElement("li");
            li.id = "li_" + j;
            li.innerHTML = "<a href='#'onclick='getArticles(" + j + ")'>" + j + "</a>";
            ul.appendChild(li);
        }
        document.getElementById("li_" + current).className = "active";
        var li_last = document.createElement("li");
        li_last.innerHTML = "<a href='#'onclick='getArticles(" + next + ")'>&raquo;</a>";
        ul.appendChild(li_last);
        if (current >= i) {
            document.getElementById("li_next").className = "disabled";
        }

    });

};


function del(aid, j) {
    var targetUrl = "/admin/delArticle";
    if(window.confirm("此操作不可逆，是否确认？")){
        $.post(targetUrl, {articleId: aid}, function (result) {
            if (result.success){
                alert("删除成功");
                window.location.reload();
            }
            else {
                alert(result.msg);
            }
        })
    }
}
