/**
 * Created by Administrator on 2016/10/3.
 */
document.write("<script src='config.js'></script>");
function judgeAuthority(){
    $.ajax({
        type: "post",
        url: urlConfig+"user/session.action",
        contentType: 'application/json;charset=utf-8',
        success: function (data) {
            for(var i=0;i<data.roleList.length;i++){
                if(data.roleList[i]=="admin"){
                    $(".admin").css("display","block");
                }
            }
            if(data.userName!=null){
                $("#loginTag").html(data.userName);
            }
        }
    })
}