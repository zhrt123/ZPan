document.write("<script language=javascript src='/js/load-page.js'></script>");
$(document).ready(function () {
    $("body").on("click", ".back-previous-page", function () {
        var type = "";
        if ($(this).hasClass("my-file")) type = "filePath";
        else if ($(this).hasClass("my-share")) type = "mySharePath";
        else if ($(this).hasClass("sharing")) type = "sharingPath";
        $.ajax({
            type: "post",
            url: "backPrevoiousPage.action",
            data: {
                pathType: type
            },
            success: function () {
                load(type);
            },
            error: function () {
                alert("error");
            }
        })
    })
    $("body").on("click", "div.path-change", function () {
            var a = $(this).next().get(0);
            var type = "";
            if ($(this).hasClass("my-file")) type = "filePath";
            else if ($(this).hasClass("my-share")) type = "mySharePath";
            else if ($(this).hasClass("sharing")) type = "sharingPath";
            $.ajax({
                type: "post",
                url: "changePath.action",
                data: {
                    filePath: a.name,
                    pathType: type
                },
                success: function () {
                    load(type);
                },
                error: function () {
                    alert("error");
                }
            })
        }
    )
    $("body").on("click", "a.path-change", function () {
        var a = $(this).get(0);
        var type = "";
        if ($(this).hasClass("my-file")) type = "filePath";
        else if ($(this).hasClass("my-share")) type = "mySharePath";
        else if ($(this).hasClass("sharing")) type = "sharingPath";
        $.ajax({
            type: "post",
            url: "changePath.action",
            data: {
                filePath: a.name,
                pathType: type
            },
            success: function () {
                load(type);
            },
            error: function () {
                alert("error");
            }
        })
    })
})