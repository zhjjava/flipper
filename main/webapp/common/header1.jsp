<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/common/include.jsp"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>HRMS</title>
    <meta name="author" content="SuggeElson" />
    <meta name="description" content="Supr admin template - new premium responsive admin template. This template is designed to help you build the site administration without losing valuable time.Template contains all the important functions which must have one backend system.Build on great twitter boostrap framework" />
    <meta name="keywords" content="admin, admin template, admin theme, responsive, responsive admin, responsive admin template, responsive theme, themeforest, 960 grid system, grid, grid theme, liquid, masonry, jquery, administration, administration template, administration theme, mobile, touch , responsive layout, boostrap, twitter boostrap" />
    <meta name="application-name" content="Supr admin template" />
    <!-- Mobile Specific Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- Force IE9 to render in normla mode -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <!-- Le styles -->
    <!-- Use new way for google web fonts 
    http://www.smashingmagazine.com/2012/07/11/avoiding-faux-weights-styles-google-web-fonts -->
  
    <!-- Text -->
    <!--[if lt IE 9]>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400" rel="stylesheet" type="text/css" />
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:700" rel="stylesheet" type="text/css" />
    <link href="http://fonts.googleapis.com/css?family=Droid+Sans:400" rel="stylesheet" type="text/css" />
    <link href="http://fonts.googleapis.com/css?family=Droid+Sans:700" rel="stylesheet" type="text/css" />
    <![endif]-->
    <!-- Core stylesheets do not remove -->
    <link id="bootstrap" href="${ctx}/css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/css/bootstrap/bootstrap-theme.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/css/supr-theme/jquery.ui.supr.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/css/icons.css" rel="stylesheet" type="text/css" />
    <!-- Plugin stylesheets -->
    <link href="${ctx}/plugins/misc/qtip/jquery.qtip.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/plugins/forms/uniform/uniform.default.css" type="text/css" rel="stylesheet" />
    <link href="${ctx}/plugins/tables/dataTables/jquery.dataTables.css" type="text/css" rel="stylesheet" />
    <link href="${ctx}/plugins/tables/dataTables/TableTools.css" type="text/css" rel="stylesheet" />
    <!-- Main stylesheets -->
    <link href="${ctx}/css/main.css" rel="stylesheet" type="text/css" />
    <!-- Custom stylesheets ( Put your own changes here ) -->
    <link href="${ctx}/css/custom.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="${ctx}/css/slancer.css" />
    <!--[if IE 8]><link href="${ctx}/css/ie8.css" rel="stylesheet" type="text/css" /><![endif]-->
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script type="text/javascript" src="${ctx}/js/libs/excanvas.min.js"></script>
      <script type="text/javascript" src="${ctx}/js/html5.js"></script>
      <script type="text/javascript" src="${ctx}/js/libs/respond.min.js"></script>
    <![endif]-->
    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="${ctx}/images/favicon.ico" />
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${ctx}/images/apple-touch-icon-144-precomposed.png" />
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${ctx}/images/apple-touch-icon-114-precomposed.png" />
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${ctx}/images/apple-touch-icon-72-precomposed.png" />
    <link rel="apple-touch-icon-precomposed" href="${ctx}/images/apple-touch-icon-57-precomposed.png" />
    <!-- Windows8 touch icon ( http://www.buildmypinnedsite.com/ )-->
    <meta name="application-name" content="Supr" />
    <meta name="msapplication-TileColor" content="#3399cc" />
    <!-- Load modernizr first -->
    <script type="text/javascript" src="${ctx}/js/libs/modernizr.js"></script>
    
        <!-- Important plugins put in all pages -->
    <script src="${ctx}/js/jquery-1.9.0.js"></script>
    <script>
       // var $j = jQuery.noConflict();
    </script>
    <script type="text/javascript" src="${ctx}/js/jquery-migrate-1.2.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/bootstrap/bootstrap.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.mousewheel.js"></script>
    <script type="text/javascript" src="${ctx}/js/libs/jRespond.min.js"></script>
    <!-- Charts plugins -->
    <script type="text/javascript" src="${ctx}/plugins/charts/sparkline/jquery.sparkline.min.js"></script>
    <!-- Sparkline plugin -->
    <!-- Misc plugins -->
    <script type="text/javascript" src="${ctx}/plugins/misc/nicescroll/jquery.nicescroll.min.js"></script>
    <script type="text/javascript" src="${ctx}/plugins/misc/qtip/jquery.qtip.min.js"></script>
    <!-- Custom tooltip plugin -->
    <script type="text/javascript" src="${ctx}/plugins/misc/totop/jquery.ui.totop.min.js"></script>
    <!-- Search plugin -->
    <script type="text/javascript" src="${ctx}/plugins/misc/search/tipuesearch_set.js"></script>
    <script type="text/javascript" src="${ctx}/plugins/misc/search/tipuesearch_data.js"></script>
    <!-- JSON for searched results -->
    <script type="text/javascript" src="${ctx}/plugins/misc/search/tipuesearch.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.json-2.5.1.min.js"></script>    
    
    <!-- Form plugins -->
    <script type="text/javascript" src="${ctx}/plugins/forms/uniform/jquery.uniform.min.js"></script>
    <!-- Table plugins -->
    <script type="text/javascript" src="${ctx}/plugins/tables/dataTables/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="${ctx}/plugins/tables/dataTables/TableTools.min.js"></script>
    <script type="text/javascript" src="${ctx}/plugins/tables/dataTables/ZeroClipboard.js"></script>
    <script type="text/javascript" src="${ctx}/plugins/tables/responsive-tables/responsive-tables.js"></script>
    <!-- Make tables responsive -->
    <!-- Init plugins -->
    <script type="text/javascript" src="${ctx}/js/utils.js"></script>
    <script type="text/javascript" src="${ctx}/js/main_new.js"></script>
    <!-- Core js functions -->
</head>    
<body>