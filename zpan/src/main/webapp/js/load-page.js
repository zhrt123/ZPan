function load(type) {
    $.ajax({
        type: "post",
        url: "fileManager.action",
        data: {
            pathType: type
        },
        dataType: "json",
        success: function (data) {
            var d = eval("(" + data + ")");
            if (type == "filePath") {
                $("#myFileDirectionHTML").empty().append(d.myFileDirectionHTML);
                $("#myFileFolderListHTML").empty().append(d.myFileFolderListHTML);
                $("#myFileFileItemsHTML").empty().append(d.myFileFileItemsHTML);
            }
            if (type == "mySharePath") {
                $("#myShareDirectionHTML").empty().append(d.myShareDirectionHTML);
                $("#myShareFileItemsHTML").empty().append(d.myShareFileItemsHTML);
            }
            if (type == "sharingPath") {
                $("#sharingDirectionHTML").empty().append(d.sharingDirectionHTML);
                $("#sharingFileItemsHTML").empty().append(d.sharingFileItemsHTML);
            }
        },
        error: function () {
            alert("error");
        }
    })
}