function onSelectFile() {
    var file_input = document.getElementById("file-input");
    file_input.click();
}

function onUploadFile() {
    var form = new FormData(document.getElementById("file-upload"));
    $.ajax({
        url: "fileUpload.action",
        type: "post",
        data: form,
        processData: false,
        contentType: false,
        success: function (data) {
            var d = eval("(" + data + ")");
            alert(d.result);
            window.location.replace("fileManager.action");
        },
        error: function () {
            alert("error");
        }
    });
}

$(document).ready(function () {
    $("body").on("click", ".file-download", function () {
        var type = "";
        var file_type = "";
        if ($(this).hasClass("my-file")) type = "filePath", file_type = "my-file";
        else if ($(this).hasClass("my-share")) type = "mySharePath", file_type = "my-share";
        else if ($(this).hasClass("sharing")) type = "sharingPath", file_type = "sharing";
        var selected_file_names = $("div .file-item").filter(".selected").filter("." + file_type).children("a.file-item-name");
        if (selected_file_names.length == 0) alert("请选择文件");
        else {
            var file_names = "";
            for (var i = 0; i < selected_file_names.length; i++) {
                var str = selected_file_names.get(i).innerHTML;
                file_names += str;
                if (i < selected_file_names.length - 1) file_names += ";";
            }
            $.ajax({
                type: "post",
                url: "downloadMultiFile.action",
                data: {
                    fileNames: file_names,
                    pathType: type
                },
                dataType: "json",
                success: function (data) {
                    var d = eval("(" + data + ")");
                    var file_name = d.file_name;
                    var download_time = new Date().getTime();
                    download("download.action?fileName=" + file_name + "&downloadTime=" + download_time + "&pathType=" + type);
                    if (selected_file_names.length > 1) {
                        $.ajax({
                            type: "post",
                            url: "afterDownload.action",
                            data: {
                                fileName: file_name,
                                downloadTime: download_time
                            },
                            error: function () {
                                alert("error");
                            }
                        })
                    }
                },
                error: function () {
                    alert("error");
                }
            })
        }
    })
})

function download(url) {
    var a = document.createElement('a');
    a.href = url;
    $("body").append(a);
    a.click();
}
