var timeUtil = (function(){

    function getDefaultTodayDate(){
        var date = new Date();
        
        var month = date.getMonth()+1;
        var _date = date.getDate();
        if(month < 10){
        	month = "0" + month;
        }
        if(_date < 10){
        	_date = "0" + _date;
        }
        var d = date.getFullYear() + "-" + month + "-" + _date;
        return d;
    }
    
    function getDefaultTodayMonthDate(){
        var date = new Date();
        
        var month = date.getMonth()+1;
        if(month < 10){
        	month = "0" + month;
        }
        var d = date.getFullYear() + "-" + month + "-01";
        return d;
    }
    

    return {
        getDefaultTodayDate:getDefaultTodayDate(),
        getDefaultTodayMonthDate:getDefaultTodayMonthDate()
    }
})();