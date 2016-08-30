  $(function(){
            $("#people-num").change(function(){
                $("#people-info").empty();
                var peonum=$("#people-num").val();
                for(var i=0;i<peonum;i++)
                {
                    $("#people-info").append("<div class=\"form-group\"> <label class=\"col-lg-2 control-label\">姓名:</label><div class=\"col-lg-2\"><input class=\"form-control\"  type=\"text\"  /></div><label class=\"col-lg-1 control-label\">单位:</label><div class=\"col-lg-3\"><input class=\"form-control\"  type=\"text\"  /></div><label class=\"col-lg-2 control-label\">职务:</label><div class=\"col-lg-2\"><input class=\"form-control\"  type=\"text\"  /></div></div>");
                }
                
            });

        });