document.write("<script language=javascript src='/js/load-page.js'></script>");
$(document).ready(function () {
    $("body").on("click", "a.click", function () {
        var a = $(this).parent().parent().prev().prev().prev().get(0);
        var form = $(this).parent().parent().prev().prev().get(0);
        var op_type = $(this).get(0).innerHTML;
        var type = "";
        if ($(this).hasClass("my-file")) type = "filePath";
        else if ($(this).hasClass("my-share")) type = "mySharePath";
        else if ($(this).hasClass("sharing")) type = "sharingPath";
        if (op_type == "重命名") {
            a.style.display = "none";
            form.style = "";
        } else if (op_type == "删除") {
            if (confirm("确定删除吗？")) {
                var file_name = a.innerHTML;
                $.ajax({
                    type: "post",
                    url: "removeFile.action",
                    data: {
                        fileName: file_name
                    },
                    success: function () {
                        load(type);
                    },
                    error: function () {
                        alert("error");
                    }
                })
            }
        } else if (op_type == "移动") {
            $(this).parent().parent().parent().addClass("selected border-primary");
            $(".path-select").addClass("my-file").attr("name", "path-select-move");

        } else if (op_type == "拷贝") {
            $(this).parent().parent().parent().addClass("selected border-primary");
            $(".path-select").addClass("my-file").attr("name", "path-select-copy");
        } else if (op_type == "分享") {
            if (confirm("确定分享吗？")) {
                var file_name = a.innerHTML;
                $.ajax({
                    type: "post",
                    url: "shareFile.action",
                    data: {
                        fileName: file_name
                    },
                    error: function () {
                        alert("error");
                    }
                })
            }
        }
    })
    $("body").on("click", "button.rename-cancel", function () {
        var a = $(this).parent().prev().get(0);
        var form = $(this).parent().get(0);
        a.style = "";
        form.style.display = "none";
    })
    $("body").on("click", "button.rename-sumbit", function () {
        var a = $(this).parent().prev().get(0);
        var input = $(this).prev().get(0);
        var file_name = a.innerHTML;
        var new_file_name = input.value;
        var type = "";
        if ($(this).hasClass("my-file")) type = "filePath";
        else if ($(this).hasClass("my-share")) type = "mySharePath";
        else if ($(this).hasClass("sharing")) type = "sharingPath";
        $.ajax({
            type: "post",
            url: "renameFile.action",
            data: {
                fileName: file_name,
                newFileName: new_file_name
            },
            dataType: "json",
            success: function (data) {
                var d = eval("(" + data + ")");
                if (d.status != "success") alert("文件名不能相同");
                load(type);
            },
            error: function () {
                alert("error");
            }
        })

    })

    $("body").on("click", "button.new-file", function () {
        var new_file_name = $(this).parent().prev().find("input").get(0).value;

        var type = "";
        if ($(this).hasClass("my-file")) type = "filePath";
        else if ($(this).hasClass("my-share")) type = "mySharePath";
        else if ($(this).hasClass("sharing")) type = "sharingPath";
        $.ajax({
            type: "post",
            url: "makeDir.action",
            data: {
                newFileName: new_file_name
            },
            dataType: "json",
            success: function (data) {
                var d = eval("(" + data + ")");
                if (d.status != "success") alert("文件名不能相同");
                window.location.replace("fileManager.action");
            },
            error: function () {
                alert("error");
            }
        })
    })
    $("body").on("click", "a.remove-selected-file", function () {
        var type = "";
        var file_type = "";
        if ($(this).hasClass("my-file")) type = "filePath", file_type = "my-file";
        else if ($(this).hasClass("my-share")) type = "mySharePath", file_type = "my-share";
        else if ($(this).hasClass("sharing")) type = "sharingPath", file_type = "sharing";
        var files = $("div .file-item").filter(".selected").filter("." + file_type).children("a.file-item-name");
        var file_names = new Array(files.length);
        for (var i = 0; i < files.length; i++) {
            file_names[i] = files[i].innerHTML;
        }

        $.ajax({
            type: "post",
            url: "removeSelectedFiles.action",
            data: {
                fileNames: file_names,
                pathType: type
            },
            dataType: "json",
            traditional: true,
            success: function () {
                load(type);
            },
            error: function () {
                alert("error");
            }
        })
    })
    $("body").on("click", "button.path-select", function () {
        var file_path = $(this).parent().prev().find("ul").children().filter("[aria-selected='true']").attr("name");
        var url;
        if ($(this).attr("name") == "path-select-move") {
            url = "moveSelectedFiles.action";
        } else {
            url = "copySelectedFiles.action";
        }
        var type = "";
        var file_type = "";
        if ($(this).hasClass("my-file")) type = "filePath", file_type = "my-file";
        else if ($(this).hasClass("my-share")) type = "mySharePath", file_type = "my-share";
        else if ($(this).hasClass("sharing")) type = "sharingPath", file_type = "sharing";
        var files = $("div .file-item").filter(".selected").filter("." + file_type).children("a.file-item-name");
        var file_names = new Array(files.length);
        for (var i = 0; i < files.length; i++) {
            file_names[i] = files[i].innerHTML;
        }

        $.ajax({
            type: "post",
            url: url,
            data: {
                fileNames: file_names,
                filePath: file_path
            },
            dataType: "json",
            traditional: true,
            success: function (data) {
                var d = eval("(" + data + ")");
                if (d.status != "success") alert("文件名不能相同");
                window.location.replace("fileManager.action");
            },
            error: function () {
                alert("error");
            }
        })
    })
    $("body").on("click", ".select-all-files", function () {
        var type = "";
        if ($(this).hasClass("my-file")) type = "my-file";
        else if ($(this).hasClass("my-share")) type = "my-share";
        else if ($(this).hasClass("sharing")) type = "sharing";
        var class_name = $("div.file-item").filter("." + type).get(0).className;
        if ($(this).is(':checked')) {
            $("div.file-item").filter("." + type).not(".selected").find(".custom-control-input").trigger("click");
            $("div.file-item").filter("." + type).attr("class", "file-item selected border-primary " + type);
        }
        else {
            $("div.file-item").filter("." + type).filter(".selected").find(".custom-control-input").trigger("click");
            $("div.file-item").filter("." + type).attr("class", "file-item " + type);
        }
        $("div.file-item").filter("." + type).get(0).className = class_name;
    })
    $("body").on("click", ".sidenav-link", function () {
        var type = $(this).attr("href");
        type = type.substring(1, type.length);
    })
    $("body").on("keypress", ".search-input", function (event) {
        if (event.keyCode == 13) {
            var file_name = $(this).val();
            var type = "";
            if ($(this).hasClass("my-file")) type = "filePath";
            else if ($(this).hasClass("my-share")) type = "mySharePath";
            else if ($(this).hasClass("sharing")) type = "sharingPath";
            $.ajax({
                type: "post",
                url: "fileSearch.action",
                data: {
                    fileName: file_name,
                    pathType: type
                },
                dataType: "json",
                success: function (data) {
                    var d = eval("(" + data + ")");
                    if (type == "filePath") {
                        $("#myFileFileItemsHTML").empty().append(d.fileItemsHTML);
                    }
                    if (type == "mySharePath") {
                        $("#myShareFileItemsHTML").empty().append(d.fileItemsHTML);
                    }
                    if (type == "sharingPath") {
                        $("#sharingFileItemsHTML").empty().append(d.fileItemsHTML);
                    }
                },
                error: function () {
                    alert("error");
                }
            })
        }
    })
    $("#my-file-href").click(function () {
        load("filePath");
    })
    $("#my-share-href").click(function () {
        load("mySharePath");
    })
    $("#sharing-href").click(function () {
        load("sharingPath");
    })
})

function onClickMove() {
    var button = document.getElementsByClassName("path-select").item(0);
    button.setAttribute("name", "path-select-move");
}

function onClickCopy() {
    var button = document.getElementsByClassName("path-select").item(0);
    button.setAttribute("name", "path-select-copy");
}

