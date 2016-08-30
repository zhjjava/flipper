  var clicknum = 0;
  $(function() {
      $("#add-row").click(function() {

          clicknum++;
          //  alert(clicknum);
          var addString =  "<div class=\"row\" id=\"row" + clicknum + "\" ><div class=\"col-lg-12\"> <div class=\"form-group\"><label class=\"col-lg-1 control-label\">所在城市:</label><div class=\"col-lg-2\"><input class=\"form-control\"  type=\"text\"  /></div><label class=\"col-lg-1 control-label\" for=\"username\">酒店名称:</label><div class=\"col-lg-2\"><input class=\"form-control\" type=\"text\" /></div><label class=\"col-lg-1 control-label\" for=\"text\">入住日期:</label><div class=\"col-lg-2\"><input class=\"form-control\" type=\"text\" /></div><label class=\"col-lg-1 control-label\" >天数:</label><div class=\"col-lg-2\"><input class=\"form-control\" type=\"text\"  /> </div><label class=\"col-lg-1 control-label\" >房单价:</label><div class=\"col-lg-2\"><input class=\"form-control\" type=\"text\"  /> </div><label class=\"col-lg-1 control-label\" >总价:</label><div class=\"col-lg-2\"><input class=\"form-control\" type=\"text\"  /> </div><label class=\"col-lg-1 control-label\" >离店日期:</label><div class=\"col-lg-2\"><input class=\"form-control\" type=\"text\"  /> </div> </div><div class=\"form-group\"> <label class=\"col-lg-1 control-label\" for=\"username\">事由:</label><div class=\"col-lg-2\"> <textarea class=\"form-control textarea\"></textarea></div><label class=\"col-lg-1 control-label\" for=\"text\">备注:</label><div class=\"col-lg-2\"><textarea class=\"form-control textarea\"></textarea></div><div class=\"col-lg-6  sl-form-btn\"><button class=\"btn btn-danger\" id=\"del" + clicknum + "\" type=\"button\" onclick=\"del(this.id)\">删除</button></div> </div></div></div>"
          $("#refund-form").append(addString);


      });


  });

  function del(id) {
      //alert(id);

      $("#" + id).parents("div.row").first().remove();
      //  $(this).parents(".row").remove();
  }
