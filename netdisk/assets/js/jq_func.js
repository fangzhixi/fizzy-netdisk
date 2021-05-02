//标题出现省略触发抬头显示
$(".file_name").hover(
    function() {
        console.log("hover")
        var box = $(this).get(0);
        console.log("scrollWidth: ", box.scrollWidth)
        console.log("offsetWidth: ", box.offsetWidth)
        if (box.scrollWidth > box.offsetWidth) {
            console.log("出现了省略号")
            $(this).attr("data-original-title",$(this).text());
        } else {
            console.log("没有出现省略号")
        }
    },
    function() {
        console.log("blur")
        var file_title = $(".file_name")
        file_title.attr("data-original-title","");
    }
)