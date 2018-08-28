//输出uuid
function guid() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
        return v.toString(16);
    });
}
//产生时间
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month =  formatTime(date.getMonth() + 1);
    var strDate =formatTime (date.getDate());
    var hour = formatTime (date.getHours());
    var minutes = formatTime (date.getMinutes());
    var seconds = formatTime (date.getSeconds());
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
        + " " + hour + seperator2 + minutes
        + seperator2 + seconds;
    return currentdate;
}
//格式化时间
function formatTime(str){
    if (str >= 1 && str <= 9) {
        str = "0" + str;
    }
    return str;
}