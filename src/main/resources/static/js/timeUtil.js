var timeUtil = (function(){

    function getDefaultTodayDate(){
        var date = new Date();
        return date.getFullYear() + "-" + (date.getMonth()+1) + "-" + date.getDate();
    }


    return {
        getDefaultTodayDate:getDefaultTodayDate()
    }
})();